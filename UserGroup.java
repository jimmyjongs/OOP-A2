import java.util.ArrayList;

public class UserGroup implements UserComposite{
    private String id;
    private long creationTime;
    private final ArrayList<UserComposite> children = new ArrayList<>();

  

    public UserGroup(String id){
        this.id = id;
        this.creationTime = System.currentTimeMillis();
    }

    public void add(UserComposite u){
        this.children.add(u);
    }

    



    public UserComposite findUser(String id){
        for(UserComposite each : this.children){
            if(each.getID().equals(id)){
                return each;
            }
            
            if(each.getChildren() != null){
                for(UserComposite child : each.getChildren()){
                    if(child.getID().equals(id)){
                        return child;
                    }
                }
            }
        }
        
        return null;
    }
    
    @Override
    public ArrayList<UserComposite> getChildren(){
        return this.children;
    }

    @Override
    public String getID(){
        return id;
    }

    @Override
    public UserComposite getChild(int i) {
        // TODO Auto-generated method stub
        return children.get(i); 
    }

    @Override
    public void followUser(UserComposite findUser) {
        // TODO Auto-generated method stub

    }

    @Override
    public void tweet(String string) {
        // TODO Auto-generated method stub

    }

    @Override
    public ArrayList<UserComposite> getFollowing() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<String> getTweets() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getCreationTime() {
        return this.creationTime;
    }

    @Override
    public void setLastUpdate() {
        // TODO Auto-generated method stub

    }

    @Override
    public long getLastUpdated() {
        // TODO Auto-generated method stub
        return 0;
    }
}
