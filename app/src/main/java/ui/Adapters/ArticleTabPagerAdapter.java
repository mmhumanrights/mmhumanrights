package ui.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import ui.fragments.ArticleOneFragment;
import ui.fragments.ArticleTwoFragment;

/**
 * Created by winhtaikaung on 11/4/15.
 */
public class ArticleTabPagerAdapter extends FragmentPagerAdapter {

    private final String[] TITLES = { "အပိုဒ်(၁ မှ ၁၅)","အပိုဒ်(၁၆ မှ ၃၀)" };
    //private final String[] TITLES = { "A","B" };
    public ArticleTabPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:

                ArticleOneFragment fragment = new ArticleOneFragment();
                return fragment;

            case 1:

                ArticleTwoFragment second_fragment = new ArticleTwoFragment();
                /*Bundle argument = new Bundle();

                demofragment.setArguments(argument);*/
                return second_fragment;

            default:

                ArticleOneFragment defaultfragment = new ArticleOneFragment();
                return defaultfragment;

        }


    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }

    @Override
    public int getCount() {
        return 2;
    }
}
