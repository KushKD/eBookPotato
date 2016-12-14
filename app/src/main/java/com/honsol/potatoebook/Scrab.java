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

public class Scrab extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrab);
        String text  = "Common Scab is very wide spread soil/tuber borne disease.  It does not cause yield loss but disfigures the tubers with the result there is economic loss.  It is caused by Streptomyces sp.  The symptoms ranges from a) abrasions of skin, russettings b) corky lesions around lenticels which may be star shaped or irregularly circular c) irregular concentric corky rings around lenticels d) raised rough corky pustules  and e) 3-4 mm deep pits surrounded by hard corky tissues.\n" +
                "\n" +
                "Use of healthy seed is the first requirement for control of the disease.\n" +
                "\n" +
                "Treating the seed tubers with organo merculrial compounds (0.015% for 20 minutes or boric acid (3% for 30 minutes) before or after cold storage is recommended.\n" +
                "\n" +
                "Keeping the soil at optimum moisture content right from tuber initiation also checks the disease development.\n" +
                "\n" +
                "Crop rotation with wheat, peas, oats, barley, lupin, soybean, sorghum, bajra and green manures checks the disease.\n" +
                "\n" +
                "Summer cultivation in the north western plains also checks the disease.\n" +
                "\n";

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
                Scrab.this.finish();
            }
        });

        ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Custom_Dialog CD = new Custom_Dialog();
                CD.showDialog(Scrab.this,"csfig");
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {














    }
}
