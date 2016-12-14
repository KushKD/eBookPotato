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

public class dehydratedproducts extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dehydratedproducts);
        String text  =  "Dehydration is one of the important means of preserving potatoes for obtaining dehydrated products such as chips, dices, potato flour, granules, flakes, waris and  papads.  Solar energy is available in abundance in the plains of India after the harvest of potatoes which can be utilized to dehydrate potato slices, dices, waris, papads etc.  Among them, dehydrated chips are commonly prepared in the villages.  Preparation of dehydrated chips is simple and involves manual cutting of 2-3 mm thick slices directly in cold water followed by blanching in hot water for 1 to 5 min, and then spread in the sun to dry. The dried product can be stored in air‑tight containers or sealed polythene bags for 6 months. These slices are consumed after shallow frying as and when required. Besides domestic consumption, dried potato chips are made in rural areas in several parts of the country for sale. Certain rural areas of central and western Uttar Pradesh and  Malwa region of Madhya Pradesh have many small-scale units for making dehydrated chips. These small entrepreneurs generally make dehydrated chips just after the potato harvest in February-March and continue preparing till June, from the potatoes stored in traditional stores. The market price of the chips depends on the visual appearance of dehydrated chips. Lighter the colour, more the price.  In Gujarat and Maharashtra, considerable quantities of partially cooked potatoes are sliced, dried in the sun and consumed after frying. The procedure is similar to the one used for drying raw potato slices, except that potato tubers are parboiled (cooked in boiling water for about 8 min), before peeling and slicing. Dehydration of such slices takes longer time but they take up much less cooking medium during frying than raw slices. Besides, in certain parts of India, potatoes are cut into pieces (as wedges, cubes or dices) and dried in sun for later use in making curries. The processing of potatoes in rural areas can be increased substantially provided the procedure is partially mechanized. Hand operated peeler, gas heated blancher and low cost solar dryers of big capacity are required to be developed. These dryers, besides enhancing the efficiency of drying will also improve the quality of chips.  Several Indian varieties, viz. Kufri Chipsona-1, Kufri Chipsona-2, Kufri Chandramukhi, Kufri Lauvkar and Kufri Sindhuri produce good quality dehydrated chips. The recovery of dehydrated chips from these varieties ranges between 14.9‑17.4%. \n" +
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
                dehydratedproducts.this.finish();
            }
        });

    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {


    }
}
