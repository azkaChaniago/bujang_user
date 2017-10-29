package com.example.root.fullinterfaceapp;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by root on 15/10/17.
 */

public class HelpActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference_help);
    }

}
