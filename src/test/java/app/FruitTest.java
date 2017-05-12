package app;

import org.junit.*;
import static org.junit.Assert.*;

public class FruitTest{

    @Test
    public void incrementTest(){
        Fruit apple = new Fruit("Apple", 1, 3);
        apple.increment();
        assertEquals(2, apple.amount);
    }

    @Test
    public void sumTest(){
        Fruit apple = new Fruit("Apple", 2, 5);
        apple.increment();
        apple.increment();
        assertEquals(20, apple.sum(), 0.1);
    }

}