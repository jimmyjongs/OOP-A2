import javax.swing.JLabel;
import java.awt.*;

public class FeedPanel extends Panel implements Feed{
    private UserComposite user;
    private Panel content;

    public FeedPanel(String label, UserComposite userComposite){
        this.getPanel().setPreferredSize(new Dimension(300,300));
        this.setColor(Color.blue);
        JLabel followLabel = new JLabel();
        followLabel.setText(label);
        
        this.content = new Panel();
        this.user = userComposite;
        content.getPanel().add(followLabel);
        update();
    }

    @Override
    public void update() {
        content.getPanel().validate();
        content.getPanel().repaint();
        content.getPanel().removeAll();
        content.getPanel().updateUI();
        for(UserComposite each: user.getFollowing()){
            if(each != null){
                for(String tweet: each.getTweets()){
                    Panel element = new Panel();
                    element.setColor(Color.gray);
                    element.getPanel().setPreferredSize(new Dimension(200, 20));
                    JLabel n = new JLabel();

                    System.out.println(tweet);
        
        
                    n.setText(each.getID() +": " + tweet);
                    element.getPanel().add(n);
                    content.getPanel().add(element.getPanel());
                }
            }
        }
        this.getPanel().add(content.getPanel());
    }
    
}
