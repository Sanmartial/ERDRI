package manager;

import procedure.Format;
import procedure.FormatForFormSix;
import procedure.ListCompare;
import procedure.ReadWriteInf;
import resource.StorageMemory;

import java.io.IOException;

public class ProcedureSix {

    final StorageMemory storageMemory;
    final ReadWriteInf readWriteInf;
    Format singleFormat6;
    final ListCompare listCompare;

    final String pathListOneTxt = System.getProperty("user.home") + "\\ErdrPlus\\listOne.txt";
    final String pathResultTxt = System.getProperty("user.home") + "\\ErdrPlus\\Result.txt";
    String message;

    public ProcedureSix(StorageMemory storageMemory, ReadWriteInf readWriteInf,
                        FormatForFormSix singleFormat6, ListCompare listCompare) {
        this.storageMemory = storageMemory;
        this.readWriteInf = readWriteInf;
        this.singleFormat6 = singleFormat6;
        this.listCompare = listCompare;
    }

    public void start(int open, int choice) throws IOException {
        storageMemory.setListOne(readWriteInf.readWithCoding(pathListOneTxt));
        singleFormat6.format(storageMemory);
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
