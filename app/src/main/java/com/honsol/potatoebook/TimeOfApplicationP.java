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

public class TimeOfApplicationP extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_of_application_p);

        String text  ="Potato plant needs P at early stages of development thus its application at planting is recommended. Like P, application of K at planting time in furrows has been found to be better than its application above or below seed tubers or broadcasting in hill soils. In ware potato crop, split application of K i.e. half at planting and half at earthing up alongwith N has a positive effect on the yield of large tubers. Foliar application of K is done, then 2 per cent  KCl at 50 or 70 days after planting has been found quite effective in Kufri Badshah in northern plains and helped in saving in K dose by 40 kg K2O/ha.";
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
                TimeOfApplicationP.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {

    }
}