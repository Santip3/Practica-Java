import java.util.Scanner;
// Usa un solo Scanner para el programa //
public class Entrada {
    private static final Scanner sc = new Scanner(System.in);
    //System.in es lo que uno inserta //
    public static String texto(String mensaje) {
        System.out.print(mensaje);
        if (!sc.hasNextLine()) {
            throw new IllegalStateException("Fin de la entrada de datos");
        }
        return sc.nextLine();
    }

    public static int entero(String mensaje) {
        while (true) {
            try {
                return Integer.parseInt(texto(mensaje).trim());
            } catch (NumberFormatException e) {
                System.out.println("  Valor inválido, escribe un número entero.");
            }
        }
    }

    public static int enteroEnRango(String mensaje, int min, int max) {
        while (true) {
            int n = entero(mensaje);
            if (n >= min && n <= max) return n;
            System.out.println("  El valor debe estar entre " + min + " y " + max + ".");
        }
    }

    public static double decimal(String mensaje) {
        while (true) {
            try {
                return Double.parseDouble(texto(mensaje).trim().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("  Valor inválido, escribe un número (ej: 3.5).");
            }
        }
    }

    public static double decimalEnRango(String mensaje, double min, double max) {
        while (true) {
            double n = decimal(mensaje);
            if (n >= min && n <= max) return n;
            System.out.println("  El valor debe estar entre " + min + " y " + max + ".");
        }
    }

    /** Repite un texto n veces (equivalente a String.repeat, compatible con Java 8). */
    public static String repetir(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(s);
        return sb.toString();
    }
}
