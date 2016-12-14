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

public class Areas extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_areas);
        String text  =  "All varieties are not suitable for processing. The tuber dry matter content and the reducing sugar content of potatoes are the two most important parameters, which determine the yield, texture and quality of processed products. The potato chipping industries demand varieties with more than 20% dry matter and reducing sugars less than 0.15% on fresh tuber weight basis. It has been observed that temperature plays a dominant role in the accumulation of dry matter and reducing sugar in potatoes. Generally, places having average night temperature of 10°C or more, especially in last 30 days of crop growth, produce good processing quality tubers having high dry matter content and low reducing sugars. The processing quality generally improves as we move from North towards the warmer regions of North eastern plains and peninsular India. The Malwa region of Madhya Pradesh, several parts in Gujarat, Rajasthan, Assam, Bihar, West Bengal and Karnataka have been found to produce potatoes having high dry matter and low sugars. Until now only two varieties, viz. Kufri Jyoti and Kufri Lauvkar grown at above mentioned locations were found suitable for producing potatoes of good processing quality.";

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
                Areas.this.finish();
            }
        });

    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {


    }
}
