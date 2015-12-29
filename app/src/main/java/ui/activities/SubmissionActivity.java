package ui.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.myanmarhumanrights.R;

import comm.MySharedPreference;
import config.GLOBAL_STRING;

public class SubmissionActivity extends AppCompatActivity {

    WebView wv_formviewer;
    AlertDialog dialog_fontchooser;
    AppCompatRadioButton rdo_unicode, rdo_zawgyi;
    MySharedPreference mSharedPreference;

    String UNICODE_FORM = "https://docs.google.com/forms/d/1R_YaDOa9goBpfn6lpvx9HezOCK9kNXo_gLyprT_GVlE/viewform?usp=send_form";
    String ZAWGYI_FORM = "https://docs.google.com/forms/d/155yJHJcEf-dUymP6v39m5YvPb0PZ--9DBwuIx6N3fW8/viewform?usp=send_form";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_submission);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));

        mSharedPreference = new MySharedPreference(this);

        loadDialogChooser(this);
        if (mSharedPreference.getString(GLOBAL_STRING.FONT_SETTINGS, "").equals("")) {

            dialog_fontchooser.show();
        }
        wv_formviewer = (WebView) findViewById(R.id.submission_formloader);
        wv_formviewer.getSettings().setJavaScriptEnabled(true);


        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.menu_submission);

        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        upArrow.setColorFilter(getResources().getColor(android.R.color.white), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SubmissionActivity.this.finish();
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        loadForm();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_submission, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_settings:
                    loadDialogChooser(this);
                    dialog_fontchooser.show();
                    break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    void loadForm() {
        if (mSharedPreference.getString(GLOBAL_STRING.FONT_SETTINGS, "").equals(GLOBAL_STRING.UNICODE)) {
            wv_formviewer.loadUrl(UNICODE_FORM);
        }

        if (mSharedPreference.getString(GLOBAL_STRING.FONT_SETTINGS, "").equals(GLOBAL_STRING.ZAWGYI)) {
            wv_formviewer.loadUrl(ZAWGYI_FORM);
        }
    }

    void loadDialogChooser(Context c){
        dialog_fontchooser = new AlertDialog.Builder(c)
                .setTitle("FontChooser").
                        setView(R.layout.dialog_font_chooser).
                        setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                loadForm();
                                dialog_fontchooser.dismiss();


                            }
                        }).
                        setNegativeButton("Cancel", null).create();

        dialog_fontchooser.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                rdo_unicode = (AppCompatRadioButton) dialog_fontchooser.findViewById(R.id.rdo_unicode);
                rdo_zawgyi = (AppCompatRadioButton) dialog_fontchooser.findViewById(R.id.rdo_zawgyi);


                if (!mSharedPreference.getString(GLOBAL_STRING.FONT_SETTINGS, "").equals("")) {
                    if(mSharedPreference.getString(GLOBAL_STRING.FONT_SETTINGS, "").equals(GLOBAL_STRING.UNICODE)){
                        rdo_unicode.setChecked(true);
                    }
                    if(mSharedPreference.getString(GLOBAL_STRING.FONT_SETTINGS, "").equals(GLOBAL_STRING.ZAWGYI)){
                        rdo_zawgyi.setChecked(true);
                    }



                }


                rdo_unicode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (buttonView.getId() == rdo_unicode.getId()) {
                            if (rdo_unicode.isChecked()) {
                                rdo_zawgyi.setChecked(false);
                                mSharedPreference.setString(GLOBAL_STRING.FONT_SETTINGS, GLOBAL_STRING.UNICODE);
                            } else {
                                rdo_zawgyi.setChecked(true);
                            }
                        }

                    }
                });
                rdo_zawgyi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (buttonView.getId() == rdo_zawgyi.getId()) {
                            if (rdo_zawgyi.isChecked()) {
                                rdo_unicode.setChecked(false);
                                mSharedPreference.setString(GLOBAL_STRING.FONT_SETTINGS, GLOBAL_STRING.ZAWGYI);
                            } else {
                                rdo_unicode.setChecked(true);
                            }
                        }
                    }
                });
            }
        });
    }

}
