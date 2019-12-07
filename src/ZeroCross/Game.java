package ZeroCross;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    Player fistPlayer;
    Player secondPlayer;
    String[][] battlefield = new String[3][3];

    public Game(Player fistPlayer, Player secondPlayer) {
        this.fistPlayer = fistPlayer;
        this.secondPlayer = secondPlayer;
        PrepareTheField();
    }


    public static void main(String[] args) {
        Player firstPlayer = new Player("John", "zero");
        Player secondPlayer = new Player("Kevin", "cross");
        Game game = new Game(firstPlayer, secondPlayer);
        while (!game.isGameOver()) {

            game.fistPlayer.makeMove(game.battlefield);
            if (game.isGameOver()) {
                break;
            } else {
                game.secondPlayer.makeMove(game.battlefield);
            }

        }
    }

    private boolean isGameOver() {
        boolean result = false;
        if (iStart()) {
            return result;
        }
        for (int i = 0; i < battlefield.length; i++) {
            boolean isSomeoneWon = true;
            final String etalonFigure = battlefield[i][0];
            for (int j = 0; j < battlefield[i].length; j++) {
                if (!etalonFigure.equals(battlefield[i][j])) {
                    isSomeoneWon = false;
                    break;
                }
            }
            if (isSomeoneWon == true) {
                return whoIsWinner(battlefield[i][0],true);
            }
        }
        for (int i = 0; i < 3; i++) {
            boolean isSomeoneWon = true;
            final String etalonFigure = battlefield[0][i];
            for (int j = 0; j < 3; j++) {
                if (!etalonFigure.equals(battlefield[j][i])) {
                    isSomeoneWon = false;
                    break;
                }
            }
            if (isSomeoneWon == true) {
                return whoIsWinner(battlefield[2][i],true);
            }
        }

        String etalonValue = battlefield[1][1];
        boolean isSomeoneWon = false;
        if ((!etalonValue.trim().equals("")) && etalonValue.equals(battlefield[0][0]) && etalonValue.equals(battlefield[2][2])) {
            isSomeoneWon = true;
        } else if ((!etalonValue.trim().equals("")) && etalonValue.equals(battlefield[2][0]) && etalonValue.equals(battlefield[0][2])) {
            isSomeoneWon = true;
        }

        return whoIsWinner(etalonValue, isSomeoneWon);
    }

    private boolean iStart() {
        StringBuilder result = new StringBuilder();
        for (String[] row : battlefield) {
            for (String cell : row) {
                result = result.append(cell);

            }
        }
        return result.toString().trim().length() == 0 ? true : false;
    }

    private boolean whoIsWinner(String etalonCell, boolean flagWinner) {
        boolean result = true;
        StringBuilder totalString = new StringBuilder();
        for (String[] row : battlefield) {
            for (String cell : row) {
                totalString = totalString.append(cell);
            }
        }
        if (totalString.toString().trim().length() == 0) {
            System.out.println("Ничья!!!");
            return false;
        }
        if (flagWinner == true) {
            if (fistPlayer.figure.equals(etalonCell.trim())) {
                System.out.println("Выиграл : " + fistPlayer.name);
            } else {
                System.out.println("Выиграл : " + secondPlayer.name);
            }
            result=false;
        }
        return result;
    }

    public void PrepareTheField() {
        for (int i = 0; i < battlefield.length; i++) {
            for (int j = 0; j < battlefield[i].length; j++) {
                battlefield[i][j] = "     ";
            }
        }
    }
}
