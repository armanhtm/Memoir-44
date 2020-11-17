import java.util.ArrayList;

public class Infantry extends Troop{
    private int unitPerTeam = 4;
    private final int validMove = 2;
    void Move(String movement) {
        String[] movements = movement.split("\\s");
        while (moveCounter(movements) > validMove || !isValid(movements)) {
            error.moveError();
            movement = input.getInput();
            movements = movement.split("\\s");
        }
        moveSteps(movements);
        if(moveCounter(movements) == 2)
            canAttack = false;
        else
            canAttack = true;
    }

    void attack(Point point) {
        int pointsBetween = distance.CalculateDistance(this.currentPoint,point);
        if(pointsBetween > 3) {
            error.farError();
            return;
        }
        distance.setDiceCounter(4 - pointsBetween);
        if(canAttack){
            switch (point.getType()) {
                case HILL:
                case JUNGLE:
                    distance.decrement(1);
                    break;
                case SHELTER:
                    if (point.getTroop().getTeam().getName() == Team.teamName.AXIS)
                        distance.decrement(1);
            }
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

    public void die(){
        alive = false;
    }

    public void kill(){
        unitPerTeam --;
        if(unitPerTeam == 0)
            die();
    }
}
