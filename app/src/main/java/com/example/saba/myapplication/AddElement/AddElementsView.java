package com.example.saba.myapplication.AddElement;

import java.util.List;

public interface AddElementsView {
    void setListEmptyError();

    void goToNext();

    void setInputError();

    void setInputOk();

    void renderThings(List<String> things);
}
