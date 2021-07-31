package com.snippy.todolist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s=item.getText().toString();
                arli.add(s);
                item.setText("");
                helper.writeData(arli,getApplicationContext());
                adarr.notifyDataSetChanged();
            }
        });


        liview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                AlertDialog.Builder alrtmsg=new AlertDialog.Builder(MainActivity.this);

                alrtmsg.setTitle("Delete Task");
                alrtmsg.setMessage("Do you want to delete this task from the list");
                alrtmsg.setCancelable(false);

                alrtmsg.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                alrtmsg.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        arli.remove(position);

                        adarr.notifyDataSetChanged();

                        helper.writeData(arli,getApplicationContext());
                    }
                });

                AlertDialog aldi=alrtmsg.create();
                aldi.show();
            }
        });
    }
}