/**
 * Created by root on 15-11-13.
 */
public class TomcatDemo {

    public static void main(String[] args) throws Exception {

        String host = "centos2";
        String username="root";
        String password="Qwer6666";
        String tomcat_home= "/usr/local/tomcat8";


        String centos1_host="centos1";
        String centos1_user="root";
        String centos1_pw="Qwer6666";

        JschDemo centos1 = new JschDemo(centos1_user, centos1_pw, centos1_host);
        centos1.connect();
        centos1.execCmd("cd /workspace/eden/eva;sh /usr/local/gradle-2.8/bin/gradle build -x test;");

        //sftp war

//        SFtpDemo.sshSftp(host,username,password,-1,"/workspace/eden/eva/eva-web/build/libs/eva-web-1.1.0.war","/usr/local/tomcat8/webapps/eva-web-1.1.0.war");
//        SFtpDemo.sshSftp(host,username,password,-1,"/root/eva-web-1.1.0.war","/usr/local/tomcat8/webapps/eva-web-1.1.0.war");

        JschDemo demo = new JschDemo(username, password, host);
        demo.connect();
        demo.execCmd("cd /usr/local/tomcat8/bin;./shutdown.sh;cd /usr/local/tomcat8/webapps;rm -rf ROOT;mkdir ROOT;rm -rf /usr/local/tomcat8/logs/*;");


        SFtpDemo.sshSftp(host,username,password,-1,"/workspace/eden/eva/eva-web/build/libs/eva-web-1.1.0.war","/usr/local/tomcat8/webapps/ROOT/eva-web-1.1.0.war");
        SFtpDemo.sshSftp(host,username,password,-1,"/workspace/eden/eva/eva-web/build/libs/eva-web-1.1.0.war","/usr/local/tomcat8/webapps/eva-web-1.1.0.war");

        demo.connect();
        demo.execCmd("cd /usr/local/tomcat8/webapps/ROOT;jar -xvf eva-web-1.1.0.war;rm -rf eva-web-1.1.0.war;cd /usr/local/tomcat8/bin;./startup.sh;");
    }


//    public static void main(String[] args) throws Exception {
//
//        String host = "centos2";
//        String username="root";
//        String password="Qwer6666";
//        String tomcat_home= "/usr/local/tomcat8";
//        //sftp war
//
//
//        JschDemo demo = new JschDemo(username, password, host);
//        demo.connect();
//        demo.execCmd("cd /usr/local/tomcat8/bin;./shutdown.sh;cd /usr/local/tomcat8/webapps;rm -rf eva*;rm -rf /usr/local/tomcat8/logs/*;");
//
//
//        SFtpDemo.sshSftp(host,username,password,-1,"/workspace/eden/eva/eva-web/build/libs/eva-web-1.1.0.war","/usr/local/tomcat8/webapps/eva-web-1.1.0.war");
//
//        demo.connect();
//        demo.execCmd("cd /usr/local/tomcat8/bin;./startup.sh;");
//    }
}
