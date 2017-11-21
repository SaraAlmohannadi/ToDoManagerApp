package m.todomanager;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ToDoInfo extends AppCompatActivity {
    Button chooseDate,chooseTime,submit;
    TextView textvdate,textvtime;
    EditText texttitle;
RadioGroup sgroup,pgroup;
    Calendar myCalendar = Calendar.getInstance();
    Task task;


    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabelDate();
        }

    };



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_info);

        chooseDate= (Button) findViewById(R.id.choseDate);
        chooseTime=(Button) findViewById(R.id.chooseTime);
        submit= (Button) findViewById(R.id.Submit);

        textvdate= (TextView) findViewById(R.id.date);
        textvtime=(TextView) findViewById(R.id.time);
        texttitle=(EditText) findViewById(R.id.title);
       sgroup = (RadioGroup) findViewById(R.id.StatusGroup);
        pgroup = (RadioGroup) findViewById(R.id.priorityGroup);


        sgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.Done: {
                        task.setStatus("Done");
                        break;

                    }
                    case R.id.NotDone: {
                        task.setStatus("NotDone");
                        break;
                    }

                }}
            });

                pgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
                public void onCheckedChanged(RadioGroup group, int checkedId){

                    switch (checkedId) {
                        case R.id.low: {
                            task.setPriority("Low");
                            break;

                        }
                        case R.id.medium: {
                            task.setPriority("Medium");
                            break;
                        }
                        case R.id.high: {
                            task.setPriority("High");
                            break;
                        }
                    }


                }
                });


        chooseTime.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);

                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(ToDoInfo.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        textvtime.setText( selectedHour + ":" + selectedMinute);}
                }, hour, minute, true);
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });


        chooseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(ToDoInfo.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();


            }
        });

             submit.setOnClickListener(new View.OnClickListener() {
              @Override
               public void onClick(View view) {
                  task.setTitle(String.valueOf(texttitle.getText()));
                  task.setTheDate(String.valueOf(textvdate.getText()));
                  task.setTheTime(String.valueOf(textvtime.getText()));

                  Intent i = new Intent();

                  i.putExtra("Title",task.getTitle());
                  i.putExtra("Date",task.getTheDate());
                  i.putExtra("Time",task.getTheTime());
                  i.putExtra("Status",task.getStatus());
                  i.putExtra("Priority",task.getPriority());
                  setResult(Activity.RESULT_OK,i);
                  finish();
              }
            });



}


public void updateLabelDate(){
    String myFormat = "dd:MM:yyyy";
    SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

    textvdate.setText(sdf.format(myCalendar.getTime()));


}



}
