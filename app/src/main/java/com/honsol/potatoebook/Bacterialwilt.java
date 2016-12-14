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

public class Bacterialwilt extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bacterialwilt);
        String text  = "Bacterial wilt/brown rot is the most destructive bacterial disease of potato. Besides potato, the pathogen Ralstonia solanacearum (formerly Pseudomonas solanacearum and more recently, Burkholderia solanacearum) also causes lethal vascular wilt diseases in more than 200 plant species belonging to at least 50 different plant families including several crops like potato, tomato, chilli, brinjal, pepper, ginger and others. It is very widespread in southern India. Since the disease affects the vascular bundles, the symptoms of the disease is seen in the field as drooping of foliage as in the case of water stress.  Control of bacterial wilt is difficult but it can be managed so that the loss is minimized.";

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
                Bacterialwilt.this.finish();
            }
        });

        ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Custom_Dialog CD = new Custom_Dialog();
                CD.showDialog(Bacterialwilt.this,"tuberbackterialwilt1");
            }
        });


        ImageView  imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Custom_Dialog CD = new Custom_Dialog();
                CD.showDialog(Bacterialwilt.this,"leafbacterialwilt1");
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {
    }
}
