package ui.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

import com.myanmarhumanrights.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class SubmissionActivity extends AppCompatActivity {

    WebView wv_formviewer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Padauk.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
        setContentView(R.layout.activity_submission);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.black));

        wv_formviewer  = (WebView) findViewById(R.id.submission_formloader);
        wv_formviewer.getSettings().setJavaScriptEnabled(true);
        wv_formviewer.loadUrl("https://docs.google.com/forms/d/1R_YaDOa9goBpfn6lpvx9HezOCK9kNXo_gLyprT_GVlE/viewform?usp=send_form");

        setSupportActionBar(toolbar);



                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}
