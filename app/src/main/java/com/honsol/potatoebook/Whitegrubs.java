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

public class Whitegrubs extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whitegrubs);
        String text  = " White grubs are distributed throughout the country. The damage to potato is caused by the grubs only, which feed on rootlets, roots and tubers. The white grubs infested tubers, have poor market value.  The grubs damage the tubers without any symptoms on the foliage.  Thus, the farmer remains unaware of the damage to tubers until harvest. The damage is more severe in the years following high adult activity. In Shimla hills, yield losses to potato crop have been reported to be as high as 85%.\n" +
                "\n" +
                "The larval stages live in the soil from July-November and initially feed upon roots of living plants, ingesting at the same time large quantities of soil and dead organic matter and afterward feed upon tubers. Emergence of adults starts with the onset of first monsoon showers in June onwards.  Understanding the life cycle of white grubs makes it easy to manage them.\n" +
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
                Whitegrubs.this.finish();
            }
        });



        ImageView  imageView1 = (ImageView) findViewById(R.id.imageView1);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Custom_Dialog CD = new Custom_Dialog();
                CD.showDialog(Whitegrubs.this,"whitegrub1");
            }
        });


        ImageView  imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Custom_Dialog CD = new Custom_Dialog();
                CD.showDialog(Whitegrubs.this,"whitegrub2");
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {
    }
}
