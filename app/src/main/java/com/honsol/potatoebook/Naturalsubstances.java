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

public class Naturalsubstances extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naturalsubstances);
        String text  = "Several naturally occurring aromatic aldehydes (salicylaldehyde, benzaldehyde, cinnamaldehyde and cumminaldehyde) and aromatic alcohols (thymol) are reported to inhibit sprout growth for a short period of up to 14 days. Aromatic compounds like mono, di and trimethyl naphthalenes, benzothiophene and diphenylamine have also been found to have sprout inhibitory effect. Some volatile monoterpenes are also reported to inhibit sprout growth. Muna plants (family Lamiacea) contain essential oils that are comprised of over 98% monoterpenes. Vapour treatment (250 µl/l for ten days) with pure E. globulus oil showed strong sprout suppression effect upto 80 days of storage at 24 + 2O C.  Carvone a monoterpene produced by Carum carvi (caraway), has shown consistently good results in storage trials at 8-10O C. It is found in essential oils of Cuminim Cyminum, Mentha Spicata, Mentha citrata, Mentha cardiaca, Anethem graveolens and Anathem soya.\n" +
                "\n" +
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
                Naturalsubstances.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {
    }
}
