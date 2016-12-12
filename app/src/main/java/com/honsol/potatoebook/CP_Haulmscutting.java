package com.honsol.potatoebook;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.View;

import Interfaces.TextLinkClickListener;
import Presentation.LinkEnabledTextView;

public class CP_Haulmscutting extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cp__haulmscutting);
        String text  =  "In the case of potato in the northern plains, the crop can be harvested before full maturity to take advantage of the market prices.  In the case of the seed crop also after the tubers are fully grown the haulms remain active for some time.  The skin maturity does not take place as long as the haulms do not completely die away.  Since this takes a lot of time which can otherwise be used for growing another crop, haulms cutting is done. Haulms cutting is a must for the seed crop and for the crop whose produce is likely to be stored for a long time either in cold stores or in country stores because only after haulms cutting the tuber skin starts maturing and a mature tuber skin is essential to avoid bruising of the tubers during harvest.  In the case of the early crop or in the crop which is sold and consumed within a few days after harvest, halums cutting is not essential. Therefore generally in the main crop, haulms cutting is done about 4-5 days after the last irrigation and the fields left as such for tuber skin maturity and drying of the field.  About 8-10 days after haulms cutting, the tuber skin would be hard enough to withstand harvesting.  Generally haulms cutting is done by hand implement like sickle but contact herbicides like Diquat have also been recommended.";
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
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {

    }
}
