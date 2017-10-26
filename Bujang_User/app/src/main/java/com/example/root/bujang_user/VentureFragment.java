package com.example.root.bujang_user;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by root on 24/10/17.
 */

public class VentureFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_venture, container, false);

        String [] values =
                {"---","Aceh","Sumatra Utara","Sumatra Barat","Riau","Jambi","Bengkulu","Sumatra Utara","Lampung",
                "Jakarta","Jawa Barat","Jawa Tengah","Jawa Timur","Yogyakarta"};

        Spinner spin = (Spinner) rootView.findViewById(R.id.spinner_province);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);

        return rootView;
    }
}
