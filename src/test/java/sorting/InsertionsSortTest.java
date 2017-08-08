package sorting;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Oleksandra_Dmytrenko on 8/8/2017.
 */
public class InsertionsSortTest {

    /*
    Самый простой тест, который можно придумать это если у нас есть лист уже отсортированный, то он на выходе так и останется.
     */
    @Test
    public void insertionsSortDoesntBreakSortedList() {
        //GIVEN
        LinkedList<Integer> listToSort = new LinkedList<Integer>(Arrays.asList(-6, -1, 2, 3, 4));

        //WHEN
        List<Integer> sortedList = InsertionsSort.insertionsSort(listToSort);

        //THEN
        assertEquals(listToSort, sortedList);
    }

    /*
    Самый нужный тест, который проверит, что сортировка делает свою работу. Введем список, в котором куча мешанины разного рода:
    первый и последний элементы не на своих местах и в середине все не так, есть дубликаты.
     */
    @Test
    public void insertionsSortActuallySorts() {
        //GIVEN
        LinkedList<Integer> listToSort = new LinkedList<Integer>(Arrays.asList(6, -1, 8, -2, 8, 12, -32, 3, 4, 7));
        LinkedList<Integer> listToExpect = new LinkedList<Integer>(Arrays.asList(-32, -2, -1, 3, 4, 6, 7, 8, 8, 12));

        //WHEN
        List<Integer> sortedList = InsertionsSort.insertionsSort(listToSort);

        //THEN
        assertEquals(listToExpect, sortedList);
    }

    /*
    Еще нужный тест для проверки граничных условий, когда список из одного элемента.
    Говорит о том, что все границы в циклах расставлены правильно.
    */
    @Test
    public void insertionsSortOneElement() {
        //GIVEN
        LinkedList<Integer> listToSort = new LinkedList<Integer>(Arrays.asList(Integer.MAX_VALUE));

        //WHEN
        List<Integer> sortedList = InsertionsSort.insertionsSort(listToSort);

        //THEN
        assertEquals(listToSort, sortedList);
    }

    /*
    Еще нужный тест для проверки граничных условий, когда список из двух элементов.
    Говорит о том, что все границы в циклах расставлены правильно.
    */
    @Test
    public void insertionsSortTwoElements() {
        //GIVEN
        LinkedList<Integer> listToSort = new LinkedList<Integer>(Arrays.asList(Integer.MAX_VALUE, Integer.MIN_VALUE));
        LinkedList<Integer> listToExpect = new LinkedList<Integer>(Arrays.asList(Integer.MIN_VALUE, Integer.MAX_VALUE));

        //WHEN
        List<Integer> sortedList = InsertionsSort.insertionsSort(listToSort);

        //THEN
        assertEquals(listToExpect, sortedList);
    }
}