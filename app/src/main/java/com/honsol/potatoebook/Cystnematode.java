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

public class Cystnematode extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cystnematode);
        String text  = "Dr. F.G.W. Jones first detected the PCNs in India in 1961 from a field at Vijayanagaram state Farm in Ootacamund, Niligirs hills (Tamil Nadu). Later on, their occurrence was also noticed from Kodaikanal hills.  Extensive surveys conducted in other major potato growing areas of Assam, Karnataka, Himachal Pradesh, Punjab and Uttar Pradesh indicated the absence of PCNs in these states.  Realising the potential danger of PCNs to potato cultivation in the country, the Destructive Insect Pest act 1919 was amended by the Tamil Nadu Government in 1971 to ensure strict checking of movement of potatoes grown in infested fields/areas prior to their marketing. PCN affects the total growth of the plant.  Since it is soil as well as seed borne a variety of methods have to be employed to control this pest.\n" +
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
                Cystnematode.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {
    }
}
