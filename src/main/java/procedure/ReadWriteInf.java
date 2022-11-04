package procedure;

import java.awt.*;
import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import resource.StorageMemory;

public class ReadWriteInf {

    public List<String> read(String s) {
        List<String> list = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(s)) {
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.rowIterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (cell.getCellType() == CellType.NUMERIC)
                        list.add(String.valueOf(cell.getNumericCellValue()));
                    if (cell.getCellType() == CellType.STRING)
                        list.add(cell.getStringCellValue());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    public List<String> readTxt(String s) {
        List<String> list = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(s))) {
            String line;
            while ((line = bf.readLine()) != null) {
                list.add(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<String> readExFull(String s) {
        List<String> list = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(s)) {
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.rowIterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (cell.getCellType() == CellType.NUMERIC) {
                        list.add(String.valueOf(cell.getNumericCellValue()) + "\t");
                        System.out.print(String.valueOf(cell.getNumericCellValue()) + "\t");
                    }
                    if (cell.getCellType() == CellType.STRING) {
                        list.add(cell.getStringCellValue() + "\t");
                        System.out.print(cell.getStringCellValue() + "\t");
                    }
                }
                list.add("\n");
                System.out.println();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    public void write(String s, StorageMemory storageMemory) throws IOException {
        try(Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("result");
            for (int i = 0; i < storageMemory.getListResult().size(); i++) {
                Row row = sheet.createRow(i);
                row.createCell(0).setCellValue(storageMemory.getListResult().get(i));
            }

            try (FileOutputStream fos = new FileOutputStream(s)) {
                try {
                    workbook.write(fos);
                    System.out.println("Информация записана в файл " + Paths.get(s).getFileName());
                    Desktop.getDesktop().open(new File(s)); //открываем файл для удобства
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }

    public void writeTxt(String s, StorageMemory storageMemory) throws IOException {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(s))) {
            for (int i = 0; i < storageMemory.getListResult().size(); i++) {
                printWriter.println(storageMemory.getListResult().get(i));
            }
            System.out.println("Информация записана в файл " + Paths.get(s).getFileName());
            Desktop.getDesktop().open(new File(s));
        }


    }

}
