import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Frame extends JFrame {
   public Frame() {
        this.setSize(800,600); // sets frame size
        this.setVisible(true); // makes frame visible
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Title here"); // sets title
        this.getContentPane().setBackground(new Color(123, 50, 250));
        // this.setResizable(false);

        JLabel label = new JLabel();
        label.setText("Bottom Text");
        label.setVerticalAlignment(JLabel.BOTTOM);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setForeground(Color.green);
        this.add(label);

        // this.pack();
        
    }

    public Frame(int width, int height) {
        this.setSize(width,height); // sets frame size
        this.setVisible(true); // makes frame visible
        // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Title here"); // sets title
        this.getContentPane().setBackground(new Color(123, 50, 250));
        // this.setResizable(false);

        JLabel label = new JLabel();
        label.setText("Bottom Text");
        label.setVerticalAlignment(JLabel.BOTTOM);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setForeground(Color.green);
        this.add(label);

        // this.pack();
        
    }

    public void add(Panel comp){
        this.add(comp);
    }
}
