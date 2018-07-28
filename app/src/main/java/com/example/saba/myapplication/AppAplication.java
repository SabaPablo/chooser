package com.example.saba.myapplication;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class AppAplication  extends Application{

    private static AppAplication instance;

    List things = null;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        things = new ArrayList<>();
    }



    public static AppAplication getInstance() {
        return instance ;
    }


    public void addElement(String s) {
        things.add(s);
    }
    public List<String> getList(){
        return this.things;
    }

    public void setList(ArrayList<String> strings) {
        this.things = strings;
    }
}
