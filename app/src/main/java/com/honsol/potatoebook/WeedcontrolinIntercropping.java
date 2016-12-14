package com.honsol.potatoebook;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import Interfaces.TextLinkClickListener;
import Presentation.LinkEnabledTextView;
import Utils.Custom_Dialog;

public class WeedcontrolinIntercropping extends AppCompatActivity implements TextLinkClickListener {
    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weedcontrolin_intercropping);
        String text = "Selection of suitable mechanical method/herbicide is a great problem in the intercropping system than in the case of the component crop grown alone. The mechanical method/herbicide selected for weed control should be effective to suppress the weed growth of both the crops without having any deleterious effect on the component crops.  In sugarcane + potato and potato + maize intercropping systems, metribuzin @ 0.7 and 0.5 kg/ha, respectively as pre-emergence to potato provide weed free environment throughout the entire span of both the crops.";

        check = (LinkEnabledTextView) findViewById(R.id.linkenabledtextview);
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
                WeedcontrolinIntercropping.this.finish();
            }
        });



        ImageView  imageView1 = (ImageView) findViewById(R.id.imageView1);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Custom_Dialog CD = new Custom_Dialog();
                CD.showDialog(WeedcontrolinIntercropping.this,"pot_gar2");
            }
        });


        ImageView  imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Custom_Dialog CD = new Custom_Dialog();
                CD.showDialog(WeedcontrolinIntercropping.this,"wh_pot1");
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {



    }
}
