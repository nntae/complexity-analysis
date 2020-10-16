public class AlgorithmBox {

    public static void fone(long n) {
        int x = 0;
        for (int i = 1; i < 12; i++) {
            x++;
        }
    }

    public static void flogn(long n) {
        int x = 0;
        for (int i = 1; i < Math.log(n); i++) {
            x++;
        }
    }

    public static void fn(long n) {
        int x = 0;
        for (int i = 1; i < Math.log(n); i++) {
            x++;
        }
    }

    public static void fnlogn(long n) {
        int x = 0;
        for (int i = 1; i < Math.log(n)*n; i++) {
            x++;
        }
    }

    public static void fn2(long n) {
        int x = 0;
        for (int i = 1; i < Math.pow(n,2); i++) {
            x++;
        }
    }

    public static void fn3(long n) {
        int x = 0;
        for (int i = 1; i < Math.pow(n,3); i++) {
            x++;
        }
    }

    public static void f2n(long n) {
        int x = 0;
        for (int i = 1; i < Math.pow(2,n)*100; i++) {
            x++;
        }
    }

    public static void ffac(long n) {
        int x = 0;
        for (int i = 1; i < (Math.sqrt(2*3.142*n) * Math.pow(n/Math.exp(1),n)) /200; i++) {
            x++;
        }
    }
}
