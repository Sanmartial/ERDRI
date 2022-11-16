package procedure;

import resource.StorageMemory;

import java.util.ArrayList;
import java.util.List;

public class FormatForFormThree extends Format {
    @Override
    public void format(StorageMemory storageMemory) {
        List<String> list1 = new ArrayList<>();
        for (int i = 0; i < storageMemory.getListOne().size(); i++) {
            list1.add(stringErdr(storageMemory.getListOne().get(i)));
        }
        storageMemory.setListResult(list1);
    }
    public String stringErdr(String s) {
        String line = builderLine(s);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        String s1, s2, s3, s4;
        sb.append(line);
        if (line.contains("120")) {
            s1 = sb.substring(0, 1);
            s2 = sb.substring(1, 5);
            s3 = sb.substring(5, 10);
            s4 = sb.substring(10, 17);//!!!
            return sb1.append(s1).append(" ").append(s2).append(" ").append(s3).append("-").append(s4).substring(0);
        } else
            return "null";
    }
}
