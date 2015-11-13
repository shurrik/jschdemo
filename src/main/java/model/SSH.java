package model;

/**
 * Created by root on 15-11-13.
 */
public class SSH {

    private String host;
    private String user;
    private String pw;

    public SSH(String host, String user, String pw) {
        this.host = host;
        this.user = user;
        this.pw = pw;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
