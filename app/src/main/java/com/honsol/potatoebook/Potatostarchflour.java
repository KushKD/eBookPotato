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

public class Potatostarchflour extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_potatostarchflour);
        String text  =  "Starch:  About 3% of the world potato is used for the production of starch and the world production of potato starch is approximately 2 million tons. Potato starch has high swelling power and high viscosity and due to these properties it is considered superior than all types of cereal starch.  It has a wide application in paper, food and pharmaceutical industries. Potato starch is used in paper manufacture for beater sizing, tub sizing, calendar sizing and surface coating. It is also used in the textile industry in the sizing of cotton, worsted and spun rayon warps. Much of the potato starch in developed countries is utilized in the food industry in bakers' speciality items and in the confectionery industry. It is also used as a thickener in soups and gravies. Potato starch has been successfully used to make instant puddings and in this form it is preferred over cereal starches. It is also used in producing adhesives and dextrins, as a fermentation raw material, binder for tablets and binder and extender for sausages. \n" +
                "\n" +
                "Sub-standard potatoes like too small, too large, misshapen, damaged, culled or surplus potatoes can be used for starch manufacture, yet for high starch recovery, potatoes with high dry matter content are preferred. The principal operations in a typical modern starch manufacturing plant involves milling of washed potatoes by a vertical hammer mill type disintegrater, followed by several centrifugal sieves employed in a series, final purification through a battery of cylindro-conical centrifugal separators, vacuum filtration, flash drying and packaging. The extracted pulp during starch manufacture is dried which serves as a feed for livestock.\n" +
                "\n" +
                "Other edible products: Several edible fried and non-fried products can be made from cooked, mashed potatoes, potato flour and potato starch either alone or in combination with other foodstuffs.";

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
                Potatostarchflour.this.finish();
            }
        });

        ImageView  imageView1 = (ImageView) findViewById(R.id.imageView1);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Custom_Dialog CD = new Custom_Dialog();
                CD.showDialog(Potatostarchflour.this,"pot_flour1");
            }
        });

    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {


    }
}
