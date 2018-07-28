package com.example.saba.myapplication.selectElement;

import com.example.saba.myapplication.AppAplication;

import java.util.List;

public class SelectElementPresenter {

    SelectElementView view;

    public SelectElementPresenter(){

    }

    public SelectElementPresenter(SelectElementView view){
        this.view = view;
    }

    public void getSometime() {
        List<String> list = AppAplication.getInstance().getList();
        int element = (int) (Math.random() * list.size());
        view.renderThing(list.get(element));
    }
}
