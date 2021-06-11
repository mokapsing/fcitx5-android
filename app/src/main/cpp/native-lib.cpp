#include <jni.h>
#include <memory>
#include <string>
#include <cstdlib>
#include <unistd.h>
#include <android/log.h>
#include <thread>

#include <fcitx-utils/eventdispatcher.h>
#include <fcitx-utils/testing.h>
#include <fcitx-utils/stringutils.h>
#include <fcitx-utils/standardpath.h>
#include <fcitx-utils/testing.h>
#include <fcitx/addonmanager.h>
#include <fcitx/inputmethodmanager.h>
#include <fcitx/instance.h>
#include "androidfrontend/androidfrontend_public.h"

// https://codelab.wordpress.com/2014/11/03/how-to-use-standard-output-streams-for-logging-in-android-apps/
static int pfd[2];
static pthread_t thr;
static const char *tag = "fcitx5";

static void* logger_thread(void*)
{
    ssize_t read_size;
    char buf[128];
    while((read_size = read(pfd[0], buf, sizeof buf - 1)) > 0) {
        if(buf[read_size - 1] == '\n') --read_size;
        /* add null-terminator */
        buf[read_size] = '\0';
        __android_log_write(ANDROID_LOG_DEBUG, tag, buf);
    }
    return nullptr;
}

void start_logger()
{
    /* make stdout line-buffered and stderr unbuffered */
    setvbuf(stdout, nullptr, _IOLBF, 0);
    setvbuf(stderr, nullptr, _IONBF, 0);
    /* create the pipe and redirect stdout and stderr */
    pipe(pfd);
    dup2(pfd[1], 1);
    dup2(pfd[1], 2);
    /* spawn the logging thread */
    pthread_create(&thr, nullptr, logger_thread, nullptr);
    pthread_detach(thr);
}

std::unique_ptr<fcitx::Instance> p_instance;
std::unique_ptr<fcitx::EventDispatcher> p_dispatcher;
std::unique_ptr<fcitx::AddonInstance> p_addon;
fcitx::ICUUID p_uuid;

void scheduleEvent(fcitx::EventDispatcher *dispatcher, fcitx::Instance *instance) {
    dispatcher->schedule([dispatcher, instance]() {
        auto *unicode = instance->addonManager().addon("unicode", true);
        FCITX_ASSERT(unicode);
        auto *punctuation = instance->addonManager().addon("punctuation", true);
        FCITX_ASSERT(punctuation);
        auto *pinyin = instance->addonManager().addon("pinyin", true);
        FCITX_ASSERT(pinyin);

        auto defaultGroup = instance->inputMethodManager().currentGroup();
        defaultGroup.inputMethodList().clear();
        defaultGroup.inputMethodList().push_back(fcitx::InputMethodGroupItem("pinyin"));
        defaultGroup.setDefaultInputMethod("");
        instance->inputMethodManager().setGroup(defaultGroup);

        auto *androidfrontend = instance->addonManager().addon("androidfrontend");
        auto uuid = androidfrontend->call<fcitx::IAndroidFrontend::createInputContext>("fcitx5-android");
        p_addon.reset(androidfrontend);
        p_uuid = (uuid);
    });

    dispatcher->schedule([dispatcher, instance]() {
        auto *androidfrontend = instance->addonManager().addon("androidfrontend");
        auto uuid = androidfrontend->call<fcitx::IAndroidFrontend::createInputContext>("fcitx5-android");

        androidfrontend->call<fcitx::IAndroidFrontend::keyEvent>(uuid, fcitx::Key("n"), false);
        androidfrontend->call<fcitx::IAndroidFrontend::keyEvent>(uuid, fcitx::Key("i"), false);
        androidfrontend->call<fcitx::IAndroidFrontend::keyEvent>(uuid, fcitx::Key("h"), false);
        androidfrontend->call<fcitx::IAndroidFrontend::keyEvent>(uuid, fcitx::Key("a"), false);
        androidfrontend->call<fcitx::IAndroidFrontend::keyEvent>(uuid, fcitx::Key("o"), false);
        androidfrontend->call<fcitx::IAndroidFrontend::keyEvent>(uuid, fcitx::Key("1"), false);

        dispatcher->schedule([dispatcher, instance]() {
            dispatcher->detach();
            instance->exit();
        });
    });
}

extern "C"
JNIEXPORT void JNICALL
Java_me_rocka_fcitx5test_MainActivity_startupFcitx(JNIEnv *env, jobject /* this */, jstring appData, jstring appLib, jstring extData, jstring appDataLibime) {
    // debug log
    start_logger();

    setenv("SKIP_FCITX_PATH", "true", 1);

    const char* app_data = env->GetStringUTFChars(appData, nullptr);
    const char* app_lib = env->GetStringUTFChars(appLib, nullptr);
    const char* ext_data = env->GetStringUTFChars(extData, nullptr);
    const char* app_data_libime = env->GetStringUTFChars(appDataLibime, nullptr);

    setenv("HOME", ext_data, 1);
    setenv("XDG_DATA_DIRS", app_data, 1);
    setenv("XDG_CONFIG_HOME", ext_data, 1);
    setenv("XDG_DATA_HOME", ext_data, 1);
    setenv("FCITX_ADDON_DIRS", app_lib, 1);
    setenv("LIBIME_MODEL_DIRS", app_data_libime, 1);
    setenv("LIBIME_INSTALL_PKGDATADIR", app_data_libime, 1);

    env->ReleaseStringUTFChars(appData, app_data);
    env->ReleaseStringUTFChars(appLib, app_lib);
    env->ReleaseStringUTFChars(extData, ext_data);
    env->ReleaseStringUTFChars(appDataLibime, app_data_libime);

    char arg0[] = "";
    char arg1[] = "--disable=all";
    char arg2[] = "--enable=unicode,punctuation,pinyin,androidfrontend";
    char *argv[] = { arg0, arg1, arg2 };
    p_instance = std::make_unique<fcitx::Instance>(FCITX_ARRAY_SIZE(argv), argv);
    p_instance->addonManager().registerDefaultLoader(nullptr);
    p_dispatcher = std::make_unique<fcitx::EventDispatcher>();
    p_dispatcher->attach(&p_instance->eventLoop());
    std::thread thread(scheduleEvent, p_dispatcher.get(), p_instance.get());
    p_instance->exec();
    thread.join();
}

extern "C"
JNIEXPORT void JNICALL
Java_me_rocka_fcitx5test_MainActivity_sendKeyToFcitx(JNIEnv *env, jobject /* this */, jstring key) {
    auto *androidfrontend = p_instance->addonManager().addon("androidfrontend");
    auto uuid = p_uuid;
    const char* k = env->GetStringUTFChars(key, nullptr);
    p_dispatcher->schedule([&](){
        androidfrontend->call<fcitx::IAndroidFrontend::keyEvent>(uuid, fcitx::Key(k), false);
    });
}