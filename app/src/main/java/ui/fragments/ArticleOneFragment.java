package ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.myanmarhumanrights.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import base.BaseFragment;
import config.GLOBAL_STRING;
import ui.Adapters.ArticleGridAdapter;
import ui.activities.DefinitionActivity;
import ui.activities.DrawerMainActivity;

/**
 * Created by winhtaikaung on 11/4/15.
 */
public class ArticleOneFragment extends Fragment {

    GridView gv_article_pt_one;
    ArticleGridAdapter mArticleGridAdapter;
    List<String> article_pt_one;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_articlepartone,container,false);

        gv_article_pt_one=(GridView) v.findViewById(R.id.gv_article_pt_one);
        article_pt_one=new ArrayList<>(Arrays.asList(getActivity().getResources().getStringArray(R.array.arr_article_title)));
        mArticleGridAdapter=new ArticleGridAdapter(getActivity(),article_pt_one.subList(0, 15));
        gv_article_pt_one.setAdapter(mArticleGridAdapter);

        gv_article_pt_one.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(getActivity(),DefinitionActivity.class);
                intent.putExtra(GLOBAL_STRING.ARRAY_INDEX,position);
                intent.putExtra(GLOBAL_STRING.ARTICLE_PART,"1");
                startActivity(intent);
            }
        });


        return v;
    }


}
