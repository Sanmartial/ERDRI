package ApplicationReZerV.MissionEmployees;

import ApplicationReZerV.CommonMethods.CommonMethods;
import ApplicationReZerV.RZ_Day.WriteReaderRZ;

import java.io.IOException;
import java.util.List;

public class MainMethodMission {
    public static void main(String[] args) throws IOException {
        String pathListEmployees = "D:\\Test\\MissionEmployees\\listEmployees.txt";
        String pathResult = "D:\\Test\\MissionEmployees\\result.txt";


        SeparateList separateList = new SeparateList();
        //WriteReaderRZ showList = new WriteReaderRZ();

        List<String> listEmployees = CommonMethods.readerListEmployee(pathListEmployees);//считываю список работников с текстового файла
        separateList.setListEmployees(listEmployees); //передаю его для разделения на нужные составляющие
        List<String> listResult = separateList.separateListEmployees();
        CommonMethods.writeList(listResult, pathResult);


        //showList.showList(listResult);



    }

}
