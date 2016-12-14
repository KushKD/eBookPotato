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

public class PhosphorusandPotash extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phosphorusand_potash);

        String text  ="The physiological responses of crops to phosphorus is well known.  In potato the _requirement_of_P_&_K assumes added significance due to the shallow root system of the crop and the high requirement of K for rapid bulking of the tubers.  In addition, potato is grown in diverse soil types ranging from acidic hill soils to the neutral to slightly alkaline soils of the northern plains.  In contrast to N, phosphorus is fixed in many soils and so is not easily available.  Moreover, P does not move much in the soil.  In the case of K also fixation does take place, though fixed K is easily available through exchange process. Therefore the _application_rate, _time_of_application as well as the _method_of_application of these two nutrients would require greater manipulation for making it easily available.  Apart from the effect of P&K on the growth, development and yield of the crop K has also been found to impart _resistance_against_frost and also mitigate the effect of _moisture_stress and _biotic_stress  Thus P&K nutrition has to be given its due importance but is often ignored.";

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
                PhosphorusandPotash.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {
        if(clickedString.equalsIgnoreCase("_requirement_of_P_")){
            Intent x = new Intent(PhosphorusandPotash.this,RequirementofPK.class);
            startActivity(x);
        }else if(clickedString.equalsIgnoreCase("_application_rate")){
            Intent x = new Intent(PhosphorusandPotash.this,ApplicationRateP.class);
            startActivity(x);
        }else if(clickedString.equalsIgnoreCase("_time_of_application")) {
            Intent x = new Intent(PhosphorusandPotash.this,TimeOfApplicationP.class);
            startActivity(x);
        }else if(clickedString.equalsIgnoreCase("_method_of_application")) {
            Intent x = new Intent(PhosphorusandPotash.this,MethordOfApplication.class);
            startActivity(x);

        }else if(clickedString.equalsIgnoreCase("_resistance_against_frost")) {
            Intent x = new Intent(PhosphorusandPotash.this,Resistanceagainstfrost.class);
            startActivity(x);
        }else if(clickedString.equalsIgnoreCase("_moisture_stress")) {
            Intent x = new Intent(PhosphorusandPotash.this,EffectofPKonresponsetomoisturestress.class);
            startActivity(x);
        }else if(clickedString.equalsIgnoreCase("_biotic_stress")) {
            Intent x = new Intent(PhosphorusandPotash.this,EffectofPKnutritiononresponsetobioticstress.class);
            startActivity(x);
        }else{
            //time of application
            Log.e("Hyperlink is :x: " + clickedString, "Hyperlink is :: " + clickedString);
        }
    }
}