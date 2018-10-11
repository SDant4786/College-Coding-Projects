package com.example.sdant.dailyplanner;

import android.location.Address;
import io.objectbox.BoxStore;
import io.objectbox.Box;
import io.objectbox.BoxStoreBuilder;
public class DataObject {

    public long id;
    private String title;
    private String startDate;
    private String startTime;
    private String address;
public DataObject(String title,String startTime,String startDate,
                   String address){
    this.title = title;
    this.startTime = startTime;
    this.startDate = startDate;
    this.address = address;
    }
    public void setTitle(String s){title = s;}
    public void setStartDate(String s){startDate = s;}
    public void setStartTime (String s){startDate =s;}
    public void setAddress(String s){address=s;}
    public String getTitle(){
        return title;
    }
    public String getStartDate(){
        return startDate;
    }
    public String getStartTime(){
        return startTime;
    }
    public String getAddress(){
        return address;
    }
}
