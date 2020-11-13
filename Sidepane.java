import java.util.ArrayList;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Sidepane extends Panel {
    private UserComposite root;
    private Panel content;
    public Sidepane(UserComposite root){
        super();
        
        this.setColor(Color.black);
        this.root = root;    
        this.content = new Panel();
        this.getPanel().setPreferredSize(new Dimension(200, 900)); 
        content.getPanel().setPreferredSize(new Dimension(200, 900)); 
        displayList();
    }    

    public UserComposite getRoot() {
        return root;
    }

    public void displayList(){

        Panel element = new Panel();
        JLabel n = new JLabel();

        content.getPanel().validate();
        content.getPanel().repaint();
        content.getPanel().removeAll();
        content.getPanel().updateUI();

        
        n.setText("Root");
        n.setFont(new Font("Verdana", Font.BOLD, 16)); 
        element.getPanel().add(n);
        element.getPanel().setPreferredSize(new Dimension(100, 20));
        content.getPanel().add(element.getPanel());
        
        for(UserComposite each : root.getChildren()){

            

            if(each.getChildren() == null){
                element = new Panel();
                element.getPanel().setPreferredSize(new Dimension(100, 20));
                n = new JLabel();


                n.setText(each.getID());
                element.getPanel().add(n);
                content.getPanel().add(element.getPanel());
            }

            if(each.getChildren() != null){
                element = new Panel();
                element.getPanel().setPreferredSize(new Dimension(100, 20));
                n = new JLabel();
                n.setText(each.getID());
                n.setFont(new Font("Verdana", Font.BOLD, 16)); 
                System.out.println(each.getID());

                element.getPanel().add(n);
                element.getPanel().setPreferredSize(new Dimension(100, 20));
                content.getPanel().add(element.getPanel());
                
                for(UserComposite child : each.getChildren()){
                    element = new Panel();
                    element.getPanel().setPreferredSize(new Dimension(100, 20));
                    n = new JLabel();
    
    
                    n.setText(child.getID());
                    element.getPanel().add(n);
                    content.getPanel().add(element.getPanel());
                }
            }
            

            

    
        }


        this.getPanel().add(content.getPanel());
    }
}
