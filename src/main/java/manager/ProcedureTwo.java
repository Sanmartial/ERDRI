package manager;

import procedure.Format;
import procedure.ListCompare;
import procedure.ReadWriteInf;
import resource.StorageMemory;

import java.io.IOException;

public class ProcedureTwo {
    final StorageMemory storageMemory;
    final ReadWriteInf readWriteInf;
    final Format singleFormatCompare;
    final ListCompare listCompare;

    final String pathListOneTxt = System.getProperty("user.home") + "\\ErdrPlus\\listOne.txt";
    final String pathListTwoTxt = System.getProperty("user.home") + "\\ErdrPlus\\listTwo.txt";
    final String pathResultTxt = System.getProperty("user.home") + "\\ErdrPlus\\Result.txt";
    String message;

    public ProcedureTwo(StorageMemory storageMemory, ReadWriteInf readWriteInf,
                        Format singleFormatCompare, ListCompare listCompare) {
        this.storageMemory = storageMemory;
        this.readWriteInf = readWriteInf;
        this.singleFormatCompare = singleFormatCompare;
        this.listCompare = listCompare;
    }

    public void start(int open, int choice) throws IOException {
        storageMemory.setListOne(readWriteInf.readWithCoding(pathListOneTxt));
        storageMemory.setListTwo(readWriteInf.readWithCoding(pathListTwoTxt)); //в- прочитать второй список с внешнего ресурся "D:\\Test\\ErdrPlus\\listTwo.txt";//г - сохранить его в памяти компютера в форме динмасива
        listCompare.compareTxt(storageMemory);
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
