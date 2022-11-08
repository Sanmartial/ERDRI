package procedure;

import resource.SingleFormat;
import resource.StorageMemory;

import java.util.ArrayList;
import java.util.List;

public class FormatForFormFour extends Format {
    public void format(StorageMemory storageMemory) {
        List<String> list1 = new ArrayList<>();
        for (int i = 0; i < storageMemory.getListOne().size(); i++)
            list1.add(stringErdr(storageMemory.getListOne().get(i)));
        storageMemory.setListResult(list1);
    }//приводим строки к единому формату в 17 символов

    public String stringErdr(String s) {
        String ss=builderLine(s);
        return ss+"000";
    }
}
