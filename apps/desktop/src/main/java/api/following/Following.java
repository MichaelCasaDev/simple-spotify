package api.following;

import api.search.Artists;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="root")
public class Following {
    private Artists artists;

    public Following() {}

    public Following(Artists artists) {
        this.artists = artists;
    }

    public Artists getArtists() {
        return artists;
    }

    public void setArtists(Artists artists) {
        this.artists = artists;
    }
}
