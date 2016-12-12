package Presentation;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * Created by kuush on 12/12/2016.
 */

public class Char extends ImageView {

    Char (Context context, Drawable drawable) {
        super(context);
        setBackgroundDrawable(drawable);
    }


}
