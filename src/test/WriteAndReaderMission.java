package ApplicationReZerV.MissionEmployees;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteAndReaderMission {
    public List<String> reader(String path){
        List<String> list = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while((line = br.readLine()) != null){
                list.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    return list;}

    public void writer(List<String> list, String path){
        int count = 0;
        try(PrintWriter writer = new PrintWriter(path)) {
            for (int i = 0; i < list.size(); i++) {
                count++;
                writer.println(list.get(i));
            }
            System.out.println("write " + count + " row");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
