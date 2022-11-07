package manager;

import procedure.*;
import resource.StorageMemory;

import java.io.IOException;

public class Launcher {
    public static void main(String[] args) throws IOException {
        Procedure procedure = new Procedure(new UserChoice(), new ReadWriteInf(), new StorageMemory(), new FixList(), new ListCompare());
        procedure.start();
    }
}
