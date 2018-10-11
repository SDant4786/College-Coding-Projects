package com.example.sdant.dailyplanner;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class Display extends AppCompatActivity {
    private ListView lv;
    Button newEvent;
    //default values for inputs
    EditText Title;
    TextView StartTime;
    TextView StartDate;
    EditText Address;
    Button Cancel;
    Button Save;
    //Variables, need to clean up and organize better
    String startTime;
    String startDate;
    String title;
    String address;
    String location;
    ArrayAdapter<String> adapter;
    ArrayList<String> events;
    ArrayList<DataObject> storage;
    int clickCounter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        clickCounter = -1;
        storage = new ArrayList<DataObject>();
        events = new ArrayList<String>();
        lv =(ListView) findViewById(R.id.ListView);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                events);
        lv.setAdapter(adapter);
        newEvent = findViewById(R.id.New);


        newEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(Display.this);
                //View mView = getLayoutInflater().inflate(R.layout.activity_input,null);
                View mView = LayoutInflater.from(Display.this).inflate(R.layout.activity_input, null);
                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.Layout);
                ScrollView scroll = (ScrollView) mView.findViewById(R.id.ScrrolView);
                final EditText Title = (EditText) mView.findViewById(R.id.Title);
                final TextView StartTime = (EditText) mView.findViewById(R.id.StartTime);
                final TextView StartDate = (EditText) mView.findViewById(R.id.StartDate);
                final EditText Address = (EditText) mView.findViewById(R.id.Address);
                final Button Cancel = (Button) mView.findViewById(R.id.Cancel);
                Button Save = (Button) mView.findViewById(R.id.Save);
                mBuilder.setView(mView);
                final AlertDialog alert = mBuilder.create();
                alert.show();
                Button cancel = mView.findViewById(R.id.Cancel);
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alert.cancel();
                    }
                });
                Button save = mView.findViewById(R.id.Save);

                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //takes input and assigns to variables

                        title = Title.getText().toString();
                        startTime = StartTime.getText().toString();
                        startDate = StartDate.getText().toString();
                        address = Address.getText().toString();
                        //creates new object

                        DataObject Event = new DataObject(title, startTime, startDate,  address);
                        clickCounter++;


                        String displayText = Event.getTitle()+" \n " +
                                "Time: " + Event.getStartTime() + "\n" +
                                "Date: " + Event.getStartDate()+ "\n" +
                                "Address: " + Event.getAddress();
                        storage.add(clickCounter,Event);
                        events.add(clickCounter, displayText);
                        adapter.notifyDataSetChanged();
                        alert.cancel();
                    }
                });

            }
        });

    }
    public void addItems(View v){
        clickCounter++;
        adapter.notifyDataSetChanged();
    }
}



