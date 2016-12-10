package com.honsol.potatoebook;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import Interfaces.TextLinkClickListener;
import Presentation.LinkEnabledTextView;

public class CP_Introduction extends AppCompatActivity implements TextLinkClickListener {

    private  LinkEnabledTextView check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        String text  =  "This is a _test of regular expressions with http://example.com links as used in @twitter for performing various operations based on the links this handles multiple links like http://this_is_fun.com and _Awesomess and @Cool";
        String text2 = "Potato is a temperate crop grown under subtropical conditions in India.  The economically useful part (the tuber) is a modified stem.  This necessitates special care while carrying out cultural operations The tubers are invariably used as planting material therefore _seed preparation and its handling becomes very important.  Since the tubers are formed underground _land preparation needs to be done so as to promote a healthy environment both for the roots as well as the growing tubers.  Use of tubers as _planting material also necessitates greater skill in planting so as to economize of seed and get maximum possible yield.  Further potato has sparse root system at the same time it is a heavy feeder of nutrients as well as very sensitive to drought.  Therefore, _fertilization and _irrigation is more intense in potato than other crops.  Since it is heavily fertilized and supplied with water as and when required it is natural that potato is exposed to greater competition from weeds than would have been the case otherwise.  In addition weeds play a more important role as carriers of vectors of potato pests and diseases and so _weeding and _earthing up  are very important cultural practices in potato.  Potato is exposed to very serious pests and diseases. Some of the pests/diseases are so serious that the whole crop is washed out in a few days if timely action is not taken, therefore, adequate and timely plant protection is required. Haulms cutting, harvesting and _sorting and _grading are some of the other cultural operations which needs special attention in potato due to it being a bulky vegetative organ with more than 80% moisture.  Further, potato is used as such as a vegetable. However it is a semi-perishable commodity. About 80% of the produce is produced in the northern indo-gangetic plains, where the summer season sets in soon after its harvest. Unless proper care is taken while harvesting and _grading as well as during storage heavy losses can occur. Cold storage are the major method of storage but low cost alternate storage structures have also been developed. A clear understanding of the _storagerequirement is necessary for proper storage with minimum loss as well as cost.  It needs to be processed for getting added returns.  Therefore, processing is a big industry in potato.   Properly timed cultural operations is expected to make potato cultivation profitable as well help meet the nutritional security of the people of the country. ";

       setContentView(R.layout.activity_cp__introduction);
          check = (LinkEnabledTextView)findViewById(R.id.linkenabledtextview) ;
       // check = new LinkEnabledTextView(this, null);
        check.setOnTextLinkClickListener(this);
        check.gatherLinksForText(text2);
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
        if(clickedString.equalsIgnoreCase("_seed")){
            Intent intent = new Intent(CP_Introduction.this,CP_SeedPrepration.class);
            startActivity(intent);
        }else if(clickedString.equalsIgnoreCase("_land")){
            Log.e("Hyperlink is :2: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_planting")){
            Log.e("Hyperlink is :3: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_fertilization")){
            Log.e("Hyperlink is :4: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_irrigation")){
            Log.e("Hyperlink is :5: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_weeding")){
            Log.e("Hyperlink is :6: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_earthing")){
            Log.e("Hyperlink is :7: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_sorting")){
            Log.e("Hyperlink is :8: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_grading")){
            Log.e("Hyperlink is :9: " + clickedString, "Hyperlink is :: " + clickedString);
        }else if(clickedString.equalsIgnoreCase("_storagerequirement")){
            Log.e("Hyperlink is :10: " + clickedString, "Hyperlink is :: " + clickedString);
        }else{
            Log.e("Hyperlink is :x: " + clickedString, "Hyperlink is :: " + clickedString);
        }
    }
}
