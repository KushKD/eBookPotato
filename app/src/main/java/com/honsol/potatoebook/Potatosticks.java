package com.honsol.potatoebook;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import Interfaces.TextLinkClickListener;
import Presentation.LinkEnabledTextView;
import Utils.Custom_Dialog;

public class Potatosticks extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_potatosticks);
        String text  =  "Taste and crispness of biscuits improved when half of the wheat flour (maida) was replaced either by potato starch or potato flour. However, biscuits prepared from pure potato starch or pure potato flour were not acceptable. \n" +
                "\n" +
                "Potato papad\n" +
                "\n" +
                "Potatoes are boiled, peeled and mashed into a dough. The dough is made into small pieces and rolled into thin round sheets with hand rollers and dried. Better quality papads can be prepared by mixing the mashed potato with gelatinized Sabudana paste (1:1).  Papads show excellent keeping quality for several months.\n" +
                "\n" +
                "Potato sticks or shreds\n" +
                "\n" +
                "For the preparation of sticks, peeled potatoes are passed through square die of 3 x 3 mm to form sticks of 5-6 cm in length. These are blanched in boiling water for 2-3 min and dried. The dried product is fried in oil before consumption. Thin Shreds are made by the kitchen shredders, blanched and dried in the sun and the product is fried whenever required. The dried sticks and shreds can be stored for several months upon proper packaging. \n" +
                "\n" +
                "Chakali\n" +
                "\n" +
                "It is prepared by using either whole potato flour or potato flour in combination with chickpea or peanut meal (4:1). Water is added to the whole meal or composite flour to form a hard dough. Salt and other spices are added to taste. The dough is passed through an orifice under pressure by using a kitchen press. The product is sun dried and fried in oil. The chakali prepared from composite flour have higher protein content than the ones prepared from whole potato flour.\n" +
                "\n" +
                "Vada\n" +
                "\n" +
                "The potatoes are boiled, peeled and cut into pieces. These are mixed with onion and other spices and fried in oil. These pieces are made into balls and dipped into thick slurry made of chickpea flour. The balls are then deep fried in vegetable oil.\n" +
                "\n" +
                "Alu Bhujiya\n" +
                "\n" +
                "The potato flour is mixed with a thick slurry of chickpea flour and deep fried in the vegetable oil. This product is a very popular snack not only in the Indian subcontinent but also in Gulf countries, Europe etc.\n" +
                "\n" +
                "Other traditional products\n" +
                "\n" +
                "Several products, like samosa, tikki, stuffed chapaties, waris and potato pickle etc. can be prepared from mashed  and cooked potato. Some of these products are quite popular with Indians.               \n" +
                "\n" +
                "In spite of the vast scope for processed products, India lags behind in indigenously developed infrastructure for modern industries, wider choice of processing varieties, appropriate potato storage technology, proper packaging, transportation facilities and awareness among the masses about the food and nutritive value of potato. All this has to be achieved to enhance processing of potatoes in India with high efficiency and cut down the cost of processed products. Development of appropriate technology for dehydrated products for the rural sector is also important to avoid stress sale at harvest by the small farmers, ensure remunerative returns, give a boost to potato processing and consumption in India.\n" +
                "\n" +
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
                Potatosticks.this.finish();
            }
        });

        ImageView  imageView1 = (ImageView) findViewById(R.id.imageView1);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Custom_Dialog CD = new Custom_Dialog();
                CD.showDialog(Potatosticks.this,"sticks");
            }
        });

    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {


    }
}
