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

public class Source extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source);

        String text  =  "There are many N fertilizers available in the market. The important ones are Ammonium sulphate, Calcium ammonium nitrate, and urea.\n" +
                "\n" +
                "Ammonium sulphate: It contains 21% N and has been found to be the best nitrogenous carrier for potato perhaps due to the S supplied by it as it contains 25 per cent S. However, it is expensive moreover, its prolonged use causes acidity in soil. It is generally recommended in neutral soils as well as for production of potatoes for processing.  It is beneficial to apply A/S at planting since the NH4 N is less prone to leaching and its availability is after it gets converted to nitrate form.\n" +
                "\n" +
                "Calcium ammonium nitrate: It is a neutral fertilizer containing 25% N It is recommended for soils with neutral to slightly alkaline pH. It is cheaper than A/S as well as it does not have the deleterious effect of urea. CAN can be applied both at planting as well as at top dressing.\n" +
                "\n" +
                "Urea:  It is a cheap and concentrated N source having 46% N.  In potato crop it is 10-15 per cent less efficient compared to other N fertilizers i.e. ammonium sulphate and calcium ammonium nitrate. The poor performance is due to its adverse effect on plant emergence, which is related to the dose applied. The adverse affect is more in alluvial and calcareous soils having high pH as compared to acidic soils. It is generally advocated to apply urea at top dressing and use other sources of N at planting so that both leaching and sprout injury could be minimised.  A mixture of urea and calcium ammonium nitrate in equal ratio at planting and urea at the time of earthing up has been found to give not only high yields but also higher N recovery and nutrient use efficiency in potato crop.  When urea is applied at planting, its quantity should not exceed 60 kg N/ha.\n" +
                "\n" +
                "The methods to mitigate the deleterious effect of urea on potato emergence include applying low dose (<60 kg N/ha) at planting, applying the fertilizer one day before planting and using _slow_release_fertilizer. \n" +
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
                Source.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {
//_slow_release_fertilizer

        if(clickedString.equalsIgnoreCase("_slow_release_fertilizer")){
            Intent i = new Intent(Source.this,UseofslowreleaseNsources.class);
            startActivity(i);
        }

    }
}