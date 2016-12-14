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

public class Wart extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wart);
        String text  =  "Wart is caused by Synchytriun endobioticum (schilberszky) Percival a member of Chytridales. It causes great damage to potato seed industry in the hills. The disease once established is difficult to eradicate since the resting spores of the pathogen remain viable for many decades.\n" +
                "\n" +
                "Rough warty mostly spherical outgrowths or protuberances appear on buds and eyes of tubers, stolons, or underground stems or at stem base. Wart may appear occasionally on above ground stem, leaf or flowers. Underground galls are white to light pink when young that become brown or light black with age. Above ground galls are green to brown or black. The wart tissues are soft and spongy. Tubers may get completely replaced by warts, which desiccate or decay at harvest.\n" +
                "\n" +
                "Potato wart is restricted by domestic quarantine to Darjeeling and adjoining hills in India. The disease has been successfully managed by sanitation, long crop rotation, growing resistant and immune varieties and by enforcing strict quarantine legislation in Darjeeling hills. Control of the disease is possible by cultivation of wart immune varieties. Many varieties immune to wart have been developed in India. Development and introduction of wart immune varieties such as Kufri Jyoti, Kufri Bahar, Kufri Sherp and Kufri Kanchan to wart infested region of Darjeeling Hills coupled with domestic quarantine had great impact in containing wart in the region.\n" +
                "\n" +
                "Application of fungicides and chemical to soil is costly and not practical. Intercropping potato with maize, or rotational crops such as bean and radish have been found to reduce population of viable resting spores in soil. \n" +
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
                Wart.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {














    }
}
