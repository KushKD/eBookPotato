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

public class Chemical_Methord  extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemical__methord);


        String text  =  "Chemical Method\n" +
                "\n" +
                "Seed tubers (whole with few cuts or cut seed) should be dipped in solution containing 1% thiourea and 1ppm GA for one hour. These tubers are then heaped over an inverted basket below which 3% ethylen chlorohydrin is kept. The heap is covered by gunny bags etc to prevent the ethylen chlorohydrin vapours to go out. The seed tubers are thus exposed to the vapours for 24 hrs. After 24 hrs the tubers are removed and kept for chitting .\n" +
                "Precautions\n" +
                "\n" +
                "Ethylen chlorohydrin is poisonous and its vapours should not be inhaled. Therefore proper care has to be taken.\n" +
                "Method of preparation of GA and thiourea solution:\n" +
                "\n" +
                "For 20 lt. solution 200 g thiourea and 20 mg GA is required. The GA is first dissolved in a bottle alchol/spirit and then this solution is mixed in the required quantity of water. To this the required quantity of this urea is added and shirred throughly. 20 lt solution is sufficiant for 40 kg of seed.\n";
        check = (LinkEnabledTextView)findViewById(R.id.linkenabledtextview) ;
        // check = new LinkEnabledTextView(this, null);
        check.setOnTextLinkClickListener(this);
        check.gatherLinksForText(text);
        check.setTextColor(Color.BLACK);
        check.setLinkTextColor(Color.BLUE);
        // setContentView(check);

        back_Bt = (Button)findViewById(R.id.back);
        back_Bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Chemical_Methord.this.finish();
            }
        });

        MovementMethod m = check.getMovementMethod();
        if ((m == null) || !(m instanceof LinkMovementMethod)) {
            if (check.getLinksClickable()) {
                check.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {


    }


}