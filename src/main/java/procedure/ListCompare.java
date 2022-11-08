package procedure;

import resource.StorageMemory;

import java.util.ArrayList;
import java.util.List;

public class ListCompare {

    public void compare(StorageMemory storage) {
        int count;
        List<String> listR = new ArrayList<>();
        List<String> listOne = storage.getListOne();
        List<String> listTwo = storage.getListTwo();
        for (int i = 0; i < listOne.size(); i++) {
            count = 0;
            for (int j = 0; j < listTwo.size(); j++) {
                if (equivalentData(listOne.get(i), listTwo.get(j))) {
                    listR.add(listOne.get(i) + " " + listTwo.get(j));
                    //j++;
                } else
                    count++;
            }
            if (count == listTwo.size()) {
                listR.add("--");
            }
        }
        storage.setListResult(listR);
    }

    private boolean equivalentData(String s1, String s2) {

            if(s2.equals(s1))
                return true;
            else
                return false;

    }

    public void compareTxt(StorageMemory storage) {
        int count;
        List<String> listR = new ArrayList<>();
        for (int i = 0; i < storage.getListOne().size(); i++) {
            count = 0;
            for (int j = 0; j < storage.getListTwo().size(); j++) {
                if (storage.getListOne().get(i).equals(storage.getListTwo().get(j))) {
                    listR.add("OK");
                } else
                    count++;
            }
            if (count == storage.getListTwo().size()) {
                listR.add("--");
            }
        }
        storage.setListResult(listR);
    }


}
