import java.awt.*;

import org.w3c.dom.Text;
public class Admin {
    private Frame frame;
    private Panel p;
    private UserComposite root;
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
        root.add(new User("Bob"));
        root.add(new User("Barney"));
        root.add(new User("Barb"));
        root.add(new User("Boggle"));
  
        root.getChild(0).followUser(root.findUser("Barney"));

        root.getChild(0).followUser(root.findUser("Barb"));
        root.getChild(0).followUser(root.findUser("Boggle"));
        root.getChild(0).followUser(root.findUser("Bob"));
        root.getChild(0).followUser(root.findUser("Bob"));
        root.getChild(0).followUser(root.findUser("Bob"));

        root.findUser("Barney").tweet("Hello 1");
        root.findUser("Barb").tweet("Hello 2");
        root.findUser("Barney").tweet("Hello 3");
        root.findUser("Barney").tweet("Hello 4");

        UserGroup BSCS = new UserGroup("BSCS");

        root.add(BSCS);
        BSCS.add(new User("Jimmy"));
        BSCS.add(new User("John"));
        BSCS.add(new User("James"));
        BSCS.add(new User("Jojo"));


    }


}
