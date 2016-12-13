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

public class Micronutrient extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_micronutrient);

        String text  =" With the advent of green revolution, the crop production scenario changed drastically.  Crop production became input intensive since the high yielding varieties were very responsive to fertilizers and water.  Though the major nutrients were invariably applied, the micro nutrients were invariably ignored.  Moreover, with industrialization, the agricultural labour decreased and maintenance of farm animals become more and more difficult.  This resulted in reduced availability of farm yard manure and its application to the crops went on decreasing.  Thus, _micronutrient_deficiencies have started manifesting in most crops.  Without the application of micronutrients the response to the major nutrients cannot be obtained since micronutrients affect directly many _plant_processes. Micronutrient deficiencies have been observed in potato in many locations and it has been found to _respond to its application. The _critical_content of micronutrients in soils and plants have been established. Micronutrients also affect _tuber_quality. As regards _method and _time_of_application micronutrients, the most affective method considering the _source has to be adopted.\n" +
                "\n";

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
                Micronutrient.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {
        //Log.e("Hyperlink is :: " + clickedString, "Hyperlink is :: " + clickedString);
        if(clickedString.equalsIgnoreCase("_plant_processes")){
           Intent x = new Intent(Micronutrient.this,Plantprocesses.class);
            startActivity(x);
        }else if(clickedString.equalsIgnoreCase("_micronutrient_deficiencies")){
            Intent x = new Intent(Micronutrient.this,Micronutrientdeficiencies.class);
            startActivity(x);
        }else if(clickedString.equalsIgnoreCase("_respond")) {

        }else if(clickedString.equalsIgnoreCase("_critical_content")) {

        }else if(clickedString.equalsIgnoreCase("_source")) {
            Intent x = new Intent(Micronutrient.this,SourceMicro.class);
            startActivity(x);

        }else if(clickedString.equalsIgnoreCase("_tuber_quality")) {
            Intent x = new Intent(Micronutrient.this,Relationship_between_micro_nutrients.class);
            startActivity(x);
        }
        else if(clickedString.equalsIgnoreCase("_method")) {

        }else if(clickedString.equalsIgnoreCase("_time_of_application")) {
            Intent x = new Intent(Micronutrient.this,TimeOfAppliaction.class);
            startActivity(x);
        }else{
            //time of application
            Log.e("Hyperlink is :x: " + clickedString, "Hyperlink is :: " + clickedString);
        }
    }
}