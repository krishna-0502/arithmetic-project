package arbitraryarithmetic;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AFloat {
    private static final int SCALE = 30;
    private final BigDecimal value;

    public AFloat() {
        this.value = BigDecimal.ZERO.setScale(SCALE, RoundingMode.DOWN);
    }

    public AFloat(String s) {
        if (s == null) throw new IllegalArgumentException("Input string cannot be null");
        this.value = new BigDecimal(s)
                         .setScale(SCALE, RoundingMode.DOWN);
    }

    public AFloat(AFloat other) {
        if (other == null) throw new IllegalArgumentException("Other cannot be null");
        this.value = other.value.setScale(SCALE, RoundingMode.DOWN);
    }

    public static AFloat parse(String s) {
        return new AFloat(s);
    }

    public AFloat add(AFloat other) {
        BigDecimal result = this.value.add(other.value)
                                  .setScale(SCALE, RoundingMode.DOWN);
        return new AFloat(result.toPlainString());
    }

    public AFloat subtract(AFloat other) {
        BigDecimal result = this.value.subtract(other.value)
                                  .setScale(SCALE, RoundingMode.DOWN);
        return new AFloat(result.toPlainString());
    }

    public AFloat multiply(AFloat other) {
        BigDecimal result = this.value.multiply(other.value)
                                  .setScale(SCALE, RoundingMode.DOWN);
        return new AFloat(result.toPlainString());
    }

    public AFloat divide(AFloat other) {
        if (other.value.compareTo(BigDecimal.ZERO) == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        BigDecimal result = this.value.divide(other.value, SCALE, RoundingMode.DOWN);
        return new AFloat(result.toPlainString());
    }

    @Override
    public String toString() {
        // strip any trailing zeros, but keep at most SCALE digits
        return value.stripTrailingZeros().toPlainString();
    }
}
