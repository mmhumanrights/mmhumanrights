package ui.fragments;

import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;
import com.myanmarhumanrights.R;

import base.BaseFragment;
import comm.Com_Utils;
import ui.Adapters.ArticleTabPagerAdapter;

/**
 * Created by winhtaikaung on 11/3/15.
 */
public class ArticlesTabFragment extends BaseFragment {
    ViewPager mViewPager;
    Com_Utils com_utils=new Com_Utils();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_articletab, container, false);
        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) v.findViewById(R.id.tabs);

        mViewPager = (ViewPager) v.findViewById(R.id.pager);
        ArticleTabPagerAdapter tabPagerAdapter=new ArticleTabPagerAdapter(getChildFragmentManager());

        Typeface custom_font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Padauk.ttf");
        tabs.setTextColor(getResources().getColor(R.color.main_pink));
        tabs.setIndicatorColor(getResources().getColor(R.color.main_pink));
        tabs.setTypeface(custom_font, 1);
        tabs.setTextSize(com_utils.getScreenWidth(getActivity())/18);

        Log.w("SCR_WIDTH", String.valueOf(com_utils.getScreenWidth(getActivity())/30));


        mViewPager.setAdapter(tabPagerAdapter);

        tabs.setViewPager(mViewPager);

        return v;
    }
}
