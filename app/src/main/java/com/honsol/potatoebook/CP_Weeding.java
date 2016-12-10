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

public class CP_Weeding extends AppCompatActivity implements TextLinkClickListener {
    private LinkEnabledTextView check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cp__weeding);
        String text = "Weeds affect crop growth and yield in a variety of ways.  They compete with the crop for space, water and nutrients.  However in  _potato_they_are_more_serious because potato is a short duration crop and fast early growth is essential for high yield.  Presence of weeds at early stages will slow down early growth due to competition for space, water and nutrients while presence of weeds at harvest would make it difficult to expose the tubers thus increasing the cost of harvesting as well as cumbersome.  Weeds also harbour vectors of potato pests and diseases which makes pest and disease control difficult unless weeds are controlled.  Weed control traditionally is done through _cultural_methods in potato.  However, in some situations _chemical_weed_control is advantageous while in some other situation a combination of the two i.e. _integrated_weed_control is desirable.  For an effective weed control strategy, the weeding operation should be _properly_timed as well as the cropping system i.e. _crop_sequence or _intercropping system should also be borne in mind.";
        check = (LinkEnabledTextView) findViewById(R.id.linkenabledtextview);
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

        //Log.e("Hyperlink is :: " + clickedString, "Hyperlink is :: " + clickedString);
        if (clickedString.equalsIgnoreCase("_potato_they_are_more_serious")) {
            Log.e("Hyperlink is :1: " + clickedString, "Hyperlink is :: " + clickedString);
        } else if (clickedString.equalsIgnoreCase(" _cultural_methods")) {
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        } else if (clickedString.equalsIgnoreCase("_chemical_weed_control")) {
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        } else if (clickedString.equalsIgnoreCase("_integrated_weed_control")) {
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        } else if (clickedString.equalsIgnoreCase("_properly_timed")) {
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        } else if (clickedString.equalsIgnoreCase(" _crop_sequence")) {
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        } else if (clickedString.equalsIgnoreCase(" _intercropping")) {
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        } else {
            Log.e("Hyperlink is :x: " + clickedString, "Hyperlink is :: " + clickedString);
        }

    }
}
