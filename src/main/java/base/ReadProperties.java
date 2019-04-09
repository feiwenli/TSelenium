package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    public static String getprop(String filename, String propname) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(String.format("./target/test-classes/properties/%s.properties", filename)));
        String str = properties.getProperty(propname);
        return str;

    }

    public static void main(String[] args) throws IOException {
        System.out.println(getprop("test", "test"));
    }
}


















