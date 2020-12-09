import java.util.ArrayList;

public class User implements UserComposite{
    private String id;
    private ArrayList<UserComposite> followers;
    private ArrayList<UserComposite> following;
    private ArrayList<String> feed;
    private long creationTime;
    private long lastUpdated;


    public User(String id){
        this.id = id;
        this.followers = new ArrayList<UserComposite>();
        this.following = new ArrayList<UserComposite>();
        this.feed = new ArrayList<String>();
        this.creationTime = System.currentTimeMillis();

        // initialize to some value
        this.lastUpdated = this.creationTime;

        // follow self to see tweets
        // pos not necesary
        this.following.add(this);
    }

    @Override
    public String getID(){
        return id;
    }

    public void followUser(User user){
        this.following.add(user);
    }

    @Override
    public ArrayList<UserComposite> getFollowing() {
        return this.following;
    }

    public void tweet(String msg){
        this.feed.add(msg);
        setLastUpdate();
        
    }
    


    @Override
    public ArrayList<String> getTweets() {
        return this.feed;
    }
    
    public ArrayList<UserComposite> getFollowers(){
        return this.followers;
    }

    @Override
    public void add(UserComposite u) {
        // TODO Auto-generated method stub

    }

    @Override
    public User getChild(int i) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User findUser(String string) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void followUser(UserComposite findUser) {
        this.following.add(findUser);
    }

    @Override
    public ArrayList<UserComposite> getChildren() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getCreationTime() {
        return this.creationTime;
    }

    @Override
    public void setLastUpdate() {
        this.lastUpdated = System.currentTimeMillis();
    }

    @Override
    public long getLastUpdated() {
        return this.lastUpdated;
    }

 
}
