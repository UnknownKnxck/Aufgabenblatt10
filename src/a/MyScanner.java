package a;

import java.io.IOException;
import java.io.InputStreamReader;

public class MyScanner {
    private final InputStreamReader inputStreamReader;

    public MyScanner(InputStreamReader inputStreamReader) {
        this.inputStreamReader = inputStreamReader;
    }

    public String nextLine() throws IOException {
        StringBuilder sb = new StringBuilder();
        int charInt;
        while ((charInt = inputStreamReader.read()) != -1) {
            char c = (char) charInt;
            // If the character is a newline, break out of the loop
            if (c == '\n') {
                break;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public int nextInt() throws IOException, NumberFormatException {
        String line = nextLine().trim();
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Input is not a valid integer");
        }
    }

    public double nextDouble() throws IOException, NumberFormatException {
        String line = nextLine().trim();
        try {
            return Double.parseDouble(line);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Input is not a valid double");
        }
    }

    public MyClass nextMyClass() throws IOException, MyClassFormatException {
        String line = nextLine().trim();
        try {
            String[] parts = line.split(",");
            int a = Integer.parseInt(parts[0]);
            double b = Double.parseDouble(parts[1]);
            return new MyClass(a, b);
        } catch (Exception e) {
            throw new MyClassFormatException("Input is not a valid MyClass");
        }
    }

    public static class MyClassFormatException extends Exception {
        public MyClassFormatException(String message) {
            super(message);
        }
    }

    public static class MyClass {
        private final int a;
        private final double b;

        public MyClass(int a, double b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "MyClass{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }
}