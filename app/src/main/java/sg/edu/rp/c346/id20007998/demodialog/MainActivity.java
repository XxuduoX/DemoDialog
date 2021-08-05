package sg.edu.rp.c346.id20007998.demodialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.time.Year;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btnDemo1;
    Button btnDemo2;
    Button btnDemo3;
    Button btnEx3;
    Button btnDemo4;
    Button btnDemo5;
    TextView tvDemo2;
    TextView tvDemo3;
    TextView tvSum;
    TextView tvDemo4;
    TextView tvDemo5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDemo1=findViewById(R.id.buttonDemo1);
        btnDemo2=findViewById(R.id.buttonDemo2);
        tvDemo2=findViewById(R.id.tvDemo2);
        btnDemo3=findViewById(R.id.buttonDemo3);
        tvDemo3=findViewById(R.id.tvDemo3);
        btnEx3=findViewById(R.id.buttonEX3);
        tvSum=findViewById(R.id.tvEX3);
        btnDemo4=findViewById(R.id.buttonDemo4);
        tvDemo4=findViewById(R.id.tvDemo4);
        btnDemo5=findViewById(R.id.buttonDemo5);
        tvDemo5=findViewById(R.id.tvDemo5);


        btnDemo1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                // Create the Dialog builder
                AlertDialog.Builder myBuilder=new AlertDialog.Builder(MainActivity.this);

                //Set the dialog details
                /*
                myBuilder.setTitle("Demo 1-Simple Dialog");
                myBuilder.setMessage("I can develop Andriod App.");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Close",null);
                */
                myBuilder.setTitle("Congratulations");
                myBuilder.setMessage("You have completed a simple Dialog Box.");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("DISMISS",null);


                AlertDialog myDialog=myBuilder.create();
                myDialog.show();

            }
        });

        btnDemo2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                // Create the Dialog builder
                AlertDialog.Builder myBuilder=new AlertDialog.Builder(MainActivity.this);

                //Set the dialog details
                myBuilder.setTitle("Demo 2 Buttons Dialog");
                myBuilder.setMessage("Select one of the Buttons below");
                myBuilder.setCancelable(false);

                //Configure the positive buttons

                myBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have selected Positive.");
                    }
                });

                //Configure the negative buttons

                myBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have selected Negative.");
                    }
                });

                //Configure the 'neutral' buttons

                myBuilder.setNeutralButton("Cancel",null);

                AlertDialog myDialog=myBuilder.create();
                myDialog.show();

            }
        });

        btnDemo3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //Inflate the input.xml layout file
                LayoutInflater inflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog= inflater.inflate(R.layout.input,null);

                //Obtain the UI component in the input.xml layout
                //It needs to be defined as "Final", si that it can be used in the onCLick() method later

                final EditText edInput=viewDialog.findViewById(R.id.edTextInput);

                // Create the Dialog builder
                AlertDialog.Builder myBuilder=new AlertDialog.Builder(MainActivity.this);

                //Set the dialog details
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Demo 3 Text input Dialog");
                //Configure the positive buttons

                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Extract the text entered by the user
                        String message = edInput.getText().toString();
                        //Set the text to the TextView
                        tvDemo3.setText(message);
                    }
                });

                //Configure the 'neutral' buttons

                myBuilder.setNeutralButton("CANCEL",null);

                AlertDialog myDialog=myBuilder.create();
                myDialog.show();

            }
        });

        btnEx3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //Inflate the input.xml layout file
                LayoutInflater inflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog= inflater.inflate(R.layout.input_ex3,null);

                //Obtain the UI component in the input.xml layout
                //It needs to be defined as "Final", so that it can be used in the onCLick() method later

                final EditText edNumInput1=viewDialog.findViewById(R.id.edNumInput1),edNumInput2=viewDialog.findViewById(R.id.edNumInput2);

                // Create the Dialog builder
                AlertDialog.Builder myBuilder=new AlertDialog.Builder(MainActivity.this);

                //Set the dialog details
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Exercise 3");
                //Configure the positive buttons

                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Extract the text entered by the user
                        Integer input1=Integer.parseInt(edNumInput1.getText().toString());
                        Integer input2=Integer.parseInt(edNumInput2.getText().toString());

                        Integer sum=input1+input2;
                        //Set the text to the TextView
                        tvSum.setText("The sum is "+sum);
                    }
                });

                //Configure the 'neutral' buttons

                myBuilder.setNegativeButton("CANCEL",null);

                AlertDialog myDialog=myBuilder.create();
                myDialog.show();

            }
        });
        btnDemo4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                DatePickerDialog.OnDateSetListener myDateListener=new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tvDemo4.setText("Date: "+dayOfMonth+"/"+(month+1)+"/"+year);
                    }
                };

                //Create the Date Picker Dialog
                Calendar now=Calendar.getInstance();
                int year=now.get(Calendar.YEAR);
                int month=now.get(Calendar.MONTH);
                int day=now.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog myDateDialog =new DatePickerDialog(MainActivity.this,myDateListener, year,month,day);
                myDateDialog.show();

            }
        });

        btnDemo5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                // Create the Listener to set the time
                TimePickerDialog.OnTimeSetListener myTimeListener=new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tvDemo5.setText("Time: "+hourOfDay+":"+minute);
                    }
                };
                Calendar now = Calendar.getInstance();
                int hourOfDay = now.get(Calendar.HOUR_OF_DAY);  // Current Hour
                int minute = now.get(Calendar.MINUTE);  // Current Minute


                //Create the Date Picker Dialog
                TimePickerDialog myTimeDialog =new TimePickerDialog(MainActivity.this,myTimeListener, hourOfDay,minute,true);
                myTimeDialog.show();

            }
        });
    }
}