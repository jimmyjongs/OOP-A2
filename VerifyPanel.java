import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;

public class VerifyPanel extends Panel implements ActionListener{
    private JButton verifyButton;
    private UserComposite root;


    public VerifyPanel(UserComposite root){

        this.verifyButton = new JButton("Verify User Accounts");

        this.getPanel().add(verifyButton);

        this.root = root;
        this.verifyButton.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        Map<String, Integer> seen = new HashMap<String, Integer>();
        boolean flag = false;

        for(UserComposite each : root.getChildren()){
            if(each.getID().indexOf(" ") != -1 || seen.get(each.getID()) != null){
                System.out.println("Error! " + each.getID() + " contains a space or already exists");
                flag = true;
            }
            else{
                seen.put(each.getID(), 1);
            }


            if(each.getChildren() != null){
                for(UserComposite child : each.getChildren()){
                    if(child.getID().indexOf(" ") != -1 || seen.get(child.getID()) != null){
                        System.out.println("Error! " + child.getID() + " contains a space or already exists");
                        flag = true;
                    }
                    else{
                        seen.put(child.getID(), 1);
                    }
                }
            }
        }
        if(!flag){
            System.out.println("All good! No errors.");
        }
        
    }

}
