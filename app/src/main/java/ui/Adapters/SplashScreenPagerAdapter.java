package ui.Adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import ui.fragments.SplashFragment;

/**
 * Created by winhtaikaung on 12/29/15.
 */
public class SplashScreenPagerAdapter extends FragmentPagerAdapter {

    public SplashScreenPagerAdapter(FragmentManager fm){
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = new SplashFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("pagerposition", position);

        fragment.setArguments(bundle);
        return  fragment;//Has to return Fragment
    }

    @Override
    public int getCount() {
        return 5;
    }
}
