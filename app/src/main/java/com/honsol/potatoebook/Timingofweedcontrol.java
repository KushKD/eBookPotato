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

public class Timingofweedcontrol extends AppCompatActivity implements TextLinkClickListener {
    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timingofweedcontrol);
        String text = "Weed management is the process of limiting the weed infestation so that the crop could be grown profitably. Wider spacing, frequent irrigations/rains and liberal use of manures and fertilizers provide favourable conditions for an early growth of the weeds, well before the crop emergence in the potato crop. Weed control should be done before the period when its presence would affect the yield seriously.  This period is known as the critical period of crop weed competition. Early weed competition usually reduces crop yields more than late season weed growth. The critical period of crop-weed competition is first 4-6 and 6-8 weeks after planting in the plains and hills, respectively, when the crop must be kept free from weeds.  Weeding should not be delayed beyond this period as this adversely affects the yield.\n" +
                "\n" +
                "The best crop production practices favorable to potato plants should be adopted so that weeds are ‘crowded out’. Planting of well sprouted seed tubers at sufficient moisture and proper depth with proper dose of manures and fertilizers in bands near the root zone of the crop ensures vigorous growth and early canopy cover.\n" +
                "\n" +
                "Ensuring proper sanitation through inclusion of smother crops like cowpea and green manure crops in sequence, summer cultivation and thorough seedbed preparation also minimises the weed competition in the potato crop.\n" +
                "\n";

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
                Timingofweedcontrol.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {



    }
}
