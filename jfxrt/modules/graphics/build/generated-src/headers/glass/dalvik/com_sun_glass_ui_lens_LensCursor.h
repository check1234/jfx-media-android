/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_sun_glass_ui_lens_LensCursor */

#ifndef _Included_com_sun_glass_ui_lens_LensCursor
#define _Included_com_sun_glass_ui_lens_LensCursor
#ifdef __cplusplus
extern "C" {
#endif
#undef com_sun_glass_ui_lens_LensCursor_CURSOR_NONE
#define com_sun_glass_ui_lens_LensCursor_CURSOR_NONE -1L
#undef com_sun_glass_ui_lens_LensCursor_CURSOR_CUSTOM
#define com_sun_glass_ui_lens_LensCursor_CURSOR_CUSTOM 0L
#undef com_sun_glass_ui_lens_LensCursor_CURSOR_DEFAULT
#define com_sun_glass_ui_lens_LensCursor_CURSOR_DEFAULT 1L
#undef com_sun_glass_ui_lens_LensCursor_CURSOR_TEXT
#define com_sun_glass_ui_lens_LensCursor_CURSOR_TEXT 2L
#undef com_sun_glass_ui_lens_LensCursor_CURSOR_CROSSHAIR
#define com_sun_glass_ui_lens_LensCursor_CURSOR_CROSSHAIR 3L
#undef com_sun_glass_ui_lens_LensCursor_CURSOR_CLOSED_HAND
#define com_sun_glass_ui_lens_LensCursor_CURSOR_CLOSED_HAND 4L
#undef com_sun_glass_ui_lens_LensCursor_CURSOR_OPEN_HAND
#define com_sun_glass_ui_lens_LensCursor_CURSOR_OPEN_HAND 5L
#undef com_sun_glass_ui_lens_LensCursor_CURSOR_POINTING_HAND
#define com_sun_glass_ui_lens_LensCursor_CURSOR_POINTING_HAND 6L
#undef com_sun_glass_ui_lens_LensCursor_CURSOR_RESIZE_LEFT
#define com_sun_glass_ui_lens_LensCursor_CURSOR_RESIZE_LEFT 7L
#undef com_sun_glass_ui_lens_LensCursor_CURSOR_RESIZE_RIGHT
#define com_sun_glass_ui_lens_LensCursor_CURSOR_RESIZE_RIGHT 8L
#undef com_sun_glass_ui_lens_LensCursor_CURSOR_RESIZE_UP
#define com_sun_glass_ui_lens_LensCursor_CURSOR_RESIZE_UP 9L
#undef com_sun_glass_ui_lens_LensCursor_CURSOR_RESIZE_DOWN
#define com_sun_glass_ui_lens_LensCursor_CURSOR_RESIZE_DOWN 10L
#undef com_sun_glass_ui_lens_LensCursor_CURSOR_RESIZE_LEFTRIGHT
#define com_sun_glass_ui_lens_LensCursor_CURSOR_RESIZE_LEFTRIGHT 11L
#undef com_sun_glass_ui_lens_LensCursor_CURSOR_RESIZE_UPDOWN
#define com_sun_glass_ui_lens_LensCursor_CURSOR_RESIZE_UPDOWN 12L
#undef com_sun_glass_ui_lens_LensCursor_CURSOR_DISAPPEAR
#define com_sun_glass_ui_lens_LensCursor_CURSOR_DISAPPEAR 13L
#undef com_sun_glass_ui_lens_LensCursor_CURSOR_WAIT
#define com_sun_glass_ui_lens_LensCursor_CURSOR_WAIT 14L
#undef com_sun_glass_ui_lens_LensCursor_CURSOR_RESIZE_SOUTHWEST
#define com_sun_glass_ui_lens_LensCursor_CURSOR_RESIZE_SOUTHWEST 15L
#undef com_sun_glass_ui_lens_LensCursor_CURSOR_RESIZE_SOUTHEAST
#define com_sun_glass_ui_lens_LensCursor_CURSOR_RESIZE_SOUTHEAST 16L
#undef com_sun_glass_ui_lens_LensCursor_CURSOR_RESIZE_NORTHWEST
#define com_sun_glass_ui_lens_LensCursor_CURSOR_RESIZE_NORTHWEST 17L
#undef com_sun_glass_ui_lens_LensCursor_CURSOR_RESIZE_NORTHEAST
#define com_sun_glass_ui_lens_LensCursor_CURSOR_RESIZE_NORTHEAST 18L
#undef com_sun_glass_ui_lens_LensCursor_CURSOR_MOVE
#define com_sun_glass_ui_lens_LensCursor_CURSOR_MOVE 19L
/*
 * Class:     com_sun_glass_ui_lens_LensCursor
 * Method:    _setNativeCursor
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_com_sun_glass_ui_lens_LensCursor__1setNativeCursor
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_sun_glass_ui_lens_LensCursor
 * Method:    _releaseNativeCursor
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_com_sun_glass_ui_lens_LensCursor__1releaseNativeCursor
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_sun_glass_ui_lens_LensCursor
 * Method:    _createNativeCursorByType
 * Signature: (I)J
 */
JNIEXPORT jlong JNICALL Java_com_sun_glass_ui_lens_LensCursor__1createNativeCursorByType
  (JNIEnv *, jobject, jint);

/*
 * Class:     com_sun_glass_ui_lens_LensCursor
 * Method:    _createNativeCursorInts
 * Signature: (II[III)J
 */
JNIEXPORT jlong JNICALL Java_com_sun_glass_ui_lens_LensCursor__1createNativeCursorInts
  (JNIEnv *, jobject, jint, jint, jintArray, jint, jint);

/*
 * Class:     com_sun_glass_ui_lens_LensCursor
 * Method:    _createNativeCursorBytes
 * Signature: (II[BII)J
 */
JNIEXPORT jlong JNICALL Java_com_sun_glass_ui_lens_LensCursor__1createNativeCursorBytes
  (JNIEnv *, jobject, jint, jint, jbyteArray, jint, jint);

/*
 * Class:     com_sun_glass_ui_lens_LensCursor
 * Method:    _createNativeCursorDirect
 * Signature: (IILjava/nio/Buffer;III)J
 */
JNIEXPORT jlong JNICALL Java_com_sun_glass_ui_lens_LensCursor__1createNativeCursorDirect
  (JNIEnv *, jobject, jint, jint, jobject, jint, jint, jint);

/*
 * Class:     com_sun_glass_ui_lens_LensCursor
 * Method:    _setVisible
 * Signature: (Z)V
 */
JNIEXPORT void JNICALL Java_com_sun_glass_ui_lens_LensCursor__1setVisible
  (JNIEnv *, jclass, jboolean);

#ifdef __cplusplus
}
#endif
#endif
