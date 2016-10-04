package by.mrkip.apps.epamandroidtraining.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

/**
 * Created by kip on 03.10.2016.
 */

 public class  SharedPrefManager {
    private SharedPreferences sharedPref;
    private Context appContext;

    public SharedPrefManager(String prefFileName, Context appContext) {
        sharedPref = appContext.getApplicationContext().getSharedPreferences(prefFileName, appContext.MODE_PRIVATE);
        this.appContext = appContext;
    }

    public boolean saveParam(String tag, String val) {

        try {
            sharedPref.edit().putString(tag, val).commit();

        } catch (Exception e) {
            Toast.makeText(this.appContext, "Error while try to save in sharedPreference : " + e.toString(), Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }

    public String getStringParam(String tag) {
        String res = null;
        try {
            res = sharedPref.getString(tag, "-1");

        } catch (Exception e) {
            Toast.makeText(this.appContext, "Error while try to get from sharedPreference: " + e.toString(), Toast.LENGTH_LONG).show();
            return res;
        }
        return res;
    }

    public String getStringParam(String tag,String defVal) {
        String res = null;
        try {
            res = sharedPref.getString(tag, defVal);

        } catch (Exception e) {
            Toast.makeText(this.appContext, "Error while try to get from sharedPreference: " + e.toString(), Toast.LENGTH_LONG).show();
            return res;
        }
        return res;
    }


}
