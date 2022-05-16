package hw_4;

public class main extends TaskClass{
    public static void main(String[] args) throws MyException {
        double a = 30;
        double b = 15;
        double c = 20;
        double p = (a+b+c)/2;
        double s = p*(p-a)*(p-b)*(p-c);
        double result = Math.sqrt(s);
        System.out.println(s);
        System.out.println(result);
    }
}
