package manager;

import GUI.FormForChoice;
import procedure.FixList;
import procedure.Format;
import procedure.ListCompare;
import procedure.ReadWriteInf;
import resource.StorageMemory;

import java.io.IOException;

public class ProcedureFive {

    final StorageMemory storageMemory;
    final ReadWriteInf readWriteInf;
    Format singleFormat3;
    final ListCompare listCompare;
    final FixList fixList;
    final String pathListOneTxt = System.getProperty("user.home") + "\\ErdrPlus\\listOne.txt";
    final String pathResultTxt = System.getProperty("user.home") + "\\ErdrPlus\\Result.txt";
    String message;
    final private String[] arrS = {"", "115", "121", "122", "125", "162", "185", "186", "187", "263", "289", "296", "307", "309", "311"};
    final private String[] arrS1 = {"", "115", "121", "122", "125", "146", "149", "152", "153", "154", "155", "156", "162", "185", "186", "187", "189", "190", "191", "194", "199", "209", "222", "249", "255", "256", "257", "263",
            "277", "278", "286", "289", "287", "288", "290", "296", "300", "301", "302", "303", "332", "304", "306", "307", "308", "309", "310", "313", "315", "317", "320", "321", "357", "358", "364", "365", "366", "311"};

    public ProcedureFive(StorageMemory storageMemory, ReadWriteInf readWriteInf,
                         ListCompare listCompare, FixList fixList) {
        this.storageMemory = storageMemory;
        this.readWriteInf = readWriteInf;
        this.singleFormat3 = singleFormat3;
        this.listCompare = listCompare;
        this.fixList = fixList;
    }

    public void start(int open, int choice, int r) throws IOException {
        storageMemory.setListOne(readWriteInf.readWithCoding(pathListOneTxt));
        if (r == 1) {
            fixList.listProccess(storageMemory, arrS);
        } else {
            fixList.listProccess(storageMemory, arrS1);
        }
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
