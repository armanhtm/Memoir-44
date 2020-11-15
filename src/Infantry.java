public class Infantry extends Troop{
    int unitPerTeam = 4;
    final int validMove = 2;
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
        if(canAttack){

        }
    }
}
