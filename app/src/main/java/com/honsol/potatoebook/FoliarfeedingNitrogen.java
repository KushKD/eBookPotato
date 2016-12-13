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

public class FoliarfeedingNitrogen extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foliarfeeding_nitrogen);

        String text = "Among the nutrient elements, N as NH4+ or NO3- ions or even NH2 form can easily be adsorbed, translocated and metabolized in plant system and can be used for foliar application.  Urea has been found to be quite effective in raising potato yield when used as foliar application. Since urea contains biuret which is toxic to leaf, causing leaf burn, its concentration should not exceed 0.5 per cent in urea. The efficiency of foliar application of urea is 1.5 times higher than its soil application in alluvial soils. Foliar fertilization is more useful in hills, where vegetative growth and relative atmospheric humidity are higher during bulking stage than in plains. Moreover, urea is compatible for mixing with fungicides/pesticides which adds to its advantage for foliar application. In the case of leaf spots of potato combined application of urea and mancozeb has been found to be more effective than fungicide alone.";

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

        back_Bt = (Button) findViewById(R.id.back);
        back_Bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FoliarfeedingNitrogen.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {


    }
}