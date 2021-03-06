package ui.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.animation.Interpolator;
import android.widget.Scroller;

import com.crashlytics.android.Crashlytics;
import com.myanmarhumanrights.R;
import com.viewpagerindicator.CirclePageIndicator;

import io.fabric.sdk.android.Fabric;
import java.lang.reflect.Field;

import base.BaseActivity;
import comm.MySharedPreference;
import config.GLOBAL_STRING;
import ui.Adapters.SplashScreenPagerAdapter;
import ui.fragments.SplashFragment;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by winhtaikaung on 12/30/15.
 */
public class SplashActivity extends BaseActivity implements SplashFragment.INavigationListener {

    ViewPager helpViewPager;
    CirclePageIndicator pageIndicator;
    SplashScreenPagerAdapter screenSlidePagerAdapter;
    MySharedPreference mSharedpreferences;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Padauk.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
        setContentView(R.layout.activity_splash);
        mSharedpreferences=new MySharedPreference(this);
        if(!mSharedpreferences.getString(GLOBAL_STRING.SPLASH, "").equals("")){

            startActivity(new Intent(SplashActivity.this,DrawerMainActivity.class));
            finish();
        }


        helpViewPager=(ViewPager)findViewById(R.id.help_viewpager);
        pageIndicator = (CirclePageIndicator) findViewById(R.id.help_viewpager_indicator);

        screenSlidePagerAdapter = new SplashScreenPagerAdapter(getSupportFragmentManager());
        helpViewPager.setAdapter(screenSlidePagerAdapter);
        pageIndicator.setViewPager(helpViewPager);

        pageIndicator.setStrokeWidth(2);

        changePagerScroller();

        helpViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                pageIndicator.setCurrentItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onNavigationClickListener(String nav) {
        if(nav.equals(this.getResources().getString(R.string.next))){
            helpViewPager.setCurrentItem(helpViewPager.getCurrentItem() + 1);
        }
        else if(nav.equals(this.getResources().getString(R.string.prev))){
            helpViewPager.setCurrentItem(helpViewPager.getCurrentItem() - 1);
        }
        else if(nav.equals(this.getResources().getString(R.string.done))){
            mSharedpreferences.setString(GLOBAL_STRING.SPLASH, "DONE");
            startActivity(new Intent(this, DrawerMainActivity.class));
            finish();
        }
    }

    private void changePagerScroller() {
        try {
            Field mScroller = null;
            mScroller = ViewPager.class.getDeclaredField("mScroller");
            mScroller.setAccessible(true);
            ViewPagerScroller scroller = new ViewPagerScroller(helpViewPager.getContext());
            mScroller.set(helpViewPager, scroller);
        } catch (Exception e) {
            Log.e("TAG", "error of change scroller ", e);
        }
    }

    /**
     * Created by Jerry on 14-6-6.
     */
    public class ViewPagerScroller extends Scroller {


        private int mScrollDuration = 600;

        public ViewPagerScroller(Context context) {
            super(context);
        }

        public ViewPagerScroller(Context context, Interpolator interpolator) {
            super(context, interpolator);
        }

        @Override
        public void startScroll(int startX, int startY, int dx, int dy, int duration) {
            super.startScroll(startX, startY, dx, dy, mScrollDuration);
        }

        @Override
        public void startScroll(int startX, int startY, int dx, int dy) {
            super.startScroll(startX, startY, dx, dy, mScrollDuration);
        }
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
