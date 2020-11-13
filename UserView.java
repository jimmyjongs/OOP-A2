import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.*;

public class UserView extends Frame implements ActionListener{
    private ActionPanel followPanel;
    private ActionPanel tweetPanel;
    private FollowPanel following;
    private FeedPanel feed;
    private UserComposite user;
    private String id;
    private UserComposite root;
    private ArrayList<UserView> observers;

    public UserView(UserComposite userComposite, UserComposite root, ArrayList<UserView> observers){
        super(200,900);
        this.id = userComposite.getID();
        this.user = userComposite;
        this.root = root;
        this.observers = observers;
 
        Panel megaPanel = new Panel();
        JLabel title = new JLabel();
        title.setText(id);
        title.setFont(new Font("Verdana", Font.BOLD, 24)); 
        title.setForeground(Color.BLACK);
        title.setVisible(true);
        megaPanel.getPanel().add(title);

        followPanel = new ActionPanel("Follow User");
        megaPanel.getPanel().add(followPanel.getPanel());
        followPanel.getButton().addActionListener(this);

        tweetPanel = new ActionPanel("Tweet Message");
        megaPanel.getPanel().add(tweetPanel.getPanel());
        tweetPanel.getButton().addActionListener(this);

        following = new FollowPanel("Currently Following", userComposite);
        megaPanel.getPanel().add(following.getPanel());

        feed = new FeedPanel("Tweet Feed", userComposite);
        megaPanel.getPanel().add(feed.getPanel());

        this.add(megaPanel.getPanel());

    }

    private FeedPanel getFeedPanel(){
        return this.feed;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == followPanel.getButton()){
            if(root.findUser(followPanel.getText()) != null){
                user.followUser(root.findUser(followPanel.getText()));
                System.out.println(root.findUser(followPanel.getText()).getID() + " followed");
            }         
            following.update();  
        }
        else if (e.getSource() == tweetPanel.getButton()){
            user.tweet(tweetPanel.getText());
            feed.update();

            for(UserView each : observers){
                each.getFeedPanel().update();
            }

            for(String each: user.getTweets()){
                System.out.println(each);
            }
        }


    }
}
