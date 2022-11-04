package procedure;

import resource.StorageMemory;

import java.util.ArrayList;
import java.util.List;

public class ListCompare {

    public void compare(StorageMemory storageMemory) {
        int count;
        List<String> listR = new ArrayList<>();
        for (int i = 0; i < storageMemory.getListOne().size(); i++) {
            count = 0;
            for (int j = 0; j < storageMemory.getListTwo().size(); j++) {
                if (storageMemory.getListOne().get(i).equals(storageMemory.getListTwo().get(j))) {
                    listR.add(lineString(storageMemory.getListOne().get(i), storageMemory.getListTwo().get(j)));
                } else
                    count++;
            }
            if (count == storageMemory.getListTwo().size()) {
                listR.add("--");
            }
        }
        storageMemory.setListResult(listR);
    }

    public void compareTxt(StorageMemory storageMemory) {
        int count;
        List<String> listR = new ArrayList<>();
        for (int i = 0; i < storageMemory.getListOne().size(); i++) {
            count = 0;
            for (int j = 0; j < storageMemory.getListTwo().size(); j++) {
                if (storageMemory.getListOne().get(i).equals(storageMemory.getListTwo().get(j))) {
                    listR.add("OK");
                } else
                    count++;
            }
            if (count == storageMemory.getListTwo().size()) {
                listR.add("--");
            }
        }
        storageMemory.setListResult(listR);
    }

    private String lineString(String s, String s1) {
        StringBuilder sb = new StringBuilder();
        sb.append(s).append("  ").append(s1);
        return sb.substring(0);
    }
}
