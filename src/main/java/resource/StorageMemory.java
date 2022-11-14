package resource;

import java.util.ArrayList;
import java.util.List;

public class StorageMemory {

    private List<String> listOne;
    private List<String> listTwo;
    private List<String> listResult;
    public List<String> getListResult() {
        return listResult;
    }

    private List <Policeman> listPolicemanOne = new ArrayList<>();
    private List <Policeman> listPolicemanTwo = new ArrayList<>();

    public List<Policeman> getListPolicemanOne() {
        return listPolicemanOne;
    }

    public void setListPolicemanOne(List<Policeman> listPolicemanOne) {
        this.listPolicemanOne = listPolicemanOne;
    }

    public List<Policeman> getListPolicemanTwo() {
        return listPolicemanTwo;
    }

    public void setListPolicemanTwo(List<Policeman> listPolicemanTwo) {
        this.listPolicemanTwo = listPolicemanTwo;
    }

    public void setListResult(List<String> listResult) {
        this.listResult = listResult;
    }

    public List<String> getListOne() {
        return listOne;
    }

    public void setListOne(List<String> listOne) {
        this.listOne = listOne;
    }

    public List<String> getListTwo() {
        return listTwo;
    }

    public void setListTwo(List<String> listTwo) {
        this.listTwo = listTwo;
    }
}
