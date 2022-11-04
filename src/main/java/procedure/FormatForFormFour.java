package procedure;

import resource.SingleFormat;
import resource.StorageMemory;

import java.util.ArrayList;
import java.util.List;

public class FormatForFormFour implements SingleFormat {
    public void format(StorageMemory storageMemory) {
        List<String> list1 = new ArrayList<>();
        for (int i = 0; i < storageMemory.getListOne().size(); i++)
            list1.add(stringErdr(storageMemory.getListOne().get(i)));
        storageMemory.setListResult(list1);
    }//приводим строки к единому формату в 17 символов

    public String stringErdr(String s) {
        StringBuilder sb = new StringBuilder();
        String ss;
        sb.append(s);
        if (sb.indexOf("№") >= 0)
            sb.deleteCharAt(sb.indexOf("№"));
        while ((sb.indexOf(" ")) >= 0)
            sb.deleteCharAt(sb.indexOf(" "));
        if (sb.indexOf("-") >= 0)
            sb.deleteCharAt(sb.indexOf("-"));
        ss = sb.substring(0);
        if (sb.length() > 17) {
            ss = sb.substring(0, 17);
        }
        return ss+"000";
    }
}
