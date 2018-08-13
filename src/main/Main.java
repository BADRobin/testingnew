package main;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public final static double EPS = 1e-6;

    private double a = 2.8;
    private double b = -0.3;
    private double c = 4.0;
    public static void main(String[] args) {

    }
    public double f(double x){
        if (x< 1.4-EPS){
            return a*x*x+b*x+c;
        }else if (x>1.4+EPS){
            return (a+b*x)/Math.sqrt(x*x+1);
        }else {
            return a/x+Math.sqrt(x*x+1);
        }
    }
    public int steps(double start, double finish, double step){
        return (int) ((finish-start)/step+1);
    }
    public double[] fillX(double start, double finish, double step) {
        return IntStream
                .iterate(0, i->i+1)
                .mapToDouble(i->start+i*step)
                .limit(steps(start,finish,step))
                .toArray();
    }

    public double[] fillY(double[] x) {
        return Arrays.stream(x)
                .map(this::f)
                .toArray();
    }

    public double sum(double[] arr) {
        return Arrays.stream(arr)
                .reduce(0, (a,b) -> a+b);
    }

    public double numMin(double[] arr) {
        int res = 0;
        for (int i = 1; i <arr.length; i++) {
            if (arr[i] < arr[res]) {
                res = i;
            }
        }
        return res;
    }
}
//Додати до створеного класу метод main, перетворивши, таким чином, його на
//автономну програму. Cкомпілювати і виконати програму
