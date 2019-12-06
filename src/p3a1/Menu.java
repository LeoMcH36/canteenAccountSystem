package p3a1;

import java.util.Scanner;

public class Menu {

    private String title;
    private String[] optionList;

    public Menu(String menuTitle, String[] options) {
        title = menuTitle;
        optionList = options;
    }

    private void displayMenu() {
        int optionCount;
        System.out.println("\n" + title + "\n\n");
        for (optionCount = 0; optionCount < optionList.length;
                optionCount++) {
            System.out.println(optionList[optionCount]);
        }
        System.out.print("\nYour choice? (number) :");
    }

    public int getChoice() {
        Scanner keyb = new Scanner(System.in);
        int choice;
        displayMenu();
        choice = keyb.nextInt();
        return choice;
    }
}
