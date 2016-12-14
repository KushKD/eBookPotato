package com.honsol.potatoebook;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import Interfaces.TextLinkClickListener;
import Presentation.LinkEnabledTextView;

public class WeedprobleminPotato extends AppCompatActivity implements TextLinkClickListener {
    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weedproblemin_potato);
        String text = "Weeds reduce the potato yield. The reduction in yield due to weeds has been estimated in the range of 10-80% under different agro-climatic conditions. Competition between the crop and weeds for nutrients is perhaps the most serious cause for reduction in crop yield. Weeds are better adapted to withstand adverse conditions and hence they deplete soil moisture while the crop suffers. Weeds also compete for nutrients. Weeds have been estimated to remove 43, 8 and 49 kg NPK respectively in the hills while in the plains the removal is about 21,7, 19 kg NPK per ha. The crop yielding 250 to 230 q/ha removes about 120 to 140 kg N, 25 to 30 kg P2O5 and 170 to 230 kg K2O per ha.Weeds also over-power the crop because of their large number, hardy nature and fast growth thus smothering the crop. Some weeds also release biochemical substances called “allelochemicals” which adversely affect the growth and development of potato plants.\n" +
                "\n" +
                "A large number of weeds act as hosts and support multiplication of insect pests/virus vectors and various pathogens, which cause serious diseases to the potato crop. Aphids are the major vectors of potato viruses with a wide host range. Myzus persicae (Sulzer) and Aphis gosspii (Glover) multiply on Ageratum conyzoides L., Nicandra physaloides Gaerten. Solanaceous weeds viz. Solanum pimpinellifolium and S. sisymbrifolium and several others are the collateral hosts of wart pathogen (Synchytrium endobioticum). The late blight (Phytophthora infestans) has also been observed on some common weeds in potato fields viz. Polygonum alatum, Buch-Hum; Ipomea purpurea Lam. and Sonchus oleraceus L. Similarly,  Nicandra physaloides is a host of early blight pathogen (Alternaria solani Ell. & Mart). The bacterial wilt caused by Ralstonia solanacearum Smith has been observed on Ageratum conyzoides, Amaranthus viridis and Phyllanthus niruri growing in and around potato fields. Majority of viruses infecting potato have many weed hosts that are widely distributed in and around the potato crop. The viruses present in these weed hosts serve as a primary source of inoculum for infecting the crop either through contact or through the vectors.\n" +
                "\n" +
                "Weeds offer resistance to harvesting, hence, potato crop infested with weeds requires extra labour for harvesting. The presence of weeds also causes breakages, stoppages and thus extra depreciation of farm machinery at the time of earthing up and lifting of the tubers. In addition, rhizomes of weeds like nut sedge (Cyperus rotundus L.) may damage tubers physically resulting in deterioration of the quality.\n" +
                "\n" +
                "For effective weed management, it is essential to have the knowledge of weed flora infesting the crop. \n" +
                "\n";

        check = (LinkEnabledTextView) findViewById(R.id.linkenabledtextview);
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
                WeedprobleminPotato.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {



    }
}
