package lists;

/**
 * Created by olexandra on 6/27/17.
 */
public class ListElement {

    String value;
    ListElement prev;
    ListElement next;

    public ListElement(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ListElement getPrev() {
        return prev;
    }

    public void setPrev(ListElement prev) {
        this.prev = prev;
    }

    public ListElement getNext() {
        return next;
    }

    public void setNext(ListElement next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListElement)) return false;

        ListElement element = (ListElement) o;

        if (value != null ? !value.equals(element.value) : element.value != null) return false;
        return next != null ? next.equals(element.next) : element.next == null;
    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (next != null ? next.hashCode() : 0);
        return result;
    }
}
