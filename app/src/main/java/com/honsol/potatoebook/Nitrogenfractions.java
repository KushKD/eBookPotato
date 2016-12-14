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

public class Nitrogenfractions extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nitrogenfractions);
        String text  = "The total nitrogen of potato tuber comprises soluble protein, insoluble protein and soluble non-protein nitrogenous compounds (NPN). The NPN compounds are free amino acids, the amides asparagines and glutamine and small amounts of nitrate nitrogen and basic nitrogen compounds including nucleic acids and alkaloids. Though reducing sugars are the major determinants of processing quality, anomalies in the relationship of reducing sugars to fry colour do occur and free amino acids may also act as determinants of processing quality. Protein degradation has been associated with the end of tuber dormancy and the mobilization of nitrogen reserves for sprout formation and the breakdown of proteins is consistent with an increase of proteolytic enzyme activity. Protein synthesis may also occur during potato storage, although low temperature conditions reduce the rate of this process while enhancing protease activity. The free amino acid content changes with storage duration. Glycoalkaloids are another important nitrogen fraction and about 95% of the total glycoalkaloids present in potato tubers are accounted for by two compounds viz. alpha solanine and alpha chaconine. It has been suggested that at low concentrations, the presence of glycoalkaloids may enhance the flavour of potatoes, but at levels exceeding 15 mg/100g fresh weight, a bitter taste may be perceived. Potatoes containing more than 20 mg of glycoalkaloids per 100g fresh weight of tuber are not safe for human consumption. The rate of glycoalkaloid accumulation was independent of the levels found at harvest and significant interactions are observed between the cultivars and temperature.";
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
                Nitrogenfractions.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {
    }
}
