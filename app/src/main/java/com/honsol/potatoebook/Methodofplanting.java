package com.honsol.potatoebook;

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

public class Methodofplanting extends AppCompatActivity implements TextLinkClickListener {
    private LinkEnabledTextView check;
    Button back_Bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_methodofplanting);
        String text  =  "In the northern plains, presprouted seed tubers are planted by dibbling the seeds about 8-10 cm deep in the ridges in the case of manual planting.  When bullocks are used for planting, a furrow is drawn and seeds are placed in the exposed furrows.  These furrows get covered when another furrow is drawn nearby the previously drawn furrow.  In many areas ridges are drawn with a tractor drawn ridger and seeds are dibbled manually on the ridges. Tractor drawn mechanical planters are also available in which persons sit at the back of the planter and place the seed in the rotating slots which places the seed at the required spacing.\n" +
                "\n" +
                "In the case of the early crop in the northern plains the temperatures are relatively warmer so deep planting is recommended to mitigate the effect of high temperature.  Similarly in the case of the late/spring crop due to the cool temperatures, shallow planting is advocated to ensure quick emergence.\n" +
                "\n" +
                "Flat planting is also practised in some situations especially in the kharif crop in the plateau regions.  The objective in this case also is to promote quick emergence using the available soil moisture at the top few centimeters of soil since the crop is rainfed and the first few rains will wet only a shallow depth of soil.\n" +
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
                Methodofplanting.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {

    }

}