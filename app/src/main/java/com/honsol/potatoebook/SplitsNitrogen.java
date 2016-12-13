package com.honsol.potatoebook;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.View;
import android.widget.Button;

import Interfaces.TextLinkClickListener;
import Presentation.LinkEnabledTextView;

public class SplitsNitrogen extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splits_nitrogen);

        String text  = "The uptake and efficacy of N fertilizer depends upon the method of application.  Application of urea by broadcasting and mixing with moist soil 2-3 days before planting is quite effective in alluvial soils where crop is taken under assured irrigation.  Under moisture stress, particularly in rainfed areas, where potato has sparse root system, broadcasting does not ensure proper utilization of N. Here it is important to place the fertilizer where interception by active roots is higher. The placement of urea in side bands (10 cm deep and 5 cm away from seed tubers) at planting has been found to be more beneficial as compared to broadcasting and furrow placement as regards tuber yield and nutrient recovery. The economics of N fertilizer application is also in its favor as it was found to economizes on the N dose by 20 per cent. \n" +
                "\n" +
                "            As regards A/S and CAN two splits, one at planting and the other at about 20 days after planting i.e. at the time of weeding and earthingup in the main season in the northern Indo Gangetic plains is recommended. In the case of other seasons, the application time may be suitably modified. ";

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
                SplitsNitrogen.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {


    }
}