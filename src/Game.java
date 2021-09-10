import java.util.ArrayList;
/**
 * @author Arman Hatami
 * @version 1.0
 * game class to adjust and control main orders in game
 */
public class Game {
    Input input = new Input();
    Error error = new Error();
    private Player[] players;
    private Board board;
    private Player currentTurn;
    enum GameStatus{
        ACTIVE,
        ALLIED_WIN,
        AXIS_WIN
    }
    public Game(){
        players = new Player[2];
        board = new Board();
    }
    private GameStatus gameStatus;

    /**
     * adjusting first turn in the game
     * @param p1
     * @param p2
     */
    public void init(Player p1,Player p2){
        players[0] = p1;
        players[1] = p2;
        if(p1.getTeam().getName() == Team.teamName.ALLIED)
            currentTurn = p1;
        else
            currentTurn = p2;
    }
    public boolean isEnd()
    {
        return this.gameStatus != GameStatus.ACTIVE;
    }
    public void setStatus(GameStatus status)
    {
        this.gameStatus = status;
    }
    public Player[] getPlayers(){
        return players;
    }

    /**
     * printing the main board of the game
     */
    public void printBoard(){
        for(int i = 0;i < 9;i ++){
            for(int j = 0;j < 25; j += 2){
                if(j == 0)
                    if(i % 2 == 1) {
                        j = 1;
                        System.out.print("\t");
                    }
                board.getPoint(i,j).print();
            }
            System.out.println("\n");
        }
    }

    /**
     * setting players troops on the map
     * @param player
     */
    public void insertion(Player player){
        int select;
        int xCoordinate;
        int yCoordinate;
        while(true) {
            player.getTeam().printTroops();
            System.out.println("select which item to want to insert:");
            select = input.getInteger();
            while(select > player.getTeam().getTroopsInsertion().size()){
                error.indexError();
                select = input.getInteger();
            }
            System.out.println("please enter the coordinate you want to place this troop:");
            xCoordinate = input.getInteger();
            yCoordinate = input.getInteger();
            if (player.getTeam().getName() == Team.teamName.ALLIED)
                while (xCoordinate < 3 || yCoordinate > 24 ||board.getPoint(xCoordinate,yCoordinate).getTroop() != null||
                        board.getPoint(xCoordinate,yCoordinate).getType() == Point.Type.RIVER
                        || (board.getPoint(xCoordinate,yCoordinate).getType() == Point.Type.SHELTER && (player.getTeam()
                        .getTroopsInsertion().get(select - 1) instanceof TankAxis || player.getTeam()
                        .getTroopsInsertion().get(select - 1) instanceof TankAllied || player.getTeam()
                        .getTroopsInsertion().get(select - 1) instanceof Cannon))) {
                    error.coordinateError();
                    xCoordinate = input.getInteger();
                    yCoordinate = input.getInteger();
                }
            else
                while (xCoordinate > 2 || yCoordinate > 24 ||board.getPoint(xCoordinate,yCoordinate).getTroop() != null||
                        board.getPoint(xCoordinate,yCoordinate).getType() == Point.Type.RIVER
                        || (board.getPoint(xCoordinate,yCoordinate).getType() == Point.Type.SHELTER && (player.getTeam()
                        .getTroopsInsertion().get(select - 1) instanceof TankAxis || player.getTeam()
                        .getTroopsInsertion().get(select - 1) instanceof TankAllied || player.getTeam()
                        .getTroopsInsertion().get(select - 1) instanceof Cannon))) {
                    error.coordinateError();
                    xCoordinate = input.getInteger();
                    yCoordinate = input.getInteger();
                }
            board.getPoint(xCoordinate, yCoordinate).setTroop(player.getTeam()
                    .getTroopsInsertion().get(select - 1));
            player.getTeam().getTroopsInsertion().get(select - 1).setTeam(player.getTeam());
            player.getTeam().getTroopsInsertion().get(select - 1).setCoordinate(xCoordinate,yCoordinate);
            player.getTeam().getTroopsInsertion().get(select - 1).setCurrentPoint(board.getPoint(xCoordinate,yCoordinate));

            player.getTeam().getTroopsInsertion().remove(player.getTeam()
                    .getTroopsInsertion().get(select - 1));
            System.out.println("done!");
            printBoard();
            if (player.getTeam().getTroopsInsertion().size() == 0)
                break;
        }
    }

    public Player getCurrentTurn() {
        return currentTurn;
    }

    public Board getBoard() {
        return board;
    }
    public void changeTurn(){
        if(currentTurn == players[0])
            currentTurn = players[1];
        else
            currentTurn = players[0];
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }
}
