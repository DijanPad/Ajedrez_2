import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PeónN here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PeónN extends PiezasN
{public PeónN()
{setImage("PN.png");
}
    /**
     * Act - do whatever the Pawn wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean selected = false;
    int b1=0;
    public void act() 
    {
        if(selected)
        {
            setImage("PNselect.png");
            getWorld().Orden(PeónN.class);
            if(getY()==1)
            {
                setImage("PNselectstart.png");
            }
        }
        else
        {
            setImage("PN.png");
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
            
            if(mouse.getY()==getY()+1)
            {
                setLocation(mouse.getX(), mouse.getY());
                selected = false;
                MatarBlanco();
                ((Tablero)getWorld()).TurnoB();
            }
            if(getY()+2==3 && mouse.getY()==3)
            {
                setLocation(mouse.getX(), mouse.getY());
                selected = false;
                MatarBlanco();
                ((Tablero)getWorld()).TurnoB();
            }
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
