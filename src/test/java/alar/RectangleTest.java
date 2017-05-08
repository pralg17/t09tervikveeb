package alar;

/**
 * Created by Alar Aasa on 07.05.2017.
 */

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RectangleTest {
    @Test
    public void contextLoads(){}

    @Test
    public void createEmptyTest(){
        Rectangle rectangle = new Rectangle();
        rectangle.setA(5);
        rectangle.setB(6);
        Assert.assertNull(rectangle.getArea());
        Assert.assertNull(rectangle.getD());
        rectangle.setArea();
        rectangle.setD();
        Assert.assertEquals(7.81, rectangle.getD(), 0.1);
        Assert.assertEquals(30, rectangle.getArea(), 0);
    }

    @Test
    public void createRectangleTest(){
        Rectangle rectangle = new Rectangle(5, 6);
        Assert.assertEquals(7.81, rectangle.getD(), 0.1);
        Assert.assertEquals(30, rectangle.getArea(), 0);
    }
}
