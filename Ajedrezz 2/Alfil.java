import greenfoot.*;
import java.util.List;
import java.util.ArrayList;

/**
 
 */
public class Alfil extends Piezas {
    
    Alfil(int cd) {
        super(cd);  
        if (this.cd == 1) setImage("AlfilNegro.png");
        else setImage("AlfilBlanco.png");
    }
 
    public List<Posiciones> getLegalPositions(){
        List<Posiciones> list = new ArrayList<Posiciones>();
        int d = 1;      
        while (getX() + d < 8 && getY() + d < 8 && !isOwnPieceAtOffset(d, d)) {
            list.add(new Posiciones(getX()+d, getY()+d));
            if (isPieceAtOffset(d, d)) break;
            d++;
        }
        d = 1;
        while (getX() - d >= 0 && getY() + d < 8 && !isOwnPieceAtOffset(-d, d)) {
            list.add(new Posiciones(getX()-d, getY()+d));
            if (isPieceAtOffset(-d, d)) break;
            d++;     
        }
        d = 1;
        while (getX() + d < 8 && getY() - d >= 0 && !isOwnPieceAtOffset(d, -d)) {
            list.add(new Posiciones(getX()+d, getY()-d));
            if (isPieceAtOffset(d, -d)) break;
            d++;
        }
        d = 1;
        while (getX() - d >= 0 && getY() - d >= 0 && !isOwnPieceAtOffset(-d, -d)) {
            list.add(new Posiciones(getX()-d, getY()-d));
            if (isPieceAtOffset(-d,-d)) break;
            d++;
        }
        return list;
    } 
    
   
}
