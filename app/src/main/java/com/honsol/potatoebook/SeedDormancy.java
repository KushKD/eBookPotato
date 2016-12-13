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

public class SeedDormancy extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seed_dormancy);


        String text  =  "Cutting of tubers breaks the dormancy and fastens sprouting. When whole tubers are to be used, giving 2-3 cuts 3-4cm long and 2mm deep on the seed tubers and then presprouting leads to good sprouting in some cases. When cut seed tubers are to be planted then _cutting_may_be_done_as_recommended and then kept for chitting. Sprouting is slow (4-6 weeks) when only cutting treatment is imposed. Therefore, when faster sprouting is required _Chemical_method has to be adopted.\n";
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
                SeedDormancy.this.finish();
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

        //Log.e("Hyperlink is :: " + clickedString, "Hyperlink is :: " + clickedString);
        if(clickedString.equalsIgnoreCase("_cutting_may_be_done_as_recommended")){
            Intent x = new Intent(SeedDormancy.this,Seed_Cutting.class);
            startActivity(x);
        }else if(clickedString.equalsIgnoreCase("_Chemical_method")){
            Intent x = new Intent(SeedDormancy.this,Chemical_Methord.class);
            startActivity(x);

        }else{
            Log.e("Hyperlink is :x: " + clickedString, "Hyperlink is :: " + clickedString);
        }
    }


}
