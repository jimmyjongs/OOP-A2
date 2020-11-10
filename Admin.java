import java.awt.*;
public class Admin {
    Frame frame;
    Panel p;
    UserGroup root;

    public Admin(){
        frame = new Frame();
        p = new Panel();
        root = new UserGroup("ROOT");

        frame.add(new Sidepane(root).getPanel(), BorderLayout.WEST);

        // empty panel
        frame.add(p.getPanel(), BorderLayout.CENTER);
        p.getPanel().setLayout(new BorderLayout());

        // user panel
        p.getPanel().add(new UserPane(root).getPanel(), BorderLayout.NORTH);

        // bottom panel;
        p.getPanel().add(new DetailsPane().getPanel(), BorderLayout.CENTER);
    }
}
