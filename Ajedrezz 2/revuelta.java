import greenfoot.*;  
import java.util.List;
import java.util.ArrayList;

/**

 */
public class revuelta extends World {

    boolean isPieceSelected;
    Piezas PiezaSelec = new Extra();
    int Turno; 

    public revuelta() {    
        super(8, 8, 50); 
        addObject(new Torre(1), 0, 0);
        addObject(new Torre(1), 7, 0);
        addObject(new Caballo(1), 1, 0);
        addObject(new Caballo(1), 6, 0);
        addObject(new Alfil(1), 2, 0);
        addObject(new Alfil(1), 5, 0);
        addObject(new Reina(1), 3, 0);
        addObject(new Rey(1), 4, 0);

        for (int i = 0; i < 8; i++) {
            addObject(new Peon(-1), i, 7);
        }
        
        addObject(new Barbaro(-1), 7, 6);
        addObject(new Barbaro(-1), 1, 6);
        addObject(new Barbaro(-1), 5, 6);
        addObject(new Barbaro(-1), 3, 6);
        addObject(new Rey(-1), 4, 6);
        
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
