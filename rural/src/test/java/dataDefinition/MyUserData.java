package dataDefinition;

public class MyUserData {
    public String username;
    public String password;
    public String country;
    public String language;

    @Override
    public String toString() {
        return "MyUserData{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
