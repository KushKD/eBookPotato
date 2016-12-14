package com.honsol.potatoebook;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import Interfaces.TextLinkClickListener;
import Presentation.LinkEnabledTextView;
import Utils.Custom_Dialog;

public class Mite extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mite);
        String text  = " The broad mite, Polyphagotarsonemus latus (Banks) (= Hemitarsonemus latus (Banks)), also known as tarsonemid mite, tropical mite, yellow tea mite, causing tambera in potato (or murda in chillies), is widely distributed. Damage due to broad mite is serious in Maharashtra and Karnataka during kharif season and western UP and Punjab on early-planted rabi potatoes. Besides, mite damage on potato crop has been observed around Gwalior (MP) and in Kangra valley (HP).\n" +
                "\n" +
                "Both the adults and nymphs of this mite feed on the lower surface of leaves by sucking the cell sap. The infestation normally starts from the top leaves and gradually proceed downward. Because of its attack, the lower sides of infested leaves first turn oily, then reddish and finally bronze coloured. In case of severe infestation, the leaves are short and leathery. The pest is responsible for 80-100% foliage infestation, causing 12 to 60% yield losses. High humidity and moderate temperatures are quite conducive for the multiplication of this mite and consequent damage.\n" +
                "\n" +
                "This mite generally appears in the 3rd week of October on potato crops planted at/around 15th September in western Gangetic plains.However, it causes little damage on main crop (planted after 15th October) and spring crop (planted during the last week of December). In peninsular India, this mite generally appears in early August on kharif crop, and is active during August-September. In Maharashtra and Karnataka its attack on rabi potato crop is generally seen towards crop maturity i.e. during February-March.  For control of mites general cultural practices as adopted for leaf hoppers may be taken but as regards chemicals acaricides are available which can be integrated with cultural practices.\n" +
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
                Mite.this.finish();
            }
        });



        ImageView  imageView1 = (ImageView) findViewById(R.id.imageView1);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Custom_Dialog CD = new Custom_Dialog();
                CD.showDialog(Mite.this,"mite1");
            }
        });


        ImageView  imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Custom_Dialog CD = new Custom_Dialog();
                CD.showDialog(Mite.this,"mitefig");
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {
    }
}
