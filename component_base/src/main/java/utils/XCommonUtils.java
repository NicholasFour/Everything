package utils;

import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by songshuaitong on 2018/3/28.
 */

public class XCommonUtils {

    public static String getTextViewString(TextView textView) {
        return textView.getText().toString().trim();
    }

    public static String getEditTextString(EditText editText) {
        return editText.getText().toString().trim();
    }
}
