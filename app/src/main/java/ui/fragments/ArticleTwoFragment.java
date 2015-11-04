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
public class ArticleTwoFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_articleparttwo,container,false);
        return v;
    }
}
