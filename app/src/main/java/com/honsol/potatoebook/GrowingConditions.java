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

public class GrowingConditions extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_growing_conditions);
        String text  =  "Since cultural practices are carried out to provide favourable environmental conditions and provide congenial atmosphere for growth and development, the growing conditions determine the extent/nature of the cultural practices to be adopted. Potato requires well drained soil of fine tilth but _land_preparation may be minimised when following wheat in the spring season in the northern indo gangetic plains while if the crop is raised after rice then it has to be intense.  It is a cool season crop and the growing season can be said to have started when the maximum temperatures fall below 320 C.  Further it requires low night temperatures (<200 C) for tuberisation which occurs about 25-30 days after planting in the autumn season in the northern Indo Gangetic plains.  The crop is of short duration with shallow root system, therefore it is very responsive to _fertilizers. It is also highly susceptible to water stress therefore frequent _irrigation is required. Irrigation requirement would be high if the season is warm like in the early crop or early in the season in the autumn crop and less under rainfed crop in the hills or in the winter season in the plains.  Since it is a vegetatively propagated crop it is also prone to many _pests_and_diseases which have to be controlled.";
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
                GrowingConditions.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {
        if(clickedString.equalsIgnoreCase("_land_preparation")){
            Intent cv = new Intent(GrowingConditions.this,CP_LandPrepration.class);
            startActivity(cv);
        }else if(clickedString.equalsIgnoreCase("_fertilizers")){
            Intent cv = new Intent(GrowingConditions.this,CP_Fertilization.class);
            startActivity(cv);
        }else if(clickedString.equalsIgnoreCase("_irrigation")){
            Intent cv = new Intent(GrowingConditions.this,CP_Irrigation.class);
            startActivity(cv);
        }else if(clickedString.equalsIgnoreCase("_pests_and_diseases")){
            Intent cv = new Intent(GrowingConditions.this,CP_PlantProtection.class);
            startActivity(cv);
        }else{
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        }
    }
}
