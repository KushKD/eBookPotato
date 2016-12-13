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

public class CalciumnMagnisium extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calciumn_magnisium);

        String text  ="Failure of development of terminal buds and apical tips of roots is the first sign of Ca deficiency. In mild deficiency, a light green band appears along the margins in young leaves. Leaves do not develop normally and have wrinkled appearance. In severe deficiency, the young leaves at top remain folded and later on their tips die. On the other hand in magnesium deficiency the plants become slightly pale, older leaves develop central necrosis, turn yellow or brown, interveinal areas become bronzed and wither prematurely. In severe Mg deficiency, leaflets become thick and brittle and show a definite bulging with leaves rolling upwards. \n" +
                "\n" +
                "Its application has been reported to reduce the incidence of soft rot during storage.  It also helps emergence of healthier sprouts. Leaves have higher Ca content than tubers while tubers contain more Mg than leaves. Soil application of CaCl2 @ 20 kg/ha is more effective than 0.01% foliar application of CaCl2 in increasing the potato yield mainly due to increase in proportion of large and medium sized tubers.";
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
                CalciumnMagnisium.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {

    }
}