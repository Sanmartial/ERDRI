package procedure;

import resource.StorageMemory;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FixList {
     final private List<String> list1 = new ArrayList<>();
    public void listProccess(StorageMemory storageMemory, String[] arrS) {
        String s;
        for (int i = 0; i < storageMemory.getListOne().size(); i++) {
            s = processing(storageMemory.getListOne().get(i));
            if (!compareArr(s, arrS))
                s = "інші";
            list1.add(s);
        }
        storageMemory.setListResult(list1);
    }
    private boolean compareArr(String s, String[] arrS) {
        int count = 0;
        for (String arr : arrS) {
            if (s.equals(arr)) count++;
        }
        return count > 0;
    }
    private String processing(String s) {
        String liner = "";
        Pattern pattern = Pattern.compile("\\d{3}");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            liner = matcher.group();
        }
        return liner;
    }
}

