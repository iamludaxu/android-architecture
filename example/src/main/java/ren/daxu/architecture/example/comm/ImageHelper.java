package ren.daxu.architecture.example.comm;

import android.content.Context;
import android.widget.ImageView;

public final class ImageHelper {


    public static void showCommGif(Context fragmentActivity, String url, ImageView imageView){

        GlideApp.with(fragmentActivity).load(url).into(imageView);
    }

}
