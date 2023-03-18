package api.me;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "external_urls")
public class External_urls {
    private String spotify;

    public External_urls() {}

    public External_urls(String spotify) {
        this.spotify = spotify;
    }

    @XmlElement
    public String getSpotify ()
    {
        return spotify;
    }

    public void setSpotify (String spotify)
    {
        this.spotify = spotify;
    }
}
