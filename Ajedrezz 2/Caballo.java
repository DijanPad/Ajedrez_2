import java.util.List;
import java.util.ArrayList;
/**

 */
public class Caballo extends Piezas
{
    Caballo(int cd) {
        super(cd);  
        if (this.cd == 1) setImage("CaballoN.png");
        else setImage("CaballoB.png");
    }
  
    public List<Posiciones> getLegalPositions(){
        List<Posiciones> list = new ArrayList<Posiciones>();
        if (!isOwnPieceAtOffset(1,2) && isOnBoardDelta(1,2)) {
            list.add(new Posiciones(getX()+1, getY()+2)); 
        }
        if (!isOwnPieceAtOffset(1,-2) && isOnBoardDelta(1,-2)) {
            list.add(new Posiciones(getX()+1, getY()-2)); 
        }
        if (!isOwnPieceAtOffset(-1,2) && isOnBoardDelta(-1,2)) {
            list.add(new Posiciones(getX()-1, getY()+2)); 
        }
        if (!isOwnPieceAtOffset(-1,-2) && isOnBoardDelta(-1,-2)) {
            list.add(new Posiciones(getX()-1, getY()-2)); 
        }
        if (!isOwnPieceAtOffset(-2,1) && isOnBoardDelta(-2,1)) {
            list.add(new Posiciones(getX()-2, getY()+1)); 
        }
        if (!isOwnPieceAtOffset(-2,-1) && isOnBoardDelta(-2,-1)) {
            list.add(new Posiciones(getX()-2, getY()-1)); 
        }
        if (!isOwnPieceAtOffset(2,1) && isOnBoardDelta(2,1)) {
            list.add(new Posiciones(getX()+2, getY()+1)); 
        }
        if (!isOwnPieceAtOffset(2,-1) && isOnBoardDelta(2,-1)) {
            list.add(new Posiciones(getX()+2, getY()-1)); 
        }
        return list;
    } 
}
