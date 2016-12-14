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

public class MH extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mh);
        String text  = "MH is the only sprout inhibitor that is applied as a spray to foliage while others are applied to potatoes in storage. MH applied to foliage is translocated to tubers and 10-15 days are needed for the accumulation of MH in tubers in sufficient concentration to inhibit sprout growth. Maleic Hydrazide was the only sprout suppressant registered for commercial use in India until 1998. 0.30% MH applied 4 weeks before haulm cutting is effective in suppressing sprout growth without any adverse effect on tuber yield and quality. The tolerance limit for MH residues is 50 ppm.";
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
                MH.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {
    }
}
