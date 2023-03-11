package me;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "root")
public class Me {
    private Images images;
    private String display_name;
    private External_urls external_urls;

    public Me() {}

    public Me(Images images, String display_name, External_urls external_urls) {
        this.images = images;
        this.display_name = display_name;
        this.external_urls = external_urls;
    }

    @XmlElement
    public Images getImages ()
    {
        return images;
    }

    public void setImages (Images images)
    {
        this.images = images;
    }

    @XmlElement
    public String getDisplay_name ()
    {
        return display_name;
    }

    public void setDisplay_name (String display_name)
    {
        this.display_name = display_name;
    }

    @XmlElement
    public External_urls getExternal_urls ()
    {
        return external_urls;
    }

    public void setExternal_urls (External_urls external_urls)
    {
        this.external_urls = external_urls;
    }
}