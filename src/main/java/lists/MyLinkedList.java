package lists;

/**
 * Created by olexandra on 6/27/17.
 */
public class MyLinkedList {

    private ListElement first;
    private ListElement last;
    int size = 0;

    public void add(String content) {
        ListElement element = new ListElement(content);
        if (last != null) {
            //элемент второй или последующий.
            //Таких элементов будет больше, чем первых, поэтому это условие лучше чтоб шло первее.
            element.setPrev(last);
            last.setNext(element);
            last = element;
        } else {
            //элемент первый и единственный
            first = element;
            last = element;
        }
        size++;
    }

    /*
    На данный момент в самом плохом случае (при поиске последнего элемента) придется пройти по всем элементам в списке.
    Этот метод можно улучшить, определив, в какой части списка находится необходимый элемент.
    Если в начале - так и оставить.
    Если в конце - идти к нужному элементу с конца списка, от last
     */
    public String get(int index) {
        if (index >= 0 && index < size) {
            ListElement searchedElement = first;
            for (int i = 0; i < index; i++) {
                //дойдем до нужного элемента, после чего возьмем его значение
                searchedElement = first.getNext();
            }
            return searchedElement.getValue();
        } else {
            throw new IndexOutOfBoundsException("Index is invalid, please input index that will be a positive value, less than " + size);
        }
    }

    public ListElement getFirst() {
        return first;
    }

    public ListElement getLast() {
        return last;
    }
}
