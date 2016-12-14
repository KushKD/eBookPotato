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

public class Tubermoth extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tubermoth);
        String text  = " The potato tuber moth, Phthorimaea operculella (Zeller), (Lepidoptera: Gelechiidae) (PTM) is a native of South America and is the most obnoxious pest of potato both in fields and the country stores. In areas where the pest is left unmanaged, the losses to potatoes kept in the country stores may be as high as 70 per cent. Due to inadequate cold storage capacity, raising more than one crop in a year and non-adoption of recommended control measures, PTM has the status of a serious/key pest. Prolonged dry and hot weather is quite conducive for PTM multiplication.  PTM larvae damage the crop foliage and also stems, exposed tubers in field and stored tubers in the country stores with estimated losses to the tune of 26 and 56 per cent, respectively.  In infested tubers, the feeding tunnels are packed with black excretory pellets and the larvae are inside the tunnels. PTM can be controlled effectively only through a combination of different methods.\n" +
                "\n ";
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
                Tubermoth.this.finish();
            }
        });



        ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Custom_Dialog CD = new Custom_Dialog();
                CD.showDialog(Tubermoth.this,"tubermoth1");
            }
        });


        ImageView  imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Custom_Dialog CD = new Custom_Dialog();
                CD.showDialog(Tubermoth.this,"tubermoth2");
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {
    }
}
