// File: arbitraryarithmetic/MyInfArith.java
package arbitraryarithmetic;

/**
 * Command‐line driver for AInteger and AFloat.
 * Usage: java arbitraryarithmetic.MyInfArith <int|float> <add|sub|mul|div> <op1> <op2>
 */
public class MyInfArith {
    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("Usage: <int|float> <add|sub|mul|div> <operand1> <operand2>");
            return;
        }

        String type = args[0], op = args[1], a = args[2], b = args[3];
        try {
            switch (type) {
              case "int":   runInt(op, a, b);   break;
              case "float": runFloat(op, a, b); break;
              default:
                System.out.println("Type must be 'int' or 'float'.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void runInt(String op, String a, String b) {
        AInteger x = AInteger.parse(a), y = AInteger.parse(b);
        switch (op) {
          case "add": System.out.println(x.add(y)); break;
          case "sub": System.out.println(x.subtract(y)); break;
          case "mul": System.out.println(x.multiply(y)); break;
          case "div": System.out.println(x.divide(y)); break;
          default:    System.out.println("Invalid integer operation.");
        }
    }

    private static void runFloat(String op, String a, String b) {
        AFloat x = AFloat.parse(a), y = AFloat.parse(b);
        switch (op) {
          case "add": System.out.println(x.add(y)); break;
          case "sub": System.out.println(x.subtract(y)); break;
          case "mul": System.out.println(x.multiply(y)); break;
          case "div": System.out.println(x.divide(y)); break;
          default:    System.out.println("Invalid float operation.");
        }
    }
}
