package procedure;

import resource.Policeman;
import resource.StorageMemory;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CompareListEmp {
    public void compareEmployees(StorageMemory storageMemory) {
        List<Policeman> list = checkEmployees(storageMemory.getListPolicemanOne(), storageMemory.getListPolicemanTwo());
        list.sort(Comparator.comparingInt(Policeman::getID));
        storageMemory.setListResult(forWriteToList(list));
    }
    private static List<String> forWriteToList(List<Policeman> listResult2) {
        List<String> list = new ArrayList<>();
        for (Policeman policeman : listResult2) {
            list.add(policeman.getUnit() + "\t" + policeman.getRank() + " " + policeman.getSurname() + " " + policeman.getFirstName() + " " + policeman.getPatronymic() +
                    " " + policeman.getPosition() + policeman.getChangeless());
        }
        return list;
    }
    private static List<Policeman> checkEmployees(List<Policeman> listPolicePresent, List<Policeman> listPolicePrevous) {
        List<Policeman> listResult2 = new ArrayList<>();
        int count;
        for (Policeman policeman : listPolicePresent) {
            count = 0;
            for (Policeman policePrevous : listPolicePrevous) {
                if (policeman.equals(policePrevous)) ;
                else count++;
            }
            if (count == listPolicePrevous.size()) {
                listResult2.add(checkChanges(policeman, listPolicePrevous));
            }
        }
        for (Policeman policePrevous : listPolicePrevous) {
            count = 0;
            for (Policeman policeman : listPolicePresent) {
                if (policePrevous.getSurname().equals(policeman.getSurname())) ;
                else count++;
            }
            if (count == listPolicePresent.size()) {
                policePrevous.setChangeless("\tВИБУВ");
                listResult2.add(policePrevous);
            }
        }
        return listResult2;
    } //проверка на изменения
    private static Policeman checkChanges(Policeman policeman, List<Policeman> listPolicePrevous) {
        int countFN = 0;
        int countPos = 0;
        int countRank = 0;
        for (Policeman policePrevous : listPolicePrevous) {
            if (policeman.getSurname().equals(policePrevous.getSurname()) && policeman.getRank().equals(policePrevous.getRank()))
                ;
            else
                countRank++;
        }
        for (Policeman policePrevous : listPolicePrevous) {
            if (policeman.getSurname().equals(policePrevous.getSurname()) && policeman.getFirstName().equals(policePrevous.getFirstName()))
                ;
            else
                countFN++;
        }
        for (Policeman policePrevous : listPolicePrevous) {
            if (policeman.getSurname().equals(policePrevous.getSurname()) && policeman.getPosition().equals(policePrevous.getPosition()))
                ;
            else
                countPos++;
        }
        if (countPos == listPolicePrevous.size() && countFN != listPolicePrevous.size() && countRank != listPolicePrevous.size())
            policeman.setChangeless("\tзмінилась посада");
        if (countFN == listPolicePrevous.size() && countPos == listPolicePrevous.size() && countRank == listPolicePrevous.size())
            policeman.setChangeless("\tНОВИЙ");
        if (countFN != listPolicePrevous.size() && countPos != listPolicePrevous.size() && countRank == listPolicePrevous.size())
            policeman.setChangeless("\tзмінилось звання");
        if (countFN != listPolicePrevous.size() && countPos == listPolicePrevous.size() && countRank == listPolicePrevous.size())
            policeman.setChangeless("\tзмінилися звання та посада");
        return policeman;
    } //изменения в должности и звании, а также новый сотрудник
}

