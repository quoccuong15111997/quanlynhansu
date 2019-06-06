package com.nqc.sharepreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.CheckBox;
import android.widget.EditText;

import static com.nqc.constan.Const.PASS;
import static com.nqc.constan.Const.REMEMBER;
import static com.nqc.constan.Const.USERNAME;

public class ManagerSharePreference {
    private static SharedPreferences sPreferences;
    public ManagerSharePreference() {

    }
    public static void init(Context context) {
        if (sPreferences == null) {
            sPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        }
    }

    public static void clearData() {
        SharedPreferences.Editor editor = sPreferences.edit();
        editor.clear();
        editor.commit();
    }

    public static void saveData(String username, String Pass, CheckBox checkBox) {
        SharedPreferences.Editor editor = sPreferences.edit();
        editor.putString(USERNAME, username);
        editor.putString(PASS, Pass);
        editor.putBoolean(REMEMBER,checkBox.isChecked());
        editor.commit();
    }
    public static void loadData(EditText edtUserName, EditText edtPassword, CheckBox checkBox) {
        if(sPreferences.getBoolean(REMEMBER,false)) {
            edtUserName.setText(sPreferences.getString(USERNAME, ""));
            edtPassword.setText(sPreferences.getString(PASS, ""));
            checkBox.setChecked(true);
        }
        else
            checkBox.setChecked(false);

    }
}
