package api.search;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name= "tracks")
public class Tracks {
    private int total;
    private List<Item> items;

    public Tracks() {}

    public Tracks(int total, List<Item> items) {
        this.total = total;
        this.items = items;
    }

    @XmlElement
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }

    @XmlElement
    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }
}
