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

public class CP_PlantProtection extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cp__plant_protection);
        String text  =  "Plant protection refers to the practices adopted for controlling the pests and diseases attacking the potato crop.  Potato crop is infested by a variety of fungal, bacterial and viral diseases.  As regards pests, some pests attacks the foliage while some attacks the tubers.  Many of the diseases in potato are soil/seed borne and so once infected is very difficult to control them.  Similarly viruses affect the seed quality and so has a chain of implications.  Thus proper diagnosis and control of pests and diseases is of utmost importance. Some of the important pests and diseases attacking the potato crop are late blight, early blight, wart, common scab, black scurf, bacterial wilt, soft rot/black leg, viruses, cutworm, white grub, aphids, leaf hoppers, tuber moth, mites, potato cyst nematode, root knot nematode etc. Not all pests and diseases are present every where.  Some of them are more widespread than the other while some are very localized e.g. Wart is one such disease, which is confined to the Darjeeling hills while golden nematode is another such pest, which is confined to the Nilgiri hills.";
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
//Log.e("Hyperlink is :: " + clickedString, "Hyperlink is :: " + clickedString);
        if(clickedString.equalsIgnoreCase("_fertilization")){
            Log.e("Hyperlink is :1: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_Nitrogen")){
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_Phosphorous_and_potash")) {
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_calcium")) {
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_sulphur")) {
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_micronutrients ")) {
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        }else
        {
            Log.e("Hyperlink is :x: " + clickedString, "Hyperlink is :: " + clickedString);
        }
    }
}
