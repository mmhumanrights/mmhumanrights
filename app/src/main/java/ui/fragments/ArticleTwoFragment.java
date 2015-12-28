package ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import models.Article;
import ui.Adapters.ArticleGridAdapter;
import ui.Adapters.ArticleListAdapter;
import ui.activities.DefinitionActivity;

/**
 * Created by winhtaikaung on 11/4/15.
 */
public class ArticleTwoFragment extends BaseFragment {
    RecyclerView gv_article_pt_two;
    ArticleListAdapter mArticleListAdapter;
    List<String> article_pt_two;
    List<String> article_definition_pt_two;
    LinearLayoutManager layoutManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_articleparttwo,container,false);
        gv_article_pt_two=(RecyclerView) v.findViewById(R.id.gv_article_pt_two);
        article_pt_two=new ArrayList<>(Arrays.asList(getActivity().getResources().getStringArray(R.array.arr_article_title)));
        article_definition_pt_two=new ArrayList<>(Arrays.asList(getActivity().getResources().getStringArray(R.array.arr_article_def)));


        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        gv_article_pt_two.setLayoutManager(layoutManager);

        int arrsize=article_definition_pt_two.subList(15, 30).size();
        Article[] articles=new Article[arrsize];

        for(int i=0;i<article_definition_pt_two.subList(15, 30).size();i++){
            Article a=new Article();
            a.setArticledefinition(article_definition_pt_two.subList(15, 30).get(i));
            a.setArticletitle(article_pt_two.subList(15, 30).get(i));
            articles[i]=a;

        }

        mArticleListAdapter=new ArticleListAdapter(getActivity(), articles, new ArticleListAdapter.ArticleItemclickHandler() {
            @Override
            public void onItemClickListener(int position, Article selectedArticle, ArticleListAdapter.ArticleViewHolder vh) {
                Intent intent=new Intent(getActivity(),DefinitionActivity.class);
                intent.putExtra(GLOBAL_STRING.ARRAY_INDEX,position);
                intent.putExtra(GLOBAL_STRING.ARTICLE_PART,"2");
                startActivity(intent);
            }
        });
        gv_article_pt_two.setAdapter(mArticleListAdapter);

        /*gv_article_pt_two.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("GRID_POSITION", String.valueOf(view.getTag()));
                Intent intent = new Intent(getActivity(),DefinitionActivity.class);
                intent.putExtra(GLOBAL_STRING.ARRAY_INDEX, position);
                intent.putExtra(GLOBAL_STRING.ARTICLE_PART,"2");
                startActivity(intent);
            }
        });*/
        return v;
    }
}
