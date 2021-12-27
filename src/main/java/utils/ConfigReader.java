package utils;

import org.aeonbits.owner.Config;


@Config.Sources(value="file:${user.dir}/src/main/java/resources/FrameworkConfig.properties")
public interface ConfigReader extends Config {
    String browser();
    @DefaultValue("true")
    Boolean takescreenshot();
    Long timeout();
    String url();
}
