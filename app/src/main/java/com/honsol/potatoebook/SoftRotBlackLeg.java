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

public class SoftRotBlackLeg extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft_rot_black_leg);
        String text  = "  Soft rot of potato caused by bacteria is a serious problem of potatoes in storage as well as transit while in the field it causes black leg. Soft rot of tubers and black leg or stem rot is mainly caused by coliform bacteria called Erwinia carotovora ssp. carotovora, E. carotovora ssp. atroseptica, E. chrysanthemi. The same pathogen also causes the black leg in fields. Losses caused by bacterial decay in seed and storage are very common. Extreme tuber losses of more than 80% have also been recorded in poorly ventilated transport system. Soft rot of potato can be observed at any stage right from tuberization in field until it reaches the market and /or consumer. \n" +
                "\n" +
                "         The disease is not only present in the cool, temperate climates but also in the warm, tropical potato growing region of the world. The incidence of the disease is greater in the tropics due to high temperature and humidity. For management of the disease a combination of methods including avoidance, exclusion and eradication are to be practiced.";
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
                SoftRotBlackLeg.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {
    }
}
