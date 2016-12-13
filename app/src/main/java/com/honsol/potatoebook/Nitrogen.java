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

public class Nitrogen  extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nitrogen);

        String text  =  " The _importance_of_nitrogen for potato and for that matter all crops is well recognized.  The _amount, _time_of_application and _source of nitrogen are the critical decisions in this case.  This is because, in the northern Indo Gangetic plains the duration is short and nitrogen stress would slow down the growth.  On the contrary over fertilisation of this nutrient delays the onset of tuberisation and the completion of the growth cycle within the available growing period.  N also affects the quality. To high as well as low nitrogen impairs tuber quality.  Therefore the amount of N for each _variety, growing condition has to be critically worked.  Since N is highly mobile, time of application becomes very critical since if it is applied and not taken up by the crop, it would be lost thus creating pollution problems in addition to economic and yield loss.  Hence, decisions such as whether it has to be applied full at planting or in _splits,or _use_of_slow_release_N_sources or _through_foliar feeding needs to be taken.  In many cases the _residual_effect of N applied to potato is made use of by proper choice of the succeeding crop so that the problem of left over N in soil is minimised."   ;
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
                Nitrogen.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {
        //Log.e("Hyperlink is :: " + clickedString, "Hyperlink is :: " + clickedString);
        if(clickedString.equalsIgnoreCase("_importance_of_nitrogen")){
            Intent i = new Intent(Nitrogen.this,ImportanceOfN.class);
            startActivity(i);
        }else if(clickedString.equalsIgnoreCase("_amount")){
            Intent i = new Intent(Nitrogen.this,Amount.class);
            startActivity(i);
        }else if(clickedString.equalsIgnoreCase("_time_of_application")) {
            Intent i = new Intent(Nitrogen.this,Time.class);
            startActivity(i);
        }else if(clickedString.equalsIgnoreCase("_source")) {
            Intent i = new Intent(Nitrogen.this,Source.class);
            startActivity(i);
        }else if(clickedString.equalsIgnoreCase("_variety")) {
            Intent i = new Intent(Nitrogen.this,VarietyNitrogen.class);
            startActivity(i);
        }else if(clickedString.equalsIgnoreCase("_splits")) {
            Intent i = new Intent(Nitrogen.this,SplitsNitrogen.class);
            startActivity(i);
        }else if(clickedString.equalsIgnoreCase("_use_of_slow_release_N_sources")) {
            Intent i = new Intent(Nitrogen.this,UseofslowreleaseNsources.class);
            startActivity(i);
        }else if(clickedString.equalsIgnoreCase("_through_foliar")) {
            Intent i = new Intent(Nitrogen.this,FoliarfeedingNitrogen.class);
            startActivity(i);
        }else if(clickedString.equalsIgnoreCase("_residual_effect")) {
            Intent i = new Intent(Nitrogen.this,Residualeffect.class);
            startActivity(i);
        }else
        {
            Log.e("Hyperlink is :x: " + clickedString, "Hyperlink is :: " + clickedString);
        }
    }
}