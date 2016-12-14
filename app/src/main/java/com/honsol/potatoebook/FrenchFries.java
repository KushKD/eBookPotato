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

public class FrenchFries extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_french_frie);
        String text  =  "Frozen French fries are potato strips of 0.7 x 0.7 cm or 1 x 1 cm in cross-section having straight or crinkle cut and 6-10 cm in length. They may be designated  as extra long, long, medium and short depending upon the length of the strips. These are either par-fried or finish-fried by the processor. In the former case, they are later finish-fried in deep fat, and in the latter, oven- normal\"> heated before consumption. For preparation of French fries, the potatoes are cut into strips using water guns with stationary knives cutting them lengthwise. The fries are sorted to remove slivers, nubbins and any other defective part. Blanching is done to leach excess sugars from fry strips, partially cook strips to improve the texture, reduce frying time and oil absorption by gelatinizing the surface layer of starch on the strips, and to produce a light, uniform color. Generally two blanchers are used with a lower temperature of 75 oC in the first and 90 oC in the second blancher, to obtain desired finish- fry colour and texture. Blanching time may range 8-14 minutes and the product is cooled in between blanching to improve the texture of the final product. Good quality French fries have a uniform light cream to golden color. They have good flavor and the texture consists of external surfaces that are moderately crisp, showing no separation from the inner portion. The inside is tender, mealy and free from sogginess. The fried strips, while still hot, are moved along vibratory shakers or blowers to remove excess oil. French fries are then moved to the freezing tunnel at about –18ºC, filled and packaged and stored frozen until consumed.";

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
                FrenchFries.this.finish();
            }
        });

        ImageView  imageView1 = (ImageView) findViewById(R.id.imageView1);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Custom_Dialog CD = new Custom_Dialog();
                CD.showDialog(FrenchFries.this,"frenchfries");
            }
        });


    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {


    }
}
