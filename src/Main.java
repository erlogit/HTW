import java.util.function.Predicate;


public class Main {

    public class InnerFactorial implements MyFunction {
        @Override
        public int apply(int x) {
            int temp = 1;
            for (int i = x; i > 1; i--) {
                temp *= i;
            }
            return temp;
        }

    }
    public static void main(String[] args) {
        MyFunction squaredFunction = (int x) -> x * x;

        MyFunction anClassSquaredFunction = new MyFunction() {
            @Override
            public int apply(int x) {
                return x * x;
            }
        };

        MyFunction factorial = (int x) -> {
            int temp = 1;
            for (int i = x; i > 1; i--) {
                temp *= i;
            }
            return temp;
        };

        MyFunction anClassFactorial = new MyFunction() {
            @Override
            public int apply(int x) {
                int temp = 1;
                for (int i = x; i > 1; i--) {
                    temp *= i;
                }
                return temp;
            }
        };

        MyFunction xtoxplus1 = (int x) -> {
            int temp = 1;
            for (int i = x; i >= 0; i--) {
                temp *= x;
            }
            return temp;
        };

        MyFunction fibo = (int x) -> {
            int result = 0;
            int temp1 = 0;
            int temp2 = 1;
            for (int i = 1; i < x; i++) {
                result = temp1 + temp2;
                temp1 = temp2;
                temp2 = result;
            }
            return result;
        };

//        applyAndPrint(3,5,squaredFunction);
//        applyAndPrint(2,10,factorial);
//        applyAndPrint(2,3,xtoxplus1);
//        applyAndPrint(3,5,fibo);

        // Aufgabe d
        Predicate<Integer> odd = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 != 0;
            }
        };

        Predicate<Integer> even = (Integer value) -> value % 2 == 0;

        System.out.println(odd.test(5));
        System.out.println(even.test(5));


        // Aufgabe e
        applyAndPrint(4,5,squaredFunction.conditionateInput(even));


        // Aufgabe f
        applyAndPrint(4,5,factorial.conditionateOutput(even));
    }

        public static void applyAndPrint(int i, int j, MyFunction f) {
            for (int k = i; k <= j; k++) {
                System.out.println("f(" + k + ") = " + f.apply(k));
            }
        }

}
