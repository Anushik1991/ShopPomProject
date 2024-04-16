package automationexersice.object;

public class Users {
    private String password;
    private String email;

    public String getPassword(){
       return password;
    }

    public String getEmail(){
        return email;
    }
    public Users(String password, String email) {
        this.password = password;
        this.email = email;
    }
}


