import greenfoot.*;
import java.util.List;
/**
 * 1 = Negro, -1 = Blanco
 */
public abstract class Piezas extends Actor {
    int cd;
    boolean Seleccionado;

    Piezas() {
        super();
    }

    Piezas(int cd) {
        super();
        this.cd = cd;
        Seleccionado = false;
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            select();
        }
    }  

    public void select() {
        if (((Tablero)getWorld()).select(this, cd)) {
            Seleccionado = true;
        }
        adjustAppearance();
    }
    
    public void unselect() {
        Seleccionado = false;
        adjustAppearance();
    }

    private void adjustAppearance() {
        if (Seleccionado) getImage().setTransparency(50);
        else getImage().setTransparency(255); 
    }
    
    public int cd() {
        return this.cd;
    }

    public void move(Posiciones p) {
        Seleccionado = false;
        setLocation(p.getX(),p.getY());
    }

    public abstract List<Posiciones> getLegalPositions();

    public boolean isPieceAtOffset(int dx, int dy) {
        return getOneObjectAtOffset(dx, dy, Piezas.class) != null;
    }

    public boolean isOwnPieceAtOffset(int dx, int dy) {
        return isPieceAtOffset(dx, dy) && cd == ((Piezas)getOneObjectAtOffset(dx, dy, Piezas.class)).cd();
    }
    
    public boolean isOnBoardDelta(int dx, int dy) {
        return getX()+dx < 8 && getX()+dx >=0 && getY()+dy < 8 && getY()+dy >= 0; 
    }
}
