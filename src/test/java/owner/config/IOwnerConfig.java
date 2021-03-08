package owner.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:${env}.properties")
public interface IOwnerConfig extends Config {

    @Key("env")
    String env();

    @Key("browser")
    String browser();

    @Key("browserVersion")
    String browserVersion();

    @Key("remoteUrl")
    String remoteUrl();

    @Key("videoStorage")
    String videoStorage();

}
