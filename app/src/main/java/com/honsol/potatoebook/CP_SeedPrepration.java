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
import android.widget.ImageView;

import Interfaces.TextLinkClickListener;
import Presentation.LinkEnabledTextView;
import Utils.Custom_Dialog;

public class CP_SeedPrepration extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cp__seed_prepration);


        String text  =  "Potato is propagated vegetatively, therefore in common parlance when we say potato seed it refers to the tubers which are meant for seed purposes.  The use of tubers for seed purposes leads to many special situations in case of potato as against other crops.  Firstly it increases the cost of cultivation so much so it accounts for almost 40-50% of the cost of cultivation.  Therefore seed cost is a major factor in potato production and since _seed_size_and_spacing affects the seed rate it has to be judiciously adopted. Further, the best use of the seed has to be made so as to get high yield.  In this context scheduling the _removal_of_seed_from_cold_stores and its handling upto planting, _pre_sprouting etc are important.  It is needless to emphasize that only when the seed management is properly done, the other inputs can show their effect on the yield.  In some areas e.g. Southern hills, western Indo Gangetic plains more than one crop is raised. In this case produce of the previous crop is used as seed in the next crop.  In such cases, _seed_dormancy has to be accounted for and dormancy breaking becomes important.";

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
                CP_SeedPrepration.this.finish();
            }
        });

        MovementMethod m = check.getMovementMethod();
        if ((m == null) || !(m instanceof LinkMovementMethod)) {
            if (check.getLinksClickable()) {
                check.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }

        ImageView  imageView1 = (ImageView) findViewById(R.id.imageView1);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Custom_Dialog CD = new Custom_Dialog();
                CD.showDialog(CP_SeedPrepration.this,"field_heap2");
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {

        //Log.e("Hyperlink is :: " + clickedString, "Hyperlink is :: " + clickedString);
        if(clickedString.equalsIgnoreCase("_seed_size_and_spacing")){
            Intent x = new Intent(CP_SeedPrepration.this,SeedSizenSpacing.class);
            startActivity(x);
        }else if(clickedString.equalsIgnoreCase("_pre_sprouting")){
            Intent x = new Intent(CP_SeedPrepration.this,PreSprouting.class);
            startActivity(x);
        }else if(clickedString.equalsIgnoreCase("_seed_dormancy")){
            Intent x = new Intent(CP_SeedPrepration.this,SeedDormancy.class);
            startActivity(x);
        }else if(clickedString.equalsIgnoreCase("_removal_of_seed_from_cold_stores")){
            Intent x = new Intent(CP_SeedPrepration.this,Removalofseedfromcoldstores.class);
            startActivity(x);
        }else{
            Log.e("Hyperlink is :x: " + clickedString, "Hyperlink is :: " + clickedString);
        }
    }


}
