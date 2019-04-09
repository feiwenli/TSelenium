package mail;

import lombok.Getter;
import lombok.Setter;

import java.util.Properties;

@Setter
@Getter
public class MailInfo {
    private String mailServerHost;
    private String mailServerPort;
    private String fromAddress;
    private String[] toAddress;
    private String[] ccAddress;
    private String username;
    private String password;
    private boolean validate = false;   // 是否需要身份验证
    private String subject;
    private String content;
    private String[] attachFileNames;
    private boolean debug = false;

    public Properties getProperties(){
        Properties p = new Properties();
        p.put("mail.smtp.host", this.mailServerHost);
        p.put("mail.smtp.port", this.mailServerPort);
        p.put("mail.smtp.auth", validate ? "true" : "false");
        p.put("mail.debug", debug ? "true" : "false");
        return p;
    }
}




























