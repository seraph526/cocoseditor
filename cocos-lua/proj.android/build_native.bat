@echo on
env
set DIR=%~dp0
set COCOS2DX_ROOT=%DIR%..\..\..\..
set ANDROID_ROOT=%COCOS2DX_ROOT%\cocos
set ANDROID_ROOT=%ANDROID_ROOT%;%COCOS2DX_ROOT%\
set ANDROID_ROOT=%ANDROID_ROOT%;%COCOS2DX_ROOT%\external
rem set ANDROID_ROOT=%ANDROID_ROOT%;%COCOS2DX_ROOT%\extensions
echo %ANDROID_ROOT%
D:\develop\android-ndk-r9d\ndk-build.cmd  -j2 -C %DIR% NDK_MODULE_PATH=%ANDROID_ROOT% NDK_TOOLCHAIN_VERSION=4.8