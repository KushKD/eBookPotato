package com.honsol.potatoebook;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import Interfaces.TextLinkClickListener;
import Presentation.LinkEnabledTextView;

public class CP_Processing extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

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

        back_Bt = (Button)findViewById(R.id.back);
        back_Bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CP_Processing.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {

        if(clickedString.equalsIgnoreCase("_chips")){
            Intent t = new Intent(CP_Processing.this,Chips.class);
            startActivity(t);
        }else if(clickedString.equalsIgnoreCase("_french_fries")){
            Intent t = new Intent(CP_Processing.this,FrenchFries.class);
            startActivity(t);
        }else if(clickedString.equalsIgnoreCase("_flakes")) {
            Intent t = new Intent(CP_Processing.this,Flakes.class);
            startActivity(t);
        }else if(clickedString.equalsIgnoreCase("_soup_thickner")) {
            Intent t = new Intent(CP_Processing.this,Potatosoupthickener.class);
            startActivity(t);
        }else if(clickedString.equalsIgnoreCase("_dehydrated_chips")) {
            Intent t = new Intent(CP_Processing.this,Dehydratedchips.class);
            startActivity(t);
        }else if(clickedString.equalsIgnoreCase("_potato_sticks")) {
            Intent t = new Intent(CP_Processing.this,Potatosticks.class);
            startActivity(t);
        }else if(clickedString.equalsIgnoreCase("_potato_custard_powder")) {
            Intent t = new Intent(CP_Processing.this,Custardpowder.class);
            startActivity(t);
        }else if(clickedString.equalsIgnoreCase("_potato_starch_and_flour")) {
            Intent t = new Intent(CP_Processing.this,Potatostarchflour.class);
            startActivity(t);
        }else if(clickedString.equalsIgnoreCase("_dehydrated_products")) {
            Intent t = new Intent(CP_Processing.this,dehydratedproducts.class);
            startActivity(t);
        }else if(clickedString.equalsIgnoreCase("_varieties_for_processing")) {
            Intent t = new Intent(CP_Processing.this,Varietiesforprocessing.class);
            startActivity(t);
        }else if(clickedString.equalsIgnoreCase("_areas")) {
            Intent t = new Intent(CP_Processing.this,Areas.class);
            startActivity(t);
        }else
        {
            Log.e("Hyperlink is :x: " + clickedString, "Hyperlink is :: " + clickedString);
        }

    }
}
