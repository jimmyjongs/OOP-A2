import javax.swing.*;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.w3c.dom.Text;

import java.awt.*;

public class UserPane extends Panel implements ActionListener{
   
    private TextButton addUser;
    private TextButton addGroup;
    private UserGroup root;
    private JButton button;
    private Sidepane sp;

    public UserPane(UserGroup root, Sidepane sp){
        super();
      
        addUser = new TextButton("Add User");
        addGroup = new TextButton("Add Group");
        this.getPanel().setLayout(new GridLayout());
        this.getPanel().add(addUser.getPanel());
        this.getPanel().add(addGroup.getPanel());
        this.root = root;
        this.sp = sp;
        

        // this.getPanel().add(addUser.getButton());
        // this.getPanel().add(addGroup.getButton());
        


		addUser.getButton().addActionListener(this);
		addGroup.getButton().addActionListener(this);
       
        
        // this.getPanel().setLayout(new GridLayout());
        this.setColor(Color.blue);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO: refresh details pane
        // observer pattern?
        if(e.getSource() == addUser.getButton()){
            System.out.println("Added user");
            root.addUser(new User(addUser.getText()));
        }
        else if(e.getSource() == addGroup.getButton()){
            System.out.println("Added Group");
            root.addUserGroup(new UserGroup(addGroup.getText()));
        }

        sp.displayList();
    }
}
