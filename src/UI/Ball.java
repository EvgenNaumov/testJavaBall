package UI;

import java.awt.*;
import java.awt.geom.Ellipse2D;
/**
Шар, который может двигаться в канве
и отскакивать от стенок окна
*/

public class Ball {
    /**
    Создание шара в верхнем левом углу
    @с the component in which the ball bounces
    */
    private Component canvas;
    private static final int XSIZE = 15;
    private static final int YSIZE = 15;
    private int x = 0;
    private int y = 0;
    private int dx = 2;
    private int dy = 2 ;

     public Ball(Component c) {
        canvas = c;
    }

    /**
     Рисование шара в его текущей позиции
     @param g2 the graphics context
     */
    public void draw(Graphics2D g2){
    g2.fill( new Ellipse2D.Double(x,y,XSIZE,YSIZE));
    }

    public void move(){
        x+=dx;
        y+=dy;
        if (x<0){
            x=0;
            dx=-dx;
        }

        if (x+XSIZE>=canvas.getWidth()){
            x = canvas.getWidth() - XSIZE;
            dx = -dx;
        }

        if (y<0){
            y = 0;
            dy = -dy;
        }
        if(y + YSIZE>=canvas.getHeight()){
            y=canvas.getHeight()-YSIZE;
            dy=-dy;
        }
        canvas.paint(canvas.getGraphics());
    }
}
