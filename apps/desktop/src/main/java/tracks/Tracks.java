package tracks;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "root")
public class Tracks {
    private String href;
    private int limit;
    private String next;
    private int offset;
    private String previous;
    private int total;
    private Track[] items;

    public Tracks() {}

    public Tracks(String href, int limit, String next, int offset, String previous, int total, Track[] items) {
        this.href = href;
        this.limit = limit;
        this.next = next;
        this.offset = offset;
        this.previous = previous;
        this.total = total;
        this.items = items;
    }

    @XmlElement
    public String getHref() {
        return href;
    }
    @XmlElement
    public int getLimit() {
        return limit;
    }
    @XmlElement
    public String getNext() {
        return next;
    }
    @XmlElement
    public int getOffset() {
        return offset;
    }
    @XmlElement
    public String getPrevious() {
        return previous;
    }
    @XmlElement
    public int getTotal() {
        return total;
    }

    @XmlElementWrapper(name="items")
    @XmlElement(name="track")
    public Track[] getItems() {
        return items;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setItems(Track[] items) {
        this.items = items;
    }
}
