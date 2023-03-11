package search;

import me.External_urls;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="items")
public class Item {
    private String name;
    private External_urls external_urls;
    private String preview_url;
    private Album album;

    public Item() {}

    public Item(String name, External_urls external_urls, String preview_url, Album album) {
        this.name = name;
        this.external_urls = external_urls;
        this.preview_url = preview_url;
        this.album = album;
    }

    @XmlElement
    public String getName() {
        return name;
    }
    @XmlElement
    public External_urls getExternal_urls() {
        return external_urls;
    }
    @XmlElement(name="preview_url")
    public String getPreview_url() {
        return preview_url;
    }
    @XmlElement
    public Album getAlbum() {
        return album;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExternal_urls(External_urls external_urls) {
        this.external_urls = external_urls;
    }

    public void setPreview_url(String preview_url) {
        this.preview_url = preview_url;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
