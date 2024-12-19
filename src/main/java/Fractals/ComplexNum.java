/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fractals;

/**
 *
 * @author bilyana-kr 
 */
public class ComplexNum {
    private double x;
    private double y;
    
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    
    public ComplexNum() {
        set();
    }
    public ComplexNum(double x, double y) {
        set(x, y);
    }
    public ComplexNum(ComplexNum other) {
        set(other);
    }
    
    public void set() {
        x = 0.0;
        y = 0.0;
    }
    public void set(double x, double y) {
        setX(x);
        setY(y);
    }
    public void set(ComplexNum other) {
        x = other.x;
        y = other.y;
    }
    
    public static ComplexNum sum(ComplexNum obj1, ComplexNum obj2) {
        double realPart = obj1.getX() + obj2.getX();
        double imgPart = obj1.getY() + obj2.getY();
        return new ComplexNum(realPart, imgPart);
    }
    
    public static ComplexNum product(ComplexNum obj1, ComplexNum obj2) {
        double realPart = obj1.getX()*obj2.getX() - obj1.getY()*obj2.getY();
        double imgPart = obj1.getX()*obj2.getY() + obj1.getY()*obj2.getX();
        return new ComplexNum(realPart, imgPart);
    }
    
    public static ComplexNum reciprocal(ComplexNum obj) throws ArithmeticException {
        if (obj.getX() == 0 && obj.getY() == 0) {
            throw new ArithmeticException("Division by 0!");
        }
        double realPart = obj.x / (obj.x*obj.x + obj.y*obj.y);
        double imgPart = -obj.y / (obj.x*obj.x + obj.y*obj.y);
        return new ComplexNum(realPart, imgPart);
    }
    
    public static ComplexNum power(ComplexNum obj, int power) throws ArithmeticException {
        if (obj.getX() == 0 && obj.getY() == 0 && power == 0) {
            throw new ArithmeticException("0 to the power of 0 is undefined!");
        }
        
        ComplexNum result = new ComplexNum(1, 0);
        
        boolean isNegative = false;
        
        if (power < 0) {
            isNegative = true;
            power = -power;
        }
        for (int i = 0; i < power; i++) {
            result = product(obj, result);
        }
          
        if (isNegative == true) {
            return reciprocal(result);
        } else{
            return result;
        }
    }
    
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(x);
        str.append(" ");
        str.append(y);
        return str.toString();
    }
}
