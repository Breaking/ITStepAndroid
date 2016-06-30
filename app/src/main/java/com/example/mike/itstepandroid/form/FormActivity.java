package com.example.mike.itstepandroid.form;

import android.graphics.Color;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.codetroopers.betterpickers.numberpicker.NumberPickerBuilder;
import com.codetroopers.betterpickers.numberpicker.NumberPickerDialogFragment;
import com.example.mike.itstepandroid.R;
import com.example.mike.itstepandroid.form.fragment.DatePickerFragment;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;

public class FormActivity extends AppCompatActivity implements NumberPickerDialogFragment.NumberPickerDialogHandlerV2 {

    private TextView tvNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar != null){
            toolbar.setTitle("FormAcitivity");
            toolbar.setTitleTextColor(Color.WHITE);
        }

        tvNumber = (TextView) findViewById(R.id.tvNumber);
        Button btnDaysNumber = (Button) findViewById(R.id.btnDaysNumber);
        final TextInputLayout firstNameWrapper = (TextInputLayout) findViewById(R.id.firstNameWrapper);
        final TextInputLayout lastNameWrapper = (TextInputLayout) findViewById(R.id.lastNameWrapper);
        final TextInputLayout dateWrapper = (TextInputLayout) findViewById(R.id.dateWrapper);
        final EditText etDate = dateWrapper.getEditText();
        final TextInputLayout timeWrapper = (TextInputLayout) findViewById(R.id.timeWrapper);
        final EditText etTime = timeWrapper.getEditText();

        final Calendar calendar = Calendar.getInstance();


        firstNameWrapper.setHint("First Name");
        lastNameWrapper.setHint("Last Name");
        dateWrapper.setHint("Date");
        timeWrapper.setHint("Time");

        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePickerFragment = new DatePickerFragment(){
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, monthOfYear);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        etDate.setText(Utils.getDate(calendar.getTimeInMillis()));

                    }
                };

                datePickerFragment.show(getSupportFragmentManager(), "DatePickerFragment" );
            }
        });



        btnDaysNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumberPickerBuilder npb = new NumberPickerBuilder().
                        setFragmentManager(getSupportFragmentManager()).
                        setStyleResId(R.style.BetterPickersDialogFragment_Light);


                npb.show();
            }
        });

    }

    @Override
    public void onDialogNumberSet(int reference, BigInteger number, double decimal, boolean isNegative, BigDecimal fullNumber) {
        tvNumber.setText(number.toString());
    }

}
