import java.awt.*;

import org.w3c.dom.Text;
public class Admin {
    private Frame frame;
    private Panel p;
    private UserGroup root;
    private static Admin instance = new Admin();

    private Admin(){
        this.frame = new Frame();
        this.p = new Panel();
        this.root = new UserGroup("ROOT");
        populate();
        Sidepane sp = new Sidepane(root);
        frame.add(sp.getPanel(), BorderLayout.WEST);

        // empty panel
        frame.add(p.getPanel(), BorderLayout.CENTER);
        p.getPanel().setLayout(new BorderLayout());

        // user panel
        p.getPanel().add(new UserPane(root, sp).getPanel(), BorderLayout.NORTH);

        // // inspect user panel
        p.getPanel().add(new InspectUser(root).getPanel(), BorderLayout.CENTER);
        

        // bottom panel;
        p.getPanel().add(new DetailsPane().getPanel(), BorderLayout.SOUTH);
    }

    public static Admin getInstance(){
        return instance;
    }


    // this test/driver code should probably be in the main
    private void populate(){
        // testing
        root.addUser(new User("Bob"));
        root.addUser(new User("Barney"));
        root.addUser(new User("Barb"));
        root.addUser(new User("Boggle"));
  
        root.getUsers().get(0).followUser(root.findUser("Barney"));
        root.getUsers().get(0).followUser(root.findUser("Barb"));
        root.getUsers().get(0).followUser(root.findUser("Boggle"));
        root.getUsers().get(1).followUser(root.findUser("Bob"));
        root.getUsers().get(2).followUser(root.findUser("Bob"));
        root.getUsers().get(3).followUser(root.findUser("Bob"));

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
