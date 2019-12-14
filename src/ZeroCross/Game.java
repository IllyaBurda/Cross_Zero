package ZeroCross;

public class Game {
    Player firstPlayer;
    Player secondPlayer;
    String[][] battlefield = new String[3][3];

    public Game(Player fistPlayer, Player secondPlayer) {
        this.firstPlayer = fistPlayer;
        this.secondPlayer = secondPlayer;
        PrepareTheField();
    }


    public static void main(String[] args) {
        Player firstPlayer = new Player("John", "zero");
        Player secondPlayer = new Player("Kevin", "cross");
        Game game = new Game(firstPlayer, secondPlayer);
        boolean flagIsGameOver = false;
        while (flagIsGameOver==false) {

            game.firstPlayer.makeMove(game.battlefield);
            flagIsGameOver = game.isGameOver(firstPlayer.figure);
            if (flagIsGameOver != false) {
                break;
            } else {
                game.secondPlayer.makeMove(game.battlefield);
                flagIsGameOver = game.isGameOver(secondPlayer.figure);
            }

        }
    }

    private boolean isGameOver(String playerFigure) {
        boolean result = false;
        int countError = 0;
        if (iStart()) {
            return result;
        }
        for (int i = 0; i < battlefield.length; i++) {
            for (int j = 0; j < battlefield[i].length; j++) {
                if (!playerFigure.equals(battlefield[i][j])) {
                    countError++;
                    break;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!playerFigure.equals(battlefield[j][i])) {
                    countError++;
                    break;
                }
            }
        }

        if (countError < 6) {
            System.out.println(countError+"   qqqqq");
            return whoIsWinner(playerFigure, firstPlayer, secondPlayer);
        }

        if (playerFigure.equals(battlefield[1][1]) && playerFigure.equals(battlefield[0][0]) && playerFigure.equals(battlefield[2][2])) {

            return whoIsWinner(playerFigure, firstPlayer, secondPlayer);
        } else if (playerFigure.equals(battlefield[1][1]) && playerFigure.equals(battlefield[2][0]) && playerFigure.equals(battlefield[0][2])) {

            return whoIsWinner(playerFigure, firstPlayer, secondPlayer);
        }
        return result;

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


    private boolean whoIsWinner(String figureWinner, Player... players) {
        for (int i = 0; i < players.length; i++) {
            System.out.println(figureWinner);
            if (figureWinner.equals(players[i].figure)) {
                System.out.println(players[i].name + " is Winner");
                break;
            }
        }
        return true;
    }

    public void PrepareTheField() {
        for (int i = 0; i < battlefield.length; i++) {
            for (int j = 0; j < battlefield[i].length; j++) {
                battlefield[i][j] = "     ";
            }
        }
    }
}
