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

public class Coldstores extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coldstores);
        String text  = "Potatoes harvested in February-March have to be stored until October and refrigeration is essential for such a long-term storage. Low temperature storage (2-40 C) is the most common method of potato storage. Low temperature storage is effective because at a storage temperature of 4ºC and below, sprout growth does not normally take place. Losses by respiration are also minimum as also due to rotting as pathogen activity is also very slow. Storage of potatoes in cold store has become a common practice in the country. The primary purpose of storage at 2-4ºC is to check sprout growth, therefore storage of seed potatoes at 2-4ºC in cold store is ideal but storage of ware potatoes at 2-4ºC is not desirable. Low temperatures induce accumulation of large amounts of sugars, which make the tubers sweet and therefore less suitable for consumption. Cold stored potatoes have high level of reducing sugars causing browning in potato chips. The high sugar content of potatoes stored at 2-4O C can be reduced to some extent by storing these potatoes at 20O C for 6 weeks. This process is called reconditioning. However, reconditioning will not restore the sugar levels to those at the time of storage.";
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
                Coldstores.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {
    }
}
