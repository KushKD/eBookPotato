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

public class Carbohydratecontent extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carbohydratecontent);
        String text  = "Carbohydrates constitute 75 to 85% of potato tuber dry matter, most of which is starch. The carbohydrate content and composition are important with respect to potato processing and its nutritive value. During storage, there is a gradual loss of carbohydrates from potatoes due to respiration. The rate of respiration is higher at temperatures below 40C, increases gradually up to 15O C and then steeply with further increase in temperature. At low temperatures, therefore, besides increased respiration, free sugars also accumulate to cause low temperature-sweetening. Potatoes stored at low temperatures thus become unsuitable for processing into chips or French fries. The low temperature sweetening is negligible at around 10O C. However, sugar content can increase at 10O C also if sprouting takes place and the mobilized sugar is transported into the young sprouts. To prevent sugar accumulation at 10O C, sprouting should be checked with a sprout suppressant like CIPC. Gamma irradiation has been reported to increase the sucrose content of potato tubers. At higher storage temperatures, loss of dry matter and rotting increase sharply. Potato storage in heaps, pits or evaporatively cooled store for 90 days results in considerable lowering of reducing sugars.";
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
                Carbohydratecontent.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {
    }
}
