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

public class Sprout_inhibition extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sprout_inhibition);
        String text  = "Once the dormancy is released, sprouts begin to grow. When stored at 2-4O C sprout growth does not take place. Potatoes stored at this temperature are suitable for seed but not for ware and processing purposes. Potatoes meant for ware and processing purposes are stored at higher temperatures generally 10-12O C and at these storage temperatures sprout growth takes place which need to be checked with a sprout inhibitor. Several sprout inhibitors have been used on potatoes. Some of the compounds used for checking sprout growth included several alcohols, acetaldehyde, ethylene etc. Naphthalene acetic acid (NAA) and its derivative methyl ester of alpha naphthalene acetic acid (MENA), 2-4 dichlorophenoxy acetic acid (2,4-D) and 2,4,5-trichlorophenoxy acetic acid (2,4,5-T) have also been reported to show sprout suppression effect. Although a number of chemical sprout inhibitors have been tried, only three have gained commercial acceptance. They are TCNB(Tetrachloro nitrobenzene), MH(Maleic Hydrazide), CIPC(Isopropyl-N-chlorophenyl carbamate) and some natural substance as well as irradiation have been found effective.\n" +
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
                Sprout_inhibition.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {
    }
}
