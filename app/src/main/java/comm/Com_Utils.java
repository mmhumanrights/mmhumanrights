package comm;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.Display;

import java.util.Random;

/**
 * Created by winhtaikaung on 11/5/15.
 */
public class Com_Utils {

    public static int getRandomnum(int max, int min) {
        Random rand = new Random();

        int n = rand.nextInt(max) + min;
        return n;
    }

    public static boolean isOnline(Context c) {
        ConnectivityManager cm = (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        if (ni == null) {
            // There are no active networks.
            return false;
        } else
            return true;
    }

    /**
     * @return Application's version code from the {@code PackageManager}.
     */
    public static String getAppVersion(Context context) {
        try {


            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            // should never happen
            throw new RuntimeException("Could not get package name: " + e);
        }
    }

    public int getScreenWidth(Activity a) {
        Display display = a.getWindowManager().getDefaultDisplay();
        if(android.os.Build.VERSION.SDK_INT <= 10) {
            int width = display.getWidth();
            return width;
        }else {


            Point size = new Point();
            display.getSize(size);
            int width = size.x;
            return width;
        }

    }

    public int getScreenHeight(Activity a) {
        Display display = a.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int height = size.y;
        return height;
    }
}
