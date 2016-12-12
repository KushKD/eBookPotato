package com.honsol.potatoebook;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.util.Log;
import android.view.View;

import Interfaces.TextLinkClickListener;
import Presentation.LinkEnabledTextView;

public class CP_Processing extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cp__processing);
        String text  =  "Processing of potatoes in India is desirable to avoid gluts, to solve the problem of storage of large quantities of potatoes during periods of extremely high temperature in the Gangetic plains, and to serve as a means to increase the supply in off-seasons. Among processed products, _chips, _french_fries and _flakes are the most popular forms. However, there is a good future for dehydrated products viz. _dehydrated_chips, _potato_sticks, _potato_dice and for newly developed edibles like _potato_custard_powder, _soup_thickner, biscuits etc. made of _potato_starch_and_flour. Village level _dehydrated_products are also prepared in many situations. The quality of processed products depends on the morphological characters such as tuber shape, size, depth of eyes as well as on the chemical characters like dry matter and reducing sugar content of tubers. Potatoes with high dry matter content (>20%) are preferred for potato chips, French fries and dehydrated products, while those with low dry matter content are best suited for canning. Therefore _varieties_for_processing have to be specially bred.  Kufri Chipsona1 and Kufri Chipsona2, two low sugar and high dry matter potato varieties released during 1998 by Central Potato Research Institute are suitable for chipping and can be grown in the entire Gangetic plains and central Indian plains to produce chips of excellent quality.  However some _areas are very good for production of potatoes for processing, due to the prevailing temperatures during the growing season in these areas.\n";
        check = (LinkEnabledTextView)findViewById(R.id.linkenabledtextview) ;
        // check = new LinkEnabledTextView(this, null);
        check.setOnTextLinkClickListener(this);
        check.gatherLinksForText(text);
        check.setTextColor(Color.BLACK);
        check.setLinkTextColor(Color.BLUE);
        // setContentView(check);

        MovementMethod m = check.getMovementMethod();
        if ((m == null) || !(m instanceof LinkMovementMethod)) {
            if (check.getLinksClickable()) {
                check.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {

        if(clickedString.equalsIgnoreCase("_chips")){
            Log.e("Hyperlink is :1: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_french_fries")){
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_ flakes")) {
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_dehydrated_chips")) {
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_ potato_sticks")) {
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_potato_dice")) {
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_potato_custard_powder")) {
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_soup_thickner")) {
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_ potato_starch_and_flour")) {
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_dehydrated_products")) {
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_ varieties_for_processing")) {
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_areas")) {
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        }else
        {
            Log.e("Hyperlink is :x: " + clickedString, "Hyperlink is :: " + clickedString);
        }

    }
}
