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

public class Time  extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        String text  =  "Sufficient N is needed in early stages to quickly build up crop canopy and to enhance leaf area as this influences the bulking rate.  Continuous supply of N delays senescence, consequently the duration of bulking is increased leading to yield increase. Split application of N, i.e. half at planting time and rest at time of earthing, is recommended. This not only reduces leaching losses but also improves N use efficiency.  Split application is more advantageous in case of urea as resorting to split application reduces the dose that needs to be applied at planting and thus can be used to overcome the deleterious effect of higher doses on crop emergence. In higher reaches of Himalayas where the growing season is of 4-5 months and crop is grown under irrigated conditions, three split doses of N has been found better than two splits. However, where late blight is a regular phenomenon and if the variety grown is susceptible to late blight then, application of N, i.e. 2/3 at planting and 1/3 at earthing time is more beneficial than its two splits in equal halves since higher N at planting will hasten initial growth and help giving economic yield before it succumbs to late blight.\n";
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
                Time.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {

    }
}