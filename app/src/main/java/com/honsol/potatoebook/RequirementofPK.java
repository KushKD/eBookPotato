package com.honsol.potatoebook;

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

public class RequirementofPK extends AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requirementof_pk);

        String text  =  "Phosphorus and potassium are the second and third limiting nutrients in potato production. Phosphorus is involved in a wide range of plant processes like cell division, development of root system and enhanced crop maturity. Its application increases the number of medium size tubers per plant, which has a special significance for the seed crop. On the other hand, application of K increases plant height, crop vigor and imparts resistance against drought, frost and diseases. Its application activates a number of enzyme systems involved in photosynthesis, carbohydrate metabolism and protein synthesis. It also increases the yield by increasing the number of large size tubers\n" +
                "\n" +
                "Phosphorus nutrition has special significance in acidic and laterite soils where P fixation is a problem while in north-western plains; potassium plays an active role as the duration is short K and K increases tuber bulking and making it possible to get high yield in a short time. It also imparts protection against frost. In north-western plains while in the hills, under long day and rainfed conditions, K application protects the crop from moisture stress in the early stages of crop growth. \n" +
                "\n" +
                "Apart from their effect on tuber size and number, application of P and K has a significant influence on the nutrient composition and tuber quality viz. dry matter, sugar and vitamin C content. Application of P at optimum dose increases tuber starch and vitamin C content but higher levels adversely affects protein content. Likewise, application of K increases total and reducing sugar contents while  decreasing tuber dry matter , the decrease being more when Muriate of Potash is applied than when Sulphate of Potash is applied. The negative effect of Muriate of Potash on dry matter is mainly due to the accompanying chloride ion. The chip quality is also affected by K source. Application of K through Muriate of Potash decreases enzymatic discoloration and phenol content thereby reducing the browning of potato chips.\n" +
                "\n" +
                "Phosphorus application has little effect on keeping quality of tubers whereas potassium has a significant role in tuber keeping quality. Tubers with higher K content show better skin curing and hardening and also lesser rottage during storage.\n" +
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
                RequirementofPK.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {

    }
}
