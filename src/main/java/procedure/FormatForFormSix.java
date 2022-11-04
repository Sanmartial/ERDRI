package procedure;

import resource.SingleFormat;
import resource.StorageMemory;

import java.util.ArrayList;
import java.util.List;

public class FormatForFormSix implements SingleFormat {

    @Override
    public void format(StorageMemory sm) {
        List<String> listResult = new ArrayList<>();
        for (int i = 0; i < sm.getListOne().size(); i++) {
            listResult.add(sm.getListOne().get(i)+"\t");
            for (int j = 0; j < 5; j++) {
                if (j == 4) {
                    listResult.add(stringErdr(sm.getListOne().get(i)));
                } else {
                    listResult.add("");
                }
            }
        }
        sm.setListResult(listResult);
    }

    @Override
    public String stringErdr(String s) {
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == 'Т') ch[i] = '-';
            if (ch[i] == 'Н') ch[i] = '-';
            if (ch[i] == 'В') ch[i] = '-';
            if (ch[i] == 'T') ch[i] = '-';
            if (ch[i] == 'H') ch[i] = '-';
            if (ch[i] == 'B') ch[i] = '-';
            sb.append(ch[i]);
        }

        return sb.substring(0);
    }
}
