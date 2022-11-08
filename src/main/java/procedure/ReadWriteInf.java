package procedure;

import java.awt.*;
import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import resource.StorageMemory;

public class ReadWriteInf {

    public List<String> readWithCoding(String s) {
        List<String> list = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(s), "UTF-8"))) {
            String line;
            while ((line  = in.readLine()) != null){
                list.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    return list;}

        public void writeWithCodding(String s, StorageMemory storageMemory) throws IOException {
        File file = new File(s);
        try (OutputStream os = new FileOutputStream(file);
        OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8")) {
            for (int i = 0; i < storageMemory.getListResult().size(); i++) {
                osw.write(storageMemory.getListResult().get(i));
                osw.write("\n");
            }
            System.out.println("Информация записана в файл " + Paths.get(s).getFileName());
            Desktop.getDesktop().open(new File(s));
        }

    }

}
