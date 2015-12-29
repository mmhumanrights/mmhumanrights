package ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myanmarhumanrights.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import base.BaseFragment;
import config.GLOBAL_STRING;
import models.Article;
import ui.Adapters.DefinitionPagerAdapter;

/**
 * Created by winhtaikaung on 12/29/15.
 */
public class DefinitionPagerFragment extends BaseFragment {

    ViewPager mViewPager;
    DefinitionPagerAdapter mPagerAdapter;
    List<String> article_pt_one;
    List<String> article_definition_pt_one;
    private int ARR_INDEX=0;
    private String ARTICLE_PART="1";




    public static DefinitionPagerFragment newInstance(int array_index,String article_part){
        DefinitionPagerFragment fragment=new DefinitionPagerFragment();
        Bundle args = new Bundle();
        args.putInt(GLOBAL_STRING.ARRAY_INDEX, array_index);
        args.putString(GLOBAL_STRING.ARTICLE_PART, article_part);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARR_INDEX = getArguments().getInt(GLOBAL_STRING.ARRAY_INDEX);

        ARTICLE_PART = getArguments().getString(GLOBAL_STRING.ARTICLE_PART);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_definitionpager,container,false);
        mViewPager=(ViewPager)v.findViewById(R.id.pager);
        article_pt_one=new ArrayList<>(Arrays.asList(getActivity().getResources().getStringArray(R.array.arr_article_title)));
        article_definition_pt_one=new ArrayList<>(Arrays.asList(getActivity().getResources().getStringArray(R.array.arr_article_def)));
        int arrsize=article_definition_pt_one.size();
        Article[] articles=new Article[arrsize];

        for(int i=0;i<article_definition_pt_one.size();i++){
            Article a=new Article();
            a.setArticledefinition(article_definition_pt_one.get(i));
            a.setArticletitle(article_pt_one.get(i));
            articles[i]=a;

        }
        mPagerAdapter=new DefinitionPagerAdapter(getActivity(),articles,getChildFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);

        if(ARR_INDEX!=-1){
            if(ARTICLE_PART.equals("2")){
                mViewPager.setCurrentItem(15+ARR_INDEX);
            }

            if(ARTICLE_PART.equals("1")){
                mViewPager.setCurrentItem(ARR_INDEX);
            }

        }


        return v;
    }
}
