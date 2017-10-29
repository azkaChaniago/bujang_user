package com.example.azka.practiceapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

/**
 * Created by azka on 25/09/17.
 */

public class FragmentTwo extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View s =  inflater.inflate(R.layout.fragment_two, container, false);

        Spinner spiner = (Spinner) s.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getActivity(), R.array.planets, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiner.setAdapter(adapter);

        return s;
    }

    public void sendMessage(View view) {
        Button btn = (Button) getView().findViewById(R.id.button_send);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });
    }

    public void onCheckboxClicked(View view) {
        boolean check = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.true_check:
                if (check) {

                } else {
                    // Put something here
                }
                break;
            case R.id.false_check:
                if (check) {
                    // Put something here
                } else {
                    // Put something here
                }
                break;
        }
    }

}
