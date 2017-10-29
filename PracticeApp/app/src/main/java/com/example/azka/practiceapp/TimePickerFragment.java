package com.example.azka.practiceapp;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.TimePicker;

/**
 * Created by azka on 30/09/17.
 */

class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        TimePickerDialog tpd = new TimePickerDialog(getActivity(), R.style.TimePicker, this, hour, minute, DateFormat.is24HourFormat(getActivity()));

        TextView titleTime = new TextView(getActivity());
        titleTime.setText("Time Picker Dialog Title");
        titleTime.setBackgroundColor(Color.parseColor("#eeffcc"));
        titleTime.setPadding(5, 3, 5 ,3);
        titleTime.setGravity(Gravity.CENTER_HORIZONTAL);
        tpd.setCustomTitle(titleTime);

        return tpd;
    }

    @Override
    public void onTimeSet(android.widget.TimePicker timePicker, int hourOfDay, int minute) {
        TextView textTime = (TextView) getActivity().findViewById(R.id.text_time);

        String aMpM = "AM";
        if (hourOfDay > 11) {
            aMpM = "PM";
        }

        int currentHour;
        if (hourOfDay > 11) {
            currentHour = hourOfDay - 12;
        } else {
            currentHour = hourOfDay;
        }

        textTime.setText("Time you choose are..\n\n");
        textTime.setText(textTime.getText() + String.valueOf(currentHour) + " : " + String.valueOf(minute) + " " + aMpM + "\n");
    }

}
