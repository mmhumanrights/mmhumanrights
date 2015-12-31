package ui.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.myanmarhumanrights.R;

import base.BaseFragment;
import comm.Com_Utils;

/**
 * Created by winhtaikaung on 12/28/15.
 */
public class AboutFragment extends BaseFragment {
    TextView tv_version_name,tv_licenses,tv_iconcredits;
    AlertDialog mLibraryLicense,mIconLicense,mAboutDialog;
    ImageView app_icon;
    WebView wv_license;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_about,container,false);
        tv_version_name=(TextView) v.findViewById(R.id.tv_version_name);
        tv_iconcredits=(TextView) v.findViewById(R.id.tv_iconcredits);
        app_icon=(ImageView) v.findViewById(R.id.app_icon);
        tv_licenses=(TextView) v.findViewById(R.id.tv_licenses);

        tv_version_name.setText("Version "+Com_Utils.getAppVersion(getActivity()));

        mLibraryLicense =new AlertDialog.Builder(getActivity()).
                setTitle("OpenSource Licenses")

                .setView(R.layout.license_layout)
                .setPositiveButton("OK",null)
                .create();
        mIconLicense =new AlertDialog.Builder(getActivity()).
                setTitle("Icon Credits")

                .setView(R.layout.license_layout)
                .setPositiveButton("OK",null)
                .create();

        mAboutDialog =new AlertDialog.Builder(getActivity()).
                setTitle("About")

                .setMessage("Myanmar Human Rights\n" +
                        "Version "+Com_Utils.getAppVersion(getActivity())+"\n" +
                        "Developer "+"Win Htike Aung\n")
                .setPositiveButton("OK",null)
                .create();
        mLibraryLicense.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                wv_license=(WebView) mLibraryLicense.findViewById(R.id.wv_license);
                String license_url="file:///android_asset/html/license.html";
                wv_license.loadUrl(license_url);
            }
        });

        mIconLicense.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                wv_license=(WebView) mIconLicense.findViewById(R.id.wv_license);
                String license_url="file:///android_asset/html/icon_license.html";
                wv_license.loadUrl(license_url);
            }
        });





        tv_licenses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLibraryLicense.show();
            }
        });
        tv_iconcredits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIconLicense.show();
            }
        });
        app_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAboutDialog.show();
            }
        });






        return v;


    }
}
