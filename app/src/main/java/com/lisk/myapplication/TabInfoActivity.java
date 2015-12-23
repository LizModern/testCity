package com.lisk.myapplication;

import android.app.Activity;
import android.app.TabActivity;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import com.lisk.myapplication.entity.CityData;
import com.lisk.myapplication.ui.CityAdapter;
import com.lisk.myapplication.utils.Constants;
import com.lisk.myapplication.utils.Preferences_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.sharedpreferences.Pref;

/**
 * Created by e.kazimirova on 23.12.2015.
 */
@EActivity(R.layout.activity_tab)
public class TabInfoActivity extends Activity {

    @Pref
    Preferences_ mPrefs;
    @ViewById
    ListView listView;

    @AfterViews
    public void afterViews() {
        TabHost tabs = (TabHost) findViewById(android.R.id.tabhost);

        tabs.setup();

        TabHost.TabSpec spec = tabs.newTabSpec(Constants.TAG1);

        spec.setContent(R.id.tab1);
        spec.setIndicator(getResources().getString(R.string.atrist));
        tabs.addTab(spec);

        spec = tabs.newTabSpec(Constants.TAG2);
        spec.setContent(R.id.tab2);
        spec.setIndicator(getResources().getString(R.string.favourite));
        tabs.addTab(spec);

        spec = tabs.newTabSpec(Constants.TAG3);
        spec.setContent(R.id.tab3);
        spec.setIndicator(getResources().getString(R.string.setting));
        tabs.addTab(spec);

        spec = tabs.newTabSpec(Constants.TAG4);
        spec.setContent(R.id.tab4);
        spec.setIndicator(getResources().getString(R.string.cities));
        tabs.addTab(spec);

        tabs.setCurrentTab(3);

        CityAdapter adapter = new CityAdapter(getApplicationContext(), CityData.loadData(mPrefs).getResult());

        listView.setAdapter(adapter);

        for (int i =0; i<tabs.getTabWidget().getChildCount(); i++) {
            TextView textView  = (TextView) tabs.getTabWidget().getChildAt(i)
                    .findViewById(android.R.id.title);
            textView.setGravity(Gravity.CENTER);
            textView.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
            textView.getLayoutParams().width = ViewGroup.LayoutParams.WRAP_CONTENT;
        }
    }
}