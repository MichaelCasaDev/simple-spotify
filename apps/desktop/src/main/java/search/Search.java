package search;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="root")
public class Search {
    private Tracks tracks;
    private Albums albums;
    private Artists artists;

    public Search() {}

    public Search(Tracks tracks, Albums albums, Artists artists) {
        this.tracks = tracks;
        this.albums = albums;
        this.artists = artists;
    }

    @XmlElement
    public Tracks getTracks() {
        return tracks;
    }
    public void setTracks(Tracks tracks) {
        this.tracks = tracks;
    }

    public Albums getAlbums() {
        return albums;
    }

    public void setAlbums(Albums albums) {
        this.albums = albums;
    }

    public Artists getArtists() {
        return artists;
    }

    public void setArtists(Artists artists) {
        this.artists = artists;
    }
}
