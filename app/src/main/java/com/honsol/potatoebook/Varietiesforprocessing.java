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

public class Varietiesforprocessing extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_varietiesforprocessing);
        String text  =  "Generally, a chipping variety must have high yielding ability of marketable size and processing grade tubers, disease resistance, maturity to fit in the growing season and good keeping quality. It must also meet the specifications of acceptable chip colour and low reducing sugars, high dry matter, proper shape and size for minimum peeling waste, free from mechanical injury and physiological disorders and the finished product should have good texture and flavour. All the Indian potato varieties released until 1998 were developed for table purpose. However, some of these varieties were found suitable for processing since these varieties possess required morphological characters, high dry matter content and an acceptable level of reducing sugars. Kufri Jyoti and Kufri Lauvkar are two varieties, which produce reasonable quality chips when grown at specific locations as mentioned above, but generally show less than 20 per cent tuber dry matter content. However, two processing varieties, Kufri Chipsona-1 and Kufri Chipsona-2, were released by Central Potato Research Institute during 1998, exclusively for processing. Both these varieties were found suitable for chipping as their tubers possessed required shape and size, contained more than 20 % dry matter and low reducing sugars and produced light coloured chips when grown at most of the places in India. These varieties also give high yield, possess good resistance to late blight and show flexibility in time of planting.\n" +
                "\n" +
                "The processed potato products can be classified into following categories: \n" +
                "\n" +
                "1.      Dehydrated  products, such  as  dehydrated  chips, dice  or  cubes,  waris,  papads,  flakes,     granules, flour etc.\n" +
                "\n" +
                "2.      Fried products, including potato chips, frozen French fries and other frozen products.\n" +
                "\n" +
                "3.     Potato Starch \n" +
                "\n" +
                "4.     Eatables such as  potato custard, potato soup, gravy thickener, potato biscuits and cake \n" +
                "\n" +
                "5.     Canned potatoes \n" +
                "\n" +
                "6.     Pre-peeled potatoes\n" +
                "\n" +
                "7.     Fabricated products such as extruded products and preformed French fries\n" +
                "\n" +
                "8.     Miscellaneous products such as alcohol, lactic acid, broth, glucose syrup etc.\n" +
                "\n" +
                "Among processed products, potato chips are the most popular in India. There are specific tuber quality requirements for different types of processed products (Table). Potatoes containing more than 20% dry matter content with mealy texture are preferred for fried and dehydrated products, while small size potatoes containing dry matter between 18-20% with waxy texture are preferred for canning. The ideal reducing sugar content for processing into chips is generally accepted to be less than 0.15% of tuber fresh weight, while for French fries the upper limit may be as high as 0.5%.\n";

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
                Varietiesforprocessing.this.finish();
            }
        });

    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {


    }
}
