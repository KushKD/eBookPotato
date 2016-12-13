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

public class VarietyNitrogen extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_variety_nitrogen);

        String text  = "The response of variety to N application is positively correlated with its maturity group, genetical potential to produce large grade tubers and more importantly, K composition of the tuber. Long duration varieties, varieties producing more number of large size tubers and varieties showing high uptake of K respond to high levels of N. The long and medium duration varieties like Kufri Badshah, Kufri Sindhuri and Kufri Jyoti are more responsive to N than the short duration varieties like Kufri Chandramukhi.\n" +
                "\n" +
                "The economic response of potato in alluvial soils of northwestern and central Indo- Gangetic plains in the country has been noticed up to 180 kg N /ha. In hill soils, the economic response to N has been observed up to 150 kg N/ha. In the black cotton soils of Deccan plateau and in red soils of Bihar, Orissa and Tamil Nadu, the economic responses have been obtained between 100-140 kg N/ha.\n" +
                "\n" +
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
                VarietyNitrogen.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {


    }
}