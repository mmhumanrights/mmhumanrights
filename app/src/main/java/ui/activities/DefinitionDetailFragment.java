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

import com.bumptech.glide.Glide;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.github.ksoichiro.android.observablescrollview.ScrollUtils;
import com.myanmarhumanrights.R;
import com.nineoldandroids.view.ViewHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import comm.Com_Utils;
import config.GLOBAL_STRING;

/**
 * A placeholder fragment containing a simple view.
 */
public class DefinitionDetailFragment extends Fragment implements ObservableScrollViewCallbacks {
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private Toolbar mToolbar;
    private int ARR_INDEX=0;
    private String ARTICLE_PART="1";
    private ObservableScrollView parallex_scrollview;
    private ImageView headerimage_view;
    FloatingActionButton share_fab;

    private int mParallaxImageHeight;
    String[] mArr_title,mArr_definition;
    int[] arr_img;

    TextView tv_def_content,tv_def_article;

    public DefinitionDetailFragment() {
    }

    public static DefinitionDetailFragment newInstance(int array_index, String article_part){
        DefinitionDetailFragment fragment=new DefinitionDetailFragment();
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
        tv_def_article=(TextView)v.findViewById(R.id.tv_def_article);
        tv_def_content=(TextView)v.findViewById(R.id.tv_def_content);
        arr_img=new int[]{R.drawable.bg_hands,R.drawable.bg_header,R.drawable.bg_keizer};



        mParallaxImageHeight = getResources().getDimensionPixelSize(R.dimen.detail_header_image_Height);

        headerimage_view=(ImageView) v.findViewById(R.id.header_imageView);

        if(savedInstanceState==null) {
            Glide.with(getActivity()).load(arr_img[Com_Utils.getRandomnum(arr_img.length, 0)]).centerCrop().into(headerimage_view);
        }

        if (mToolbar != null) {
            ((AppCompatActivity)getActivity()).setSupportActionBar(mToolbar);
            ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }
        List<String> title_list = new ArrayList(Arrays.asList(getActivity().getResources().getStringArray(R.array.arr_article_title)));
        List<String> content_list = new ArrayList(Arrays.asList(getActivity().getResources().getStringArray(R.array.arr_article_def)));
        Log.i("ARTICLE_PART", String.valueOf(ARTICLE_PART));


        if(ARTICLE_PART.equals("")){
            tv_def_article.setText(title_list.get(ARR_INDEX));
            tv_def_content.setText(content_list.get(ARR_INDEX));
        }

       //mCollapsingToolbarLayout.setTitle("Yangon");
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("");
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
