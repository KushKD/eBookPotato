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

public class Amount  extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amount);

        String text  =  "Significant response to N application has been reported in different agro-ecological regions of the country, however, magnitude of response and the optimum dose differed with soil type, cultivar and climatic conditions. The response to N application is high in alluvial soils followed by hill, red and black soils in decreasing order. The high response to N in alluvial soils is attributed to its low organic matter content and hence the low N supplying capacity of these soils. Moreover, as the crop is taken under short day and irrigated conditions, the high yield potential of this region plays an important role in getting high responses in these soils. In north-western and eastern hills where the crop is grown under rainfed and long day conditions, even though the soils are rich in total N still they require higher N dose because of slow mineralization rate of organic matter due to low temperature as well as the luxuriant vegetative growth.\n" +
                "\n" +
                "The economic response of potato in alluvial soils of northwestern and central Indo- Gangetic plains in the country has been noticed up to 180 kg N /ha. In hill soils, the economic response to N has been observed up to 150 kg N/ha. In the black cotton soils of Deccan plateau and in red soils of Bihar, Orissa and Tamil Nadu, the economic responses have been obtained between 100-140 kg N/ha.\n" +
                "\n" +
                "Organic manure application although does not contribute much in meeting N needs of potato yet they increase the apparent N recovery considerably from applied fertilizers. The accumulation of N (Total, K2Cr2O7-N and KMnO4-N) is more in the presence of farmyard manure followed by that in green manuring. Farmyard manure is more effective in raising the organic carbon and consequently N status of the soil than other organic manures.\n" +
                "\n" +
                "\n ";
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
                Amount.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {

    }
}