public class Factorial implements MyFunction {
    @Override
    public int apply(int x) {
        int temp = 1;
        for (int i = x; i > 1; i--) {
            temp *= i;
        }
        return temp;
    }
}
