import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ReyN here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ReyN  extends PiezasN
{public ReyN()
{setImage("ReN.png");
}
    /**
     * Act - do whatever the King wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean selected = false;
    boolean moved = false;
    int b1=0;
    public void act() 
    {
        if(selected)
        {
            setImage("ReNselect.png");
            getWorld().Orden(ReyN.class);
        }
        else
        {
            setImage("ReN.png");
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
            if(mouse.getX()==getX()+1 || mouse.getX()==getX()-1 || mouse.getY()==getY()+1 || mouse.getY()==getY()-1)
            {
                setLocation(mouse.getX(), mouse.getY());
                selected = false;
                MatarBlanco();
                ((Tablero)getWorld()).TurnoB();
            }
        }
        else if(b1==1 && ((Tablero)getWorld()).TurnoN && selected && moved!=true)
        {
            if(mouse.getX()==getX()+2 && mouse.getY()==getY())
            {
                moved=true;
                setLocation(mouse.getX(), mouse.getY());
                selected = false;
                MatarBlanco();
                ((Tablero)getWorld()).TurnoB();
            }
            else if(mouse.getX()==getX()-2 && mouse.getY()==getY())
            {
                moved=true;
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
