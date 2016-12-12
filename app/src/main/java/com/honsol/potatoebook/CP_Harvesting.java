package com.honsol.potatoebook;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.util.Log;
import android.view.View;

import Interfaces.TextLinkClickListener;
import Presentation.LinkEnabledTextView;

public class CP_Harvesting extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cp__harvesting);

        String text  =  "Potato harvest is a critical cultural practice.  The time of harvest and the method of harvest are some of the critical decisions to be made. The time of harvest is decided by the method of disposal of the produce.  If the crop is a ware crop for immediate disposal, then the crop is harvested any time depending upon the market prices.  However, if the crop is for either seed or ware but is to be stored then harvesting has to be scheduled depending upon the time of haulm cutting.  For processing also scheduling of harvesting is a critical operation because the crop in this case has to be harvested at its physiological maturity and early as well as late harvest impairs the tuber quality.As regards method of harvesting, generally hand tools like _Khurpa is used for harvesting in the case of manual harvesting.  A _plough is used to break open the ridge and _expose_the_tubers which are then picked in the case of harvesting by animal drawn implements while in the case of mechanical method, _specialised_harvesters of different types are available which would expose the tubers and remove the soil adhering to the tubers which are later picked by hand.Potatoes grown on improperly prepared fields are damaged while harvesting mechanically and have poor storage quality. Therefore, proper management of pre-storage factors that affect the keeping quality of potatoes is essential for getting good returns.";
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
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {
        if(clickedString.equalsIgnoreCase("_plough")){
            Log.e("Hyperlink is :1: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_expose_the_tubers")){
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_specialised_harvesters")) {
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("Khurpa")) {
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        }else{
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        }
    }
}
