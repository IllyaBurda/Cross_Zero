package ZeroCross;

import java.util.Scanner;

public class Player {
    String name;
    String figure;

    public Player(String name, String figure) {
        this.name = name;
        this.figure = figure;
    }

    public void makeMove(String[][] gameField) {
        System.out.println("Введите номер строки!");
        Scanner scanner = new Scanner(System.in);
        int indexRow = scanner.nextInt();
        System.out.println("Введите номер колонки!");
        int indexCol = scanner.nextInt();
        gameField[indexRow][indexCol] = this.figure;
        viewBattlefield(gameField);
    }

    private void viewBattlefield(String[][] gameField) {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                System.out.print("|"+(gameField[i][j].length()<5?gameField[i][j]+" ":gameField[i][j]));
            }
            System.out.println();
        }
    }

}
