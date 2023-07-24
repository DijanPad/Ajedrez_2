import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
/**

 */
public class princess extends Piezas
{
    princess(int cd) {
        super(cd);  
        if (this.cd == 1) setImage("PrincesaN.png");
        else setImage("PrincesaB.png");
    }

    public List<Posiciones> getLegalPositions(){
        List<Posiciones> list = new ArrayList<Posiciones>();
        int d = 1;
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
