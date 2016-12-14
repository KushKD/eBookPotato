package com.honsol.potatoebook;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.View;
import android.widget.Button;

import Interfaces.TextLinkClickListener;
import Presentation.LinkEnabledTextView;

public class Processingstorage extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processingstorage);
        String text  = "Potatoes for ware and processing purposes needs to be stored at 8-10O C because at this temperature excessive sugar accumulation does not take place and so are not sweet in taste. Since sugar level is within the acceptable limit these potatoes are suitable for processing. However, when stored at this temperature, sprout growth takes place after the dormancy period, therefore, a sprout suppressant needs to be used to check sprout growth. It is essential that potatoes that go into a store be of good quality and physically and chemically mature. The physical maturity refers to proper skin curing and wound healing. Chemical maturity refers to low reducing sugars and sucrose levels. High sucrose content at the time of storage can lead to accumulation of reducing sugars during long term storage. Prolonged storage at 100C could result in the development of senescent sweetening, which is variety dependent. Senescent sweetening is irreversible and sugar level cannot be decreased through reconditioning.\n" +
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
                Processingstorage.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {
    }
}
