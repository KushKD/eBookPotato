package Interfaces;

import android.view.View;

/**
 * Created by kuush on 12/10/2016.
 */

public interface TextLinkClickListener{
        /*
          *  This method is called when the TextLink is clicked from LinkEnabledTextView
          */
        public void onTextLinkClick(View textView, String clickedString);
}
