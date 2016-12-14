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

public class Enzymesystems extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enzymesystems);
        String text  = "  The potato tuber contains numerous enzyme systems that constitute a considerable proportion of the total protein, and some of which are important in relation to its processing and nutritional quality. Starch degrading enzymes decrease the degree of polymerization of starch, which contains predominantly alpha 1,4-linked glucose units. The process of starch degradation during cold sweetening is believed to be principally phosphorylitic rather than hydrolytic in nature.\n" +
                "\n" +
                "Sucrose phosphate synthase, UDP glucose pyrophosphorylase (UGPase) and invertase are the three major enzymes directly involved in sucrose and reducing sugar formation. In cold stored tubers, 70-80% decrease in sucrose phosphate synthase expression resulted in a reproducible but non-proportional (10-40%) decrease of soluble sugars. A relationship has been shown to exist between the allelic polymorphism of UGP ase exhibited among potato clones and their ability to accumulate sugars in cold storage.\n" +
                "\n" +
                "Other biochemical changes\n" +
                "\n" +
                "              Potatoes are a major and cheap source of ascorbic acid (Vitamin C) in the human diet, but its levels decrease during storage. The most rapid loss occurs during the first months of refrigerated storage ranging from 40 to 60%. Storage temperatures as well as time affect vitamin C losses and the losses are higher below 10O C storage than between 10 and 20O C.\n" +
                "\n" +
                "              Polyphenolic compounds are present in potatoes and enzyme catalysed browning reactions involve the oxidation of phenolic compounds by the enzyme tyrosinase (polyphenol oxidase (PPO)) to quinones, followed by transformation of the quinones to dark pigments. These changes result in deterioration in flavour, colour and nutritional quality. PPO activity is higher at higher storage temperatures leading to greater discolouration. The principal organic acids in potatoes are citric acid and malic acid. Low temperature storage results in decrease in pH and an increase in malic and citric acid contents of tubers.\n" +
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
                Enzymesystems.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {
    }
}
