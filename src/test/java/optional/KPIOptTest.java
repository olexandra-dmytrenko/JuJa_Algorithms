package optional;

import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class KPIOptTest {

    @Test
    public void shouldReturnEmpty_whenOnNullObject() {
        KPIOpt.Person person = null;
        Optional<Integer> age = Optional.ofNullable(person).map(p -> p.age);

        assertNull(person);
        assertEquals(Optional.empty(), age);
    }

    @Test
    public void shouldReturnAge_whenOnInitialisedObject() {
        KPIOpt.Person person = new KPIOpt.Person("myself", 3);
        Optional<Integer> age = Optional.ofNullable(person).map(p -> p.age);

        assertNotNull(person);
        assertEquals(3, age.get(), 0.1);
    }

    @Test
    public void shouldReturnEmpty1_whenOnNullObject() {
        KPIOpt.Person person = new KPIOpt.Person("myself", null);
        Optional<Integer> age = Optional.ofNullable(person).map(p -> p.age);

        if (age.isPresent()) {
            assertNotNull(person);
            assertEquals(3, age.get(), 0.1);
        }
    }

    @Test
    public void ex1() throws SQLException, IndexOutOfBoundsException {
        Stream.of(1, 2).map(el -> ex(el));
    }

    @Test
    public String ex(int... a) throws IndexOutOfBoundsException {
        try {
            //int[] a = {1, 2};
            for (int i = 0; i <= a.length; i++) {
                if (i == 1)
                    throw new IOException();
                else throw new SQLException();
            }
        } catch (IndexOutOfBoundsException | SQLException ex) {
            System.out.println("not serious");
        } catch (Exception e) {
            System.out.println("error");
            throw new MyEx(e);
        } finally {

        }
        return "";
    }
}