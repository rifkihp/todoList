package com.snippy.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText item;
    Button add;
    ListView liview;

    ArrayList<String> arli=new ArrayList<>();
    ArrayAdapter<String> adarr;   //to connect array list and list 


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        item=findViewById(R.id.edtext);
        add=findViewById(R.id.btn);
        liview=findViewById(R.id.list);

        arli=helper.readData(this);

        adarr=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,android.R.id.text2,arli);

        liview.setAdapter(adarr);

        
    }
}