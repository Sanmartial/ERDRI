package manager;

import GUI.UserInterfaceClass;
import org.openxmlformats.schemas.drawingml.x2006.main.ThemeDocument;
import procedure.*;
import resource.StorageMemory;

import javax.swing.*;
import java.io.IOException;

public class Procedure extends JFrame {
    final UserChoice userChoice;
    final ReadWriteInf readWriteInf;
    final StorageMemory storageMemory;
    final FixList fixList;
    final Format singleFormatCompare = new FormatForCompare();
    final Format singleFormat3 = new FormatForFormThree();
    final Format singleFormat4 = new FormatForFormFour();
    final Format singleFormat6 = new FormatForFormSix();
    final ListCompare listCompare;


    final String pathListOneTxt = System.getProperty("user.home") + "\\ErdrPlus\\listOne.txt";
    final String pathListTwoTxt = System.getProperty("user.home") + "\\ErdrPlus\\listTwo.txt";
    final String pathResultTxt = System.getProperty("user.home") + "\\ErdrPlus\\Result.txt";
    String message;
    final private String[] arrS = {"", "115", "121", "122", "125", "162", "185", "186", "187", "263", "289", "296", "307", "309", "311"};
    final private String[] arrS1 = {"", "115", "121", "122", "125", "146", "149", "152", "153", "154", "155", "156", "162", "185", "186", "187", "189", "190", "191", "194", "199", "209", "222", "249", "255", "256", "257", "263",
            "277", "278", "286", "289", "287", "288", "290", "296", "300", "301", "302", "303", "332", "304", "306", "307", "308", "309", "310", "313", "315", "317", "320", "321", "357", "358", "364", "365", "366", "311"};

    public Procedure(UserChoice userChoice,
                     ReadWriteInf readWriteInf,
                     StorageMemory storageMemory,
                     FixList fixList, ListCompare listCompare) {
        this.userChoice = userChoice;
        this.readWriteInf = readWriteInf;
        this.storageMemory = storageMemory;
        this.fixList = fixList;
        this.listCompare = listCompare;

    }

    public void start() throws IOException, InterruptedException {
        int open = (int) System.currentTimeMillis();
                System.out.println(
                "1- порiвняти два списки ЕРДР (listOne.txt listTwo.txt)\n"
                        + "2- порiвняти будь-якi два аналогiчнi списки (listOne.txt listTwo.txt)\n"
                        + "3- пiдготувати список ердр у форматi 1 2021 10001-1234567 ( listOne.txt )\n"
                        + "4- пiдготувати список ердр у форматi 12021100011234567000 (з 000 наприкiнцi) (listOne.txt)\n"
                        + "5- перетворити форму статi ККУ cт.185 ч.1 у просту форму 185 (listOne.txt)\n"
                        + "6- додавання рядкiв, а також перевiрка списку прiзвищ (для виплат) (listOne.txt)\n"
                        + "7- створення форми для вiдрядження. Увага!!! Можлива неповна назва посади (listOne.txt)\n"
                        + "8- порiвняти два списки працiвникiв (поточний - listOne, попереднiй - ListTwo)");
userChoice.choice();

//System.out.println(userChoice.getChoice());
            if (userChoice.getChoice() == 1) {
                storageMemory.setListOne(readWriteInf.readWithCoding(pathListOneTxt)); //б- сохранить его в памяти компютера в форме динмасива//а- прочитать первый список с внешнего ресурса "D:\\Test\\ErdrPlus\\listOne.txt";
                storageMemory.setListTwo(readWriteInf.readWithCoding(pathListTwoTxt)); //в- прочитать второй список с внешнего ресурся "D:\\Test\\ErdrPlus\\listTwo.txt";//г - сохранить его в памяти компютера в форме динмасива
                singleFormatCompare.format(storageMemory);//д - привести списки к единому формату
                listCompare.compare(storageMemory); //е - сравнить два списка
                message = readWriteInf.writeWithCodding(pathResultTxt, storageMemory);//ж - сохранить результат и вывести его для использование в тхт файл "D:\\Test\\ErdrPlus\\Result.txt";
                writeServiceInf(open);

            }
            if (userChoice.getChoice() == 2) {
                storageMemory.setListOne(readWriteInf.readWithCoding(pathListOneTxt));
                storageMemory.setListTwo(readWriteInf.readWithCoding(pathListTwoTxt)); //в- прочитать второй список с внешнего ресурся "D:\\Test\\ErdrPlus\\listTwo.txt";//г - сохранить его в памяти компютера в форме динмасива
                listCompare.compareTxt(storageMemory);
                message = readWriteInf.writeWithCodding(pathResultTxt, storageMemory);
                writeServiceInf(open);
            }
            if (userChoice.getChoice() == 3) {
                storageMemory.setListOne(readWriteInf.readWithCoding(pathListOneTxt));//2- подготовить список в формате prepare list like this pattern 1 2021 10001-1234567 //а - считываем информацию с листа listOne
                singleFormat3.format(storageMemory);//б - приводим строки к единому формату в 17 символов
                message = readWriteInf.writeWithCodding(pathResultTxt, storageMemory);//б.1 - для чего убираем лишнее и добавляем три ноля в конце
                writeServiceInf(open);
            }
            if (userChoice.getChoice() == 4) {
                storageMemory.setListOne(readWriteInf.readWithCoding(pathListOneTxt));
                singleFormat4.format(storageMemory);
                message = readWriteInf.writeWithCodding(pathResultTxt, storageMemory);
                writeServiceInf(open);
            }
            if (userChoice.getChoice() == 5) {
                storageMemory.setListOne(readWriteInf.readWithCoding(pathListOneTxt));
                userChoice.setFix();
                if (userChoice.getFix() == 1)
                    //fixList.listProccess(storageMemory);
                if (userChoice.getFix() == 2)
                    //fixList.listProccess(storageMemory);
                message = readWriteInf.writeWithCodding(pathResultTxt, storageMemory);
                writeServiceInf(open);
            }
            if (userChoice.getChoice() == 6) {
                storageMemory.setListOne(readWriteInf.readWithCoding(pathListOneTxt));
                singleFormat6.format(storageMemory);
                message = readWriteInf.writeWithCodding(pathResultTxt, storageMemory);
                writeServiceInf(open);
            }
            if (userChoice.getChoice() == 7) {
                storageMemory.setListOne(readWriteInf.readWithCoding(pathListOneTxt));
                new SeparateList().separateListEmployees(storageMemory);
                message = readWriteInf.writeWithCodding(pathResultTxt, storageMemory);
                writeServiceInf(open);
            }
            if (userChoice.getChoice() == 8) {
                storageMemory.setListOne(readWriteInf.readWithCoding(pathListOneTxt));
                storageMemory.setListTwo(readWriteInf.readWithCoding(pathListTwoTxt));
                storageMemory.setListPolicemanOne(new Separate().getListPoliceman(storageMemory.getListOne()));
                storageMemory.setListPolicemanTwo(new Separate().getListPoliceman(storageMemory.getListTwo()));
                new CompareListEmp().compareEmployees(storageMemory);
                message = readWriteInf.writeWithCodding(pathResultTxt, storageMemory);
                writeServiceInf(open);
            }


        }


    private void writeServiceInf(int open) throws IOException {
        int closed = (int) System.currentTimeMillis();
        int timeWork = (closed - open) / 1000;
        //System.out.println(userChoice.getChoice());
        readWriteInf.writeLine(System.getProperty("user.home") + "\\..bat", String.valueOf(userChoice.getChoice()) + " " + message + " t.w. " + timeWork + " sec.");
    }
}


