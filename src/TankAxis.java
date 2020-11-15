public class TankAxis extends Troop{
    int unitPerTeam = 4;
    final int validMove = 4;
    void Move(String movement) {
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
