package com.qdcatplayer.main.Setting;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceFragment;
import android.util.Log;

import com.qdcatplayer.main.R;

public class SettingTab1 extends PreferenceFragment implements OnSharedPreferenceChangeListener {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Make sure default values are applied.  In a real app, you would
        // want this in a shared function that is used to retrieve the
        // SharedPreferences wherever they are needed.
        //PreferenceManager.setDefaultValues(getActivity(),
        //        R.xml.advanced_preferences, false);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.setting_detail1);
        SharedPreferences pref= getPreferenceManager().getSharedPreferences();
        pref.registerOnSharedPreferenceChangeListener(this);
        pref.edit().putBoolean(FolderChooserPreference.FOLDER_CHANGED_KEY, false).commit();
        ListPreference somePreference = (ListPreference) findPreference("folderList");
        /*
        CheckBoxPreference limit = (CheckBoxPreference)findPreference("checkbox_preference");
        limit.setOnPreferenceChangeListener(new OnPreferenceChangeListener() {
			
			@Override
			public boolean onPreferenceChange(Preference arg0, Object arg1) {
				Log.w("qd", arg0.getKey());
				return true;//must return true
			}
		});
		*/
    }

	@Override
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
			String key) {
		// TODO Auto-generated method stub
		Log.w("qd", "fragment");
		return;
	}
	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
	}
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
	}
}
