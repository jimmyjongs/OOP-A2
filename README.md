# Mini Twitter


1. There is a centralized admin control panel to create *users* and *user groups*.
2. A *user* has 
    - an unique ID; 
    - a list of user IDs that are following this user (followers); 
    - a list of user IDs being followed by this user (followings); 
    - a news feed list containing a list of Twitter messages
3. A *user group* has an unique ID, which can be used to group users. A user group can
contain any number of users. The same user can only be included in one group. Of
course, a user group can contain other user groups recursively. There is always a root
group called *Root* to include everything.
4. Users can choose to follow other users (not user groups) by providing the target user ID.
5. Users can also post a short Tweet message (a String), so that all the followers can see
this message in their news feed lists. Of course, the user can also see his or her own
posted messages.

---
### Design Patterns
Singleton design pattern displayed in Main.java and Admin.java
    - Ensures only one instance of a class
    - Private constructor
    - Private instance of object within class itself
    - Public getter to retrieve instance

Composite design pattern displayed in User.java and UserGroup.java
    - Users and UserGroups are treated the same as a single instance of UserGroup
    - UserGroup itself contains other UserGroups
    - Tree like structure, part-whole hierachies

Observer design pattern displayed in InspectUser.java and UserView.java
    - UserView object has list of observers
    - Whenever tweet button is pressed, observers are notified and update()

---
### Good OOP
Encapsulated classes, private attribute, public getters and setters
Sole Responsibility of classes
Abstraction and extensibility thru Interfaces
Inheritance and hierarchical class design


