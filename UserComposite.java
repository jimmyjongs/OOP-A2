import java.util.ArrayList;
import java.util.List;

public interface UserComposite {
    

    public String getID();
    public void add(UserComposite u);
	public UserComposite getChild(int i);
	public UserComposite findUser(String string);
	public void followUser(UserComposite findUser);
	public void tweet(String string);
	public ArrayList<UserComposite>  getChildren();
	public ArrayList<UserComposite> getFollowing();
	public ArrayList<String> getTweets();
	public long getCreationTime();
	public void setLastUpdate();
	public long getLastUpdated();

}
