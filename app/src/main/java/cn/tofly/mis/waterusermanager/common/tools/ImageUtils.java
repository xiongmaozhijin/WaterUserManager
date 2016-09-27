package cn.tofly.mis.waterusermanager.common.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import cn.tofly.mis.waterusermanager.R;


/**
 * 图片加载 使用universalimageloader库
 * Created by baoxing on 2016/8/22.
 */
public class ImageUtils {

    private static DisplayImageOptions mDisplayImageOptions;

    public static void init(Context context) {
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(context);
        ImageLoader.getInstance().init(configuration);

        if (mDisplayImageOptions == null) {
            mDisplayImageOptions = new DisplayImageOptions.Builder()
                    .showImageForEmptyUri(R.drawable.drawable_gray_bitmap)
                    .showImageOnFail(R.drawable.drawable_gray_bitmap)
                    .resetViewBeforeLoading(true)
                    .cacheOnDisk(true)
                    .cacheInMemory(true)
                    .bitmapConfig(Bitmap.Config.RGB_565)
//                    .displayer(new FadeInBitmapDisplayer(300))
                    .build();
        }
    }

    public static void displayImage(String url, ImageView imageView) {
        ImageLoader.getInstance().displayImage(url, imageView, mDisplayImageOptions);
    }

}
