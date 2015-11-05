package ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.myanmarhumanrights.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import base.BaseFragment;
import ui.Adapters.ArticleGridAdapter;

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
        return v;
    }
}
