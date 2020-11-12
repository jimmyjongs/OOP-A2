import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;


public class InspectUser extends Panel implements ActionListener{
    TextButton button;
    UserGroup root;

    public InspectUser(UserGroup root){
        super();
        this.root = root;
        this.getPanel().setSize(new Dimension(400,400));
        this.getPanel().setLayout(new BorderLayout());
        this.button = new TextButton("Inspect User");
        this.getPanel().add(button.getPanel(), BorderLayout.CENTER);
        button.getButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == button.getButton()){
            if(!button.getText().equals("")){
                String id = button.getText();
                if(root.findUser(id) != null){
                    System.out.println("Hey" + root.findUser(id).getID());
                    UserView view = new UserView(root.findUser(id), root);
                }
                else{
                    System.out.println("User not found");
                }
                
            }
            else{
                System.out.println("Error, enter valid ID");
            }
            


        }

    }
    
}
