import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CaballoN here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaballoN extends PiezasN
{public CaballoN()
{setImage("CN.png");
}
    /**
     * Act - do whatever the CaballoN wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean selected = false;
    int b1=0;
    public void act() 
    {
        if(selected)
        {
            setImage("CNselect.png");
            getWorld().Orden(CaballoN.class);
        }
        else
        {
            setImage("CN.png");
        }
        moveWithMouse();
    }   
    public void moveWithMouse()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null)
        {
            b1 = Greenfoot.getMouseInfo().getButton();
        }
        if (Greenfoot.mouseClicked(PiezasN.class) && ((Tablero)getWorld()).TurnoN && selected)
        {
            selected = false;
        }
        else if(Greenfoot.mouseClicked(this) && ((Tablero)getWorld()).TurnoN && selected)
        {
            selected = false;
        }
        
        else if(b1==1 && ((Tablero)getWorld()).TurnoN && selected)
        {
            setLocation(mouse.getX(), mouse.getY());
            selected = false;
            MatarBlanco();
            ((Tablero)getWorld()).TurnoB();
        }
        else if(Greenfoot.mouseClicked(this) && ((Tablero)getWorld()).TurnoN && selected!=true)
        {
            selected = true;
        }
        b1=0;
    }
    public void MatarBlanco()
    {
        List MB = getWorld().getObjectsAt(getX(), getY(), PiezasB.class);
        if(MB!=null && ((Tablero)getWorld()).TurnoN)
        {
            getWorld().removeObjects(MB);
        }
    }

}

