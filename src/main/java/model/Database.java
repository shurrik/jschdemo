package model;

/**
 * Created by root on 15-11-13.
 */
public class Database {

    private String host;
    private String db;
    private String user;
    private String pw;

    public Database(String host, String db, String user, String pw) {
        this.host = host;
        this.db = db;
        this.user = user;
        this.pw = pw;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
