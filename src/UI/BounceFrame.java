package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BounceFrame extends JFrame {
    private BallCanvas canvas;
    public static final int WIDTH = 450;
    public static final int HEIGHT = 350;
   public BounceFrame(){
       super.setSize(WIDTH,HEIGHT);
       super.setTitle("Bounce");

       Container contentPane = getContentPane();
       canvas = new BallCanvas();
       contentPane.add(canvas,BorderLayout.CENTER);
       JPanel buttonPanel = new JPanel();

       addButton(buttonPanel, "Start",
               new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent e) {
                       addBall();
                   }
               });

       addButton(buttonPanel, "Close",
               new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent e) {
                       System.exit(0);
                   }
               });
       contentPane.add(buttonPanel, BorderLayout.SOUTH);

   }

   private void addButton(Container c, String title, ActionListener listener){
       JButton button = new JButton(title);
       c.add(button);
       button.addActionListener(listener);
   }

   public void addBall(){
       try {
           Ball b = new Ball(canvas);
           canvas.add(b);
           for (int i = 0; i < 1000; i++) {
               b.move();
               Thread.sleep(5);
           }
       }
       catch (InterruptedException ex){

       }
   }
}
