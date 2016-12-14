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

public class RootKnot extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root_knot);
        String text  = "Root-knot nematode infests the roots and tubers of potato plants leading to the hindrance in normal functions of nutrient and water uptake/ translocation. Infested plants are dwarfed, chlorotic and have stunted foliage and poor root development. The galls on roots are small and often go unnoticed but tubers have warty growth or rough surface that reduces their market value."
                      +"\n"+"Cultural practices: \n" +
                "\n" +
                "§         Deep ploughing and sun drying of fields during summer months help in drying of infective stages of larvae.\n" +
                "\n" +
                "§         Planting of potato crop during the 2nd week of October in autumn and in early January for the spring can limit RKN infestation on tubers.\n" +
                "\n" +
                "§         Burning of trash in field before planting helps not only by sterilizing the soil but also enriching it.\n" +
                "\n" +
                "§         Growing one row of trap plants like Tagetes patula and T. erecta (African marigold) in between 2 or 3 rows of potatoes improves the crop performance by reducing RKN infestation. \n" +
                "\n" +
                "§         RKN are being polyphagous in nature having a wide host range yet a few crops are free from M. incognita infestation allowing crop rotation with a non-host, like maize, wheat, millets, beans etc. for reducing RKN infestation.\n" +
                "\n" +
                "§         Potatoes harvested from RKN infested field should not be used as seed for subsequent crop. Movement of the soil and water from infested fields to RKNs free fields should also be avoided. Besides,the field should be kept free from weeds as RKNs have a wide host range and most of the weeds help them.\n" +
                "\n" +
                "Chemical management: An effective control of RKN can be achieved either through carbofuran @ 3 kg ai/ha or aldicarb @ 2 kg ai/ha or ethoprop @ 10 kg/ha preferably in two equal splits i.e. half at planting and remaining half at earthing time.\n" +
                "\n" +
                "Biological control: A large number of biotic agents such as fungi, bacteria, predacious nematodes, protozoan etc. are reported for managing the RKNs. However, an efficient use of these bio-agents has not yet been possible.\n" +
                "\n" +
                "Integrated approach: The IPM schedule consisting of soil solarization, adjusting planting dates, growing trap plants like Tagetus spp rotation with non host crops, conservation of natural enemies (bacteria, fungi etc.) and need based application of nematicides helps in control of nematodes in the soil.\n" +
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
                RootKnot.this.finish();
            }
        });



        ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Custom_Dialog CD = new Custom_Dialog();
                CD.showDialog(RootKnot.this,"rootknematode2");
            }
        });


        ImageView  imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Custom_Dialog CD = new Custom_Dialog();
                CD.showDialog(RootKnot.this,"rootknematode1");
            }
        });

        ImageView  imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Custom_Dialog CD = new Custom_Dialog();
                CD.showDialog(RootKnot.this,"rknfigactual");
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {
    }
}
