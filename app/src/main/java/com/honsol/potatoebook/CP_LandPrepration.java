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

public class CP_LandPrepration extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;

    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cp__land_prepration);
        String text  =  "Land preparation is crucial to potato since it provides suitable environment for the growth of both roots and tubers.  Proper tillage ensures the proper development of roots as well as helps proper retention and movement of water and nutrients to the roots. Moreover, tillage is also practised to control the weeds as well as to cover the emerging stolons and tubers to prevent them from turning into aerial stems/turning green.  The number and type of cultivations that is required for achieving these objectives is the deciding factor.  Tillage in case of potato mainly falls into two classes _pre_planting_tillage and _post_emergence_tillage though some workers have introduced two more tillage practices namely initial loosening of the soil and pre emergence tillage.  In India and more so in the northern Indo Gangetic plains, the growing season is short and so only two main tillage categories as mentioned above is followed.  Land preparation is done using animal drawn implements mostly in the eastern plains where resource poor farmers are present while mechanical power is used in the western and central Indo Gangetic plains where large scale cultivation is adopted.";

        check = (LinkEnabledTextView)findViewById(R.id.linkenabledtextview) ;
        // check = new LinkEnabledTextView(this, null);
        check.setOnTextLinkClickListener(this);
        check.gatherLinksForText(text);
        check.setTextColor(Color.BLACK);
        check.setLinkTextColor(Color.BLUE);
        // setContentView(check);

        back_Bt = (Button)findViewById(R.id.back);
        back_Bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CP_LandPrepration.this.finish();
            }
        });

        MovementMethod m = check.getMovementMethod();
        if ((m == null) || !(m instanceof LinkMovementMethod)) {
            if (check.getLinksClickable()) {
                check.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }

        ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Custom_Dialog CD = new Custom_Dialog();
                CD.showDialog(CP_LandPrepration.this,"commercial_cs1");
            }
        });

    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {
        //Log.e("Hyperlink is :: " + clickedString, "Hyperlink is :: " + clickedString);
        if(clickedString.equalsIgnoreCase("_post_emergence_tillage")){
            Intent x = new Intent(CP_LandPrepration.this,Postplantingtillage.class);
            startActivity(x);
        }else if(clickedString.equalsIgnoreCase("_pre_planting_tillage")){
            Intent x = new Intent(CP_LandPrepration.this,Preplantingtillage.class);
            startActivity(x);
        }else{
            Log.e("Hyperlink is :x: " + clickedString, "Hyperlink is :: " + clickedString);
        }
    }
}
