package unilever.it.org.actualsample.database;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @Expose
    private String email ;
    @Expose
    private String password ;
    @Expose

    private int remember_me;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRemember_me() {
        return remember_me;
    }

    public void setRemember_me(int remember_me) {
        this.remember_me = remember_me;
    }

    public User(String email, String password, int remember_me) {
        this.email = email;
        this.password = password;
        this.remember_me = remember_me;
    }
}
