import javax.swing.*;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.*;
import org.w3c.dom.Text;

public class UserView extends Frame implements ActionListener{
    private ActionPanel followPanel;
    private ActionPanel tweetPanel;
    private FollowPanel following;
    private FeedPanel feed;
    private User user;
    private String id;
    private UserGroup root;
    private ArrayList<UserView> observers;

    public UserView(User user, UserGroup root, ArrayList<UserView> observers){
        super(200,900);
        this.id = user.getID();
        this.user = user;
        this.root = root;
        this.observers = observers;
 
        // for(User each : user.getFollowers()){
        //     UserView n = new UserView(user, root);
        //     observers.add(n);
        // }


        // probably should've made these into classes oh well
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

        following = new FollowPanel("Currently Following", user);
        megaPanel.getPanel().add(following.getPanel());

        feed = new FeedPanel("Tweet Feed", user);
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
