package tcss360.foodtogo;

import java.util.ArrayList;

public class Users{

    private ArrayList<String> credentials = new ArrayList<String>();

    private String loggedIn;

    private static final Users theUsers = new Users();

    private Users() {
        credentials.add("caleb@gmail.com:thepass:Caleb");
    }

    public void addCredential(String email, String password, String name){
        String credential = email+":"+password+":"+name;
        credentials.add(credential);
    }

    public void setLoggedIn(int index){
        loggedIn = credentials.get(index);
    }

    public String getLoggedIn(){
        String user = "";
        if(loggedIn != null) {
            for (int i = 0; i < loggedIn.length(); i++) {
                user += loggedIn.charAt(i);
            }
        }
        return user;
    }

    public ArrayList<String> getCredentials() {
        ArrayList<String> newList = (ArrayList<String>) credentials.clone();
        return newList;
    }

    public void logOut(){
        loggedIn = null;
    }

    public static Users getInstance(){
        return theUsers;
    }



}