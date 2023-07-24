import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
/**

 */
public class Rey extends Piezas
{
    Rey(int cd) {
        super(cd);  
        if (cd == 1) setImage("ReyN.png");
        else setImage("reyB.png");
    }
   
    public List<Posiciones> getLegalPositions(){
        List<Posiciones> list = new ArrayList<Posiciones>();
        if (!isOwnPieceAtOffset(1, 0) && isOnBoardDelta(1, 0)) {
            list.add(new Posiciones(getX()+1, getY()));
        }
        if (!isOwnPieceAtOffset(-1, 0) && isOnBoardDelta(-1, 0)) {
            list.add(new Posiciones(getX()-1, getY()));
        }
        if (!isOwnPieceAtOffset(0, 1) && isOnBoardDelta(0, 1)) {
            list.add(new Posiciones(getX(), getY()+1));
        }
        if (!isOwnPieceAtOffset(0, -1) && isOnBoardDelta(0, -1)) {
            list.add(new Posiciones(getX(), getY()-1));
        }
        if (!isOwnPieceAtOffset(1, 1) && isOnBoardDelta(1, 1)) {
            list.add(new Posiciones(getX()+1, getY()+1));
        }
        if (!isOwnPieceAtOffset(-1, 1) && isOnBoardDelta(-1, 1)) {
            list.add(new Posiciones(getX()-1, getY()+1));
        }
        if (!isOwnPieceAtOffset(1, -1) && isOnBoardDelta(1, -1)) {
            list.add(new Posiciones(getX()+1, getY()-1));
        }
        if (!isOwnPieceAtOffset(-1, -1) && isOnBoardDelta(-1, -1)) {
            list.add(new Posiciones(getX()-1, getY()-1));
        }
        return list;
    } 
}
