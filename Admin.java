import java.awt.*;

import org.w3c.dom.Text;
public class Admin {
    Frame frame;
    Panel p;
    UserGroup root;
    // TextButton inspectUser;
    public Admin(){
        this.frame = new Frame();
        this.p = new Panel();
        this.root = new UserGroup("ROOT");

        test();
        // this.inspectUser = new TextButton("Inspect User");

        frame.add(new Sidepane(root).getPanel(), BorderLayout.WEST);

        // empty panel
        frame.add(p.getPanel(), BorderLayout.CENTER);
        p.getPanel().setLayout(new BorderLayout());

        // user panel
        p.getPanel().add(new UserPane(root).getPanel(), BorderLayout.NORTH);

        // // inspect user panel
        // p.getPanel().add(inspectUser.getPanel(), BorderLayout.CENTER);
        p.getPanel().add(new InspectUser(root).getPanel(), BorderLayout.CENTER);
        

        // bottom panel;
        p.getPanel().add(new DetailsPane().getPanel(), BorderLayout.SOUTH);
    }

    private void test(){
        // testing
        root.addUser(new User("Bob"));
        root.addUser(new User("Barney"));
        root.addUser(new User("Barb"));
        root.addUser(new User("Boggle"));
  
        root.getUsers().get(0).followUser(root.findUser("Barney"));
        root.getUsers().get(0).followUser(root.findUser("Barb"));
        root.getUsers().get(0).followUser(root.findUser("Boggle"));

        root.findUser("Barney").tweet("Hello 1");
        root.findUser("Barb").tweet("Hello 2");
        root.findUser("Barney").tweet("Hello 3");
        root.findUser("Barney").tweet("Hello 4");

        UserGroup BSCS = new UserGroup("BSCS");

        root.addUserGroup(BSCS);
        BSCS.addUser(new User("Jimmy"));
        BSCS.addUser(new User("John"));
        BSCS.addUser(new User("James"));
        BSCS.addUser(new User("Jojo"));


    }
}
