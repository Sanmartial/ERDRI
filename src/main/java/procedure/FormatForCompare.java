package procedure;

import resource.StorageMemory;

import java.util.ArrayList;
import java.util.List;

public class FormatForCompare extends Format {
    public void format(StorageMemory storageMemory) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        for (int i = 0; i < storageMemory.getListOne().size(); i++) {
            list1.add(stringErdr(storageMemory.getListOne().get(i)));
        }

        storageMemory.setListOne(list1);

        for (int i = 0; i < storageMemory.getListTwo().size(); i++) {
            list2.add(stringErdr(storageMemory.getListTwo().get(i)));
        }
        storageMemory.setListTwo(list2);

    }


}
