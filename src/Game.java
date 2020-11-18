import java.util.ArrayList;

public class Game {
    Input input = new Input();
    Error error = new Error();
    private Player[] players;
    private Board board;
    private Player currentTurn;
    private enum GameStatus{
        ACTIVE,
        ALLIED_WIN,
        AXIS_WIN
    }
    public Game(){
        players = new Player[2];
        board = new Board();
    }
    private GameStatus gameStatus;
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
    public void playerMove(Player player,Point start,String movements)
    {
        if(!player.getTeam().getTroops().contains(start.getTroop()))
            error.property();
        start.getTroop().Move(movements,board);
    }
    public void playerAttack(Player player,Point start,Point target)
    {
        if(!player.getTeam().getTroops().contains(start.getTroop()))
            error.property();
        start.getTroop().attack(target);
    }
    public void printBoard(){
        for(int i = 0;i < 9;i++){
            for(int j = 0;j< 25;j+=2){
                if(j == 0)
                    if(i % 2 == 1)
                        j = 1;
                board.getPoint(i,j).print();
            }
            System.out.println();
        }
    }
    public void insertion(Player player){
        int select;
        String coordinate;
        while(true) {
            player.getTeam().printTroops();
            System.out.println("select which item to want to insert:");
            select = input.getInteger();
            System.out.println("please enter the coordinate you want to place this troop:");
            coordinate = input.getInput();
            if (player.getTeam().getName() == Team.teamName.ALLIED)
                while (coordinate.charAt(0) < 3 || coordinate.charAt(1) > 24) {
                    error.coordinateError();
                    coordinate = input.getInput();
                }
            else
                while (coordinate.charAt(0) > 2 || coordinate.charAt(1) > 24) {
                    error.coordinateError();
                    coordinate = input.getInput();
                }
            Coordinate temp = new Coordinate(coordinate.charAt(0), coordinate.charAt(1));
            board.getPoint(temp.getX(), temp.getY()).setTroop(player.getTeam()
                    .getTroopsInsertion().get(select - 1));
            board.getPoint(temp.getX(), temp.getY()).getTroop().currentPoint = board.getPoint(temp.getX(), temp.getY());
            board.getPoint(temp.getX(), temp.getY()).getTroop().coordinate = temp;
            player.getTeam().getTroopsInsertion().remove(player.getTeam()
                    .getTroopsInsertion().get(select - 1));
            if (player.getTeam().getTroopsInsertion().size() == 0)
                break;
            printBoard();
        }
        System.out.println("done!");
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
}
