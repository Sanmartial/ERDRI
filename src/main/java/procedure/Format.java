package procedure;

import resource.SingleFormat;
import resource.StorageMemory;

public class Format implements SingleFormat {
    @Override
    public void format(StorageMemory storageMemory) {

    }

    @Override
    public String stringErdr(String s) {
       String ss = builderLine(s);
       return ss;
    }

    public String builderLine(String s) {
        StringBuilder sb = new StringBuilder(s);
        String ss;
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
    return ss;}
}
