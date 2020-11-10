import java.util.ArrayList;

public class UserGroup {
    private String id;
    private ArrayList<User> users;
    private ArrayList<UserGroup> groups;

  

    public UserGroup(String id){
        this.id = id;
        this.users = new ArrayList<User>();
        this.groups = new ArrayList<UserGroup>();
    }

    public void addUser(User u){
        this.users.add(u);
    }

    public void addUserGroup(UserGroup g){
        this.groups.add(g);
    }

    public ArrayList<User> getUsers(){
        return users;
    }

    public ArrayList<UserGroup> getGroups(){
        return groups;
    }
    
    public String getID(){
        return id;
    }
}
