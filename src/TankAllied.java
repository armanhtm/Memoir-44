public class TankAllied extends Troop{
    int unitPerTeam = 3;
    final int validMove = 4;
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

}
