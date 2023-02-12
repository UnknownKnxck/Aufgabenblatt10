package a;

import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public class CustomScanner {
        private InputStreamReader reader;

        public CustomScanner() {
            reader = new InputStreamReader(System.in);
        }

        public String readString() throws IOException {
            StringBuilder sb = new StringBuilder();
            int ch;
            while ((ch = reader.read()) != '\n' && ch != -1) {
                sb.append((char) ch);
            }
            return sb.toString();
        }

        public int readInt() throws IOException, NumberFormatException {
            String input = readString();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Invalid input. Input must be an integer.");
            }
        }

        public double readDouble() throws IOException, NumberFormatException {
            String input = readString();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Invalid input. Input must be a double.");
            }
        }

        public static class InvalidFormatException extends Exception {
            public InvalidFormatException(String message) {
                super(message);
            }
        }
    }

}
