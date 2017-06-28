package lists;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by olexandra on 6/27/17.
 */
public class MyLinkedListTest {

    private static final String ПЕРВЫЙ_ЭЛЕМЕНТ = "Первый элемент";
    private static final String SECOND_ELEMENT = "SecondElement";
    public static final String THIRD_ELEMENT = "ThirdElement";

    @Test
    public void add1() throws Exception {
        MyLinkedList list = new MyLinkedList();
        list.add(ПЕРВЫЙ_ЭЛЕМЕНТ);
        ListElement expected = new ListElement(ПЕРВЫЙ_ЭЛЕМЕНТ);
        assertEquals(expected, list.getFirst());
        assertEquals(1, list.size);
    }

    @Test
    public void add2() throws Exception {
        //GIVEN
        MyLinkedList list = new MyLinkedList();
        ListElement expected1 = new ListElement(ПЕРВЫЙ_ЭЛЕМЕНТ);
        ListElement expected2 = new ListElement(SECOND_ELEMENT);
        expected1.setNext(expected2);
        expected2.setPrev(expected1);
        //WHEN
        list.add(ПЕРВЫЙ_ЭЛЕМЕНТ);
        list.add(SECOND_ELEMENT);
        //THEN
//        assertEquals(expected1.getValue(), list.getFirst().getValue());
        assertEquals(expected1, list.getFirst());
        assertEquals(expected2.getValue(), list.getLast().getValue());
        assertEquals(2, list.size);
    }

    @Test
    public void add3() throws Exception {
        //GIVEN
        MyLinkedList list = new MyLinkedList();
        ListElement expected1 = new ListElement(ПЕРВЫЙ_ЭЛЕМЕНТ);
        ListElement expected2 = new ListElement(SECOND_ELEMENT);
        ListElement expected3 = new ListElement(THIRD_ELEMENT);
        expected1.setNext(expected2);
        expected2.setPrev(expected1);
        expected3.setPrev(expected2);
        expected2.setNext(expected3);
        //WHEN
        list.add(ПЕРВЫЙ_ЭЛЕМЕНТ);
        list.add(SECOND_ELEMENT);
        list.add(THIRD_ELEMENT);
        //THEN
        assertEquals(expected1, list.getFirst()); // за счет рекурсивности в equals методе, мы проверяем все элементы, проверяя первый.
        assertEquals(expected3.getValue(), list.getLast().getValue());
        assertEquals(3, list.size);
    }
}