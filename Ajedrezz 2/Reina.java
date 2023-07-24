import greenfoot.*;  
import java.util.List;
import java.util.ArrayList;
/**

 */
public class Reina extends Piezas {
    Reina(int cd) {
        super(cd);  
        if (this.cd == 1) setImage("ReinaN.png");
        else setImage("ReinaB.png");
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
        d = 1;
        while (getX() + d < 8 && !isOwnPieceAtOffset(d, 0)) {
            list.add(new Posiciones(getX()+d, getY()));
            if (isPieceAtOffset(d, 0)) break;
            d++;
        }
        d = 1;
        while (getX() - d >= 0 && !isOwnPieceAtOffset(-d, 0)) {
            list.add(new Posiciones(getX()-d, getY()));
            if (isPieceAtOffset(-d, 0)) break;
            d++;
        }
        d = 1;
        while (getY() + d < 8 && !isOwnPieceAtOffset(0, d)) {
            list.add(new Posiciones(getX(), getY()+d));
            if (isPieceAtOffset(0, d)) break;
            d++;
        }
        d = 1;
        while (getY() - d >= 0 && !isOwnPieceAtOffset(0, -d)) {
            list.add(new Posiciones(getX(), getY()-d));
            if (isPieceAtOffset(0,-d)) break;
            d++;
        }
        return list;
    } 
}
