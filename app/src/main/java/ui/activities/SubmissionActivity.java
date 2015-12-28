package ui.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.myanmarhumanrights.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class SubmissionActivity extends AppCompatActivity {

    WebView wv_formviewer;
    AlertDialog dialog_fontchooser;
    AppCompatRadioButton rdo_unicode,rdo_zawgyi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Padauk.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );*/
        setContentView(R.layout.activity_submission);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.black));

       dialog_fontchooser = new AlertDialog.Builder(this)
        .setTitle("FontChooser").
        setView(R.layout.dialog_font_chooser).
        setPositiveButton("OK", null).
        setNegativeButton("Cancel", null).create();


        dialog_fontchooser.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                rdo_unicode=(AppCompatRadioButton)  dialog_fontchooser.findViewById(R.id.rdo_unicode);
                rdo_zawgyi=(AppCompatRadioButton)   dialog_fontchooser.findViewById(R.id.rdo_zawgyi);

                rdo_unicode.setChecked(true);


                rdo_unicode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(buttonView.getId() == rdo_unicode.getId()){
                            if (rdo_unicode.isChecked()) {
                                rdo_zawgyi.setChecked(false);
                                Shar
                            }else {
                                rdo_zawgyi.setChecked(true);
                            }
                        }

                    }
                });
                rdo_zawgyi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(buttonView.getId() == rdo_zawgyi.getId()){
                            if (rdo_zawgyi.isChecked()) {
                                rdo_unicode.setChecked(false);
                            }else {
                                rdo_unicode.setChecked(true);
                            }
                        }
                    }
                });
            }
        });
        dialog_fontchooser.show();




        wv_formviewer  = (WebView) findViewById(R.id.submission_formloader);
        wv_formviewer.getSettings().setJavaScriptEnabled(true);

        //Unicode Form
        wv_formviewer.loadUrl("https://docs.google.com/forms/d/1R_YaDOa9goBpfn6lpvx9HezOCK9kNXo_gLyprT_GVlE/viewform?usp=send_form");

        //Zaw Gyi Form



        setSupportActionBar(toolbar);



                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        upArrow.setColorFilter(getResources().getColor(android.R.color.black), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
   /* @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }*/

}
