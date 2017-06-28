package lists;

/**
 * Created by olexandra on 6/27/17.
 */
public class MyLinkedList {

    ListElement first;
    ListElement last;
    int size = 0;

    public void add(String content){
        ListElement element = new ListElement(content);
        if (last != null){
            element.setPrev(last);
            last.setNext(element);
            last = element;
        }else {
            first = element;
            last = element;
        }
        size ++ ;
    }

    public ListElement getFirst() {
        return first;
    }

    public ListElement getLast() {
        return last;
    }

    public ListElement get(int index){
        ListElement el = null;
        for (int i = 0; i < index; i++) {
             el = first.getNext();
        }
        return el;
    }
}
