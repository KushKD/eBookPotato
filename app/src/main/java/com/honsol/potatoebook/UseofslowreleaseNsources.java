package com.honsol.potatoebook;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.View;
import android.widget.Button;

import Interfaces.TextLinkClickListener;
import Presentation.LinkEnabledTextView;

public class UseofslowreleaseNsources extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_useofslowrelease_nsources);

        String text  = "Urea is hydrolyzed to NH4+ or NO3- forms within 48 hours of its application under optimum moisture, leading to leaching losses or toxicity which could result in delayed plant emergence. Since the temporary accumulation of NH2 is the cause of deleterious effect and the rapid accumulation of NO3 makes it prone to leaching, ways and means of reducing the rate of urea hydrolysis have been developed so that accumulation of NH2 and NO3  is less.  Biological or chemical inhibitors are used to control the release of N from urea.  \n" +
                "\n" +
                "Biological inhibitors: Urease, an extra-cellular enzyme hydrolyses urea into CO2 and NH3 within one to seven days depending upon its activity and moisture content of the soil. Studies on alluvial soils  have shown that treatment of urea with urease inhibitors, i.e. benzoquinon and hydroquinone in 10:1 ratio (w/w) counteracts the adverse effect of urea on crop emergence and improves the potato yield and N use efficiency from 36 to 74 per cent. \n" +
                "\n" +
                "The use of nitrification inhibiting compounds like neem cake with urea in 1:3 ratio on N basis enhances urea efficiency and economizes N dose by about 25 per cent.  Similarly, application of urea with nitrapyrin (N-serve) at 3.0 l per 80 kg N/ha retards the nitrification of urea by 63 per cent. Neem cake coated urea retards the nitrification of urea by 56 per cent and increases the efficiency of urea comparable to ammonium sulphate besides raising the N recovery from 18 to 31 per cent. Treatment of urea with nitro -humic acid in 10:1 ratio (w/w) for overcoming the deleterious effect of urea on plant emergence is also effective in some cases.\n" +
                "\n" +
                "Chemical inhibitors: Urea granules are coated the with water resistant chemicals in order to slow down its hydrolysis. Studies in alluvial soils revealed that only 20-25 per cent of urea was solubilised in the first week after coating of urea with lac, sulphur powder or Mobil oil. In acidic hill soils where the rain intensity is high; gypsum or rock phosphate coated urea significantly increased the tuber yield. Application of pyrites also improves the efficacy of urea in alkaline alluvial soils by checking the adverse effect of urea on sprout damage. This has been attributed to the reduction of ammonia toxicity by its neutralization through sulphuric acid produced from pyrite oxidation during its transformation.   In acidic soils, the use of magnesium carbonate has also been found to improve the efficiency of urea.";

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
                UseofslowreleaseNsources.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {


    }
}