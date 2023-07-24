import greenfoot.*;  
import java.util.List;
import java.util.ArrayList;
/**

 */
public class Barbaro extends Piezas {

    boolean SeMovio = false;

    Barbaro(int cd) {
        super(cd);  
        if (this.cd == 1) setImage("BarbaroN.png");
        else setImage("BarbaroB.png");
    }

    public List<Posiciones> getLegalPositions(){
        List<Posiciones> list = new ArrayList<Posiciones>();
        if (!SeMovio) {
            list.add(new Posiciones(getX(), getY() + 2*this.cd));
        }
        list.add(new Posiciones(getX(), getY() + this.cd));
        Piezas p1 = (Piezas) getOneObjectAtOffset(-1, this.cd, Piezas.class);
        Piezas p2 = (Piezas) getOneObjectAtOffset(1, this.cd, Piezas.class);
        if (p1!=null && p1.cd() == -this.cd) list.add(new Posiciones(p1));
        if (p2!=null && p2.cd() == -this.cd) list.add(new Posiciones(p2));

        return list;
    } 

    public void move(Posiciones p) {
        SeMovio = true;
        super.move(p);
    }
}