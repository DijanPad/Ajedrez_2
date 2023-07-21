import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.lang.reflect.Field;

/**
 * Ajedrez 2
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tablero extends World
{/**
     * Constructor for objects of class ChessBoard.
     * 
     */
    public boolean Turno()
    {
        return Turno;
    }
boolean Turno = false;
    public void TurnoN()
    {
        if(Turno)
        {
            Turno = false;
            Orden(PiezasB.class, PiezasN.class);
        }
    }
    public void TurnoB()
    {
        if(!Turno)
        {
            Turno = true;
            Orden(PiezasN.class, PiezasB.class);
        }
    }
    public void ChessBoard()
    {    
        super(9, 9, 40); 
        TorreN TN = new TorreN();
        addObject(TN, 1, 0);
        TN = new TorreN();
        addObject(TN, 8, 0);
        CaballoN CN = new CaballoN();
        addObject(CN, 2, 0);
        CN = new CaballoN();
        addObject(CN, 7, 0);
        AlfilN AN = new AlfilN();
        addObject(AN, 3, 0);
        AN = new AlfilN();
        addObject(AN, 6, 0);
        ReinaN RN = new ReinaN();
        addObject(RN, 4, 0);
        ReyN ReN = new ReyN();
        addObject(ReN, 5, 0);
        PeónN PN = new PeónN();
        addObject(PN, 1, 1);
        PN = new PeónN();
        addObject(PN, 2, 1);
        PN = new PeónN();
        addObject(PN, 3, 1);
        PN = new PeónN();
        addObject(PN, 4, 1);
        PN = new PeónN();
        addObject(PN, 5, 1);
        PN = new PeónN();
        addObject(PN, 6, 1);
        PN = new PeónN();
        addObject(PN, 7, 1);
        PN = new PeónN();
        addObject(PN, 8, 1);
        TorreB TB = new TorreB();
        addObject(TN, 1, 7);
        TB = new TorreB();
        addObject(TB, 8, 7);
        CaballoB CB = new CaballoB();
        addObject(CN, 2, 0);
        CB = new CaballoB();
        addObject(CN, 7, 7);
        AlfilB AB = new AlfilB();
        addObject(AN, 3, 7);
        AB = new AlfilB();
        addObject(AB, 6, 7);
        ReinaB RB = new ReinaB();
        addObject(RB, 4, 7);
        ReyB ReB = new ReyB();
        addObject(ReN, 5, 7);
        PeónB PB = new PeónB();
        addObject(PN, 1, 6);
        PB = new PeónB();
        addObject(PN, 2, 6);
        PB= new PeónB();
        addObject(PN, 3, 6);
        PB = new PeónB();
        addObject(PN, 4, 6);
        PB = new PeónB();
        addObject(PN, 5, 6);
        PB= new PeónB();
        addObject(PN, 6, 6);
        PB = new PeónB();
        addObject(PN, 7, 6);
        PB = new PeónB();
        addObject(PB, 8, 6);
        Mouse m = new Mouse();
        addObject(m, 0, 0);
        Greenfoot.start();
    }
}
