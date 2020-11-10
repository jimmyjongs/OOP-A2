import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetailsPane extends Panel implements ActionListener {
    JButton totalUsers;
    JButton totalGroups;
    JButton totalMsgs;
    JButton totalPosMsgs;
    


    public DetailsPane(){
        super();
        this.getPanel().setLayout(new GridLayout(2, 2));
        totalUsers = new JButton();
        totalUsers.setText("Total Users");
        totalUsers.setBounds(0,0, 100, 100);
 
        totalGroups = new JButton();
        totalGroups.setText("Total Groups");
        totalGroups.setBounds(0,0, 100, 100);     
 
        totalMsgs = new JButton();
        totalMsgs.setText("Total Messsages");
        totalMsgs.setBounds(0,0, 100, 100);     
        

        totalPosMsgs = new JButton();
        totalPosMsgs.setText("Total Positive Messages");
        totalPosMsgs.setBounds(0,0, 100, 100);   
        
        this.getPanel().add(totalGroups);
        this.getPanel().add(totalMsgs);
        this.getPanel().add(totalPosMsgs);
        this.getPanel().add(totalUsers);

        totalGroups.addActionListener(this);
        totalMsgs.addActionListener(this);
        totalPosMsgs.addActionListener(this);
        totalUsers.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Frame popup = new Frame(400,200);
        if(e.getSource() == totalUsers){
            System.out.println("Total Users");
            
       
        }
        if(e.getSource() == totalGroups){
            System.out.println("Total Groups");
            // Frame popup = new Frame(400,200);
        }
        else if(e.getSource() == totalMsgs){
            System.out.println("Total Msgs");
            // Frame popup = new Frame(400,200);
        }
        else if(e.getSource() == totalPosMsgs){
            System.out.println("Total pos msgs");
            // Frame popup = new Frame(400,200);
        }
        
            
        

    }
}
