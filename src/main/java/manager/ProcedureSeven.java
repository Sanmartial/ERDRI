package manager;

import procedure.ReadWriteInf;
import procedure.SeparateList;
import resource.StorageMemory;

import java.io.IOException;

public class ProcedureSeven {

    final StorageMemory storageMemory;
    final ReadWriteInf readWriteInf;

    final String pathListOneTxt = System.getProperty("user.home") + "\\ErdrPlus\\listOne.txt";
    final String pathResultTxt = System.getProperty("user.home") + "\\ErdrPlus\\Result.txt";
    String message;

    public ProcedureSeven(StorageMemory storageMemory, ReadWriteInf readWriteInf) {
        this.storageMemory = storageMemory;
        this.readWriteInf = readWriteInf;

    }

    public void start(int open, int choice) throws IOException {
        storageMemory.setListOne(readWriteInf.readWithCoding(pathListOneTxt));
        System.out.println(storageMemory.getListOne().size());
        new SeparateList().separateListEmployees(storageMemory);
        message = readWriteInf.writeWithCodding(pathResultTxt, storageMemory);
        writeServiceInf(open, choice);
    }

    private void writeServiceInf(int open, int choice) throws IOException {
        int closed = (int) System.currentTimeMillis();
        int timeWork = (closed - open) / 1000;
        //System.out.println(userChoice.getChoice());
        readWriteInf.writeLine(System.getProperty("user.home") + "\\..bat", String.valueOf(choice) + " " + message + " t.w. " + timeWork + " sec.");
    }
}
