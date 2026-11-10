public class ParteIV {

    // 31. Primeros 10 naturales
    public static void ejercicio31() {
        for (int i = 1; i <= 10; i++) System.out.println(i);
    }

    // 32. Primeros 10 naturales impares
    public static void ejercicio32() {
        for (int i = 1; i <= 10; i++) System.out.println(2 * i - 1);
    }

    // 33. Primeros 10 naturales pares
    public static void ejercicio33() {
        for (int i = 1; i <= 10; i++) System.out.println(2 * i);
    }

    // 34. Pedir un entero positivo hasta que sea válido
    public static void ejercicio34() {
        int n;
        do {
            n = Entrada.entero("Digita un número entero positivo: ");
            if (n <= 0) System.out.println("  Valor no permitido, intenta de nuevo.");
        } while (n <= 0);
        System.out.println("Número válido: " + n);
    }

    // 35. Decimal -> binario (división sucesiva entre 2)
    public static void ejercicio35() {
        int n = Entrada.enteroEnRango("Número decimal (entero >= 0): ", 0, Integer.MAX_VALUE);
        if (n == 0) {
            System.out.println("Binario: 0");
            return;
        }
        String binario = "";
        int temp = n;
        while (temp > 0) {
            binario = (temp % 2) + binario;
            temp /= 2;
        }
        System.out.println("Binario: " + binario);
    }

    // 36. Binario -> decimal
    public static void ejercicio36() {
        String bin;
        while (true) {
            bin = Entrada.texto("Número binario: ").trim();
            if (bin.matches("[01]+")) break;
            System.out.println("  Solo se permiten 0 y 1.");
        }
        long decimal = 0;
        for (int i = 0; i < bin.length(); i++) {
            decimal = decimal * 2 + (bin.charAt(i) - '0');
        }
        System.out.println("Decimal: " + decimal);
    }

    // 37. Patrón 1, 12, 123 ... hasta 12345678910
    public static void ejercicio37() {
        for (int fila = 1; fila <= 10; fila++) {
            StringBuilder linea = new StringBuilder();
            for (int j = 1; j <= fila; j++) linea.append(j);
            System.out.println(linea);
        }
    }

    // 38. Triángulo creciente de @
    public static void ejercicio38() {
        int filas = Entrada.enteroEnRango("Número de filas: ", 1, 200);
        for (int i = 1; i <= filas; i++) {
            System.out.println(Entrada.repetir("@", i));
        }
    }

    // 39. Triángulo invertido de * (alineado a la derecha)
    public static void ejercicio39() {
        int filas = Entrada.enteroEnRango("Número de filas: ", 1, 200);
        for (int i = 0; i < filas; i++) {
            System.out.println(Entrada.repetir(" ", i) + Entrada.repetir("*", filas - i));
        }
    }
}
