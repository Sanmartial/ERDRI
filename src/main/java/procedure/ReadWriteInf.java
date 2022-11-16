package procedure;

import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import resource.StorageMemory;

public class ReadWriteInf {
    public List<String> readWithCoding(String s) {
        List<String> list = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(s), StandardCharsets.UTF_8))) {
            String line;
            while ((line = in.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public String writeWithCodding(String s, StorageMemory storageMemory) throws IOException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.YYYY HH.mm");
        File file = new File(s);
        int count = 0;
        try (OutputStream os = new FileOutputStream(file);
             OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8)) {
            for (int i = 0; i < storageMemory.getListResult().size(); i++) {
                osw.write(storageMemory.getListResult().get(i));
                osw.write("\n");
                count++;
            }

            System.out.println("Записано в файл " + Paths.get(s).getFileName() + " " + count + " рядків" + " | " + sdf.format(date) + " |");
            Desktop.getDesktop().open(new File(s));
        }

        return "Записано в файл " + Paths.get(s).getFileName() + " " + count + " рядків" + " | " + sdf.format(date) + " |" + "  (" + storageMemory.getListOne().get(0) + ") ";
    }

    public void writeLine(String path, String line) throws IOException {
        File file = new File(path);
        try (FileWriter writer = new FileWriter(file, StandardCharsets.UTF_8, true)) {
            writer.write(line);
            writer.write("\n");
        }

    }
}