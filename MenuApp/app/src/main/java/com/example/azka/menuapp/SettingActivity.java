package com.example.azka.menuapp;

import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Context context = getApplicationContext();
        CharSequence txt = "Setting";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, txt, duration);
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

}
