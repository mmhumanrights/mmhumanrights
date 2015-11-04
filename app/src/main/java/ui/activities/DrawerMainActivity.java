package ui.activities;

import android.content.Context;
import android.content.res.Configuration;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import ui.Adapters.DrawerList_Adapter;
import ui.fragments.ArticlesTabFragment;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import com.myanmarhumanrights.R;

public class DrawerMainActivity extends AppCompatActivity {

    DrawerLayout mDrawerLayout;
    Toolbar toolbar;
    LinearLayout mDrawerListLayout, btn_changefolder,btn_clearData;
    ListView mDrawerList;
    TextView mTitle;

    TextView app_version;
    ActionBarDrawerToggle mDrawerToggle;

    String[] DrawerMenuList;
    int[] DrawerIcons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/Padauk.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build()
        );
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerListLayout = (LinearLayout) findViewById(R.id.left_drawer);
        mDrawerList = (ListView) findViewById(R.id.left_drawer_lv);
        initialize();
        binddataTOList();
        makeFragmentSelection(0);
    }

    void binddataTOList() {
        DrawerMenuList = getResources().getStringArray(R.array.drawer_menu_array);
        //DrawerIcons=new int[]{R.drawable.ic_calendar, R.drawable.ic_setting,R.drawable.ic_info};
        DrawerIcons = new int[]{1, 2};
        DrawerList_Adapter drawerList_adapter = new DrawerList_Adapter(this, DrawerMenuList, DrawerIcons);
        drawerList_adapter.notifyDataSetChanged();
        mDrawerList.setAdapter(drawerList_adapter);
        mDrawerList.setOnItemClickListener(new DrawerListItemClickListener());
        setListViewHeightBasedOnChildren(mDrawerList);

    }

    private void initialize() {


        toolbar.setTitle(getResources().getString(R.string.app_name));

        toolbar.setTitleTextColor(getResources().getColor(android.R.color.black));
        toolbar.setOnMenuItemClickListener(new ToolbarMenuclickListener());


        //mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        //set toggle to naviation drawer on tollbar
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                // getActionBar().setTitle(mTitle);
                // toolbar.setTitle("PSI DataCapture");
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                // toolbar.setTitle(Title);
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerLayout.openDrawer(GravityCompat.START);


    }

    protected class ToolbarMenuclickListener implements Toolbar.OnMenuItemClickListener {

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            return false;
        }
    }

    protected class DrawerListItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            makeFragmentSelection(position);
        }

    }

    public void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }

        int totalHeight = listView.getPaddingTop()
                + listView.getPaddingBottom();
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            if (listItem instanceof ViewGroup)
                listItem.setLayoutParams(new AbsListView.LayoutParams(
                        AbsListView.LayoutParams.WRAP_CONTENT, AbsListView.LayoutParams.WRAP_CONTENT));
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    void makeFragmentSelection(int position) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        switch (position) {
            case 0:
                toolbar.setTitle(DrawerMenuList[position]);
                fragmentManager.beginTransaction().replace(R.id.content_frame,new ArticlesTabFragment()).commit();
                break;
            case 1:
                toolbar.setTitle(DrawerMenuList[position]);

                // fragmentManager.beginTransaction().replace(R.id.content_frame, new SDSListActivityFragment()).commit();
                break;
            case 2:
                //Do action here
                toolbar.setTitle(DrawerMenuList[position]);

                //fragmentManager.beginTransaction().replace(R.id.content_frame, new Fragment_vocablist()).commit();
                break;
            case 3:
                //Do action here
                toolbar.setTitle(DrawerMenuList[position]);
                //fragmentManager.beginTransaction().replace(R.id.content_frame,new Fragment_Settings()).commit();
                break;
            case 4:
                //Do action here
                toolbar.setTitle(DrawerMenuList[position]);
                //fragmentManager.beginTransaction().replace(R.id.content_frame,new Fragment_About()).commit();
                break;
            case 5:
                //Do action here
                toolbar.setTitle(DrawerMenuList[position]);
                //fragmentManager.beginTransaction().replace(R.id.content_frame,new Fragment_Licenses()).commit();
                break;
        }
        mDrawerList.setItemChecked(position, true);
        mDrawerLayout.closeDrawer(mDrawerListLayout);


    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}
