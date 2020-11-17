import java.util.ArrayList;

public class TankAllied extends Troop{
    private int unitPerTeam = 3;
    private final int validMove = 4;
    void Move(String movement) {
        int sum  = 0 , i = 0;
        String[] movements = movement.split("\\s");
        while (moveCounter(movements) > validMove || !isValid(movements)) {
            error.moveError();
            movement = input.getInput();
            movements = movement.split("\\s");
        }
        moveSteps(movements);
        canAttack = true;
    }

    void attack(Point point) {
        int pointsBetween = distance.CalculateDistance(this.currentPoint,point);
        if(pointsBetween > 3) {
            error.farError();
            return;
        }
        distance.setDiceCounter(3);
        if(!canAttack){
            error.attackError();
            return;
        }
        else{
            switch (point.getType()) {
                case HILL:
                    distance.decrement(1);
                    break;
                case JUNGLE:
                    distance.decrement(2);
                    break;
                case SHELTER:
                    if (point.getTroop().getTeam().getName() == Team.teamName.AXIS)
                        distance.decrement(2);
            }
        }
        distance.decrement(2);
        ArrayList<String> result = distance.diceResult();
        if(result.contains("5"))
            point.getTroop().kill();
        else {
            if (result.contains("1") || result.contains("6")) {
                if (point.getTroop() instanceof Infantry)
                    point.getTroop().kill();
            } else if (result.contains("2")) {
                if (point.getTroop() instanceof TankAxis)
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
}
