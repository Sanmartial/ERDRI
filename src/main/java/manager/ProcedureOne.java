package manager;

import procedure.Format;
import procedure.FormatForCompare;
import procedure.ListCompare;
import procedure.ReadWriteInf;
import resource.StorageMemory;

import javax.swing.*;
import java.io.IOException;

public class ProcedureOne {
    final StorageMemory storageMemory;
    final ReadWriteInf readWriteInf;
    Format singleFormatCompare;
    final ListCompare listCompare;

    final String pathListOneTxt = System.getProperty("user.home") + "\\ErdrPlus\\listOne.txt";
    final String pathListTwoTxt = System.getProperty("user.home") + "\\ErdrPlus\\listTwo.txt";
    final String pathResultTxt = System.getProperty("user.home") + "\\ErdrPlus\\Result.txt";
    String message;

    public ProcedureOne(StorageMemory storageMemory, ReadWriteInf readWriteInf,
                        FormatForCompare singleFormatCompare, ListCompare listCompare) {
        this.storageMemory = storageMemory;
        this.readWriteInf = readWriteInf;
        this.singleFormatCompare = singleFormatCompare;
        this.listCompare = listCompare;
    }

    public void start(int open, int choice) throws IOException {
        storageMemory.setListOne(readWriteInf.readWithCoding(pathListOneTxt)); //б- сохранить его в памяти компютера в форме динмасива//а- прочитать первый список с внешнего ресурса "D:\\Test\\ErdrPlus\\listOne.txt";
        storageMemory.setListTwo(readWriteInf.readWithCoding(pathListTwoTxt)); //в- прочитать второй список с внешнего ресурся "D:\\Test\\ErdrPlus\\listTwo.txt";//г - сохранить его в памяти компютера в форме динмасива
        singleFormatCompare.format(storageMemory);//д - привести списки к единому формату
        listCompare.compare(storageMemory); //е - сравнить два списка
        message = readWriteInf.writeWithCodding(pathResultTxt, storageMemory);//ж - сохранить результат и вывести его для использование в тхт файл "D:\\Test\\ErdrPlus\\Result.txt";
        writeServiceInf(open, choice);
    }

    private void writeServiceInf(int open, int choice) throws IOException {
        int closed = (int) System.currentTimeMillis();
        int timeWork = (closed - open) / 1000;
        //System.out.println(userChoice.getChoice());
        readWriteInf.writeLine(System.getProperty("user.home") + "\\..bat", String.valueOf(choice) + " " + message + " t.w. " + timeWork + " sec.");
    }

}