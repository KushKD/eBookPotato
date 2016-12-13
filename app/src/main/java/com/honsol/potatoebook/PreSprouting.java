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

public class PreSprouting extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        String text2 = "Pre sprouting advances the physiological development of the crop i.e. maximum leaf area, maximum tuber bulking rate, senescence etc. occur earlier so that it fits in easily within the growing period available.  Therefore pre-sprouting is advantageous when the available growing period is short but may not be very beneficial if the available growing period is long.  For pre-sprouting, seed tubers after removal from the cold stores should be kept in diffused light for 10-15 days. Ambient temperatures influence the rate of sprout growth. Diffused light ensures that the developing sprouts are short, thick and green.  Tubers can be kept in baskets or wooden battens provided with handles or plastic trays or may be spread in a thin layer on floor for pre sprouting.\n" +
                "\n" +
                "In the hills, the tubers are stored in country stores protecting against cool temperatures in winter.  Here, the seed tubers start chitting when the temperatures warm up after winter. In such situations, the control of sprouting is achieved by proper ventilation to control temperatures and permit diffused light inside the stores so that the sprouts are stout and green.";
        setContentView(R.layout.activity_pre_sprouting);
        check = (LinkEnabledTextView)findViewById(R.id.linkenabledtextview) ;

        check.setOnTextLinkClickListener(this);
        check.gatherLinksForText(text2);
        check.setTextColor(Color.BLACK);
        check.setLinkTextColor(Color.BLUE);

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
                PreSprouting.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {

    }
}
