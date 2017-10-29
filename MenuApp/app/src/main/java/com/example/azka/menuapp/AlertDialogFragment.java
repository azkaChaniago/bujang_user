package com.example.azka.menuapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by azka on 01/10/17.
 */

public class AlertDialogFragment extends DialogFragment {

    static AlertDialogFragment newInstance(int num) {
        AlertDialogFragment f = new AlertDialogFragment();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putInt("num", num);
        f.setArguments(args);

        return f;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder build = new AlertDialog.Builder(getActivity());
        build.setIcon(R.drawable.ic_new_game)
                .setTitle("Misile Launcher")
                .setMessage(R.string.dialog_fire)
                .setPositiveButton(R.string.fire, new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {}
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {}
                });

        return build.create();
    }

}
