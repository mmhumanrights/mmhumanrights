package ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.myanmarhumanrights.R;

import config.GLOBAL_STRING;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class DefinitionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/Padauk.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build()
        );
        setContentView(R.layout.activity_definition);

        if (savedInstanceState == null) {
            Intent intent = getIntent();
            if (intent.hasExtra(GLOBAL_STRING.ARRAY_INDEX)) {
                int article_no = intent.getIntExtra(GLOBAL_STRING.ARRAY_INDEX, 0);
                String article_part = intent.getStringExtra(GLOBAL_STRING.ARTICLE_PART);

                getSupportFragmentManager().beginTransaction()
                        .add(R.id.definition_container, DefinitionActivityFragment.newInstance(article_no,article_part))
                        .commit();
            }
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}
