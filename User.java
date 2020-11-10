import java.util.ArrayList;

public class User {
    private String id;
    private ArrayList<User> followers;
    private ArrayList<User> following;
    private ArrayList<String> feed;

    public User(String id){
        this.id = id;
    }

    public String getID(){
        return id;
    }

    public void followUser(String id){

    }

    public void tweet(String tweet){

    }



    

}
