package org.ccj.event;

import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.base.Ref;

/**
 * Created by yuanyou on 2014/12/16.
 */

@Platform(include = "CCEventKeyboard.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class EventKeyboard extends Event {
    public static final int KEY_NONE = 0,
            KEY_PAUSE = 1,
            KEY_SCROLL_LOCK = 2,
            KEY_PRINT = 3,
            KEY_SYSREQ = 4,
            KEY_BREAK = 5,
            KEY_ESCAPE = 6,
            KEY_BACK = KEY_ESCAPE,
            KEY_BACKSPACE = 7,
            KEY_TAB = 8,
            KEY_BACK_TAB = 9,
            KEY_RETURN = 10,
            KEY_CAPS_LOCK = 11,
            KEY_SHIFT = 12,
            KEY_LEFT_SHIFT = KEY_SHIFT,
            KEY_RIGHT_SHIFT = 13,
            KEY_CTRL = 14,
            KEY_LEFT_CTRL = KEY_CTRL,
            KEY_RIGHT_CTRL = 15,
            KEY_ALT = 16,
            KEY_LEFT_ALT = KEY_ALT,
            KEY_RIGHT_ALT = 17,
            KEY_MENU = 18,
            KEY_HYPER = 19,
            KEY_INSERT = 20,
            KEY_HOME = 21,
            KEY_PG_UP = 22,
            KEY_DELETE = 23,
            KEY_END = 24,
            KEY_PG_DOWN = 25,
            KEY_LEFT_ARROW = 26,
            KEY_RIGHT_ARROW = 27,
            KEY_UP_ARROW = 28,
            KEY_DOWN_ARROW = 29,
            KEY_NUM_LOCK = 30,
            KEY_KP_PLUS = 31,
            KEY_KP_MINUS = 32,
            KEY_KP_MULTIPLY = 33,
            KEY_KP_DIVIDE = 34,
            KEY_KP_ENTER = 35,
            KEY_KP_HOME = 36,
            KEY_KP_UP = 37,
            KEY_KP_PG_UP = 38,
            KEY_KP_LEFT = 39,
            KEY_KP_FIVE = 40,
            KEY_KP_RIGHT = 41,
            KEY_KP_END = 42,
            KEY_KP_DOWN = 43,
            KEY_KP_PG_DOWN = 44,
            KEY_KP_INSERT = 45,
            KEY_KP_DELETE = 46,
            KEY_F1 = 47,
            KEY_F2 = 48,
            KEY_F3 = 49,
            KEY_F4 = 50,
            KEY_F5 = 51,
            KEY_F6 = 52,
            KEY_F7 = 53,
            KEY_F8 = 54,
            KEY_F9 = 55,
            KEY_F10 = 56,
            KEY_F11 = 57,
            KEY_F12 = 58,
            KEY_SPACE = 59,
            KEY_EXCLAM = 60,
            KEY_QUOTE = 61,
            KEY_NUMBER = 62,
            KEY_DOLLAR = 63,
            KEY_PERCENT = 64,
            KEY_CIRCUMFLEX = 65,
            KEY_AMPERSAND = 66,
            KEY_APOSTROPHE = 67,
            KEY_LEFT_PARENTHESIS = 68,
            KEY_RIGHT_PARENTHESIS = 69,
            KEY_ASTERISK = 70,
            KEY_PLUS = 71,
            KEY_COMMA = 72,
            KEY_MINUS = 73,
            KEY_PERIOD = 74,
            KEY_SLASH = 75,
            KEY_0 = 76,
            KEY_1 = 77,
            KEY_2 = 78,
            KEY_3 = 79,
            KEY_4 = 80,
            KEY_5 = 81,
            KEY_6 = 82,
            KEY_7 = 83,
            KEY_8 = 84,
            KEY_9 = 85,
            KEY_COLON = 86,
            KEY_SEMICOLON = 87,
            KEY_LESS_THAN = 88,
            KEY_EQUAL = 89,
            KEY_GREATER_THAN = 90,
            KEY_QUESTION = 91,
            KEY_AT = 92,
            KEY_CAPITAL_A = 93,
            KEY_CAPITAL_B = 94,
            KEY_CAPITAL_C = 95,
            KEY_CAPITAL_D = 96,
            KEY_CAPITAL_E = 97,
            KEY_CAPITAL_F = 98,
            KEY_CAPITAL_G = 99,
            KEY_CAPITAL_H = 100,
            KEY_CAPITAL_I = 101,
            KEY_CAPITAL_J = 102,
            KEY_CAPITAL_K = 103,
            KEY_CAPITAL_L = 104,
            KEY_CAPITAL_M = 105,
            KEY_CAPITAL_N = 106,
            KEY_CAPITAL_O = 107,
            KEY_CAPITAL_P = 108,
            KEY_CAPITAL_Q = 109,
            KEY_CAPITAL_R = 110,
            KEY_CAPITAL_S = 111,
            KEY_CAPITAL_T = 112,
            KEY_CAPITAL_U = 113,
            KEY_CAPITAL_V = 114,
            KEY_CAPITAL_W = 115,
            KEY_CAPITAL_X = 116,
            KEY_CAPITAL_Y = 117,
            KEY_CAPITAL_Z = 118,
            KEY_LEFT_BRACKET = 119,
            KEY_BACK_SLASH = 120,
            KEY_RIGHT_BRACKET = 121,
            KEY_UNDERSCORE = 122,
            KEY_GRAVE = 123,
            KEY_A = 124,
            KEY_B = 125,
            KEY_C = 126,
            KEY_D = 127,
            KEY_E = 128,
            KEY_F = 129,
            KEY_G = 131,
            KEY_H = 132,
            KEY_I = 133,
            KEY_J = 134,
            KEY_K = 135,
            KEY_L = 136,
            KEY_M = 137,
            KEY_N = 138,
            KEY_O = 139,
            KEY_P = 140,
            KEY_Q = 141,
            KEY_R = 142,
            KEY_S = 143,
            KEY_T = 144,
            KEY_U = 145,
            KEY_V = 146,
            KEY_W = 147,
            KEY_X = 148,
            KEY_Y = 149,
            KEY_Z = 150,
            KEY_LEFT_BRACE = 151,
            KEY_BAR = 152,
            KEY_RIGHT_BRACE = 153,
            KEY_TILDE = 154,
            KEY_EURO = 155,
            KEY_POUND = 156,
            KEY_YEN = 157,
            KEY_MIDDLE_DOT = 158,
            KEY_SEARCH = 159,
            KEY_DPAD_LEFT = 160,
            KEY_DPAD_RIGHT = 161,
            KEY_DPAD_UP = 162,
            KEY_DPAD_DOWN = 163,
            KEY_DPAD_CENTER = 164,
            KEY_ENTER = 165,
            KEY_PLAY = 166;

    public EventKeyboard(long address) {
        super(address);
    }

    public native void allocate(@Cast("cocos2d::EventKeyboard::KeyCode") int keyCode, boolean isPressed);

    public EventKeyboard(int keyCode, boolean isPressed) {
        allocate(keyCode, isPressed);
    }

//    public native boolean isPressed();

    @Cast("int")
    public native int getKeyCode();

}
