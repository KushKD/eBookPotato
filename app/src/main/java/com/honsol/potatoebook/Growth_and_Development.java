package com.honsol.potatoebook;

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

public class Growth_and_Development extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_growth_and__development);
        String text  =  "The cultural practices are developed considering the physiological requirements during each phenological phase of the crop.  Planting to emergence, emergence to attainment of maximum LAI, and maximum LAI to senescence are the major phases of foliage growth while in the case of tubers, emergence to tuber initiation, tuber initiation to maximum bulking phase and maximum bulking to cessation of bulking are the important phases. Manipulation of cultural practices would affect the duration of the different phases as well as the growth and development during the phase.\n" +
                "\n" +
                "The cultural practices should ensure quick emergence, rapid development of the canopy, maintain full canopy cover as long as possible and the decline in canopy due to senescence should be as slow as possible, ensure early tuber initiation and promote rapid bulking of the tubers for as long as possible. Through cultural practices we provide the best possible environment according to the requirement of the phase. e.g. to mitigate the effect of high temperature we plant deep so that the seed tubers are at relatively cool temperatures while if the temperatures are cool shallow planting is done for early emergence. Some of the ways cultural practices affect the growth and development of potato is shown in above figure.";
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
                Growth_and_Development.this.finish();
            }
        });

        ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Custom_Dialog CD = new Custom_Dialog();
                CD.showDialog(Growth_and_Development.this,"grothndevelopment");
            }
        });

    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {
    }
}
