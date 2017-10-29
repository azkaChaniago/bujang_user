package com.example.azka.menuapp;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by azka on 01/10/17.
 */

public class SettingFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.app_preference);
    }

}
