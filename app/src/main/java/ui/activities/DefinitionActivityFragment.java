package ui.activities;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.github.ksoichiro.android.observablescrollview.ScrollUtils;
import com.myanmarhumanrights.R;
import com.nineoldandroids.view.ViewHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import config.GLOBAL_STRING;

/**
 * A placeholder fragment containing a simple view.
 */
public class DefinitionActivityFragment extends Fragment implements ObservableScrollViewCallbacks {
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private Toolbar mToolbar;
    private int ARR_INDEX=0;
    private String ARTICLE_PART="1";
    private ObservableScrollView parallex_scrollview;
    private ImageView headerimage_view;
    FloatingActionButton share_fab;

    private int mParallaxImageHeight;
    String[] mArr_title,mArr_definition;

    TextView tv_def_content,tv_def_article;

    public DefinitionActivityFragment() {
    }

    public static DefinitionActivityFragment newInstance(int array_index,String article_part){
        DefinitionActivityFragment fragment=new DefinitionActivityFragment();
        Bundle args = new Bundle();
        args.putInt(GLOBAL_STRING.ARRAY_INDEX, array_index);
        args.putString(GLOBAL_STRING.ARTICLE_PART, article_part);
        fragment.setArguments(args);


        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARR_INDEX = getArguments().getInt(GLOBAL_STRING.ARRAY_INDEX);

        ARTICLE_PART = getArguments().getString(GLOBAL_STRING.ARTICLE_PART);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_definition, container, false);
        mToolbar = (Toolbar) v.findViewById(R.id.toolbar);
        mToolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        mToolbar.setBackgroundColor(ScrollUtils.getColorWithAlpha(1, getResources().getColor(R.color.colorPrimary)));
        parallex_scrollview=(ObservableScrollView) v.findViewById(R.id.parallex_scrollview);
        share_fab =(FloatingActionButton) v.findViewById(R.id.share_fab);

        mParallaxImageHeight = getResources().getDimensionPixelSize(R.dimen.detail_header_image_Height);

        headerimage_view=(ImageView) v.findViewById(R.id.header_imageView);
        tv_def_article=(TextView)v.findViewById(R.id.tv_def_article);
        tv_def_content=(TextView)v.findViewById(R.id.tv_def_content);
        if (mToolbar != null) {
            ((AppCompatActivity)getActivity()).setSupportActionBar(mToolbar);
            ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }
        List<String> title_list = new ArrayList(Arrays.asList(getActivity().getResources().getStringArray(R.array.arr_article_title)));
        List<String> content_list = new ArrayList(Arrays.asList(getActivity().getResources().getStringArray(R.array.arr_article_def)));
        Log.i("ARTICLE_PART", String.valueOf(ARTICLE_PART));
        if(ARTICLE_PART.equals("1")) {


            Log.i("ARTICLE_PART", title_list.subList(0, 15).get(ARR_INDEX));
            tv_def_article.setText(getResources().getString(R.string.definition_mm));
            ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(title_list.subList(0, 15).get(ARR_INDEX));
            tv_def_content.setText(content_list.subList(0, 15).get(ARR_INDEX));
        }

        if(ARTICLE_PART.equals("2")){

            Log.i("ARTICLE_PART", title_list.subList(15, 30).get(ARR_INDEX));
            tv_def_article.setText(getResources().getString(R.string.definition_mm));
            ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(title_list.subList(15, 30).get(ARR_INDEX));
            tv_def_content.setText(content_list.subList(15, 30).get(ARR_INDEX));
        }

       //mCollapsingToolbarLayout.setTitle("Yangon");
        parallex_scrollview.setScrollViewCallbacks(this);
        share_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String quote=getActivity().getResources().getString(R.string.share_template)+"\n"+mToolbar.getTitle()+"\n\n"+tv_def_content.getText();

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,quote);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });
        return v;
    }



    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        onScrollChanged(parallex_scrollview.getCurrentScrollY(), false, false);
    }

    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
        int baseColor = getResources().getColor(R.color.colorPrimary);
        float alpha = Math.min(1, (float) scrollY / mParallaxImageHeight);
        mToolbar.setBackgroundColor(ScrollUtils.getColorWithAlpha(alpha, baseColor));
        ViewHelper.setTranslationY(headerimage_view, scrollY / 2);
    }

    @Override
    public void onDownMotionEvent() {

    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {

    }
}
