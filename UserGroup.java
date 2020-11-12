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

    public User findUser(String id){
        for(User each : this.users){
            if(each.getID().equals(id)){
                System.out.println(each.getID() + " found");
                return each;
            }
        }

        for(UserGroup eachGroup : this.groups){
            for(User each : eachGroup.getUsers()){
                if(each.getID().equals(id)){
                    System.out.println(each.getID() + " found");
                    return each;
                }
            }
        }
        
        return null;
    }
    
    public String getID(){
        return id;
    }
}
