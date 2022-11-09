package procedure;


import resource.Policeman;
import resource.StorageMemory;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separate {
    private List<String> listEmployees = new ArrayList<>();
    String pathResult = "D:\\Test\\EMPLOYEES\\result.txt";

    //String pattern = "^([\sа-яйіїює№0-9\\W]+)\t([(старший )? А-яі]* поліції)\t([А-ЯІЇЮЄа-яіїює.'’\s]+)\t([№0-9]+)\t([А-ЯІЇЮЄа-яіїює\s0-9]+)\t([А-ЯІЇЮЄа-яіїює\s0-9]+)";
    String pattern = "^([(старший )? А-ЯІЇЮЄа-яіїює]* поліції)\s([А-ЯІЇЮЄа-яіїює.'’\s]+)\s([\\d+]+)\s([а-яіїює\s0-9]+)";
    //нужно только указывать номер групы 1 - звание, 2- П.І.Б., 3- жетон, 4 - должность
    String RegForName = "(поліції) ([А-ЯІЇЮЄа-яіїює'’]+) ([А-ЯІЇЮЄа-яіїює'’]+) ([А-ЯІЇЮЄа-яіїює'’]+)"; //нужно только указывать номер групы фамилия -2, имя 3, отчество - 4
    private String RegRank = "[(старший )? А-яі]* поліції"; //звание
    private String RegPosition = "([0-9\\),\\(]+) ([А-яіЇї\\s\\W0-9№]+)";//номер группы 2
    private String RegTokenID = "\\d{7}"; //номер жетона
    private final String RegPositionWhom = "^([а-яйіїює'’]+)\\s([а-яйіїює'’]+)";



    public List<Policeman> getListPoliceman(StorageMemory memory){
        List<Policeman> listPol = new ArrayList<>();
        for (int i = 0; i < memory.getListOne().size(); i++) {
            if(memory.getListOne().get(i).length() > 60) {
                listPol.add(new Policeman(i + 1, getRank(memory.getListOne().get(i)), getSurname(memory.getListOne().get(i)),
                        getFirstName(memory.getListOne().get(i)), getShortName(memory.getListOne().get(i)),
                        getPatronymic(memory.getListOne().get(i)), getTokenID(memory.getListOne().get(i)),
                        getPosition(memory.getListOne().get(i)), getUnit(memory.getListOne().get(i))));
            }
        }
        return listPol;} //создаем и возвращаем список полицейских в виде екземпляров класса policeman

    private String separateWithRegExpression(String patternS, String fromList, int numberGroup){
        String list = null;
        Pattern pattern = Pattern.compile(patternS);
        Matcher matcher = pattern.matcher(fromList);

        while(matcher.find()){
            list = matcher.group(numberGroup);
        }
        return list;} //метод для регулярных выражений. Возвращает нужную фразу из строки

    private String getRank(String s){
        return separateWithRegExpression(RegRank, s, 0);
    } //звание

    private String getSurname(String s){
        return separateWithRegExpression(RegForName, s, 2);
    } //фамилия

    private String getFirstName(String s){
        return separateWithRegExpression(RegForName, s, 3);
    } //имя

    private String getPatronymic(String s){
        return separateWithRegExpression(RegForName, s, 4);
    } //отчество

    private String getShortName(String fromList) {
        String firstName;
        String patronymic;
        StringBuilder sb = new StringBuilder();
        firstName = separateWithRegExpression(RegForName,fromList,3);
        patronymic = separateWithRegExpression(RegForName, fromList, 4);
        firstName = separateInitials(firstName);
        patronymic = separateInitials(patronymic);
        sb.append(firstName).append(" ").append(patronymic);
        return sb.substring(0);

    } //устанавливаю инициалы

    private String getTokenID(String s){
        return separateWithRegExpression(RegTokenID, s, 0); //номер жетона
    }

    private String getPosition(String s){
        return  separateWithRegExpression(RegPosition, s, 2);
    } // должность

    private String getUnit(String s1) {

        String position = separateWithRegExpression(RegPosition, s1, 2);
        String s = "#";
        StringBuilder sb = new StringBuilder();
        sb.append(position);
        if((sb.indexOf("командир полку")) >= 0)
            s = "КП";
        if((sb.indexOf("заступник командира полку")) >= 0)
            s = "ЗКП";
        if((sb.indexOf("помічник начальника")) >= 0)
            //s = "Ш";
        s = "штаб";
        if((sb.indexOf("інспектор штабу")) >= 0)
            //s = "Ш";
        s = "штаб";
        if((sb.indexOf("чергової частини")) >= 0)
            //s = "Ш";
            s = "ЧЧ";
        if((sb.indexOf("відділення документування")) >= 0)
            //s = "Ш";
        s = "штаб";
        if((sb.indexOf("відділення зв’язку")) >= 0)
           // s = "Ш";
        s = "зв'язок";
        if((sb.indexOf("відділення кадрового")) >= 0)
            //s = "Ш";
        s = "кадри";
        if((sb.indexOf("відділення логістики")) >= 0)
            //s = "Ш";
        s = "ВЛМТЗ";
        if((sb.indexOf("тактико")) >= 0)
            //s = "Ш";
        s = "БСП";
        if((sb.indexOf("відділення превентивної")) >= 0)
            //s = "Ш";
        s = "ВПК";
        if((sb.indexOf("автотранспортної")) >= 0)
            s = "АР";
        if((sb.indexOf("роти № 1")) >= 0)
            s = "1";
        if((sb.indexOf("роти № 2")) >= 0)
            s = "2";
        if((sb.indexOf("роти № 3")) >= 0)
            s = "3";
        if((sb.indexOf("роти № 4")) >= 0)
            s = "4";
        if((sb.indexOf("роти № 5")) >= 0)
            s = "5";
        if((sb.indexOf("швидкого реагування")) >= 0)
            s = "РШР";
        return s;};//look for UNIT

    private String separateInitials(String firstName) {
        StringBuilder sb = new StringBuilder();
        char ch[] = firstName.toCharArray();
        sb.append(ch[0]).append(".");
        return sb.substring(0);
    } //отделяем первую букву имени и доставляем точку

    //GettersAndSetters
    public List<String> getListEmployees() {
        return listEmployees;
    }

    public void setListEmployees(List<String> listEmployees) {
        this.listEmployees = listEmployees;
    }

    public List<Policeman> separateForListToWhom(List<Policeman> listPol) {
        for (int i = 0; i < listPol.size(); i++) {
            //System.out.println(i);
            listPol.get(i).setPosition(changePosition(listPol.get(i).getPosition()));
            listPol.get(i).setSurname(changeSurname(listPol.get(i).getSurname()));
            listPol.get(i).setFirstName(changeFirstName(listPol.get(i).getFirstName()));
            listPol.get(i).setPatronymic(changePatronymic(listPol.get(i).getPatronymic()));
            listPol.get(i).setRank(changeRank(listPol.get(i).getRank()));
        }
   return listPol; }

    private String changeRank(String list) {

        if(list.equals("полковник поліції"))
            return "полковнику поліції";
        if(list.equals("підполковник поліції"))
            return "підполковнику поліції";
        if(list.equals("майор поліції"))
            return "майору поліції";
        if(list.equals("капітан поліції"))
            return "капітану поліції";
        if(list.equals("старший лейтенант поліції"))
            return "старшому лейтенанту поліції";
        if(list.equals("лейтенант поліції"))
            return "лейтенанту поліції";
        if(list.equals("молодший лейтенант поліції"))
            return "молодшому лейтенанту поліції";
        if(list.equals("старший сержант поліції"))
            return "старшому сержанту поліції";
        if(list.equals("сержант поліції"))
            return "сержанту поліції";
        if(list.equals("капрал поліції"))
            return "капралу поліції";
        if(list.equals("рядовий поліції"))
            return "рядовому поліції";
        else return list;
    }

    private String changePatronymic(String list) {
        int sizeWord = list.length();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        sb.append(list);

        if(sb.substring(sizeWord-2).toLowerCase(Locale.ROOT).equals("на")){
            sb1.append(sb.substring(0, sizeWord-2)).append("ні");
            return sb1.substring(0);
        }

        else{
            sb1.append(sb.substring(0, sizeWord)).append("у");
            return sb1.substring(0);
        }
    } //меняем окончание отчества

    private String changeFirstName(String list) {

        int sizeWord = list.length();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        sb.append(list);

        if(sb.substring(sizeWord-1).toLowerCase(Locale.ROOT).equals("о")){
            sb1.append(sb.substring(0, sizeWord-1)).append("у");
            return sb1.substring(0);
        }
        if(sb.substring(0).equals("Ігор")){
            return "Ігорю";
        }
        if(sb.substring(0).equals("Джоні")){
            return "Джоні";
        }
        if(sb.substring(sizeWord-1).toLowerCase(Locale.ROOT).equals("р")){
            sb1.append(sb.substring(0, sizeWord-1)).append("ру");
            return sb1.substring(0);
        }
        if(sb.substring(sizeWord-2).toLowerCase(Locale.ROOT).equals("ія")){
            sb1.append(sb.substring(0, sizeWord-2)).append("ії");
            return sb1.substring(0);
        }
        if(sb.substring(sizeWord-2).toLowerCase(Locale.ROOT).equals("ій")){
            sb1.append(sb.substring(0, sizeWord-2)).append("ію");
            return sb1.substring(0);
        }
        if(sb.substring(sizeWord-2).toLowerCase(Locale.ROOT).equals("та")){
            sb1.append(sb.substring(0, sizeWord-2)).append("ті");
            return sb1.substring(0);
        }
        if(sb.substring(sizeWord-2).toLowerCase(Locale.ROOT).equals("на")){
            sb1.append(sb.substring(0, sizeWord-2)).append("ні");
            return sb1.substring(0);
        }
        if(sb.substring(sizeWord-2).toLowerCase(Locale.ROOT).equals("ла")){
            sb1.append(sb.substring(0, sizeWord-2)).append("лі");
            return sb1.substring(0);
        }
        if(sb.substring(sizeWord-2).toLowerCase(Locale.ROOT).equals("ль")){
            sb1.append(sb.substring(0, sizeWord-2)).append("лю");
            return sb1.substring(0);
        }
        if(sb.substring(sizeWord-2).toLowerCase(Locale.ROOT).equals("ра")){
            sb1.append(sb.substring(0, sizeWord-2)).append("рі");
            return sb1.substring(0);
        }
        if(sb.substring(sizeWord-2).toLowerCase(Locale.ROOT).equals("га")){
            sb1.append(sb.substring(0, sizeWord-2)).append("зі");
            return sb1.substring(0);
        }

        else{
            sb1.append(sb.substring(0, sizeWord)).append("у");
            return sb1.substring(0);
        }
    } //меняем окончание имени

    private String changeSurname(String list) {

        int sizeWord = list.length();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        sb.append(list);
        //System.out.println(sb.substring(sizeWord-1));
        if(sb.substring(sizeWord-1).toLowerCase(Locale.ROOT).equals("о")){
            sb1.append(sb.substring(0, sizeWord-1)).append("У");
            return sb1.substring(0);
        }
        if(sb.substring(sizeWord-2).toLowerCase(Locale.ROOT).equals("ка")){
            sb1.append(sb.substring(0, sizeWord-2)).append("ЦІ");
            return sb1.substring(0);
        }

        if(sb.substring(sizeWord-2).toLowerCase(Locale.ROOT).equals("ха")){
            sb1.append(sb.substring(0, sizeWord-2)).append("СІ");
            return sb1.substring(0);
        }

        if(sb.substring(sizeWord-2).toLowerCase(Locale.ROOT).equals("ія")){
            sb1.append(sb.substring(0, sizeWord-2)).append("ІЮ");
            return sb1.substring(0);
        }

        if(sb.substring(sizeWord-1).toLowerCase(Locale.ROOT).equals("я")){
            sb1.append(sb.substring(0, sizeWord-1)).append("І");
            return sb1.substring(0);
        }

        if(sb.substring(sizeWord-2).toLowerCase(Locale.ROOT).equals("ій")){
            sb1.append(sb.substring(0, sizeWord-2)).append("ІЮ");
            return sb1.substring(0);
        }

        if(sb.substring(0).toLowerCase(Locale.ROOT).equals("швець")){
            return "ШВЕЦЮ";
        }

        if(sb.substring(0).toLowerCase(Locale.ROOT).equals("орел")){
            return "ОРЛУ";
        }
        if(sb.substring(0).toLowerCase(Locale.ROOT).equals("фрунзе")){
            return "ФРУНЗЕ";
        }

        if(sb.substring(0).equals("ГАЛІШТЕЙ")){
            return "ГАЛІШТЕЙ";
        }
        if(sb.substring(0).equals("ЦИТЛІШВІЛІ")){
            return "ЦИТЛІШВІЛІ";
        }

        if(sb.substring(sizeWord-3).toLowerCase(Locale.ROOT).equals("ець")){
            sb1.append(sb.substring(0, sizeWord-3)).append("ЦЮ");
            return sb1.substring(0);
        }
        if(sb.substring(sizeWord-3).toLowerCase(Locale.ROOT).equals("нок")){
            sb1.append(sb.substring(0, sizeWord-3)).append("НКУ");
            return sb1.substring(0);
        }

        if(sb.substring(sizeWord-1).toLowerCase(Locale.ROOT).equals("ь")){
            sb1.append(sb.substring(0, sizeWord-1)).append("Ю");
            return sb1.substring(0);
        }

        if(sb.substring(sizeWord-1).toLowerCase(Locale.ROOT).equals("й")){
            sb1.append(sb.substring(0, sizeWord-2)).append("ОМУ");
            return sb1.substring(0);
        }

        if(sb.substring(sizeWord-1).toLowerCase(Locale.ROOT).equals("а")){
            sb1.append(sb.substring(0, sizeWord-1)).append("І");
            return sb1.substring(0);
        }

        else
        {
            sb1.append(sb.substring(0, sizeWord)).append("У");
            return sb1.substring(0);
        }

    } //мемняю фамилию

    private String changePosition(String list) {

        int[] indexCh =getCharArrayFromList(list);

        String lineReturn = getStringLine(indexCh, list);

   return lineReturn;} //меняю должность

    private String getStringLine(int[] indexCh, String list) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        sb.append(list);
        String word1 = sb.substring(0, indexCh[0]);
        String word2;
        if(indexCh.length > 2 && indexCh.length < 8){
            word1 = changeWordEnd(word1);
            word2 = getWordSecond(indexCh, list);
            word2 = changeWordEnd(word2);
            sb1.append(word1).append(word2).append(sb.substring(indexCh[1]).substring(0));
            return sb1.substring(0);
        }
        else
        {
            word1 = changeWordEnd(word1);
           sb1.append(word1).append(sb.substring(indexCh[0]).substring(0));
           return sb1.substring(0);
        }
    } //возвращает строку для вывода

    private String changeWordEnd(String list) {
        //System.out.println("@ - " + list);
        int sizeWord = list.length();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        sb.append(list);

        if(sb.substring(sizeWord-3).toLowerCase(Locale.ROOT).equals("дир")){
            sb1.append(sb.substring(0, sizeWord-3)).append("диру");
            return sb1.substring(0);
        }

        if(sb.substring(sizeWord-3).toLowerCase(Locale.ROOT).equals("ник")){
            sb1.append(sb.substring(0, sizeWord-3)).append("нику");
            return sb1.substring(0);
        }

        if(sb.substring(sizeWord-3).toLowerCase(Locale.ROOT).equals("ший")){
            sb1.append(sb.substring(0, sizeWord-3)).append("шому");
            return sb1.substring(0);
        }

        if(sb.substring(sizeWord-3).toLowerCase(Locale.ROOT).equals("тор")){
            sb1.append(sb.substring(0, sizeWord-3)).append("тору");
            return sb1.substring(0);
        }
        if(sb.substring(0).toLowerCase(Locale.ROOT).equals("інспектор–черговий")){
            sb1.append("інспектору-черговому");
            return sb1.substring(0);
        }

        if(sb.substring(sizeWord-3).toLowerCase(Locale.ROOT).equals("нер")){
            sb1.append(sb.substring(0, sizeWord-3)).append("неру");
            return sb1.substring(0);
        }
        if(sb.substring(sizeWord-3).toLowerCase(Locale.ROOT).equals("ина")){
            sb1.append(sb.substring(0, sizeWord-3)).append("ині");
            return sb1.substring(0);
        }
        if(sb.substring(0).toLowerCase(Locale.ROOT).equals("поліцейський-водій")){
            sb1.append("поліцейському-водію");
            return sb1.substring(0);
        }
        if(sb.substring(sizeWord-3).toLowerCase(Locale.ROOT).equals("кий")){
            sb1.append(sb.substring(0, sizeWord-3)).append("кому");
            return sb1.substring(0);
        }

        if(sb.substring(0).toLowerCase(Locale.ROOT).equals("інспектор-снайпер")){
            sb1.append("інспектору-снайперу");
            return sb1.substring(0);
        }

        if(sb.substring(sizeWord-3).toLowerCase(Locale.ROOT).equals("лог")){
            sb1.append(sb.substring(0, sizeWord-3)).append("логу");
            return sb1.substring(0);
        }

        else
            return list;

    } // меняем окончание словa

    private String getWordSecond(int[] indexCh, String list) {
        //System.out.println(indexCh.length + " # " + list + " l -" + list.length());
        String word2;
        StringBuilder sb = new StringBuilder();
        sb.append(list);
        word2 = sb.substring(indexCh[0], indexCh[1]);

    return  word2;} // ищем второе слово

    private int[] getCharArrayFromList(String list) {
        char[] ch =list.toCharArray();
        int count = 1;
        for (int i = 0; i < ch.length; i++) {
            if(ch[i] == 32)
                count++;
        }
        int[] indexCh = new int[count];
        int j = 0;

        for (int i = 0; i < ch.length; i++) {
            if((int)ch[i] == 32) {
                indexCh[j] = i;
                j++;  }
        }
    return  indexCh;} // возвращает индекс пробелов в строке
}
