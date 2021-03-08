package owner.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:${env}.properties")
public interface IOwnerConfig extends Config {

    @Key("browser")
    String browser();

    @Key("browser_version")
    String browserVersion();

    @Key("remote_url")
    String remoteUrl();

    @Key("video_storage")
    String videoStorage();

}
