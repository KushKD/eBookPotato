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
import android.widget.TextView;

import Interfaces.TextLinkClickListener;
import Presentation.LinkEnabledTextView;
import Utils.Custom_Dialog;

public class CP_Introduction extends BaseActivity implements TextLinkClickListener {

    private  LinkEnabledTextView check;
    Button back_Bt;

    ImageView imageView1,imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


         String text2 = "Potato is a temperate crop grown under subtropical conditions in India.  The economically useful part (the tuber) is a modified stem.  This necessitates special care while carrying out cultural operations The tubers are invariably used as planting material therefore _seed preparation and its handling becomes very important.  Since the tubers are formed underground _land preparation needs to be done so as to promote a healthy environment both for the roots as well as the growing tubers.  Use of tubers as _planting material also necessitates greater skill in planting so as to economize of seed and get maximum possible yield.  Further potato has sparse root system at the same time it is a heavy feeder of nutrients as well as very sensitive to drought.  Therefore, _fertilization and _irrigation is more intense in potato than other crops.  Since it is heavily fertilized and supplied with water as and when required it is natural that potato is exposed to greater competition from weeds than would have been the case otherwise.  In addition weeds play a more important role as carriers of vectors of potato pests and diseases and so _weeding and _earthing up  are very important cultural practices in potato.  Potato is exposed to very serious pests and diseases. Some of the pests/diseases are so serious that the whole crop is washed out in a few days if timely action is not taken, therefore, adequate and timely plant protection is required. Haulms cutting, harvesting and _sorting and _grading are some of the other cultural operations which needs special attention in potato due to it being a bulky vegetative organ with more than 80% moisture.  Further, potato is used as such as a vegetable. However it is a semi-perishable commodity. About 80% of the produce is produced in the northern indo-gangetic plains, where the summer season sets in soon after its harvest. Unless proper care is taken while harvesting and _grading as well as during storage heavy losses can occur. Cold storage are the major method of storage but low cost alternate storage structures have also been developed. A clear understanding of the _storagerequirement is necessary for proper storage with minimum loss as well as cost.  It needs to be processed for getting added returns.  Therefore, processing is a big industry in potato.   Properly timed cultural operations is expected to make potato cultivation profitable as well help meet the nutritional security of the people of the country. ";

       setContentView(R.layout.activity_cp__introduction);
          check = (LinkEnabledTextView)findViewById(R.id.linkenabledtextview) ;

        check.setOnTextLinkClickListener(this);
        check.gatherLinksForText(text2);
        check.setTextColor(Color.BLACK);
        check.setLinkTextColor(Color.BLUE);

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
                CP_Introduction.this.finish();
            }
        });

        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Custom_Dialog CD = new Custom_Dialog();
                CD.showDialog(CP_Introduction.this,"healthy_crop");
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Custom_Dialog CD = new Custom_Dialog();
                CD.showDialog(CP_Introduction.this,"pot_field2");
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {
        if(clickedString.equalsIgnoreCase("_seed")){
            Intent x = new Intent(CP_Introduction.this,CP_SeedPrepration.class);
            startActivity(x);
        }else if(clickedString.equalsIgnoreCase("_land")){
            Intent x = new Intent(CP_Introduction.this,CP_LandPrepration.class);
            startActivity(x);
        }else if(clickedString.equalsIgnoreCase("_planting")){
            Intent x = new Intent(CP_Introduction.this,CP_Planting.class);
            startActivity(x);
        }else if(clickedString.equalsIgnoreCase("_fertilization")){
            Intent x = new Intent(CP_Introduction.this,CP_Fertilization.class);
            startActivity(x);
        }else if(clickedString.equalsIgnoreCase("_irrigation")){
            Intent x = new Intent(CP_Introduction.this,CP_Irrigation.class);
            startActivity(x);
        }else if(clickedString.equalsIgnoreCase("_weeding")){
            Intent x = new Intent(CP_Introduction.this,CP_Weeding.class);
            startActivity(x);
        }else if(clickedString.equalsIgnoreCase("_earthing")){
            Intent x = new Intent(CP_Introduction.this,CP_EarthingUp.class);
            startActivity(x);
        }else if(clickedString.equalsIgnoreCase("_sorting")){
            Intent x = new Intent(CP_Introduction.this,CP_sortingGrading.class);
            startActivity(x);
        }else if(clickedString.equalsIgnoreCase("_grading")){
            Intent x = new Intent(CP_Introduction.this,CP_sortingGrading.class);
            startActivity(x);
        }else if(clickedString.equalsIgnoreCase("_storagerequirement")){
            Intent x = new Intent(CP_Introduction.this,CP_Storage.class);
            startActivity(x);
        }else{
            Log.e("Hyperlink is :x: " + clickedString, "Hyperlink is :: " + clickedString);
        }
    }
}
