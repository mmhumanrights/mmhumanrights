package ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.myanmarhumanrights.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import base.BaseFragment;
import config.GLOBAL_STRING;
import ui.Adapters.ArticleGridAdapter;
import ui.activities.DefinitionActivity;

/**
 * Created by winhtaikaung on 11/4/15.
 */
public class ArticleTwoFragment extends BaseFragment {
    GridView gv_article_pt_two;
    ArticleGridAdapter mArticleGridAdapter;
    List<String> article_pt_one;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_articleparttwo,container,false);
        gv_article_pt_two=(GridView) v.findViewById(R.id.gv_article_pt_two);
        article_pt_one=new ArrayList<>(Arrays.asList(getActivity().getResources().getStringArray(R.array.arr_article_title)));
        mArticleGridAdapter=new ArticleGridAdapter(getActivity(),article_pt_one.subList(15, 30));
        gv_article_pt_two.setAdapter(mArticleGridAdapter);

        gv_article_pt_two.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("GRID_POSITION", String.valueOf(view.getTag()));
                Intent intent = new Intent(getActivity(),DefinitionActivity.class);
                intent.putExtra(GLOBAL_STRING.ARRAY_INDEX, position);
                intent.putExtra(GLOBAL_STRING.ARTICLE_PART,"2");
                startActivity(intent);
            }
        });
        return v;
    }
}
