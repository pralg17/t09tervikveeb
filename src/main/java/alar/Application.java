package alar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Alar Aasa on 07.05.2017.
 */
@RestController
@SpringBootApplication
public class Application {
    private final RectangleDao rectangleDao;

    @Autowired
    public Application(RectangleDao rectangleDao){
        this.rectangleDao = rectangleDao;
    }

    @RequestMapping("/listCreatedRectangles")
    public String listCreatedRectangles(){
        StringBuilder stringBuilder = new StringBuilder();
        for(Rectangle item: rectangleDao.findAll()){
            stringBuilder.append("<br>A: ").
                    append(item.getA()).
                    append(" | B:").
                    append(item.getB()).
                    append(" | Diagonal: ").
                    append(item.getD()).
                    append(" | Area: ").
                    append(item.getArea());
        }
        return stringBuilder.toString();
    }

    @RequestMapping("/createRectangle")
    public String createRectangle(Integer a, Integer b){
        Rectangle rectangle = new Rectangle(a, b);
        rectangleDao.save(rectangle);
        return "Rectangle created.";
    }
}
