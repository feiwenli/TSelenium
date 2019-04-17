package mail;

import base.ReadProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;


public class AutoMail {

    public static void main (String[] args) throws IOException {
        MailInfo mailInfo = new MailInfo();
        String sendTo[] = readMail("sendto");
        String cclist[] = readMail("cc");

        mailInfo.setMailServerHost(ReadProperties.getprop("mail", "MailServerHost"));
        mailInfo.setMailServerPort(ReadProperties.getprop("mail", "MailServerPort"));
        mailInfo.setValidate(true);
        mailInfo.setUsername(ReadProperties.getprop("mail", "Username"));
        mailInfo.setPassword(ReadProperties.getprop("mail", "Password"));
        mailInfo.setFromAddress(ReadProperties.getprop("mail", "FromAddress"));
        mailInfo.setToAddress(sendTo);
        mailInfo.setSubject(ReadProperties.getprop("mail", "Subject"));
        mailInfo.setCcAddress(cclist);

//        String mailcontent = ReadHtml.readString("test-output/html/overview.html");
//        String cssvalue = ReadHtml.readString("test-output/html/reportng.css");
        String mailcontent = ReadHtml.readString("./target/surefire-reports/html/overview.html");
        String cssvalue=ReadHtml.readString("./target/surefire-reports/html/reportng.css");
        String changestr="<style type=\"text/css\">h1 {display : inline}"+cssvalue+"</style>";
        mailcontent=mailcontent.replace("<link href=\"reportng.css\" rel=\"stylesheet\" type=\"text/css\" />", changestr);
        String logostr="<h2 style=\"color:red ; font-size:25px;font-family: '楷体','楷体_GB2312';\">MAVEN_DEMO</h2><h2>自动化测试报告</h2>";
        mailcontent=mailcontent.replace("<h1>Test Results Report</h1>", logostr);
        mailInfo.setContent(mailcontent);
        SendMail.sendHtmlMail(mailInfo);

    }

    private static String[] readMail(String mailtype) throws IOException {
        int i = 0;
        Properties properties = new Properties();
        properties.load(new FileInputStream(String.format("./target/test-classes/properties/%s.properties", mailtype)));
        String [] mailto = new String[properties.size()];

        for(Enumeration enu=properties.elements(); enu.hasMoreElements(); i++){
            String key = (String)enu.nextElement();
            mailto[i] = key;
        }

        return mailto;
    }

}
