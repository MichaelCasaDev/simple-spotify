package api.search;

import api.me.Images;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="album")
public class Album {
    private Images images;
    private Item artists;

    public Album() {}

    public Album(Images images, Item artists) {
        this.images = images;
        this.artists = artists;
    }

    @XmlElement
    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    @XmlElement(name = "artists")
    public Item getArtists() {
        return artists;
    }

    public void setArtists(Item artists) {
        this.artists = artists;
    }
}
