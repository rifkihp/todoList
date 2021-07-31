package com.snippy.todolist;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static ArrayList<String> readData(Context ctx) {
        ArrayList<String> itli = null;
        try {
            FileInputStream fis = ctx.openFileInput(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);

            itli = (ArrayList<String>) ois.readObject();

        }
        catch(FileNotFoundException e){
             itli=new ArrayList<>();
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return itli;
    }
}
