package com.example.saba.myapplication.selectElement;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.saba.myapplication.AddElement.AddElementsActivity;
import com.example.saba.myapplication.AddElement.AddElementsPresenter;
import com.example.saba.myapplication.R;

public class SelectActivity extends AppCompatActivity implements SelectElementView{

    SelectElementPresenter presenter;

    TextView visor;
    Button searchBtn;
    Button returnBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);


        presenter = new SelectElementPresenter(this);

        visor = findViewById(R.id.inputTx);
        searchBtn = findViewById(R.id.selectBtn);
        returnBtn = findViewById(R.id.returnBtn);


        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.getSometime();
            }
        });
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectActivity.this, AddElementsActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public void renderThing(String some) {
        visor.setText(some);
    }
}
