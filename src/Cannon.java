import java.util.ArrayList;

public class Cannon extends Troop{
    private int unitPerTeam = 2;
    private final int validMove = 1;
    void Move(String movement,Board board) {
            board.getPoint(coordinate.getX(),coordinate.getY()).setTroop(null);
            String[] movements = movement.split("\\s");
            while (moveCounter(movements) > validMove || !isValid(movements)) {
                error.moveError();
                movement = input.getInput();
                movements = movement.split("\\s");
            }
            moveSteps(movements,board);
            if (moveCounter(movements) == 1)
                canAttack = false;
            else
                canAttack = true;
            board.getPoint(coordinate.getX(),coordinate.getY()).setTroop(this);
            currentPoint = board.getPoint(coordinate.getX(),coordinate.getY());
    }

    void attack(Point point) {
        int pointsBetween = distance.CalculateDistance(this.currentPoint,point);
        if(pointsBetween > 6) {
            error.farError();
            return;
        }
        if(pointsBetween == 1 || pointsBetween == 2)
            distance.setDiceCounter(3);
        else
            if(pointsBetween == 3 || pointsBetween == 4)
                distance.setDiceCounter(4);
            else
                distance.setDiceCounter(1);
        if(!canAttack){
            error.attackError();
            return;
        }
        ArrayList<String> result = distance.diceResult();
        if(result.contains("5"))
            point.getTroop().kill();
        else {
            if (result.contains("1") || result.contains("6")) {
                if (point.getTroop() instanceof Infantry)
                    point.getTroop().kill();
            } else if (result.contains("2")) {
                if (point.getTroop() instanceof TankAllied || point.getTroop() instanceof TankAxis)
                    point.getTroop().kill();
            }
            else
                error.badLuck();
        }
    }
    public void die() {
        alive = false;
    }

    public void kill() {
        unitPerTeam --;
        if(unitPerTeam == 0)
            die();
    }
    int livesCounter() {
        return unitPerTeam;
    }
    public String TroopToString(){
        return "Cannon";
    }
}
