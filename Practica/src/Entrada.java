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
        // Lee hasta el enter //
    }

    public static int entero(String mensaje) {
        while (true) {
            try {
                return Integer.parseInt(texto(mensaje).trim());
            } catch (NumberFormatException e) {
                System.out.println("  Valor inválido, escribe un número entero.");
            }
        }
        // texto a int //
    }

    public static int enteroEnRango(String mensaje, int min, int max) {
        while (true) {
            int n = entero(mensaje);
            if (n >= min && n <= max) return n;
            System.out.println("  El valor debe estar entre " + min + " y " + max + ".");
        }
        // para limitar, dias o digitos//
    }

    public static double decimal(String mensaje) {
        while (true) {
            try {
                return Double.parseDouble(texto(mensaje).trim().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("  Valor inválido, escribe un número (ej: 3.5).");
            }
        }
        // permite la coma y la reemplaza por el punto//
    }

    public static double decimalEnRango(String mensaje, double min, double max) {
        while (true) {
            double n = decimal(mensaje);
            if (n >= min && n <= max) return n;
            System.out.println("  El valor debe estar entre " + min + " y " + max + ".");
        }
        // decimales en rango //
    }

    public static String repetir(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(s);
        return sb.toString();
    }
    // Repite un texto n veces //
}
