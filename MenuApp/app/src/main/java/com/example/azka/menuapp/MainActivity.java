package com.example.azka.menuapp;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MainActivity extends Activity {

    private Object v;

    @RequiresApi(api = Build.VERSION_CODES.N_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast));
        TextView txt = (TextView) layout.findViewById(R.id.toast_txt);
        txt.setText("This is Costum Toast");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.game_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.new_game:
                showDialog();
                return true;
            case R.id.help:
                return true;
            case R.id.create_new:
                createNew();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void showDialog() {
        DialogFragment dialog = AlertDialogFragment.newInstance(R.string.dialog_fire);
        dialog.show(getFragmentManager(), "dialog");
    }

    public boolean help(MenuItem item) {
        Intent intent = new Intent(this, SettingActivity.class);
        startActivity(intent);
        return true;
    }

    public void createNew() {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast));
        TextView txt = (TextView) layout.findViewById(R.id.toast_txt);
        txt.setText("Create New Toast");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

    public void createShortcut() {
        ShortcutManager shortcutManager = getSystemService(ShortcutManager.class);

        ShortcutInfo shortcut = new ShortcutInfo.Builder(this, "shortcut")
                .setShortLabel("W3 School")
                .setLongLabel("Open W3 School")
                .setIcon(Icon.createWithResource(this, R.drawable.ic_new_game))
                .setIntent(new Intent(Intent.ACTION_VIEW, Uri.parse("https://w3schools.com/")))
                .build();
        shortcutManager.setDynamicShortcuts(Arrays.asList(shortcut));
    }

}
