import java.util.function.Predicate;

public interface MyFunction {
    public int apply(int i);

    default MyFunction conditionateInput(Predicate<Integer> predicate) {
        return (value) -> predicate.test(value) ? this.apply(value) : 0;
    }

    default MyFunction conditionateOutput(Predicate<Integer> predicate) {
        return (value) -> predicate.test(apply(value)) ? this.apply(value) : 0;
    }
}
