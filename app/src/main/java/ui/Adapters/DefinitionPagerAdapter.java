package ui.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import models.Article;
import ui.activities.DefinitionDetailFragment;

/**
 * Created by winhtaikaung on 12/28/15.
 */
public class DefinitionPagerAdapter extends FragmentPagerAdapter {

    Article[] arr_articles;
    Context mContext;
    public DefinitionPagerAdapter(Context c,Article[] articles,FragmentManager manager){
        super(manager);
        this.arr_articles=articles;
        this.mContext=c;
    }

    @Override
    public Fragment getItem(int position) {

       return  DefinitionDetailFragment.newInstance(position,"");
    }

    @Override
    public int getCount() {
        return arr_articles.length;
    }
}
