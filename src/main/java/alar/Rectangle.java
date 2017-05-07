package alar;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;

import static java.lang.Math.sqrt;

/**
 * Created by Alar Aasa on 07.05.2017.
 */
@Entity
@Table(name="rectangle")
public class Rectangle {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer a;
    private Integer b;
    private Integer area;
    private Double d;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }



    Double getD() {
        return d;
    }

    public void setD() {
        this.d = sqrt(a*a+b*b);
    }

    Integer getArea() {
        return area;
    }

    public void setArea() {
        this.area = a*b;
    }

    public Rectangle(){}

    Rectangle(Integer a, Integer b){
        this.a = a;
        this.b = b;
        setArea();
        setD();
    }
}
