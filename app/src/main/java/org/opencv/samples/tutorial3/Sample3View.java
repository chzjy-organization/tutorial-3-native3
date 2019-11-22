package org.opencv.samples.tutorial3;

import android.content.Context;
import android.graphics.Bitmap;

class Sample3View extends SampleViewBase {

    public Sample3View(Context context) {
        super(context);
    }

    @Override
    protected Bitmap processFrame(byte[] data) {
        int frameSize = getFrameWidth() * getFrameHeight();
        int[] rgba = new int[frameSize];

	
      int nc=  FindFeatures(getFrameWidth(), getFrameHeight(), data, rgba);
System.out.println(nc+"------------");
        Bitmap bmp = Bitmap.createBitmap(getFrameWidth(), getFrameHeight(), Bitmap.Config.ARGB_8888);
        bmp.setPixels(rgba, 0/* offset */, getFrameWidth() /* stride */, 0, 0, getFrameWidth(), getFrameHeight());
        return bmp;
    }

  public native int FindFeatures(int width, int height, byte yuv[], int[] rgba);

    static {
        System.loadLibrary("native_sample");
    }
}
