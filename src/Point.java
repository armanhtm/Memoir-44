import java.util.HashMap;

public class Point {
    enum Type{
        VILLAGE,
        HILL,
        RIVER,
        SHELTER,
        JUNGLE
    }
    private Type type;
    private Troop troop;
    Coordinate coordinate;
    public Point(String type,int x,int y){
       coordinate = new Coordinate(x,y);
       this.type = Type.valueOf(type);
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
}
