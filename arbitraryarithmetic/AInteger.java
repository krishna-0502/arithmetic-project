package arbitraryarithmetic;

import java.math.BigInteger;

public class AInteger {
    private final BigInteger value;

    public AInteger() {
        this.value = BigInteger.ZERO;
    }

    public AInteger(String s) {
        this.value = new BigInteger(s);
    }

    public AInteger(AInteger other) {
        this.value = new BigInteger(other.value.toString());
    }

    public static AInteger parse(String s) {
        return new AInteger(s);
    }

    public AInteger add(AInteger other) {
        return new AInteger(this.value.add(other.value).toString());
    }

    public AInteger subtract(AInteger other) {
        return new AInteger(this.value.subtract(other.value).toString());
    }

    public AInteger multiply(AInteger other) {
        return new AInteger(this.value.multiply(other.value).toString());
    }

    public AInteger divide(AInteger other) {
        if (other.value.equals(BigInteger.ZERO)) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return new AInteger(this.value.divide(other.value).toString());
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
