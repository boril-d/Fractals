/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Gate
 */
public class ComplexNum {
     private double x;
    private double y;
    
    public double getX(){
        return x;
    }
    public void setX (double x){
        this.x = x;
    }
    
    public double getY(){
        return y;
    }
    public void setY (double y){
        this.y = y;
    }
    
    public ComplexNum (double x, double y){
        setX(x);
        setY(y);
    }
    
    public ComplexNum (){
        this(0,0);
    }
    
    public ComplexNum (ComplexNum obj){
        this(obj.getX(), obj.getY());
    }
    
    public static ComplexNum SumOfCmplxNum(ComplexNum obj1, ComplexNum obj2){
        double realPart = obj1.getX() + obj2.getX();
        double imgPart = obj1.getY() + obj2.getY();
        return new ComplexNum (realPart, imgPart);
    }
    
    public static ComplexNum ProductOfCmplxNum(ComplexNum obj1, ComplexNum obj2){
        double realPart = obj1.getX()*obj2.getX() - obj1.getY()*obj2.getY();
        double imgPart = obj1.getX()*obj2.getY() + obj1.getY()*obj2.getX();
        return new ComplexNum (realPart, imgPart);
    }
    
    public static ComplexNum ReciprocalOfCmplxNum (ComplexNum obj) throws ArithmeticException{
        if (obj.getX() == 0 && obj.getY() == 0){
            throw new ArithmeticException("Division by 0!");
        }
        double realPart = obj.x / (obj.x*obj.x + obj.y*obj.y);
        double imgPart = -obj.y / (obj.x*obj.x + obj.y*obj.y);
        return new ComplexNum (realPart, imgPart);
    }
    
    public static ComplexNum PowerOfCmplxNum (ComplexNum obj, int power) throws IllegalArgumentException {
        
        if (power >= -1 && power <= 1){
            throw new IllegalArgumentException ("The power of z must be > 1 or < -1.");
        }
        ComplexNum result = new ComplexNum(1, 0);
        
        boolean isNegative = false;
        
        if (power < -1) {
            isNegative = true;
            power = -power;
        }
        for (int i = 0; i < power; i++){
            result = ProductOfCmplxNum(obj, result);
        }
        if (isNegative == true) return ReciprocalOfCmplxNum(result);
        else{
            return result;
        }
    }

}
