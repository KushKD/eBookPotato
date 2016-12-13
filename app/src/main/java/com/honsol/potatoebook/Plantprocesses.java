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

public class Plantprocesses extends  AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plantprocesses);

        String text  = "Plant processes affected by micronutrients\n" +
                "\n" +
                "Micro-nutrients, which include zinc, iron, manganese, copper, molybdenum, boron and chlorine, play specific roles in the growth and development of plants. Even though these elements are needed in only minute quantities, many soils do not supply them in sufficient quantities for healthy growth and optimum yield of potato. Micronutrients affect different plant processes like\n" +
                "\n" +
                "Photosynthetic rate\n" +
                "\n" +
                "The photosynthetic rate has been shown to increase by 72 and 80% in the presence of 10 ppm of zinc and manganese, respectively in Hoagland,s solution.\n" +
                "\n" +
                "Translocation of sugars\n" +
                "\n" +
                "Supplementing zinc has been shown to increase the incorporation of 14C from the labeled sucrose, glucose and fructose into starch.\n" +
                "\n" +
                "Numbers and size of potato tubers\n" +
                "\n" +
                "The increase in tuber yield with micro-nutrient application can occur through an increase in number and/or size of tubers. Zinc, iron, boron and molybdenum have been reported to increase the tuber number of medium and large grades at the cost small ones i.e. the total tuber number was not affected.";

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
                Plantprocesses.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {

    }
}