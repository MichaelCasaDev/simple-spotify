package api.tracks;

import api.me.External_urls;
import api.search.Album;
import api.search.Artists;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "track")
public class Track {
    private External_urls external_urls;
    private String name;
    private String preview_url;
    private Album album;
    private Artists artists;
    private int duration_ms;

    public Track() {}

    public Track(External_urls external_urls, String name, String preview_url, Album album, Artists artists, int duration_ms) {
        this.external_urls = external_urls;
        this.name = name;
        this.preview_url = preview_url;
        this.album = album;
        this.artists = artists;
        this.duration_ms = duration_ms;
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

    @XmlElement(name = "album")
    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Artists getArtists() {
        return artists;
    }

    public void setArtists(Artists artists) {
        this.artists = artists;
    }

    public int getDuration_ms() {
        return duration_ms;
    }

    public void setDuration_ms(int duration_ms) {
        this.duration_ms = duration_ms;
    }
}
