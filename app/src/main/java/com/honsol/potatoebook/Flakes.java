package com.honsol.potatoebook;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.View;
import android.widget.Button;

import Interfaces.TextLinkClickListener;
import Presentation.LinkEnabledTextView;

public class Flakes extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flakes);
        String text  =  " Potato flakes are convenient foods both for domestic and large scale use as they can be easily reconstituted with cold water or hot milk. The flakes are also used in the preparation of pasta, aloo bhujia, fabricated chips, potato papads etc. As a thickener, they enhance creamy frozen deserts, gravies and chocolate milk.   The process for preparation of flakes can use rejected potatoes, as the raw material requirements are less stringent.  Peeled potatoes are cut into slices of about 15 mm thickness and washed to remove excess starch. Then they are heated in water at 71-74 oC for a period of 20 min. and cooled in the water for 20 min at a temperature below 24 oC. The slices are then cooked in a screw conveyor steam cooker for 30 min. The slices are mashed by a mixer immediately after cooking and additives like monoglyceride emulsifier, sodium bisulphite, butylated hydroxyanisole (Tenox 5B or Tenox V) and sodium acid pyrophosphate are added to the mash to improve thecolour/texture and also extend the shelf life of the product. The mash is dried quickly on a single drum drier equipped with four to six applicator rolls and heated with steam. The dry layer is removed as a sheet and broken into flakes and packed in a laminated packaging material.\n" +
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
                Flakes.this.finish();
            }
        });

    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {


    }
}
