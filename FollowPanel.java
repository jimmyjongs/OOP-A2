import javax.swing.*;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import org.w3c.dom.Text;

public class FollowPanel extends Panel implements Feed{
    private User user;
    private Panel content;
    
    public FollowPanel(String label, User user){
        this.getPanel().setPreferredSize(new Dimension(300,300));
        this.setColor(Color.blue);
        JLabel followLabel = new JLabel();
        followLabel.setText(label);
        this.getPanel().add(followLabel);
        this.content = new Panel();
        this.user = user;
        
        update();
    }

    @Override
    public void update() {
        content.getPanel().validate();
        content.getPanel().repaint();
        content.getPanel().removeAll();
        content.getPanel().updateUI();
        for(User each: user.getFollowing()){
            if(each != null){
                Panel element = new Panel();
                element.getPanel().setPreferredSize(new Dimension(200, 20));
                JLabel n = new JLabel();
    
    
                n.setText(each.getID());
                element.getPanel().add(n);
                content.getPanel().add(element.getPanel());
            }
        }
        this.getPanel().add(content.getPanel());
    }
    
}
