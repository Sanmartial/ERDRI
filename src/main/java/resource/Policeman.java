package resource;

import java.util.Objects;

public class Policeman {
    private int ID;
    private String rank; //звание
    private String surname; // фамилия
    private String firstName; // имя
    private String shortName; // инициалы
    private String patronymic; //отчество
    private String tokenID; // номер жетона
    private String Position; // должность
    private String unit; // подразделение короткий номер
    private String changeless; //фиксируем изменение
    private String TenChar;
    private String nameAndPatronymic;


    public Policeman(int ID, String rank, String surname, String firstName, String shortName, String patronymic, String tokenID, String position, String unit) {
        this.ID = ID;
        this.rank = rank;
        this.surname = surname;
        this.firstName = firstName;
        this.shortName = shortName;
        this.patronymic = patronymic;
        this.tokenID = tokenID;
        this.Position = position;
        this.unit = unit;
    }

    @Override
    public String toString() {
        return rank + " " + surname + " " + firstName + " " + patronymic + " " + tokenID + " " + Position + " " + unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Policeman policeman = (Policeman) o;
        return rank.equals(policeman.rank) && surname.equals(policeman.surname) && Position.equals(policeman.Position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, surname, Position);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getShortName() {
        return shortName;
    }

    public void setNameAndPatronymic(String nameAndPatronymic) {
        this.nameAndPatronymic = nameAndPatronymic;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getChangeless() {
        return changeless;
    }

    public void setChangeless(String changeless) {
        this.changeless = changeless;
    }

    public String getRank() {
        return rank;
    }

    public void setTenChar(String tenChar) {
        TenChar = tenChar;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getTokenID() {
        return tokenID;
    }


    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getUnit() {
        return unit;
    }


}
