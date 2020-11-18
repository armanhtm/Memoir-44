import java.util.HashMap;

public class Point {
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
       coordinate = new Coordinate(x,y);
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
    public void print(){
        if(troop == null || !troop.alive)
            troop = null;
        System.out.print("("+ coordinate.getX() + "," + coordinate.getY() + "):");
        if(troop instanceof Infantry)
            System.out.print(troop.livesCounter() + troop.getTeam().getName().name() +
                    "Infantry" + "(" + this.type.name() + ")" + "\t");
        else
        if(troop instanceof TankAllied || troop instanceof TankAxis)
            System.out.print(troop.livesCounter() + troop.getTeam().getName().name() +
                    "Tank" + "(" + this.type.name() + ")" + "\t");
        else
        if(troop instanceof Cannon)
            System.out.print(troop.livesCounter() + troop.getTeam().getName().name() +
                    "Cannon" + "(" + this.type.name() + ")" + "\t");
        else
            System.out.print("EmptyPlace" + "(" + this.type.name() + ")" + "\t");
    }
}
