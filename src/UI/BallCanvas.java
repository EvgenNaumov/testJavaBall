package UI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BallCanvas extends JPanel {
    /**
    Создание шара в канве
    ©param b the ball to add
     **/
    private ArrayList balls = new ArrayList();
    public void add(Ball b){
        balls.add(b);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        for (int i=0;i< balls.size();i++){
            Ball b = (Ball)balls.get(i);
            b.draw(g2);
        }
    }
}
