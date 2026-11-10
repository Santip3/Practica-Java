import java.text.Normalizer;

public class ParteIII {

    // 25. Función invertirTexto
    public static String invertirTexto(String original) {
        return new StringBuilder(original).reverse().toString();
    }

    public static void ejercicio25() {
        String t = Entrada.texto("Texto: ");
        System.out.println(invertirTexto(t));
    }

    // 26. Primera letra de cada palabra en mayúscula
    public static void ejercicio26() {
        String t = Entrada.texto("Texto: ").trim();
        if (t.isEmpty()) {
            System.out.println("No escribiste nada.");
            return;
        }
        String[] palabras = t.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String p : palabras) {
            sb.append(Character.toUpperCase(p.charAt(0)))
              .append(p.substring(1).toLowerCase())
              .append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    // 27. Penúltima palabra
    public static void ejercicio27() {
        String t = Entrada.texto("Texto: ").trim();
        String[] palabras = t.isEmpty() ? new String[0] : t.split("\\s+");
        if (palabras.length < 2) {
            System.out.println("El texto necesita al menos 2 palabras.");
        } else {
            System.out.println("Penúltima palabra: " + palabras[palabras.length - 2]);
        }
    }

    // 28. ¿El segundo texto contiene al primero?
    public static void ejercicio28() {
        String t1 = Entrada.texto("Primer texto (el que se busca): ");
        String t2 = Entrada.texto("Segundo texto (donde se busca): ");
        if (t2.contains(t1)) {
            System.out.println("SÍ, el segundo texto contiene al primero.");
        } else {
            System.out.println("NO, el segundo texto no contiene al primero.");
        }
    }

    // 29. Función esPalindromo (ignora mayúsculas, tildes, espacios y signos)
    public static boolean esPalindromo(String palabra) {
        String limpia = Normalizer.normalize(palabra, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .replaceAll("[^A-Za-z0-9]", "")
                .toLowerCase();
        return new StringBuilder(limpia).reverse().toString().equals(limpia);
    }

    public static void ejercicio29() {
        String p = Entrada.texto("Palabra: ");
        System.out.println(esPalindromo(p)
                ? "\"" + p + "\" SÍ es palíndromo (true)"
                : "\"" + p + "\" NO es palíndromo (false)");
    }

    // 30. Área de cualquier polígono (simple) a partir de sus vértices - fórmula de Shoelace
    public static double areaPoligono(double[] x, double[] y) {
        double suma = 0;
        int n = x.length;
        for (int i = 0; i < n; i++) {
            int j = (i + 1) % n;
            suma += x[i] * y[j] - x[j] * y[i];
        }
        return Math.abs(suma) / 2;
    }

    public static void ejercicio30() {
        int n = Entrada.enteroEnRango("Número de vértices (mínimo 3): ", 3, 1000);
        double[] x = new double[n];
        double[] y = new double[n];
        System.out.println("Ingresa los vértices EN ORDEN (horario o antihorario):");
        for (int i = 0; i < n; i++) {
            x[i] = Entrada.decimal("  x" + (i + 1) + ": ");
            y[i] = Entrada.decimal("  y" + (i + 1) + ": ");
        }
        System.out.printf("Área del polígono: %.4f%n", areaPoligono(x, y));
    }
}
