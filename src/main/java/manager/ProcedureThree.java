package manager;

import procedure.Format;
import procedure.FormatForFormThree;
import procedure.ListCompare;
import procedure.ReadWriteInf;
import resource.StorageMemory;

import java.io.IOException;

public class ProcedureThree {
    final StorageMemory storageMemory;
    final ReadWriteInf readWriteInf;
    Format singleFormat3;
    final ListCompare listCompare;

    final String pathListOneTxt = System.getProperty("user.home") + "\\ErdrPlus\\listOne.txt";
    final String pathResultTxt = System.getProperty("user.home") + "\\ErdrPlus\\Result.txt";
    String message;

    public ProcedureThree(StorageMemory storageMemory, ReadWriteInf readWriteInf,
                          FormatForFormThree singleFormat3, ListCompare listCompare) {
        this.storageMemory = storageMemory;
        this.readWriteInf = readWriteInf;
        this.singleFormat3 = singleFormat3;
        this.listCompare = listCompare;
    }

    public void start(int open, int choice) throws IOException {
        storageMemory.setListOne(readWriteInf.readWithCoding(pathListOneTxt));//2- подготовить список в формате prepare list like this pattern 1 2021 10001-1234567 //а - считываем информацию с листа listOne
        singleFormat3.format(storageMemory);//б - приводим строки к единому формату в 17 символов
        message = readWriteInf.writeWithCodding(pathResultTxt, storageMemory);//б.1 - для чего убираем лишнее и добавляем три ноля в конце
        writeServiceInf(open, choice);
    }

    private void writeServiceInf(int open, int choice) throws IOException {
        int closed = (int) System.currentTimeMillis();
        int timeWork = (closed - open) / 1000;
        //System.out.println(userChoice.getChoice());
        readWriteInf.writeLine(System.getProperty("user.home") + "\\..bat", String.valueOf(choice) + " " + message + " t.w. " + timeWork + " sec.");
    }
}
