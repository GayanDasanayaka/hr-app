package controller;


import model.Department;

import javax.swing.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class WriteFile {
    public static boolean writeFile(String filePath, ArrayList<?> objectArrayList) {

        //serialization arraylist and writing it in file
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(filePath);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(objectArrayList);


        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error Writing to file!", "Error", JOptionPane.ERROR_MESSAGE);

            throw new RuntimeException(e);
        } finally {
            if (fileOutputStream != null && objectOutputStream != null) {
                try {
                    fileOutputStream.close();
                    objectOutputStream.close();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }
        return false;
    }
}
