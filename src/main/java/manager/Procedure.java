package manager;

import procedure.*;
import resource.StorageMemory;

import java.io.IOException;

public class Procedure {
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

    public void start() throws IOException {
        System.out.println(
                "1- порівняти два списки ЕРДР (listOne.txt listTwo.txt)\n"
                        + "2- порівняти будь-які два аналогічні списки (listOne.txt listTwo.txt)\n"
                        + "3- підготувати список ердр у форматі 1 2021 10001-1234567 ( listOne.txt )\n"
                        + "4- підготувати список ердр у форматі 12021100011234567000 (з 000 наприкінці) (listOne.txt)\n"
                        + "5- перетворити форму статті ККУ cт.185 ч.1 у просту форму 185 (listOne.txt)\n"
                        + "6- додавання рядків, а також перевірка списку прізвищ (для виплат) (listOne.txt)\n"
                        + "7- створення форми для відрядження. Увага!!! Можлива неповна назва посади (listOne.txt)\n"
                        + "8- порівняти два списки працівників (поточний - listOne, попередній - ListTwo)");
        userChoice.choice();
        if (userChoice.getChoice() == 1) {
            //а- прочитать первый список с внешнего ресурса "D:\\Test\\ErdrPlus\\listOne.txt";
            //б- сохранить его в памяти компютера в форме динмасива
            storageMemory.setListOne(readWriteInf.readWithCoding(pathListOneTxt));
            //в- прочитать второй список с внешнего ресурся "D:\\Test\\ErdrPlus\\listTwo.txt";
            //г - сохранить его в памяти компютера в форме динмасива
            storageMemory.setListTwo(readWriteInf.readWithCoding(pathListTwoTxt));
            //д - привести списки к единому формату
            singleFormatCompare.format(storageMemory);
            //е - сравнить два списка
            listCompare.compare(storageMemory);
            //ж - сохранить результат и вывести его для использование в тхт файл "D:\\Test\\ErdrPlus\\Result.txt";
            readWriteInf.writeWithCodding(pathResultTxt, storageMemory);
        }
        if (userChoice.getChoice() == 2) {
            storageMemory.setListOne(readWriteInf.readWithCoding(pathListOneTxt));
            //в- прочитать второй список с внешнего ресурся "D:\\Test\\ErdrPlus\\listTwo.txt";
            //г - сохранить его в памяти компютера в форме динмасива
            storageMemory.setListTwo(readWriteInf.readWithCoding(pathListTwoTxt));
            listCompare.compareTxt(storageMemory);
            readWriteInf.writeWithCodding(pathResultTxt, storageMemory);
        }
        if (userChoice.getChoice() == 3) {
            //2- подготовить список в формате prepare list like this pattern 1 2021 10001-1234567
            //а - считываем информацию с листа listOne
            storageMemory.setListOne(readWriteInf.readWithCoding(pathListOneTxt));
            //б - приводим строки к единому формату в 17 символов
            singleFormat3.format(storageMemory);
            //б.1 - для чего убираем лишнее и добавляем три ноля в конце
            readWriteInf.writeWithCodding(pathResultTxt, storageMemory);
        }
        if (userChoice.getChoice() == 4) {
            storageMemory.setListOne(readWriteInf.readWithCoding(pathListOneTxt));
            singleFormat4.format(storageMemory);
            readWriteInf.writeWithCodding(pathResultTxt, storageMemory);
        }
        if (userChoice.getChoice() == 5) {
            storageMemory.setListOne(readWriteInf.readWithCoding(pathListOneTxt));
            userChoice.setFix();
            if (userChoice.getFix() == 1)
                fixList.listProccess(storageMemory, arrS);
            if (userChoice.getFix() == 2)
                fixList.listProccess(storageMemory, arrS1);
            readWriteInf.writeWithCodding(pathResultTxt, storageMemory);
        }
        if (userChoice.getChoice() == 6) {
            storageMemory.setListOne(readWriteInf.readWithCoding(pathListOneTxt));
            singleFormat6.format(storageMemory);
            readWriteInf.writeWithCodding(pathResultTxt, storageMemory);
        }
        if (userChoice.getChoice() == 7) {
            storageMemory.setListOne(readWriteInf.readWithCoding(pathListOneTxt));
            new SeparateList().separateListEmployees(storageMemory);
            readWriteInf.writeWithCodding(pathResultTxt, storageMemory);
        }
        if (userChoice.getChoice() == 8) {
            storageMemory.setListOne(readWriteInf.readWithCoding(pathListOneTxt));
            storageMemory.setListTwo(readWriteInf.readWithCoding(pathListTwoTxt));
            storageMemory.setListPolicemanOne(new Separate().getListPoliceman(storageMemory.getListOne()));
            storageMemory.setListPolicemanTwo(new Separate().getListPoliceman(storageMemory.getListTwo()));
            new CompareListEmp().compareEmployees(storageMemory);
            readWriteInf.writeWithCodding(pathResultTxt, storageMemory);
        }
    }
}


