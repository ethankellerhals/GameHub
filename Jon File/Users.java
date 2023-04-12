
public class Users {
    private Integer userID;
    private String userName;
    private String firstName;
    private String userEmail;
// Not done * char
    public Users(Integer userID, String userName, String firstName, String userEmail){
        this.userID = userID;
        this.userName = userName;
        this.firstName = firstName;
        this.userEmail = userEmail;
    }
    public void setUserID(Integer userID){
        this.userID = userID;

    }
    public void setUserName(String userName){
        this.userName = userName;

    }
    public void setFirstName(String firstName){
        this.firstName = firstName;

    }
    public void setUserEmail(String userEmail){
        this.userEmail = userEmail;

    }
    public Integer getUserID(){
        return this.userID;
    }
    public String getuserName(){
        return this.userName;
    }
    public String getfirstName(){
        return this.firstName;
    }
    public String userEmail(){
        return this.userEmail;
    }
}
