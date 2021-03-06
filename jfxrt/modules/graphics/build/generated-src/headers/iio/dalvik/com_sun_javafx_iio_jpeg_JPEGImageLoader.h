/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_sun_javafx_iio_jpeg_JPEGImageLoader */

#ifndef _Included_com_sun_javafx_iio_jpeg_JPEGImageLoader
#define _Included_com_sun_javafx_iio_jpeg_JPEGImageLoader
#ifdef __cplusplus
extern "C" {
#endif
#undef com_sun_javafx_iio_jpeg_JPEGImageLoader_JCS_UNKNOWN
#define com_sun_javafx_iio_jpeg_JPEGImageLoader_JCS_UNKNOWN 0L
#undef com_sun_javafx_iio_jpeg_JPEGImageLoader_JCS_GRAYSCALE
#define com_sun_javafx_iio_jpeg_JPEGImageLoader_JCS_GRAYSCALE 1L
#undef com_sun_javafx_iio_jpeg_JPEGImageLoader_JCS_RGB
#define com_sun_javafx_iio_jpeg_JPEGImageLoader_JCS_RGB 2L
#undef com_sun_javafx_iio_jpeg_JPEGImageLoader_JCS_YCbCr
#define com_sun_javafx_iio_jpeg_JPEGImageLoader_JCS_YCbCr 3L
#undef com_sun_javafx_iio_jpeg_JPEGImageLoader_JCS_CMYK
#define com_sun_javafx_iio_jpeg_JPEGImageLoader_JCS_CMYK 4L
#undef com_sun_javafx_iio_jpeg_JPEGImageLoader_JCS_YCC
#define com_sun_javafx_iio_jpeg_JPEGImageLoader_JCS_YCC 5L
#undef com_sun_javafx_iio_jpeg_JPEGImageLoader_JCS_RGBA
#define com_sun_javafx_iio_jpeg_JPEGImageLoader_JCS_RGBA 6L
#undef com_sun_javafx_iio_jpeg_JPEGImageLoader_JCS_YCbCrA
#define com_sun_javafx_iio_jpeg_JPEGImageLoader_JCS_YCbCrA 7L
#undef com_sun_javafx_iio_jpeg_JPEGImageLoader_JCS_YCCA
#define com_sun_javafx_iio_jpeg_JPEGImageLoader_JCS_YCCA 10L
#undef com_sun_javafx_iio_jpeg_JPEGImageLoader_JCS_YCCK
#define com_sun_javafx_iio_jpeg_JPEGImageLoader_JCS_YCCK 11L
/*
 * Class:     com_sun_javafx_iio_jpeg_JPEGImageLoader
 * Method:    initJPEGMethodIDs
 * Signature: (Ljava/lang/Class;)V
 */
JNIEXPORT void JNICALL Java_com_sun_javafx_iio_jpeg_JPEGImageLoader_initJPEGMethodIDs
  (JNIEnv *, jclass, jclass);

/*
 * Class:     com_sun_javafx_iio_jpeg_JPEGImageLoader
 * Method:    disposeNative
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_com_sun_javafx_iio_jpeg_JPEGImageLoader_disposeNative
  (JNIEnv *, jclass, jlong);

/*
 * Class:     com_sun_javafx_iio_jpeg_JPEGImageLoader
 * Method:    initDecompressor
 * Signature: (Ljava/io/InputStream;)J
 */
JNIEXPORT jlong JNICALL Java_com_sun_javafx_iio_jpeg_JPEGImageLoader_initDecompressor
  (JNIEnv *, jobject, jobject);

/*
 * Class:     com_sun_javafx_iio_jpeg_JPEGImageLoader
 * Method:    startDecompression
 * Signature: (JIII)I
 */
JNIEXPORT jint JNICALL Java_com_sun_javafx_iio_jpeg_JPEGImageLoader_startDecompression
  (JNIEnv *, jobject, jlong, jint, jint, jint);

/*
 * Class:     com_sun_javafx_iio_jpeg_JPEGImageLoader
 * Method:    decompressIndirect
 * Signature: (JZ[B)Z
 */
JNIEXPORT jboolean JNICALL Java_com_sun_javafx_iio_jpeg_JPEGImageLoader_decompressIndirect
  (JNIEnv *, jobject, jlong, jboolean, jbyteArray);

#ifdef __cplusplus
}
#endif
#endif
