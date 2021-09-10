import java.util.HashMap;
/**
 * @author Arman Hatami
 * @version 1.0
 * point class which is part of main board and stores its coordinate and troop
 */
public class Point {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    enum Type{
        NORMAL,
        VILLAGE,
        HILL,
        RIVER,
        SHELTER,
        JUNGLE,
        BRIDGE
    }
    private Type type;
    private Troop troop;
    Coordinate coordinate;
    public Point(Type type,int x,int y){
       coordinate = new Coordinate();
       coordinate.setX(x);
       coordinate.setY(y);
       this.type = type;
    }
    public void setTroop(Troop troop){
        this.troop = troop;
    }

    public Troop getTroop() {
        return troop;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
    public int getX(){
        return coordinate.getX();
    }
    public int getY(){
        return coordinate.getY();
    }

    public Type getType() {
        return type;
    }

    /**
     * print point info
     */
    public void print(){
        if(troop == null || !troop.alive)
            troop = null;
        if(troop instanceof Infantry) {
            System.out.print(troop.livesCounter() + "I." + troop.getTeam().getBriefName());
            PointToString();
        }
        else
        if(troop instanceof TankAllied || troop instanceof TankAxis) {
            System.out.print(troop.livesCounter() + "T."+ troop.getTeam().getBriefName());
            PointToString();
        }
        else
        if(troop instanceof Cannon) {
            System.out.print(troop.livesCounter() +"C."+ troop.getTeam().getBriefName());
            PointToString();
        }
        else{
            System.out.print("E");
            PointToString();
        }
    }

    /**
     * using different colors print the type and coordinate of this point
     */
    public void PointToString(){
        if(this.type == Type.HILL)
            System.out.print(ANSI_YELLOW+ "(" + coordinate.getX() + "," + coordinate.getY() + ")" + "(H)" + "\t" + ANSI_RESET);
        else
            if(this.type == Type.JUNGLE)
                System.out.print(ANSI_GREEN+"(" + coordinate.getX() + "," + coordinate.getY() + ")" + "(J)" + "\t" + ANSI_RESET);
            else
                if(this.type == Type.RIVER)
                    System.out.print(ANSI_BLUE+"(" + coordinate.getX() + "," + coordinate.getY() + ")" + "(R)" + "\t" + ANSI_RESET);
                else
                    if(this.type == Type.SHELTER)
                        System.out.print(ANSI_CYAN+"(" + coordinate.getX() + "," + coordinate.getY() + ")" + "(S)" + "\t" + ANSI_RESET);
                    else
                        if(this.type == Type.VILLAGE)
                            System.out.print(ANSI_PURPLE+"(" + coordinate.getX() + "," + coordinate.getY() + ")" + "(V)" + "\t" + ANSI_RESET);
                        else
                            if(this.type == Type.BRIDGE)
                                System.out.print(ANSI_RED+"(" + coordinate.getX() + "," + coordinate.getY() + ")" + "(B)" + "\t" + ANSI_RESET);
                            else
                                System.out.print("(" + coordinate.getX() + "," + coordinate.getY() + ")" + "(N)" + "\t");
    }
}
