package ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.myanmarhumanrights.R;

import base.BaseFragment;
import comm.Com_Utils;

/**
 * Created by winhtaikaung on 12/28/15.
 */
public class AboutFragment extends BaseFragment {
    TextView tv_version_name;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_about,container,false);
        tv_version_name=(TextView) v.findViewById(R.id.tv_version_name);
        tv_version_name.setText("Version "+Com_Utils.getAppVersion(getActivity()));
        return v;
    }
}
