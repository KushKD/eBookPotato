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

public class CP_Planting extends AppCompatActivity implements TextLinkClickListener {
    private LinkEnabledTextView check;

    Button back_Bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cp__planting);
        String text  =  "In the northern Indo Gangetic plains the autumn season is the main potato season.  An early crop is also taken in many places to take advantage of the high prices of the early crop.  At some places especially in the western Indo Gangetic plains a late winter/spring crop is also raised.  The date of planting is temperature dependent.  In the main crop, planting starts when the maximum temperature is between 30-320 C while in the case of the late winter crop planting coincides with the period when minimum temperature is above frosting temperatures and the temperatures start warming up.  The optimum date of planting in the different locations and season is given in _table.  Apart from the time of planting, yield is also affected by the _method_of_planting.  The method adopted is also dependent to a certain extent upon the weather/season so that the adverse effect of temperature/moisture could be mitigated and maximum use of resources made.";

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
                CP_Planting.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {
        //Log.e("Hyperlink is :: " + clickedString, "Hyperlink is :: " + clickedString);
        if(clickedString.equalsIgnoreCase("_method_of_planting")){
            Intent i = new Intent(CP_Planting.this,Methodofplanting.class);
            startActivity(i);
        }else if(clickedString.equalsIgnoreCase("_table")){
           //TODO
            //TABLE
        }else{
            Log.e("Hyperlink is :x: " + clickedString, "Hyperlink is :: " + clickedString);
        }
    }

}
