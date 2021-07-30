package com.snippy.todolist;

import android.content.Context;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class helper {
    public static final  String filename="list_Information.dat";

    public static void writeData(ArrayList<String> item, Context ctx){
        try {
            FileOutputStream fos = ctx.openFileOutput(filename, ctx.MODE_PRIVATE);
            ObjectOutputStream os=new ObjectOutputStream(fos);

            os.writeObject(item);
            os.close();
        }
        catch(Exception e){
        e.printStackTrace();
        }
    }
}
