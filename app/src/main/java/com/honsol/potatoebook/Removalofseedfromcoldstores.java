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

public class Removalofseedfromcoldstores extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_removalofseedfromcoldstores);


        String text  =  "The removal of seed tubers from cold stores and the duration of pre sprouting depends on the ambient temperature.  The period of sprouting is shortest at the optimal temperature (15-200 C) and is longer at lower or higher ambient temperatures. In the northern plains in case of the early crop, the ambient temperatures are relatively high, therefore, it takes more time (20-25 days) for sprouting.  Therefore, seed preparation (removal from cold stores and its pre-sprouting) has to be scheduled about a month earlier to the date of planting.  Similarly in the late/spring crop, chitting is slow due to cool temperatures.  Therefore, early withdrawal from cold stores to give enough time for chitting (20-25 days) is recommended in this case also.  In the case of the main autumn season crop, the ambient maximum temperatures are around 30-32 oC while the minimum temperatures are around 20-22 oC.  Under these temperatures about 10-12 days is sufficient for chitting  and seed withdrawal and sorting is scheduled accordingly.\n" +
                "\n";
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
                Removalofseedfromcoldstores.this.finish();
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
                CD.showDialog(Removalofseedfromcoldstores.this,"commercial_cs1");
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {


    }


}
