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

public class Leafhoppers extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leafhoppers);
        String text  = "The leafhoppers can damage the potato crop both as vector and direct pest. The species like Alebroides nigroscutulatus Dist. and Seriana equata Singh damage the crop as vectors of phytoplasmal diseases, viz. purple top roll  (PTR) and marginal flavescence (MF). These are predominantly present at/around Shimla from May to August.\n" +
                "\n" +
                "Amrasca devastans (Dist.) (= Empoasca devastans (Dist.) = Amrasca beguttula beguttula  Isida) causes direct damage to potato crop as  a pest and is widely distributed over all the potato growing regions in India. However, it regularly causes serious damage to early planted potato crops normally grown in Western Uttar Pradesh, Haryana  and  Punjab.  On the other hand, it is graded as sporadic pest in Maharashtra and Karnataka. Being polyphagous it feeds on cotton, okra, brinjal, sunflower and holy hock. Both the adults and nymphs cause damage by sucking the sap from the foliage and depleting the cell content. The first symptom of its attack could easily be seen as black spot at the tip of leaf and/or end of each lateral vein let.  Often the entire margin of infested leaf may roll upward which subsequently turns brown and looks as if scorched by fire or drought. These brown margins continue to increase in width until a narrow strip of leaflet along the mid rib remains green while the rest of the portions shrivel and die. Normally the older leaves below the growing tips burn first. However, upon heavy infestation, every leaf succumbs rapidly and dies much before the normal development of tubers is completed. On an average, the pest is responsible for 90-100% foliage damage.  This type of foliage damage is popularly known as ‘hopper burn’ and leads to 20-30% yield losses to early-planted potato crops in the western Gangetic plains. Management of leaf hoppers involves use of both cultural and chemical methods.";

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
                Leafhoppers.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {
    }
}
