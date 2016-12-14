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

public class CP_Storage  extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cp__storage);
        String text  =  "About 80% of the potato production in India is in the Indo Gangetic plains.  The produce is harvested in January/February and summer sets in soon after.  Therefore, proper storage is a must to minimize losses since potato is a semi perishable crop. . It has been estimated that under tropical and sub-tropical conditions, losses due to poor handling and storage can amount to 40-50%. The losses during storage can be _physiological as well as _pathological in nature. Proper agronomic practices would minimise physiological losses while adequate pest and disease management is essential for minimising pathological losses During storage, various _biochemical changes in the _carbohydrate_content, _nitrogen_fractions, _enzyme_systems etc take place in the tubers.  These affect the quality of the stored tubers.  Therefore, the method of storage is an important consideration.  Normally for seed purposes it is advisable to store in _cold_stores since the seed quality is not impaired when stored in cold stores.  However, for _processing_storage under warmer temperatures of 10-120 C is preferable.  In this case _sprout_inhibition becomes important. _TCNB, _MH, _CIPC and some _natural_substance and even _irradiation have been found effective.  Some times due to lack of space and/or cost, potatoes are also stored in _country_stores and many improvised country stores are being adopted in many parts of the country.";
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
                CP_Storage.this.finish();
            }
        });

        ImageView  imageView1 = (ImageView) findViewById(R.id.imageView1);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Custom_Dialog CD = new Custom_Dialog();
                CD.showDialog(CP_Storage.this,"cool_store1");
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {
        if(clickedString.equalsIgnoreCase("_physiological")){

            Intent z = new Intent(CP_Storage.this,Physiologicalstorage.class);
            startActivity(z);
        } else if(clickedString.equalsIgnoreCase("_pathological")) {
            Intent z = new Intent(CP_Storage.this,Pathological.class);
            startActivity(z);
        }

        else if(clickedString.equalsIgnoreCase("_biochemical")) {
            Intent z = new Intent(CP_Storage.this,Biochemical.class);
            startActivity(z);
        }
        else if(clickedString.equalsIgnoreCase("_carbohydrate_content")) {
            Intent z = new Intent(CP_Storage.this,Carbohydratecontent.class);
            startActivity(z);
        }
        else if(clickedString.equalsIgnoreCase("_nitrogen_fractions")) {
            Intent z = new Intent(CP_Storage.this,Nitrogenfractions.class);
            startActivity(z);
        }
        else if(clickedString.equalsIgnoreCase("_enzyme_systems")) {
            Intent z = new Intent(CP_Storage.this,Enzymesystems.class);
            startActivity(z);
        }
        else if(clickedString.equalsIgnoreCase("_cold_stores")) {
            Intent z = new Intent(CP_Storage.this,Coldstores.class);
            startActivity(z);
        }
        else if(clickedString.equalsIgnoreCase("_processing_storage")) {
            Intent z = new Intent(CP_Storage.this,Processingstorage.class);
            startActivity(z);
        }
        else if(clickedString.equalsIgnoreCase("_sprout_inhibition")) {
            Intent z = new Intent(CP_Storage.this,Sprout_inhibition.class);
            startActivity(z);
        }
        else if(clickedString.equalsIgnoreCase("_TCNB")) {
            Intent z = new Intent(CP_Storage.this,TCNB.class);
            startActivity(z);
        }
        else if(clickedString.equalsIgnoreCase("_MH")) {
            Intent z = new Intent(CP_Storage.this,MH.class);
            startActivity(z);
        }
        else if(clickedString.equalsIgnoreCase("_CIPC")) {
            Intent z = new Intent(CP_Storage.this,CIPC.class);
            startActivity(z);
        }
        else if(clickedString.equalsIgnoreCase("_natural_substance")) {
            Intent z = new Intent(CP_Storage.this,Naturalsubstances.class);
            startActivity(z);
        }
        else if(clickedString.equalsIgnoreCase("_irradiation")) {
             Intent z = new Intent(CP_Storage.this,Irradiation.class);
            startActivity(z);
        }
        else if(clickedString.equalsIgnoreCase("_country_stores")) {
            Intent z = new Intent(CP_Storage.this,Countrystores.class);
            startActivity(z);
        }
        else {
            Log.e("Hyperlink is :x: " + clickedString, "Hyperlink is :: " + clickedString);
        }
    }
}
