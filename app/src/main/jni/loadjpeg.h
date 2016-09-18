//
// Created by gvigelet on 9/18/16.
//

#ifndef FASTCVEXAMPLE_LOADJPEG_H
#define FASTCVEXAMPLE_LOADJPEG_H

//==============================================================================
// Include Files
//==============================================================================
#include <jni.h>

//==============================================================================
// Declarations
//==============================================================================
extern "C" {

   //---------------------------------------------------------------------------
   /// @brief
   ///   Converts the RGB565 image to luminance
   /// @param img
   ///   pointer to RGB565 buffer that is to be converted, must contain
   ///   w*h*2 bytes
   /// @param w
   ///    width of buffer
   /// @param h
   ///    height of buffer
   //---------------------------------------------------------------------------
   JNIEXPORT void JNICALL Java_com_qualcomm_loadjpeg_LoadJpeg_convertToLum
   (
      JNIEnv*     env,
      jobject     obj,
      jshortArray  img,
      jint        w,
      jint        h
   );

};

#endif //FASTCVEXAMPLE_LOADJPEG_H
