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

public class Sulphur extends  AppCompatActivity implements TextLinkClickListener {

    private LinkEnabledTextView check;
    Button back_Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sulphur);

        String text  = "Sulphur\n" +
                "\n" +
                "Sulphur is now being rated as the fourth major nutrient, after N, P and K. It is gaining recognition in view of its role in improving crop quality balance of anions viz. N, P and S in agricultural crops including potato. In potato, sulphur is required for many metabolic activities.\n" +
                "\n" +
                "In case of S deficiency, the yellowing of leaves starts from the upper leaves contrary to N deficiency symptom. In case of acute deficiency the plants are retarded, with reddening of stems and inward curling of leaves.\n" +
                "\n" +
                "Ammonium sulphate (23.7% S), single super phosphate (12.0%S), potassium sulphate (18.0%S) and gypsum (13-15%S) are the major sources of S as they have readily available S as SO4. Sources which initially do not contain sulphate-S are Pyrites (20-50% S) and elemental S (85-100% S) which have to undergo transformation by chemical or biological means in the soil so as to convert the S to sulphate form. Among these, ammonium sulphate, potassium sulphate and single super phosphate are used for supplying N, P and K to the potato crop rather than for S without taking into account their S content.\n" +
                "\n" +
                "The efficacy of sulphur carriers depends upon the crop sequence, organic matter content in soil and climatic factors i.e. temperature and moisture. In plains, where the crop is taken in winter under assured irrigation, the use of gypsum has been found to be the best while in hills, where the crop duration is long and soils contain appreciable quantity of organic matter, the application of elemental S is superior to ammonium sulphate.\n" +
                "\n" +
                "Availability and requirements of sulphur \n" +
                "\n" +
                "Although soils have sufficient total S but 80 to 95 per cent of it is in organic form and only a fraction of it is in available form (sulphate). A sparse rooted crop like potato cannot utilize soluble S from the deeper layers in soil.  The Indo-Gangetic plains have light coarse textured soils low in organic matter and hence requires S from external source.  In alluvial and red loam soils, the optimum dose varied from 30-40 kg S depending upon the S status of the soil with response ranging from 26 to 78 q/ha under assured irrigation. In acidic soils of Shimla hills, application of S at 36 kg/ha is needed to meet S needs of potato under rainfed conditions.\n" +
                "\n" +
                "Balanced application of N and S has been found to enhance nutrient recovery from applied fertilizers both in hills and plains. The optimum N: S ratio in potato leaf at stolon formation and tuber initiation has been found to be 28.4:1 and 17.9:1, respectively and is positively correlated with yield. On the other hand, higher levels of S or P have an antagonistic relationship in potato crop. The optimum N: P: S ratio at stolon formation and tuber initiation stage should be 15.8:1.37:1.0 and 12.9:0.65:1.0, respectively for optimum potato yields.\n" +
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
                Sulphur.this.finish();
            }
        });
    }

    @Override
    public void onTextLinkClick(View textView, String clickedString) {

    }
}