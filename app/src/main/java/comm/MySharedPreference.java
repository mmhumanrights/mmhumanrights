package comm;

/**
 * Created by winhtaikaung on 12/28/15.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by jr on 5/7/15.
 */
public class MySharedPreference {
    private static MySharedPreference mySharedPreference;
    protected SharedPreferences mSharedPreferences;
    protected SharedPreferences.Editor mEditor;
    protected Context mcontext;

    public MySharedPreference(Context context) {
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        mEditor = mSharedPreferences.edit();
        this.mcontext = context;
    }

    public static synchronized MySharedPreference getInstance(Context context) {
        if (mySharedPreference == null) {
            mySharedPreference = new MySharedPreference(context);
        }
        return mySharedPreference;
    }

    public void setString(String Key, String Value) {
        mEditor.putString(Key, Value).apply();
    }

    public String getString(String Key, String DefValue) {
        return mSharedPreferences.getString(Key, DefValue);
    }

    public boolean getBooleanPreference(String Key, boolean DefValue) {
        return mSharedPreferences.getBoolean(Key, DefValue);
    }

    public void setIntegerPreference(String Key, int Value) {
        mEditor.putInt(Key, Value).apply();
    }

    public int getIntegerPreference(String Key, int DefValue) {
        return mSharedPreferences.getInt(Key, DefValue);
    }

    public void setBooleanPreference(String key, boolean value) {
        mEditor.putBoolean(key, value).apply();
    }
}
