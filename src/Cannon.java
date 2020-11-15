public class Cannon extends Troop{
    int unitPerTeam = 2;
    final int validMove = 1;
    void Move(String movement) {
        String[] movements = movement.split("\\s");
        while (moveCounter(movements) > validMove || !isValid(movements)) {
            error.moveError();
            movement = input.getInput();
            movements = movement.split("\\s");
        }
        moveSteps(movements);
        if(moveCounter(movements) == 1)
            canAttack = false;
        else
            canAttack = true;
    }
}
