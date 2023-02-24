package ru.synergy.myprogram;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class DatePicker extends DialogFragment
        implements DatePickerDialog.OnDateSetListener{

    @Override
    public Dialog onCreateDialog (Bundle savedInstanceState) {

        // Определяем текущую дату
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Создаём DatePickerDialog и возвращаем его
        Dialog picker = new DatePickerDialog(getActivity(),this, year, month, day);
        picker.setTitle(getResources().getString(R.string.choose_data));
        return picker;
    }
    @Override
    public void onStart(){
        super.onStart();
        // Добавляем  пользовательский текст для кнопки
        Button nButton = ((AlertDialog) getDialog()).getButton(DialogInterface.BUTTON_POSITIVE);
        nButton.setText(getResources().getString(R.string.ready));

    }
    @Override
    public void onDateSet (android.widget.DatePicker datePicker, int year, int month, int day) {

        TextView tv = (TextView) getActivity().findViewById(R.id.tv);
        tv.setText(day + "-" + month + "-" + year);
    }
}
