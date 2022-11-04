package procedure;

import java.util.Scanner;

public class UserChoice {
    private int choice;
    private int fix;

    public int getFix() {
        return fix;
    }

    public void setFix() {
        System.out.println("Внимание, если преобразовывать нужно для ГУ - нажми 1, если для ДПД - нажми 2");
        Scanner scanner = new Scanner(System.in);
        this.fix = scanner.nextInt();
    }

    public void choice() {
        Scanner scanner = new Scanner(System.in);
        this.choice = scanner.nextInt();
    }

    public int getChoice() {
        return choice;
    }


}
