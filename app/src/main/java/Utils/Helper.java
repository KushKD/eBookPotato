package Utils;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by kuush on 12/12/2016.
 */

public class Helper {

    public static String getAssetsPdfPath(Context context) {
        String filePath = context.getFilesDir() + File.separator + "sample.pdf";
        File destinationFile = new File(filePath);

        try {
            FileOutputStream outputStream = new FileOutputStream(destinationFile);
            InputStream inputStream = context.getAssets().open("sample.pdf");
            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            Log.e(context.getClass().getSimpleName(), "Error.");
        }

        return destinationFile.getPath();
    }
}
