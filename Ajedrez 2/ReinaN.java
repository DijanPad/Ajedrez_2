import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ReinaN here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ReinaN extends PiezasN
{public ReinaN()
{setImage("RN.png");
}
int endX;
int endY;
int startX;
int startY;
int x=startX-8;
int y=startY-8;
int x2=startX+8;
int y2=startY-8;
    /**
     * Act - do whatever the Queen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean valid = false;
    boolean selected = false;
    int b1=0;
    public void act() 
    {
        startX=getX();
        startY=getY();
        if(selected)
        {
            setImage("RNselect.png");
            getWorld().Orden(ReinaN.class);
        }
        else
        {
            setImage("RN.png");
        }
        moveWithMouse();
        if(!selected)
        {
            valid=false;
        }
    }   
    public void moveWithMouse()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null)
        {
            b1 = Greenfoot.getMouseInfo().getButton();
            
            if(!valid)
            {
                for(int i=0; i<8; i++)
                {
                    endX=mouse.getX();
                    endY=mouse.getY();
                    x++;
                    y++;
                    if(endX==x && endY==y)
                    {
                        valid=true;
                    }
                    else if(x>8 && y>8)
                    {
                        x=getX()-8;
                        y=getY()-8;
                    }
                }
                for(int i=0; i<8; i++)
                {
                    endX=mouse.getX();
                    endY=mouse.getY();
                    x2--;
                    y2++;
                    if(endX==x2 && endY==y2)
                    {
                        valid=true;
                    }
                    else if(x2<-8 && y2>8)
                    {
                        x2=getX()+8;
                        y2=getY()-8;
                    }
                }
            }
        }
        if (Greenfoot.mouseClicked(PiezasN.class) && ((Tablero)getWorld()).TurnoN && selected)
        {
            selected = false;
            valid=false;
        }
        else if(b1==1 && mouse.getX()==getX() && mouse.getY()==getY() && ((Tablero)getWorld()).TurnoN && selected)
        {
            selected = false;
            valid=false;
        }
        else if(b1==1 && ((Tablero)getWorld()).TurnoN && selected)
        {
            if(mouse.getX()==getX() || mouse.getY()==getY())
            {
                setLocation(mouse.getX(), mouse.getY());
                selected = false;
                MatarBlanco();
                ((Tablero)getWorld()).TurnoB();
                valid=false;
            }
            else if (valid)
            {
                setLocation(mouse.getX(), mouse.getY());
                selected = false;
                MatarBlanco();
                ((Tablero)getWorld()).TurnoB();
                valid=false;
            }
        }
        else if(Greenfoot.mouseClicked(this) && ((Tablero)getWorld()).TurnoN && selected!=true)
        {
            selected = true;
            valid=false;
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
