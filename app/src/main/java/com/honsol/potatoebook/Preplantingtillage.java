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

public class Preplantingtillage extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        String text2 = "The objective of pre planting tillage is to loosen the soil upto the rooting depth for easy penetration of the roots as well as for proper development of the stolons and tubers.  The minimum tillage required for this purpose is to be adopted as soil compaction occurs if more number of tillage is adopted.  In the northern plains the autumn season is the main growing season and the ambient maximum temperatures are between 30-320 C.  Therefore land preparation is carried out after pre sowing irrigation which is done about 5-7 days prior to planting.  When the soil reaches the proper stage for cultivation, then the land is prepared by one or two harrowing by disc harrow followed by one or two tillering along with planking.  This would suffice to bring the soil to the required tilth.     ";
        setContentView(R.layout.activity_preplantingtillage);
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
                Preplantingtillage.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {

    }
}
