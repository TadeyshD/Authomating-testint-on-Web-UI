package hw_4;

import java.util.function.BooleanSupplier;

public class TaskClass {
    public double training(double a, double b, double c) throws MyException {
        double p = (a+b+c)/2;
        if(a<0 || b<0 || c<0) throw new MyException("Введённое значение меньше нуля");
        double s=p*(p-a)*(p-b)*(p-c);
        double result = Math.sqrt(s);
        return result ;
    }
    }

