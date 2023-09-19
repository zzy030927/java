package InternetProgram.Test.Test5;

import java.util.Date;

public class User {
    private int id;
    private String name;

    public User() {
    }
    private String email;

    public User(int id, String name, String email, Date birthday) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
    }
    private Date birthday;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
