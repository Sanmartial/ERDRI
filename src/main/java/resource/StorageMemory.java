package resource;

import java.util.List;

public class StorageMemory {

    private List<String> listOne;
    private List<String> listTwo;

    private List<String> listResult;

    public List<String> getListResult() {
        return listResult;
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
