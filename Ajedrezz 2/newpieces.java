import greenfoot.*;  
import java.util.List;
import java.util.ArrayList;

/**

 */
public class newpieces extends World {

    boolean isPieceSelected;
    Piezas PiezaSelec = new Extra();
    int Turno; 

    public newpieces() {    
        super(8, 8, 50); 
        for (int i = 0; i < 8; i++) {
            addObject(new Peon(1), i, 1);
        }
        addObject(new princess(1), 0, 0);
        addObject(new princess(1), 7, 0);
        addObject(new Buffon(1), 1, 0);
        addObject(new Buffon(1), 6, 0);
        addObject(new Mago(1), 2, 0);
        addObject(new Mago(1), 5, 0);
        addObject(new Reina(1), 3, 0);
        addObject(new Rey(1), 4, 0);

        for (int i = 0; i < 8; i++) {
            addObject(new Peon(-1), i, 6);
        }
        addObject(new princess(-1), 0, 7);
        addObject(new princess(-1), 7, 7);
        addObject(new Buffon(-1), 1, 7);
        addObject(new Buffon(-1), 6, 7);
        addObject(new Mago(-1), 2, 7);
        addObject(new Mago(-1), 5, 7);
        addObject(new Reina(-1), 3, 7);
        addObject(new Rey(-1), 4, 7);
        
        isPieceSelected = false;
        PiezaSelec = new Extra();
        Turno = 1; //Black starts
    }

    public void act() {
        movePiece();
    }

    public boolean select(Piezas p, int cd) {
        if (cd == Turno) {
            if (isPieceSelected) {
                NoSelec(PiezaSelec);
            }
            isPieceSelected = true;
            PiezaSelec = p;
            MovimientosLegales();
            return true; 
        } else {
            return false;
        }
    }

    private void MovimientosLegales() {
        List<Posiciones> legalPositions = PiezaSelec.getLegalPositions();
        for (Posiciones p: legalPositions) {
            addObject(new PosibleMovimiento(), p.getX(), p.getY());
        }
    }

    private void movePiece() {
        for (PosibleMovimiento p: getObjects(PosibleMovimiento.class)) {
            if (Greenfoot.mouseClicked(p)) {
                Posiciones Posicion = new Posiciones(p);
                List<Piezas> l = getObjectsAt(Posicion.getX(), Posicion.getY(), Piezas.class);
                PiezaSelec.move(Posicion);
                if (l.size() > 0) Comer(l.get(0));
                NoSelec(PiezaSelec);
                Cambiar();
            }
        }
    }
    
    private void Cambiar() {
        Turno = -Turno;
    }
    
    private void Comer(Piezas p) {
        removeObject(p);
    }
    
    private void NoSelec(Piezas p) {
        p.unselect();
        PiezaSelec = new Extra();
        isPieceSelected = false;
        QuitarMarcado();
    }

    private void QuitarMarcado() {
        removeObjects(getObjects(PosibleMovimiento.class));
    }
}
