import java.util.ArrayList;

public class Board {
    Error error;
    Point[][]points = new Point[9][25];
    public Board(){
        this.resetBoard();
    }
    public Point[][] getPoints() {
        return points;
    }
    public void resetBoard(){
        for(int i = 0; i < 9; i++)
            for(int j = 0; j < 25; j++ )
                points[i][j] = new Point(Point.Type.NORMAL,i,j);
        points[0][2] = new Point(Point.Type.HILL,0,2);
        points[0][0] = new Point(Point.Type.HILL,0,0);
        points[4][22] = new Point(Point.Type.HILL,4,22);
        points[5][21] = new Point(Point.Type.HILL,5,21);
        points[2][12] = new Point(Point.Type.HILL,0,0);
        points[1][13] = new Point(Point.Type.HILL,0,0);
        points[5][9] = new Point(Point.Type.HILL,5,9);
        points[4][10] = new Point(Point.Type.HILL,4,10);
        points[1][9] = new Point(Point.Type.SHELTER,1,9);
        points[1][3] = new Point(Point.Type.RIVER,1,3);
        points[1][5] = new Point(Point.Type.RIVER,1,5);
        points[1][7] = new Point(Point.Type.RIVER,1,7);
        points[2][2] = new Point(Point.Type.RIVER,2,2);
        points[4][0] = new Point(Point.Type.RIVER,4,0);
        points[3][3] = new Point(Point.Type.JUNGLE,3,3);
        points[4][2] = new Point(Point.Type.JUNGLE,4,2);
        points[3][7] = new Point(Point.Type.JUNGLE,3,7);
        points[5][7] = new Point(Point.Type.JUNGLE,5,7);
        points[7][7] = new Point(Point.Type.JUNGLE,7,7);
        points[7][9] = new Point(Point.Type.JUNGLE,7,9);
        points[6][14] = new Point(Point.Type.JUNGLE,5,14);
        points[6][16] = new Point(Point.Type.JUNGLE,5,16);
        points[7][17] = new Point(Point.Type.JUNGLE,7,17);
        points[4][16] = new Point(Point.Type.JUNGLE,4,16);
        points[2][18] = new Point(Point.Type.JUNGLE,2,18);
        points[2][24] = new Point(Point.Type.JUNGLE,2,24);
        points[3][23] = new Point(Point.Type.JUNGLE,3,23);
        points[4][24] = new Point(Point.Type.JUNGLE,4,24);
        points[5][23] = new Point(Point.Type.JUNGLE,5,23);
        points[8][22] = new Point(Point.Type.VILLAGE,8,22);
        points[4][20] = new Point(Point.Type.VILLAGE,4,20);
        points[4][12] = new Point(Point.Type.VILLAGE,4,12);
        points[6][4] = new Point(Point.Type.VILLAGE,6,4);
        points[2][0] = new Point(Point.Type.VILLAGE,2,0);
        points[3][1] = new Point(Point.Type.BRIDGE,3,1);
        points[0][8] = new Point(Point.Type.BRIDGE,0,8);
    }public Point getPoint(int x, int y)
    {
        if (x < 0 || x > 8 || y < 0 || y > 24) {
            error.indexError();
        }
        return points[x][y];
    }
}
