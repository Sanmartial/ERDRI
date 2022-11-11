package procedure;

import resource.StorageMemory;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeparateList {

    List<String> listEmployees;

    private List<String> listSurname = new ArrayList<>(); // Фамилия
    private List<String> listFirstName = new ArrayList<>(); //Имя
    private List<String> listPatronymic = new ArrayList<>(); //отчество
    private List<String> listPosition = new ArrayList<>(); //должность
    private List<String> listShortname = new ArrayList<>(); //ФИО
    private List<String> listIssueWhom = new ArrayList<>();//выдано КОМУ
    private List<String> listSurnameIsTenChar = new ArrayList<>();//фамилия из максимум 10 букв
    private final String RegTokenID = "\\d{7}"; //номер жетона
    private final String RegRank = "[(старший )? А-яі]* поліції";
    ; //звание
    private final String RegPosition = "([0-9\\),\\(]+) ([А-яіЇї\\s\\W0-9№]+)";//номер группы 2
    private final String RegPositionWhom = "^([а-яйіїює'’]+)\\s([а-яйіїює'’]+)";
    private final String RegForName = "(поліції) ([А-ЯІЇЮЄа-яіїює'’]+) ([А-ЯІЇЮЄа-яіїює'’]+) ([А-ЯІЇЮЄа-яіїює'’]+)"; //нужно только указывать номер групы фамилия -2, имя 3, отчество - 4

    public void separateListEmployees(StorageMemory memory) {
        for (int i = 0; i < memory.getListOne().size(); i++) {

            if (memory.getListOne().get(i).length() > 60) {
                listSurname.add(setSurname(memory.getListOne().get(i)));
                listFirstName.add(setFirstName(memory.getListOne().get(i)));
                listPatronymic.add(setPatronymic(memory.getListOne().get(i)));
                listPosition.add(setPosition(memory.getListOne().get(i)));
                listShortname.add(setShortname(memory.getListOne().get(i)));
                listSurnameIsTenChar.add(addTenChar(memory.getListOne().get(i)));
            }
        }
        listIssueWhom = setIssueWhow();
        memory.setListResult(fullString());
    }

    private String addTenChar(String s) {
        String surName = separateWithRegExpression(RegForName, s, 2);
        surName = surName.toLowerCase(Locale.ROOT);
        char ch[] = surName.toCharArray();

        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();

        for (int i = 0; i < 20; i++) {
            if (i < ch.length)
                sb.append(ch[i]).append("\t");
            else
                sb.append(' ').append("\t");
        }
        sb1.append(sb.substring(0, 1).toUpperCase(Locale.ROOT)).append(sb.substring(1));
        return sb1.substring(0, 20);
    }

    private List<String> fullString() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < listSurname.size(); i++) {
            list.add(listSurname.get(i) + "\t" + listIssueWhom.get(i) + "\t" + listSurnameIsTenChar.get(i) + "\t" + listShortname.get(i) + "\t" + listPosition.get(i));
        }
        return list;
    } //создаем полную строку для записи в файл

    private List<String> setIssueWhow() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < listFirstName.size(); i++) {
            list.add(listFirstName.get(i) + " " + listPatronymic.get(i));

        }
        return list;
    } //создаем строку имя и отчество вместе

    private String separateWithRegExpression(String patternS, String fromList, int numberGroup) {
        String list = null;
        Pattern pattern = Pattern.compile(patternS);
        Matcher matcher = pattern.matcher(fromList);

        while (matcher.find()) {
            list = matcher.group(numberGroup);
        }

        return list;
    } //метод для регулярных выражений. Возвращает нужную фразу из строки

    public List<String> getListEmployees() {
        return listEmployees;
    }

    public void setListEmployees(List<String> listEmployees) {
        this.listEmployees = listEmployees;
    }

    private String setSurname(String fromList) {
        String list = separateWithRegExpression(RegForName, fromList, 2);
        list = addEndSurname(list);
        return list;
    } //находим фамилию

    private String addEndSurname(String list) {
        int sizeWord = list.length();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        sb.append(list);
        //System.out.println(sb.substring(sizeWord-1));
        if (sb.substring(sizeWord - 1).toLowerCase(Locale.ROOT).equals("о")) {
            sb1.append(sb.substring(0, sizeWord - 1)).append("У");
            return sb1.substring(0);
        }
        if (sb.substring(sizeWord - 2).toLowerCase(Locale.ROOT).equals("ка")) {
            sb1.append(sb.substring(0, sizeWord - 2)).append("ЦІ");
            return sb1.substring(0);
        }

        if (sb.substring(sizeWord - 2).toLowerCase(Locale.ROOT).equals("ха")) {
            sb1.append(sb.substring(0, sizeWord - 2)).append("СІ");
            return sb1.substring(0);
        }

        if (sb.substring(sizeWord - 2).toLowerCase(Locale.ROOT).equals("ія")) {
            sb1.append(sb.substring(0, sizeWord - 2)).append("ІЮ");
            return sb1.substring(0);
        }

        if (sb.substring(sizeWord - 1).toLowerCase(Locale.ROOT).equals("я")) {
            sb1.append(sb.substring(0, sizeWord - 1)).append("І");
            return sb1.substring(0);
        }

        if (sb.substring(sizeWord - 2).toLowerCase(Locale.ROOT).equals("ій")) {
            sb1.append(sb.substring(0, sizeWord - 2)).append("ІЮ");
            return sb1.substring(0);
        }

        if (sb.substring(0).toLowerCase(Locale.ROOT).equals("швець")) {
            return "ШВЕЦЮ";
        }

        if (sb.substring(0).toLowerCase(Locale.ROOT).equals("орел")) {
            return "ОРЛУ";
        }
        if (sb.substring(0).toLowerCase(Locale.ROOT).equals("фрунзе")) {
            return "ФРУНЗЕ";
        }

        if (sb.substring(0).equals("ГАЛІШТЕЙ")) {
            return "ГАЛІШТЕЙ";
        }
        if (sb.substring(0).equals("ЦИТЛІШВІЛІ")) {
            return "ЦИТЛІШВІЛІ";
        }

        if (sb.substring(sizeWord - 3).toLowerCase(Locale.ROOT).equals("ець")) {
            sb1.append(sb.substring(0, sizeWord - 3)).append("ЦЮ");
            return sb1.substring(0);
        }
        if (sb.substring(sizeWord - 3).toLowerCase(Locale.ROOT).equals("нок")) {
            sb1.append(sb.substring(0, sizeWord - 3)).append("НКУ");
            return sb1.substring(0);
        }

        if (sb.substring(sizeWord - 1).toLowerCase(Locale.ROOT).equals("ь")) {
            sb1.append(sb.substring(0, sizeWord - 1)).append("Ю");
            return sb1.substring(0);
        }

        if (sb.substring(sizeWord - 1).toLowerCase(Locale.ROOT).equals("й")) {
            sb1.append(sb.substring(0, sizeWord - 2)).append("ОМУ");
            return sb1.substring(0);
        }

        if (sb.substring(sizeWord - 1).toLowerCase(Locale.ROOT).equals("а")) {
            sb1.append(sb.substring(0, sizeWord - 1)).append("І");
            return sb1.substring(0);
        } else {
            sb1.append(sb.substring(0, sizeWord)).append("У");
            return sb1.substring(0);
        }
    }//меняем конец фамилии

    private String setShortname(String fromList) {
        String firstName;
        String patronymic;
        StringBuilder sb = new StringBuilder();
        firstName = separateWithRegExpression(RegForName, fromList, 3);
        patronymic = separateWithRegExpression(RegForName, fromList, 4);
        firstName = separateInitials(firstName);
        patronymic = separateInitials(patronymic);
        sb.append(firstName).append("\t").append(patronymic);
        return sb.substring(0);

    } //устанавливаю инициалы

    private String separateInitials(String firstName) {
        StringBuilder sb = new StringBuilder();
        char ch[] = firstName.toCharArray();
        sb.append(ch[0]).append(".");
        return sb.substring(0);
    } //отделяем первую букву имени и доставляем точку

    private String setFirstName(String fromList) {
        String list = separateWithRegExpression(RegForName, fromList, 3);
        list = addEndFirstname(list);
        return list;
    } //Находим имя

    private String addEndFirstname(String list) {
        int sizeWord = list.length();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        sb.append(list);

        if (sb.substring(sizeWord - 1).toLowerCase(Locale.ROOT).equals("о")) {
            sb1.append(sb.substring(0, sizeWord - 1)).append("у");
            return sb1.substring(0);
        }
        if (sb.substring(0).equals("Ігор")) {
            return "Ігорю";
        }
        if (sb.substring(sizeWord - 1).toLowerCase(Locale.ROOT).equals("р")) {
            sb1.append(sb.substring(0, sizeWord - 1)).append("ру");
            return sb1.substring(0);
        }
        if (sb.substring(sizeWord - 2).toLowerCase(Locale.ROOT).equals("ія")) {
            sb1.append(sb.substring(0, sizeWord - 2)).append("ії");
            return sb1.substring(0);
        }
        if (sb.substring(sizeWord - 2).toLowerCase(Locale.ROOT).equals("ій")) {
            sb1.append(sb.substring(0, sizeWord - 2)).append("ію");
            return sb1.substring(0);
        }
        if (sb.substring(sizeWord - 2).toLowerCase(Locale.ROOT).equals("та")) {
            sb1.append(sb.substring(0, sizeWord - 2)).append("ті");
            return sb1.substring(0);
        }
        if (sb.substring(sizeWord - 2).toLowerCase(Locale.ROOT).equals("на")) {
            sb1.append(sb.substring(0, sizeWord - 2)).append("ні");
            return sb1.substring(0);
        }
        if (sb.substring(sizeWord - 2).toLowerCase(Locale.ROOT).equals("ла")) {
            sb1.append(sb.substring(0, sizeWord - 2)).append("лі");
            return sb1.substring(0);
        }
        if (sb.substring(sizeWord - 2).toLowerCase(Locale.ROOT).equals("ль")) {
            sb1.append(sb.substring(0, sizeWord - 2)).append("лю");
            return sb1.substring(0);
        }
        if (sb.substring(sizeWord - 2).toLowerCase(Locale.ROOT).equals("ра")) {
            sb1.append(sb.substring(0, sizeWord - 2)).append("рі");
            return sb1.substring(0);
        }
        if (sb.substring(sizeWord - 2).toLowerCase(Locale.ROOT).equals("га")) {
            sb1.append(sb.substring(0, sizeWord - 2)).append("зі");
            return sb1.substring(0);
        } else {
            sb1.append(sb.substring(0, sizeWord)).append("у");
            return sb1.substring(0);
        }
    } //меняем окончание имени

    private String setPatronymic(String fromList) {
        String list = separateWithRegExpression(RegForName, fromList, 4);
        list = addEndPatronymic(list);
        return list;
    } // находим отчество

    private String addEndPatronymic(String list) {
        int sizeWord = list.length();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        sb.append(list);

        if (sb.substring(sizeWord - 2).toLowerCase(Locale.ROOT).equals("на")) {
            sb1.append(sb.substring(0, sizeWord - 2)).append("ні");
            return sb1.substring(0);
        } else {
            sb1.append(sb.substring(0, sizeWord)).append("у");
            return sb1.substring(0);
        }
    } //меняем окончание отчества

    private String setPosition(String fromList) {

        String word1;
        String word2;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        String list = separateWithRegExpression(RegPosition, fromList, 2);
        word1 = separateWithRegExpression(RegPositionWhom, list, 1);
        word2 = separateWithRegExpression(RegPositionWhom, list, 2);
        sb.append(word2);
        if (sb.substring(0).equals("взводу")) {
            sb1.append(" ");
        } else {
            sb1.append(word2);
        }
        word2 = sb1.substring(0);

        sb = sb.delete(0, sb.length());
        sb1 = sb1.delete(0, sb1.length());

        sb.append(word1);

        if (sb.substring(sb.length() - 3).toLowerCase(Locale.ROOT).equals("кий")) {
            sb1.append(sb.substring(0, sb.length() - 3)).append("кОМУ".toLowerCase(Locale.ROOT));
            return sb1.substring(0) + " " + word2;
        }
        if (sb.substring(sb.length() - 3).toLowerCase(Locale.ROOT).equals("ник")) {
            sb1.append(sb.substring(0, sb.length() - 3)).append("ниКу".toLowerCase(Locale.ROOT));
            return sb1.substring(0) + " " + word2;
        }
        if (sb.substring(sb.length() - 3).toLowerCase(Locale.ROOT).equals("дир")) {
            sb1.append(sb.substring(0, sb.length() - 3)).append("диру".toLowerCase(Locale.ROOT));
            return sb1.substring(0) + " " + word2;
        }
        if (sb.substring(sb.length() - 3).toLowerCase(Locale.ROOT).equals("тор")) {
            sb1.append(sb.substring(0, sb.length() - 3)).append("тору".toLowerCase(Locale.ROOT));
            return sb1.substring(0) + " " + word2;
        }
        if (sb.substring(sb.length() - 3).toLowerCase(Locale.ROOT).equals("ина")) {
            sb1.append(sb.substring(0, sb.length() - 3)).append("ині".toLowerCase(Locale.ROOT));
            return sb1.substring(0) + " " + word2;
        } else
   return sb1.substring(0); } //находим должность

}
