import java.util.ArrayList;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Sidepane extends Panel {
    // ArrayList<UserGroup> list = new ArrayList<UserGroup>();
    UserGroup root;
    public Sidepane(UserGroup root){
        super();
        this.root = root;        
        // this.list.add(root);

        // testing
        root.addUser(new User("Bob"));
        root.addUser(new User("Bob"));
        root.addUser(new User("Bob"));
        root.addUser(new User("Bob"));
        root.addUser(new User("Bob"));

        UserGroup BSCS = new UserGroup("BSCS");

        root.addUserGroup(BSCS);
        BSCS.addUser(new User("Jimmy"));
        BSCS.addUser(new User("Jimmy"));
        BSCS.addUser(new User("Jimmy"));
        BSCS.addUser(new User("Jimmy"));

       
        displayList();
    }    

    public UserGroup getRoot(){
        return root;
    }

    public void displayList(){

        Panel element = new Panel();
        element.getPanel().setPreferredSize(new Dimension(100, 20));
        JLabel n = new JLabel();


        n.setText("Root");
        n.setFont(new Font("Verdana", Font.BOLD, 16)); 
        element.getPanel().add(n);
        this.getPanel().add(element.getPanel());


        for(UserGroup each: root.getGroups()){

            for(User u: root.getUsers()){
                element = new Panel();
                element.getPanel().setPreferredSize(new Dimension(100, 20));
                n = new JLabel();


                n.setText(u.getID());
                element.getPanel().add(n);
                this.getPanel().add(element.getPanel());
            }

            element = new Panel();
            element.getPanel().setPreferredSize(new Dimension(100, 20));
            n = new JLabel();

            n.setFont(new Font("Verdana", Font.BOLD, 16)); 
            n.setText(each.getID());
            element.getPanel().add(n);
            this.getPanel().add(element.getPanel());


            for(User u : each.getUsers()){
                element = new Panel();
                element.getPanel().setPreferredSize(new Dimension(100, 20));
                n = new JLabel();


                n.setText(u.getID());
                element.getPanel().add(n);
                this.getPanel().add(element.getPanel());
            }
            
        }
    }
}
