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

public class SeedSizenSpacing  extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seed_sizen_spacing);


        String text = "Seed size affects the initial vigour of the plants.  It also affects the number of stems emerging in a hill since the number of eyes per tuber is related to the surface area of the tuber.  Thus, large tubers lead to more number of stems per hill as well as faster initial growth since the mother tuber can provide sufficient food for more number of sprouts till they become independent.  However, use of large sized tuber increases the seed input and thus the cost of cultivation and hence there is need to work out the optimum seed size and seed rate for different situations to get the desired _plant_population.  In general, well-sprouted 30-40 g tubers at 60 x 20 cm spacing are recommended for ware as well as seed production. The seed rate in this case works out to about 30-35 q/ha.  Since, seed is the costliest input in potato production, it is necessary to use most of the produce of seed plots. Therefore, except very large tubers, the other available seed tubers are also used as seed by adjusting the spacing. Hence, for seed purposes tubers weighing 10-20, 20-40, 40-60, 60-80, 80-100 g and even more than 100 g may be planted at 10, 15, 20, 25, 30 and 30-35 cm intra row spacing, respectively as seed cutting is not advocated in a seed crop.  Similarly, for ware crop, tubers may be planted by adjusting the spacing depending upon the size of seed tubers.\n" +
                "\n" +
                "Seed rate varies from 15-30 q/ha depending upon the size of tubers in ware crop.  Seed rate can be reduced by planting small tubers (10-20 g) or by cutting large tubers into two or three pieces, depending upon the size of seed tubers, and taking care to prevent rottage by treating them with mancozeb @ 0.2 % and drying them in shade for 24 hours. Cut tubers should be planted only when maximum temperature is not above 25°C since they are very sensitive to high temperature and easily rot. They also do not withstand moisture stress.";
        check = (LinkEnabledTextView) findViewById(R.id.linkenabledtextview);
        // check = new LinkEnabledTextView(this, null);
        check.setOnTextLinkClickListener(this);
        check.gatherLinksForText(text);
        check.setTextColor(Color.BLACK);
        check.setLinkTextColor(Color.BLUE);
        // setContentView(check);

        back_Bt = (Button) findViewById(R.id.back);
        back_Bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SeedSizenSpacing.this.finish();
            }
        });

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
        if (clickedString.equalsIgnoreCase("_plant_population")) {

        } else {
            Log.e("Hyperlink is :x: " + clickedString, "Hyperlink is :: " + clickedString);
        }
    }

}

