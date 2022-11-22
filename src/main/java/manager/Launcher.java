package manager;

import GUI.UserInterfaceClass;
import procedure.*;
import resource.StorageMemory;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class Launcher extends JFrame {
    public static void main(String[] args) throws IOException, InterruptedException {

        //Procedure procedure = new Procedure(new UserChoice(), new ReadWriteInf(), new StorageMemory(),
        //new FixList(), new ListCompare());
        UserInterfaceClass userInterfaceClass = new UserInterfaceClass();
        userInterfaceClass.setVisible(true);
        //procedure.start();
        FileWriter fileWriter = new FileWriter("test.txt");
        fileWriter.write("Hello");

    }
}