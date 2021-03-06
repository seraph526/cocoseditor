#include "AppDelegate.h"

#include "cocos2d.h"
#include "SimpleAudioEngine.h"
#include "ScriptingCore.h"
#include "jsb_cocos2dx_auto.hpp"
#include "jsb_cocos2dx_extension_auto.hpp"
#include "jsb_cocos2dx_builder_auto.hpp"
#include "jsb_cocos2dx_spine_auto.hpp"
#include "extension/jsb_cocos2dx_extension_manual.h"
#include "cocostudio/jsb_cocos2dx_studio_manual.h"
#include "jsb_cocos2dx_cocoseditor_auto.hpp"
#include "jsb_cocos2dx_studio_auto.hpp"
#include "jsb_cocos2dx_ui_auto.hpp"
#include "ui/jsb_cocos2dx_ui_manual.h"
#include "spine/jsb_cocos2dx_spine_manual.h"
#include "cocos2d_specifics.hpp"
#include "cocosbuilder/cocosbuilder_specifics.hpp"
#include "chipmunk/js_bindings_chipmunk_registration.h"
#include "localstorage/js_bindings_system_registration.h"
#include "jsb_opengl_registration.h"
#include "network/XMLHTTPRequest.h"
#include "network/jsb_websocket.h"
#include "network/jsb_socketio.h"
#include "cocosbuilder/js_bindings_ccbreader.h"
#include "jsb_cocos2dx_cocoseditor_auto.hpp"

#include "FunctionFactory.h"
#include "Cocos2dFunction.h"

//#if (CC_TARGET_PLATFORM == CC_PLATFORM_IOS || CC_TARGET_PLATFORM == CC_PLATFORM_ANDROID)
//#include "jsb_cocos2dx_pluginx_auto.hpp"
//#include "jsb_pluginx_extension_registration.h"
//#endif

#if (CC_TARGET_PLATFORM == CC_PLATFORM_ANDROID)
#include "platform/android/CCJavascriptJavaBridge.h"
#elif (CC_TARGET_PLATFORM == CC_PLATFORM_IOS || CC_TARGET_PLATFORM == CC_PLATFORM_MAC)
#include "platform/ios/JavaScriptObjCBridge.h"
#endif

//#include "js_Effect3D_bindings.h"

#if (CC_TARGET_PLATFORM == CC_PLATFORM_IOS || CC_TARGET_PLATFORM == CC_PLATFORM_ANDROID)
#include "jsb_cocos2dx_experimental_webView_auto.hpp"
#include "experimental/jsb_cocos2dx_experimental_webView_manual.h"
#endif

#if (CC_TARGET_PLATFORM == CC_PLATFORM_IOS || CC_TARGET_PLATFORM == CC_PLATFORM_ANDROID)
#include "jsb_cocos2dx_experimental_video_auto.hpp"
#include "experimental/jsb_cocos2dx_experimental_video_manual.h"
#endif

USING_NS_CC;
USING_NS_CC_EXT;
using namespace CocosDenshion;

AppDelegate::AppDelegate()
{
}

AppDelegate::~AppDelegate()
{
    ScriptEngineManager::destroyInstance();
}

void AppDelegate::initGLContextAttrs()
{
    GLContextAttrs glContextAttrs = {8, 8, 8, 8, 24, 8};
    
    GLView::setGLContextAttrs(glContextAttrs);
}


bool AppDelegate::applicationDidFinishLaunching()
{
    log("applicationDidFinishLaunching js");
	auto director = Director::getInstance();
	cce::FunctionFactory::getInstance()->registerFunction("cocos2d",new cce::Cocos2dFunction());
	cce::FunctionFactory::getInstance()->registerFunction("js",new cce::Cocos2dJsFunction());

	director->getEventDispatcher()->dispatchCustomEvent("game_on_loading");
	//cce::FunctionFactory::getInstance()->callFunction("Application","game_on_loading");
    // initialize director
    
    auto glview = director->getOpenGLView();
    if(!glview) {
        glview = cocos2d::GLViewImpl::createWithRect("cocos-js", Rect(0,0,480,320));
        director->setOpenGLView(glview);
    }


	//std::vector<std::string> searchPath;
	//searchPath.push_back("/sdcard/com.eachbaby.lovebaby/download/100001");
	//FileUtils::getInstance()->setSearchPaths(searchPath);

    // set FPS. the default value is 1.0/60 if you don't call this
    director->setAnimationInterval(1.0 / 60);

    ScriptingCore* sc = ScriptingCore::getInstance();
    sc->addRegisterCallback(register_all_cocos2dx);
    sc->addRegisterCallback(register_all_cocos2dx_extension);
    sc->addRegisterCallback(register_cocos2dx_js_core);
    sc->addRegisterCallback(register_all_cocos2dx_extension_manual);
    sc->addRegisterCallback(jsb_register_chipmunk);
    sc->addRegisterCallback(JSB_register_opengl);
    sc->addRegisterCallback(jsb_register_system);
    sc->addRegisterCallback(MinXmlHttpRequest::_js_register);
    sc->addRegisterCallback(register_jsb_websocket);
	sc->addRegisterCallback(register_jsb_socketio);

    //sc->addRegisterCallback(register_all_cocos2dx_builder);
	
	sc->addRegisterCallback(register_all_cocos2dx_cocoseditor);
    //sc->addRegisterCallback(register_CCBuilderReader);

    sc->addRegisterCallback(register_all_cocos2dx_ui);
    sc->addRegisterCallback(register_all_cocos2dx_ui_manual);
    sc->addRegisterCallback(register_all_cocos2dx_studio);
    sc->addRegisterCallback(register_all_cocos2dx_studio_manual);
    
    //sc->addRegisterCallback(register_all_cocos2dx_spine);
    //sc->addRegisterCallback(register_all_cocos2dx_spine_manual);
    
#if (CC_TARGET_PLATFORM == CC_PLATFORM_IOS || CC_TARGET_PLATFORM == CC_PLATFORM_ANDROID)
 //   sc->addRegisterCallback(register_all_pluginx_protocols);
 //   sc->addRegisterCallback(register_pluginx_js_extensions);
#endif
    
#if (CC_TARGET_PLATFORM == CC_PLATFORM_ANDROID)
    sc->addRegisterCallback(JavascriptJavaBridge::_js_register);
#elif (CC_TARGET_PLATFORM == CC_PLATFORM_IOS || CC_TARGET_PLATFORM == CC_PLATFORM_MAC)
    sc->addRegisterCallback(JavaScriptObjCBridge::_js_register);
#endif

    sc->start();
    sc->runScript("script/jsb_boot.js");

#if defined(COCOS2D_DEBUG) && (COCOS2D_DEBUG > 0)
    sc->enableDebugger();
#endif

	auto pEngine = ScriptingCore::getInstance();
    ScriptEngineManager::getInstance()->setScriptEngine(pEngine);
    ScriptingCore::getInstance()->runScript("main.js");

	
    director->getEventDispatcher()->dispatchCustomEvent("game_on_loaded");

	
	//cce::FunctionFactory::getInstance()->callFunction("Application","game_on_loaded");
	return true;
}

// This function will be called when the app is inactive. When comes a phone call,it's be invoked too
void AppDelegate::applicationDidEnterBackground()
{
    auto director = Director::getInstance();
    director->stopAnimation();
	cce::FunctionFactory::getInstance()->callFunction("Application","game_on_hide");
    director->getEventDispatcher()->dispatchCustomEvent("game_on_hide");
    SimpleAudioEngine::getInstance()->pauseBackgroundMusic();
    SimpleAudioEngine::getInstance()->pauseAllEffects();    
}

// this function will be called when the app is active again
void AppDelegate::applicationWillEnterForeground()
{
    auto director = Director::getInstance();
    director->startAnimation();
	cce::FunctionFactory::getInstance()->callFunction("Application","game_on_show");
    director->getEventDispatcher()->dispatchCustomEvent("game_on_show");
    SimpleAudioEngine::getInstance()->resumeBackgroundMusic();
    SimpleAudioEngine::getInstance()->resumeAllEffects();
}
