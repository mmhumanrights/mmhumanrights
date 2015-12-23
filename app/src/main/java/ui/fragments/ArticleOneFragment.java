package ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.myanmarhumanrights.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import config.GLOBAL_STRING;
import models.Article;
import ui.Adapters.ArticleListAdapter;
import ui.activities.DefinitionActivity;

/**
 * Created by winhtaikaung on 11/4/15.
 */
public class ArticleOneFragment extends Fragment {

    RecyclerView gv_article_pt_one;
    ArticleListAdapter mArticleListAdapter;
    List<String> article_pt_one;
    List<String> article_definition_pt_one;
    LinearLayoutManager layoutManager;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View  view=inflater.inflate(R.layout.fragment_articlepartone,container,false);

        gv_article_pt_one=(RecyclerView) view.findViewById(R.id.gv_article_pt_one);
        article_pt_one=new ArrayList<>(Arrays.asList(getActivity().getResources().getStringArray(R.array.arr_article_title)));
        article_definition_pt_one=new ArrayList<>(Arrays.asList(getActivity().getResources().getStringArray(R.array.arr_article_def)));
        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        gv_article_pt_one.setLayoutManager(layoutManager);

        int arrsize=article_definition_pt_one.subList(0, 15).size();
        Article[] articles=new Article[arrsize];

            for(int i=0;i<article_definition_pt_one.subList(0, 15).size();i++){
                Article a=new Article();
                a.setArticledefinition(article_definition_pt_one.subList(0, 15).get(i));
                a.setArticletitle(article_pt_one.subList(0, 15).get(i));
                articles[i]=a;

            }
        mArticleListAdapter=new ArticleListAdapter(getActivity(), articles, new ArticleListAdapter.ArticleItemclickHandler() {
            @Override
            public void onItemClickListener(int position, Article selectedArticle, ArticleListAdapter.ArticleViewHolder vh) {
                Intent intent=new Intent(getActivity(),DefinitionActivity.class);
                intent.putExtra(GLOBAL_STRING.ARRAY_INDEX,position);
                intent.putExtra(GLOBAL_STRING.ARTICLE_PART,"1");
                startActivity(intent);
            }
        });
        gv_article_pt_one.setAdapter(mArticleListAdapter);

       /* gv_article_pt_one.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(getActivity(),DefinitionActivity.class);
                intent.putExtra(GLOBAL_STRING.ARRAY_INDEX,position);
                intent.putExtra(GLOBAL_STRING.ARTICLE_PART,"1");
                startActivity(intent);
            }
        });*/


        return view;
    }


}
