package com.example.saba.myapplication.AddElement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.saba.myapplication.R;
import com.example.saba.myapplication.selectElement.SelectActivity;

import java.util.List;

public class AddElementsActivity extends AppCompatActivity implements AddElementsView {


    EditText input = null;
    Button addElement = null;
    Button cont = null;
    Button clearBtn = null;
    ListView addedElement = null;

    List<String> things = null;

    AddElementsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new AddElementsPresenter(this);


        input = findViewById(R.id.inputETx);
        addElement = findViewById(R.id.addBtn);
        cont = findViewById(R.id.continueBtn);
        addedElement = findViewById(R.id.addedElementsLst);
        clearBtn = findViewById(R.id.clearBtn);

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.clearAll();
            }
        });

        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.goToNext();
            }
        });

        addElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.addElement(input.getText().toString());
            }
        });

        presenter.renderList();


    }

    @Override
    public void setListEmptyError() {
        Toast.makeText(getApplicationContext(),"Agrega algo",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void goToNext() {
        Intent intent = new Intent(AddElementsActivity.this, SelectActivity.class);
        startActivity(intent);
    }

    @Override
    public void setInputError() {
        input.setError("Debe escribir algo al agregar");
    }

    @Override
    public void setInputOk() {
        input.setText("");
        Toast.makeText(getApplicationContext(),"Carga Ok",Toast.LENGTH_SHORT).show();
        presenter.renderList();

    }

    @Override
    public void renderThings(List<String> things) {
        CharSequence[] cs = things.toArray(new CharSequence[things.size()]);
        ListAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, cs);
        addedElement.setAdapter(adapter);
    }
}
