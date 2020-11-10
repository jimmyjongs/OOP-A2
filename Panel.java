import javax.swing.JPanel;
import java.awt.*;

public class Panel {
    private Panel[] myPanels;
    private JPanel p;

    public Panel(){
        p = new JPanel();
        p.setSize(30, 30);
        p.setBounds(0,0, 200, 200);
        p.setBackground(Color.red);
        p.setPreferredSize(new Dimension(200, 200));
    }

    public void addComponent(JPanel comp){
        p.add(comp);
    }

    public JPanel getPanel(){
        return this.p;
    }

    public void setColor(Color color){
        p.setBackground(color);
    }



}
