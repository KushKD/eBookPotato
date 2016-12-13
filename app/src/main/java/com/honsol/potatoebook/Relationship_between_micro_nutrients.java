package com.honsol.potatoebook;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import Interfaces.TextLinkClickListener;
import Presentation.LinkEnabledTextView;

public class Relationship_between_micro_nutrients extends  AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relationship_between_micro_nutrients);

        String text  = "Zinc, copper, manganese, boron and molybdenum have been shown to increase ascorbic acid content of tubers. Zinc fertilization reduced the content of tyrosine, orthodihydroxy and total phenols in tubers. The potato used for processing should contain minimum quantities of tyrosine and phenolic compounds as they are implicated in enzymic discoloration which occurs in raw peeled potatoes due to oxidation of tyrosine and chlorogenic acid formation of ferric dihydric phenolic complexes after cooking in processed products. Molybdenum and boron application increased starch content of tubers. Chloride reduced dry matter content in potato tubers. It resulted in an inhibition of the activity of the hydrolytic enzymes and hence in decreased translocation of starch.\n" +
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
                Relationship_between_micro_nutrients.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {

    }
}