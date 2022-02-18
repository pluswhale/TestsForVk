package vk.automation.logger;

import org.apache.log4j.PropertyConfigurator;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoggerForVk {
    String log4PropertyFile = "/Users/egordultsev/IdeaProjects/MavenForSelenium/src/test/java/vk/automation/files/log4j.properties.txt";

    public void configureLogger() throws IOException {
        Properties p = new Properties();
        p.load(new FileInputStream(log4PropertyFile));
        PropertyConfigurator.configure(p);

    }
}
