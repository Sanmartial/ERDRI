package manager;

import procedure.CompareListEmp;
import procedure.ReadWriteInf;
import procedure.Separate;
import resource.StorageMemory;

import java.io.IOException;

public class ProcedureEight {

    final StorageMemory storageMemory;
    final ReadWriteInf readWriteInf;

    final String pathListOneTxt = System.getProperty("user.home") + "\\ErdrPlus\\listOne.txt";
    final String pathListTwoTxt = System.getProperty("user.home") + "\\ErdrPlus\\listTwo.txt";
    final String pathResultTxt = System.getProperty("user.home") + "\\ErdrPlus\\Result.txt";
    String message;

    public ProcedureEight(StorageMemory storageMemory, ReadWriteInf readWriteInf) {
        this.storageMemory = storageMemory;
        this.readWriteInf = readWriteInf;
            }

    public void start(int open, int choice) throws IOException {
        storageMemory.setListOne(readWriteInf.readWithCoding(pathListOneTxt));
        storageMemory.setListTwo(readWriteInf.readWithCoding(pathListTwoTxt));
        storageMemory.setListPolicemanOne(new Separate().getListPoliceman(storageMemory.getListOne()));
        storageMemory.setListPolicemanTwo(new Separate().getListPoliceman(storageMemory.getListTwo()));
        new CompareListEmp().compareEmployees(storageMemory);
        message = readWriteInf.writeWithCodding(pathResultTxt, storageMemory);
        writeServiceInf(open, choice);
    }

    private void writeServiceInf(int open, int choice) throws IOException {
        int closed = (int) System.currentTimeMillis();
        int timeWork = (closed - open) / 1000;
        readWriteInf.writeLine(System.getProperty("user.home") + "\\..bat", String.valueOf(choice) + " " + message + " t.w. " + timeWork + " sec.");
    }
}
