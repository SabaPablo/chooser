package com.example.saba.myapplication.AddElement;

import com.example.saba.myapplication.AppAplication;

import java.util.ArrayList;

public class AddElementsPresenter {

    AddElementsView view;

    public AddElementsPresenter(){

    }

    public AddElementsPresenter(AddElementsView view){
        this.view = view;
    }


    public void addElement(String s) {
        if("".equalsIgnoreCase(s)){
            view.setInputError();
            return;
        }
        AppAplication.getInstance().addElement(s);
        view.setInputOk();
    }

    public void renderList() {
        view.renderThings(AppAplication.getInstance().getList());
    }

    public void clearAll() {
        AppAplication.getInstance().setList(new ArrayList<String>());
        renderList();
    }

    public void goToNext() {
        if(AppAplication.getInstance().getList().isEmpty()){
            view.setListEmptyError();
            return;
        }
        view.goToNext();
    }
}
