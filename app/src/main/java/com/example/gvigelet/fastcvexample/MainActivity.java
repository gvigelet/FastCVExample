package com.example.gvigelet.fastcvexample;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.nio.ShortBuffer;

public class MainActivity extends AppCompatActivity {


    /** Logging tag */
    private static final String         TAG               = "LoadJpeg";

    static
    {
        // Load JNI library
        System.loadLibrary( "loadjpeg" );
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Resumes camera preview
     */
    @Override
    protected void onResume()
    {
        super.onResume();

        //loadJPEG( "/sdcard/test.jpg" );

    }

    /**
     * Loads a JPEG into luminance data
     * @param fileName
     */
    private void loadJPEG( String fileName )
    {
        Bitmap bmp = BitmapFactory.decodeFile( fileName );
        if( bmp != null && bmp.getConfig() == Bitmap.Config.RGB_565 ) {

            ShortBuffer rgbBuf =
                    ShortBuffer.allocate( bmp.getWidth()*bmp.getHeight() );

            bmp.copyPixelsToBuffer( rgbBuf );

            convertToLum( rgbBuf.array(), bmp.getWidth(), bmp.getHeight() );
        }
    }


    /**
     * Performs conversion from RGB565 to Luminance in native.
     * @param data ShortByte.array() data.
     * @param w Width of buffer
     * @param h Height of buffer
     */
    private native void convertToLum( short[] data, int w, int h );

}
