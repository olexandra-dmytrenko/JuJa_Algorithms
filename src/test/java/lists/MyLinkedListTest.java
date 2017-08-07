package lists;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by olexandra on 6/27/17.
 */
public class MyLinkedListTest {

    private static final String ПЕРВЫЙ_ЭЛЕМЕНТ = "Первый элемент";
    private static final String SECOND_ELEMENT = "Второй элемент";
    public static final String THIRD_ELEMENT = "Третий элемент";

    /*
     * Этот кейс особенный поскольку
     * в списке будет только один элемент, который одновременно будет как первым, так и последним
     * @throws Exception
     */
    @Test
    public void add1Element() throws Exception {
        MyLinkedList list = new MyLinkedList();
        list.add(ПЕРВЫЙ_ЭЛЕМЕНТ);
        ListElement expected = new ListElement(ПЕРВЫЙ_ЭЛЕМЕНТ);
        assertEquals(expected, list.getFirst());
        assertEquals(1, list.size);
    }

    /*
     * Этот кейс особенный поскольку
     * в списке будет 2 элемента, представляющие 2 разные группы: первый и последний
     * @throws Exception
     */
    @Test
    public void add2Elements() throws Exception {
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

    /*
     * Этот кейс особенный поскольку
     * в списке будет 3 элемента, представляющие 3 разные группы: первый, средний и последний.
     * Написав этот кейс, мы покрыли все группы элементов, которые могут быть в списке данной реализации.
     * Этот тест по сути включает в себя второй тест кейс. Написав его можно удалить второй, но на всякий случай можно и оставить :)
     * Это тест граничных условий.
     * @throws Exception
     */
    @Test
    public void add3Elements() throws Exception {
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
        // за счет рекурсивности в equals методе, мы проверяем все элементы, проверяя первый.
        // минусом использования сравнения через equals(object) является одновременно тестирование самого сравнения,
        // а не только работы метода добавления элемента
        assertEquals(expected1, list.getFirst());
        assertEquals(expected3.getValue(), list.getLast().getValue());
        assertEquals(3, list.size);
    }

    /*
     * Этот кейс особенный поскольку
     * при работе метода get(index) программа ни разу не зайдет в цикл поиска элемента.
     */
    @Test
    public void getFirstElementOutOfOne(){
        //GIVEN - list out of one element
        MyLinkedList list = new MyLinkedList();
        list.add(ПЕРВЫЙ_ЭЛЕМЕНТ);

        //WHEN
        String searchedElementValue = list.get(0);

        //THEN
        assertEquals(ПЕРВЫЙ_ЭЛЕМЕНТ, searchedElementValue);
    }

    /*
     * Этот кейс особенный поскольку
     * при работе метода get(index) программа зайдет в цикл поиска элемента.
     */
    @Test
    public void getSecondElementOutOfTwo(){
        //GIVEN - list out of two elements
        MyLinkedList list = new MyLinkedList();
        list.add(ПЕРВЫЙ_ЭЛЕМЕНТ);
        list.add(SECOND_ELEMENT);

        //WHEN
        String searchedElementValue = list.get(1);

        //THEN
        assertEquals(SECOND_ELEMENT, searchedElementValue);
    }

    /*
     * Проверим, что программа обрабатывает исключительную ситуацию с запросом элемента из спискас отрицательным индексом
     * Хорошей практикой евляется запись названия теста, которая включает желаемый результат
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhenGetNegativeIndex(){
        //GIVEN - list out of one element from where it's possible to get something
        MyLinkedList list = new MyLinkedList();
        list.add(ПЕРВЫЙ_ЭЛЕМЕНТ);

        //WHEN - попытаемся получить первое значение из группы (класса эквивалентности) отрицательных значений.
        list.get(-1);
    }

    /*
     * Проверим, что программа обрабатывает исключительную ситуацию с запросом элемента из списка с индексом, превышающим количество элементов в списке
     * Хорошей практикой евляется запись названия теста, которая включает желаемый результат
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhenGetElementWithIndexGreaterThanPresent(){
        //GIVEN - list out of one element from where it's possible to get something
        MyLinkedList list = new MyLinkedList();
        list.add(ПЕРВЫЙ_ЭЛЕМЕНТ);

        //WHEN - попытаемся получить второй элемент, в то время, как в списке только один
        list.get(1);
    }

    /*
     * Проверим, что программа обрабатывает исключительную ситуацию с запросом элемента из списка, в котором нет элементов.
     * Этот тест есть частным случаем теста shouldThrowExceptionWhenGetElementWithIndexGreaterThanPresent,
     * поскольку в списке 0 элементов а просим мы первый.
     * Но такой кейс лучше написать, чем сомневаться, как себя поведет программа в граничной ситуации.
     * Хорошей практикой евляется запись названия теста, которая включает желаемый результат
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhenGetElementInEmptyNonNullList(){
        //GIVEN - список без элементов. По умолдчанию поле size инициализировано нулем
        MyLinkedList list = new MyLinkedList();

        //WHEN - попытаемся получить первое значение из группы (класса эквивалентности) отрицательных значений.
        list.get(0);
    }
}