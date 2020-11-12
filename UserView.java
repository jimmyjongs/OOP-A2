import javax.swing.*;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import org.w3c.dom.Text;

public class UserView extends Frame implements ActionListener{
    private TextButton follow;
    private TextButton tweet;
    private User user;
    private String id;
    private UserGroup root;

    public UserView(User user, UserGroup root){
        super(200,900);
        this.id = user.getID();
        this.user = user;
        this.root = root;


        // probably should've made these into classes oh well
        Panel megaPanel = new Panel();
        JLabel title = new JLabel();
        title.setText(id);
        title.setFont(new Font("Verdana", Font.BOLD, 24)); 
        title.setForeground(Color.BLACK);
        title.setVisible(true);
        megaPanel.getPanel().add(title);

        Panel followPanel = new Panel();
        followPanel.getPanel().setSize(new Dimension(300,300));
        followPanel.setColor(Color.black);
        follow = new TextButton("Follow User");
        followPanel.getPanel().add(follow.getPanel());
        follow.getButton().addActionListener(this);
        megaPanel.getPanel().add(followPanel.getPanel());

        Panel tweetPanel = new Panel();
        tweetPanel.getPanel().setSize(new Dimension(300,300));
        tweetPanel.setColor(Color.black);
        tweet = new TextButton("Submit Tweet");
        tweetPanel.getPanel().add(tweet.getPanel());
        tweet.getButton().addActionListener(this);
        megaPanel.getPanel().add(tweetPanel.getPanel());




        Panel listFollowPanel = new Panel();
        listFollowPanel.getPanel().setSize(new Dimension(300,300));
        listFollowPanel.setColor(Color.blue);
        JLabel followLabel = new JLabel();
        followLabel.setText("Currently Followers");
        listFollowPanel.getPanel().add(followLabel);
        for(User each: user.getFollowing()){
            if(each != null){
                Panel element = new Panel();
                element.getPanel().setPreferredSize(new Dimension(200, 20));
                JLabel n = new JLabel();
    
    
                n.setText(each.getID());
                element.getPanel().add(n);
                listFollowPanel.getPanel().add(element.getPanel());
            }
        }

        megaPanel.getPanel().add(listFollowPanel.getPanel());

        Panel listFeedPanel = new Panel();
        listFeedPanel.getPanel().setSize(new Dimension(300,300));
        listFeedPanel.setColor(Color.green);
        JLabel timelineLabel = new JLabel();
        timelineLabel.setText("Timeline");
        listFeedPanel.getPanel().add(timelineLabel);
        megaPanel.getPanel().add(listFeedPanel.getPanel());

        for(User each: user.getFollowing()){
            if(each != null){
                for(String tweet: each.getTweets()){
                    Panel element = new Panel();
                    element.getPanel().setPreferredSize(new Dimension(200, 20));
                    JLabel n = new JLabel();

                    System.out.println(tweet);
        
        
                    n.setText(each.getID() +": " + tweet);
                    element.getPanel().add(n);
                    listFeedPanel.getPanel().add(element.getPanel());
                }
            }
            
            this.add(megaPanel.getPanel());
        }

        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == follow.getButton()){
            if(root.findUser(follow.getText()) != null){
                user.followUser(root.findUser(follow.getText()));
                System.out.println(root.findUser(follow.getText()).getID() + " followed");
            }           
        }
        else if (e.getSource() == tweet.getButton()){
            user.tweet(tweet.getText());

            for(String each: user.getTweets()){
                System.out.println(each);
            }
        }


    }
}
