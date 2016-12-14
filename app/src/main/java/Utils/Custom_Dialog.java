package Utils;
import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import com.honsol.potatoebook.R;
public class Custom_Dialog  {
    public void showDialog(Activity activity, String image){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_custom);
        int res = activity.getResources().getIdentifier(image, "drawable", activity.getPackageName());
        ImageView text = (ImageView) dialog.findViewById(R.id.dialog_result);
        text.setImageResource(res);

        Button dialog_ok = (Button)dialog.findViewById(R.id.dialog_ok);

        dialog_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // activity.finish();
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}