package tcss360.foodtogo;

import java.util.ArrayList;

public class Users{

    //list of all of the registered users
    private ArrayList<User> credentials = new ArrayList<User>();
    //currently logged in user
    private User loggedIn;

    //makes a static Users object that the activities can gat
    private static final Users theUsers = new Users();

    //constructs the Users object
    private Users() {
        credentials.add(new User("Caleb","caleb@gmail.com", "thepass"));
    }

    //adds a new user to the credentials list
    public void addCredential(String email, String password, String name){
        User credential = new User(name, email, password);
        credentials.add(credential);
    }

    //sets the user at the index to be the logged in user
    public void setLoggedIn(int index){
        loggedIn = credentials.get(index);
    }

    //returns the currently logged in user
    public User getLoggedIn(){
        User user = new User(loggedIn.name, loggedIn.email, loggedIn.password);
        return user;
    }

    //returns the credentials list
    public ArrayList<User> getCredentials() {
        ArrayList<User> newList = (ArrayList<User>) credentials.clone();
        return newList;
    }

    public void logOut(){
        loggedIn = null;
    }

    //returns the Users object
    public static Users getInstance(){
        return theUsers;
    }

    public class User{
        private String name;
        private String email;
        private String password;
        //constructs the user object
        public User(String theName, String theEmail, String thePassword){
            name = theName;
            email = theEmail;
            password = thePassword;
        }
        //gets the email of the user
        public String getEmail() {
            String theEmail = "";
            for(int i = 0; i < email.length(); i++){
                theEmail = theEmail + email.charAt(i);
            }
            return theEmail;
        }
        //gets the name of the user
        public String getName() {
            String theName = "";
            for(int i = 0; i < name.length(); i++){
                theName = theName + name.charAt(i);
            }
            return theName;
        }
        //gets the password for the user
        public String getPassword() {
            String thePassword = "";
            for(int i = 0; i < password.length(); i++){
                thePassword = thePassword + password.charAt(i);
            }
            return thePassword;
        }
    }
}

