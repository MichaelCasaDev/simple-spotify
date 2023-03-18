package api.me;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="images")
public class Images {
    private String url;

    public Images() {}

    public Images(String url) {
        this.url = url;
    }

    @XmlElement
    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }
}

