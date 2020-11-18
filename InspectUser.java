import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.*;


public class InspectUser extends Panel implements ActionListener{
    private TextButton button;
    private UserComposite root;
    private ArrayList<UserView> instances;

    public InspectUser(UserComposite root){
        super();
        this.root = root;
        this.getPanel().setSize(new Dimension(400,400));
        this.getPanel().setLayout(new BorderLayout());
        this.button = new TextButton("Inspect User");
        this.getPanel().add(button.getPanel(), BorderLayout.CENTER);
        this.instances = new ArrayList<UserView>();
        button.getButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button.getButton()){
            if(!button.getText().equals("")){
                String id = button.getText();
                if(root.findUser(id) != null){
                    UserView view = new UserView(root.findUser(id), root, instances);
                    instances.add(view);
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
