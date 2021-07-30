package com.snippy.todolist;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
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


    public static ArrayList<String> readData(Context ctx) {
        ArrayList<String> itli = null;
        try {
            FileInputStream fis = ctx.openFileInput(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);

            itli = (ArrayList<String>) ois.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return itli;
    }
}
