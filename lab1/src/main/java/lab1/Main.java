package lab1;

import java.util.Arrays;
import java.util.Locale;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[ ] args) {
        int[] a;
        a = new int[12];
        for (int i = 0; i<23; i+=2){
            a[i/2]=23-i;
        }
        System.out.println(Arrays.toString(a));

        double[] x;
        x = new double[10];
        for (int i=0; i<10; i++){
            x[i]=3 + (double) (Math.random() * (-11));
        }
        for (int i=0; i<10; i++){
            x[i]*=10000;
            x[i]=Math.round(x[i]);
            x[i]/=10000;
        }
        System.out.println(Arrays.toString(x));

        int[] x3 = {1,3,5,9,13,23};
        double [][] arr2 = new double[10][12];
        double z;
        for (int i=0; i<12;i++){
            int v=a[i];
            for (int j=0; j<10; j++){
                boolean n =false;
                n=(IntStream.of(x3).anyMatch(m -> m == v));

                if (a[i]==7){
                    z=Math.cos(Math.atan(Math.cos(x[i])));
                    z*=10000;
                    z=Math.round(z);
                    z/=10000;
                    arr2[j][i] = z;
                }
                else if (n) {
                    double xx = Math.cbrt(x[j]);
                    double pwr = 2 * Math.log(Math.abs(x[j]));
                    double x_pwr = xx > 0 ? Math.pow(xx, pwr) : -Math.pow(-xx, pwr);
                    z = Math.pow(x_pwr, 2);
                    z*=10000;
                    z=Math.round(z);
                    z/=10000;
                    if (z==0.0){
                        System.out.println(i+"h"+j);
                    }
                    arr2[j][i] = z;
                }
                else {
                    z=Math.pow((2*(1-Math.atan(1/Math.pow(Math.E,Math.abs(Math.cos((1-x[i])/x[i])))))),Math.pow(Math.E,Math.sin(Math.atan((x[i]-4)/14))));
                    z*=10000;
                    z=Math.round(z);
                    z/=10000;
                    arr2[j][i] = z;
                }
                System.out.printf(Locale.US," " + "%10.4f", arr2[j][i]);
            }
            System.out.println();
        }
    }
}
