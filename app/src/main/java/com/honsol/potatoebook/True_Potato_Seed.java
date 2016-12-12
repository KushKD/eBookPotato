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

public class True_Potato_Seed extends AppCompatActivity implements TextLinkClickListener {
    private LinkEnabledTextView check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_true__potato__seed);
        String text  =  "Potato seed as is used in common parlance refers to the modified vegetative stem, which is its storage organ but is also used for propagation.  However, potato also produces fruits and seeds as in the case of other solanaceous crops such as tomato, brinjal, chilli, capsicum etc. This seed was not normally used for raising a crop due to it being more delicate than other similar seeds.  Therefore, except for breeding purposes where special care was taken to raise the seedlings, the true seed of potato was not used.  However, as the cost of cultivation increased and profit margins decreased, research to use TPS for raising a crop was intensified.  This was because use of TPS has _several_advantages. Exploitation of the advantages is expected to make potato cultivation profitable and help extend its cultivation to other areas.  However, use of TPS also has _many_constraints, which have to be overcome before a crop can be successfully raised from TPS.  Most importantly, the _agronomic_practices for the utilsation of TPS has to be standardised.  Presently its use either for _transplanting or for producing _seedling_tubers, which in turn can be used as seed has been advocated.  Many _TPS_families possesing favourable traits has been recommended for cultivation.  Success of TPS technology is expected to boost potato production in the country.";
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

        if(clickedString.equalsIgnoreCase("_several_advantages")){
            Log.e("Hyperlink is :1: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_agronomic_practices")){
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_seedling_tubers")){
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_TPS_families")){
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_many_constraints")){
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_transplanting")){
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        }else{
            Log.e("Hyperlink is :x: " + clickedString, "Hyperlink is :: " + clickedString);
        }
    }
}
