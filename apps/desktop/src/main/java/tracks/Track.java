package tracks;

import me.External_urls;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "track")
public class Track {
    private External_urls external_urls;
    private String name;
    private String preview_url;

    public Track() {}

    public Track(External_urls external_urls, String name, String preview_url) {
        this.external_urls = external_urls;
        this.name = name;
        this.preview_url = preview_url;
    }

    @XmlElement
    public External_urls getExternal_urls() {
        return external_urls;
    }
    @XmlElement
    public String getName() {
        return name;
    }
    @XmlElement
    public String getPreview_url() {
        return preview_url;
    }

    public void setExternal_urls(External_urls external_urls) {
        this.external_urls = external_urls;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPreview_url(String preview_url) {
        this.preview_url = preview_url;
    }
}
