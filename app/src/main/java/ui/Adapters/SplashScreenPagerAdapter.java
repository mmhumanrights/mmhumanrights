package ui.Adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by winhtaikaung on 12/29/15.
 */
public class SplashScreenPagerAdapter extends FragmentPagerAdapter {

    public SplashScreenPagerAdapter(FragmentManager fm){
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("pagerposition", position);

        return  null;//Has to return Fragment
    }

    @Override
    public int getCount() {
        return 0;
    }
}
