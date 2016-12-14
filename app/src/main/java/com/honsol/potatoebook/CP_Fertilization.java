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
import android.widget.ImageView;

import Interfaces.TextLinkClickListener;
import Presentation.LinkEnabledTextView;
import Utils.Custom_Dialog;

public class CP_Fertilization extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;
    ImageView imageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cp__fertilization);

        String text  =  " Potato is a short duration shallow rooted crop.  Therefore, it is highly responsive to _fertilization and hence its importance.  As in the case of other crops _Nitrogen is the first limiting nutrient in potato also. _Phosphorous_and_potash are also very important in the case of potato phosphorus due to its effect on the root system and potash due to its effect on translocation of photsynthate.  Apart from these major nutrients, _calcium and _sulphur is also becoming limiting and potato responses to both have been observed. Zinc, iron, manganese, magnesium, copper and boron are the _micronutrients found limiting in potato growing soils and potato responses to them have also been observed in India."
                ;
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
                CP_Fertilization.this.finish();
            }
        });

        imageView1 = (ImageView) findViewById(R.id.imageView1);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Custom_Dialog CD = new Custom_Dialog();
                CD.showDialog(CP_Fertilization.this,"k_deff2");
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {
        //Log.e("Hyperlink is :: " + clickedString, "Hyperlink is :: " + clickedString);
        if(clickedString.equalsIgnoreCase("_fertilization")){
            Log.e("Hyperlink is :1: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_Nitrogen")){
            Intent i = new Intent(CP_Fertilization.this,Nitrogen.class);
            startActivity(i);
        }else if(clickedString.equalsIgnoreCase("_Phosphorous_and_potash")) {
            Intent i = new Intent(CP_Fertilization.this,PhosphorusandPotash.class);
            startActivity(i);
        }else if(clickedString.equalsIgnoreCase("_calcium")) {
            Intent i = new Intent(CP_Fertilization.this,CalciumnMagnisium.class);
            startActivity(i);
        }else if(clickedString.equalsIgnoreCase("_sulphur")) {
            Intent i = new Intent(CP_Fertilization.this,Sulphur.class);
            startActivity(i);
        }else if(clickedString.equalsIgnoreCase("_micronutrients")) {
            Intent i = new Intent(CP_Fertilization.this,Micronutrient.class);
            startActivity(i);
        }else
        {
            Log.e("Hyperlink is :x: " + clickedString, "Hyperlink is :: " + clickedString);
        }
    }
}
