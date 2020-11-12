import java.util.ArrayList;

public class User {
    private String id;
    private ArrayList<User> followers;
    private ArrayList<User> following;
    private ArrayList<String> feed;

    public User(String id){
        this.id = id;
        this.followers = new ArrayList<User>();
        this.following = new ArrayList<User>();
        this.feed = new ArrayList<String>();

        // follow self to see tweets
        // pos not necesary
        this.following.add(this);
    }

    public String getID(){
        return id;
    }

    public void followUser(User user){
        this.following.add(user);
    }

    public ArrayList<User> getFollowing(){
        return following;
    }

    public void tweet(String msg){
        this.feed.add(msg);
    }
    
    public ArrayList<String> getTweets() {
        return this.feed;
    }

   



    

}
