package comm;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;

import java.util.Random;

/**
 * Created by winhtaikaung on 11/5/15.
 */
public class Com_Utils {

    public  int getRandomnum(int max,int min){
        Random rand = new Random();

        int  n = rand.nextInt(max) + min;
        return n;
    }

    public int getScreenWidth(Activity a){
        Display display = a.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        return width;
    }

    public int getScreenHeight(Activity a){
        Display display = a.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int height = size.y;
        return height;
    }
}
