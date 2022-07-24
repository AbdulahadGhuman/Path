import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
public class Learning {
    int [] xCoordinatesBad = {};
    int [] yCoordinatesBad = {};
    int [] xCoordinatesGood = {1000000};
    int [] yCoordinatesGood = {1000000};
    ArrayList <Integer> xMoves = new ArrayList <> (0);
    ArrayList <Integer> yMoves = new ArrayList <> (0);
    int xPos = 0;
    int yPos = 0;
    int exists = 0;
    public void badMove () {
        for (int i = 0; i < xMoves.get(i) / 10; i++) {
            
        }
    }
    public void randomMove () {
        int randX = (int) (Math.random() * 2);
        int randY = (int) (Math.random() * 2);
        if(randX == 0) {
            xPos = xPos + 50;
        }
        if(randY == 0) {
            yPos = yPos + 50;
        }
        xMoves.add(xPos);
        yMoves.add(yPos);
    }
    public int checkExists () {
        exists = 0;
        for (int i = 0; i < xCoordinatesGood.length; i++) {
            if(xPos == xCoordinatesGood[i] && yPos == yCoordinatesGood [i]) {
                exists = 1;
            }
        }
         for (int i = 0; i < xCoordinatesBad.length; i++) {
            if((xPos == xCoordinatesBad[i] && yPos == yCoordinatesBad [i]) || (xPos > 1000000 && yPos > 1000000) || (xPos < 0 && yPos < 0)) {
                exists = 2;
            }
        }
        return exists;
    }
    public void alwaysWin () {
        xMoves.add(xPos);
        yMoves.add(yPos);
        List <Integer> newXMoves = new ArrayList <> ();
        List <Integer> newYMoves = new ArrayList <> ();
        while(checkExists () != 1) {
            if(checkExists () == 0) {
                randomMove();
            }
            if(checkExists () == 2) {
                newXMoves = xMoves.subList(0, xMoves.size() / 2);
                xMoves = new ArrayList <> (newXMoves);
                newYMoves = yMoves.subList(0, yMoves.size() / 2);
                yMoves = new ArrayList <> (newYMoves);
                xPos = xMoves.get(xMoves.size() - 1);
                yPos = yMoves.get(yMoves.size() - 1);
            }
        }
    }
    public static void main (String [] args) {
        Learning firstTest = new Learning ();
        firstTest.alwaysWin();
    }
}
