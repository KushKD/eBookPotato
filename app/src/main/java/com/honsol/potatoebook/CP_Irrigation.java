package com.honsol.potatoebook;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import Interfaces.TextLinkClickListener;
import Presentation.LinkEnabledTextView;
import Utils.Custom_Dialog;

public class CP_Irrigation extends AppCompatActivity implements TextLinkClickListener {
    private LinkEnabledTextView check;

    Button back_Bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cp__irrigation);
        String text  =  "Irrigation refers to the practise of artificial supply of water to the crop. In the northern Indo Gangetic plains potato is grown during the autumn season which receives negligible rainfall, hence under ground tube wells are used for irrigation while in some places like Maharashtra lift irrigation is practised.\n" +
                "\n" +
                "Potato is very sensitive to water stress.  Therefore, it requires water to be supplied through irrigation wherever rainfall is not sufficient to meet the crop needs.  As regards when irrigation has to be done, this would depend upon the method of irrigation adopted as well as the scheduling criteria. Normally time interval approach is adopted in autumn season in the northern Indo Gangetic plains.  In this case irrigation is scheduled at an interval of 8-10 days initially when the temperatures are warm and later the interval is increased to 12-15 days as the winter sets in and the temperatures cool down.  Irrigation on the basis of cumulative pan evaporation has also been advocated in potato.  In this case irrigation scheduling when the cumulative pan evaporation reaches 20 mm is recommended.\n" +
                "\n" +
                "Normally surface irrigation is adopted.  Beds are prepared over 8-10 furrows of 6-8 m length and water is let into the bed till the water level reaches 3/4th of the ridge height, if the water level is more then aeration is affected.  About 50 mm water is applied at each irrigation through surface method.  It is difficult to apply lesser depth of water through this method and this is a big disadvantage of this system in addition to conveyance loss, which is also relatively high in this case.\n" +
                "\n" +
                "Sprinkler irrigation system can also be profitably adopted for potato.  In this case the conveyance losses are minimal and depth of irrigation can be maintained to the required depth.  However it is a high pressure irrigation system and requires energy for conveyance as well as pumping.  The investment cost therefore is high.  In late blight prone areas this system has to be used with caution during the favourable period for late blight incidence.\n" +
                "\n" +
                "Drip system is another system of irrigation found suitable for most crops and also potato.  With this system also conveyance losses are minimum and required depth of irrigation can be applied even daily.  This is a low pressure system and so the energy requirement is lesser than that for sprinkler system. However, the initial investment is very high due to close spacing of the plants which increases the requirement of pipes for main lines, laterals emitters etc which makes the cost exorbitant.\n" +
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
                CP_Irrigation.this.finish();
            }
        });

        ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Custom_Dialog CD = new Custom_Dialog();
                CD.showDialog(CP_Irrigation.this,"sprinkler");
            }
        });
        ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
    imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Custom_Dialog CD = new Custom_Dialog();
                CD.showDialog(CP_Irrigation.this,"drip");
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {

    }
}
