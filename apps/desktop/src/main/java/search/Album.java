package search;

import me.Images;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="album")
public class Album {
    private Images images;

    public Album() {}

    public Album(Images images) {
        this.images = images;
    }

    @XmlElement
    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }
}
