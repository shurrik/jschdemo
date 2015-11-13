import com.jcraft.jsch.JSchException;
import model.Database;
import model.SSH;

/**
 * Created by root on 15-11-13.
 */
public class MysqlDemo {

    public static final String FROM_DIR="/tmpsql";
    public static final String TO_DIR="/tmpsql";
    public static final String LOCAL_HOST="localhost";


    public static void main(String[] args) throws Exception {


        String db_host = "centos2";
        String db_db="eva";
        String db_user="root";
        String db_pw="root";

        String from_host="centos1";
        String from_user="root";
        String from_pw="Qwer6666";

        String to_host="centos2";
        String to_user="root";
        String to_pw="Qwer6666";

        String localFile = "/root/1.sql";
        String toFile = "/root/1.sql";



        Database db = new Database(db_host,db_db,db_user,db_pw);
        SSH from = new SSH(from_host,from_user,from_pw);
        SSH to = new SSH(to_host,to_user,to_pw);

        MysqlDemo sqlDemo = new MysqlDemo();

        toFile = sqlDemo.sftpSQL(to,localFile,toFile);
        sqlDemo.execSQL(to,db,toFile);

    }

    private String sftpSQL(SSH ssh,String localFile,String toFile) throws Exception {
        SFtpDemo.sshSftp(ssh.getHost(),ssh.getUser(),ssh.getPw(),-1,localFile,toFile);
        return toFile;
    }

    private void execSQL(SSH ssh, Database db,String sqlfile) throws JSchException {

        JschDemo centos1 = new JschDemo(ssh.getUser(), ssh.getPw(), ssh.getHost());
        centos1.connect();
        centos1.execCmd("mysql -h "+LOCAL_HOST+" -D "+db.getDb()+" -u"+db.getUser()+" -p"+db.getPw()+" <"+sqlfile);
    }
}
