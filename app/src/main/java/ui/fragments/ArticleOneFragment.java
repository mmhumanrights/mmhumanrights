package ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myanmarhumanrights.R;

import base.BaseFragment;

/**
 * Created by winhtaikaung on 11/4/15.
 */
public class ArticleOneFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_articlepartone,container,false);
        return v;
    }
}
