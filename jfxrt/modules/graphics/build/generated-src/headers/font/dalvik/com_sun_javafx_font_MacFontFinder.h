/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_sun_javafx_font_MacFontFinder */

#ifndef _Included_com_sun_javafx_font_MacFontFinder
#define _Included_com_sun_javafx_font_MacFontFinder
#ifdef __cplusplus
extern "C" {
#endif
#undef com_sun_javafx_font_MacFontFinder_SystemFontType
#define com_sun_javafx_font_MacFontFinder_SystemFontType 2L
#undef com_sun_javafx_font_MacFontFinder_MonospacedFontType
#define com_sun_javafx_font_MacFontFinder_MonospacedFontType 1L
/*
 * Class:     com_sun_javafx_font_MacFontFinder
 * Method:    getFont
 * Signature: (I)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_sun_javafx_font_MacFontFinder_getFont
  (JNIEnv *, jclass, jint);

/*
 * Class:     com_sun_javafx_font_MacFontFinder
 * Method:    getSystemFontSize
 * Signature: ()F
 */
JNIEXPORT jfloat JNICALL Java_com_sun_javafx_font_MacFontFinder_getSystemFontSize
  (JNIEnv *, jclass);

/*
 * Class:     com_sun_javafx_font_MacFontFinder
 * Method:    getFontData
 * Signature: ()[Ljava/lang/String;
 */
JNIEXPORT jobjectArray JNICALL Java_com_sun_javafx_font_MacFontFinder_getFontData
  (JNIEnv *, jclass);

#ifdef __cplusplus
}
#endif
#endif
