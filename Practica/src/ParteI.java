import java.math.BigDecimal;
import java.math.BigInteger;

public class ParteI {

    // 1. Concatenar dos textos separados por un espacio
    public static void ejercicio1() {
        String a = Entrada.texto("Primer texto: ");
        String b = Entrada.texto("Segundo texto: ");
        System.out.println(a + " " + b);
    }

    // 2. "Hola" y tu nombre en la misma línea
    public static void ejercicio2() {
        String nombre = Entrada.texto("Escribe tu nombre: ");
        System.out.print("Hola ");
        System.out.println(nombre);
    }

    // 3. Cuadrado de un número
    public static void ejercicio3() {
        double n = Entrada.decimal("Número: ");
        System.out.println("El cuadrado de " + n + " es " + (n * n));
    }

    // 4. Suma de dos números
    public static void ejercicio4() {
        double a = Entrada.decimal("Primer número: ");
        double b = Entrada.decimal("Segundo número: ");
        System.out.println("Suma: " + (a + b));
    }

    // 5. Suma, resta, multiplicación, división y residuo
    public static void ejercicio5() {
        double a = Entrada.decimal("Primer número: ");
        double b = Entrada.decimal("Segundo número: ");
        System.out.println("Suma: " + (a + b));
        System.out.println("Resta: " + (a - b));
        System.out.println("Multiplicación: " + (a * b));
        if (b == 0) {
            System.out.println("División: no se puede dividir por cero");
            System.out.println("Residuo: no se puede dividir por cero");
        } else {
            System.out.println("División: " + (a / b));
            System.out.println("Residuo: " + (a % b));
        }
    }

    // 6. Parte entera y parte decimal (se usa BigDecimal para no perder precisión)
    public static void ejercicio6() {
        String s = Entrada.texto("Número decimal: ").trim().replace(',', '.');
        try {
            BigDecimal numero = new BigDecimal(s);
            BigInteger entera = numero.toBigInteger();
            BigDecimal decimal = numero.subtract(new BigDecimal(entera)).abs();
            System.out.println("Parte entera: " + entera);
            System.out.println("Parte decimal: " + decimal.toPlainString());
        } catch (NumberFormatException e) {
            System.out.println("Eso no es un número válido.");
        }
    }

    // 7. Función calcularPromedio (5 notas con porcentajes)
    public static double calcularPromedio(double n1, double n2, double n3, double n4, double n5) {
        return n1 * 0.15 + n2 * 0.20 + n3 * 0.15 + n4 * 0.30 + n5 * 0.20;
    }

    /** Lee las cinco notas (0.0 a 5.0). Se reutiliza en el ejercicio 18. */
    public static double[] leerCincoNotas() {
        double[] n = new double[5];
        for (int i = 0; i < 5; i++) {
            n[i] = Entrada.decimalEnRango("Nota " + (i + 1) + " (0 a 5): ", 0, 5);
        }
        return n;
    }

    public static void ejercicio7() {
        double[] n = leerCincoNotas();
        double nota = calcularPromedio(n[0], n[1], n[2], n[3], n[4]);
        System.out.printf("Nota final: %.2f%n", nota);
    }

    // 8. Función calcularIVA: recibe precio bruto y devuelve precio con IVA (19%)
    public static double calcularIVA(double precioBruto) {
        return precioBruto * 1.19;
    }

    public static void ejercicio8() {
        double bruto = Entrada.decimal("Precio bruto: ");
        double conIva = calcularIVA(bruto);
        System.out.printf("Valor original: %.2f%n", bruto);
        System.out.printf("Valor del IVA (19%%): %.2f%n", conIva - bruto);
        System.out.printf("Valor con IVA incluido: %.2f%n", conIva);
    }

    // 9. Área y perímetro de un círculo
    public static void ejercicio9() {
        double r = Entrada.decimal("Radio: ");
        System.out.printf("Área: %.4f%n", Math.PI * r * r);
        System.out.printf("Perímetro: %.4f%n", 2 * Math.PI * r);
    }

    // 10. Área de un hexágono regular: (3 * raíz(3) / 2) * lado²
    public static void ejercicio10() {
        double lado = Entrada.decimal("Longitud del lado del hexágono regular: ");
        double area = (3 * Math.sqrt(3) / 2) * lado * lado;
        System.out.printf("Área del hexágono: %.4f%n", area);
    }

    // 11. Promedio de n números
    public static void ejercicio11() {
        int n = Entrada.enteroEnRango("¿Cuántos números? ", 1, Integer.MAX_VALUE);
        double suma = 0;
        for (int i = 1; i <= n; i++) {
            suma += Entrada.decimal("Número " + i + ": ");
        }
        System.out.println("Promedio: " + (suma / n));
    }

    // 12. Distancia entre dos puntos
    public static void ejercicio12() {
        double x1 = Entrada.decimal("x1: ");
        double y1 = Entrada.decimal("y1: ");
        double x2 = Entrada.decimal("x2: ");
        double y2 = Entrada.decimal("y2: ");
        double d = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        System.out.printf("Distancia: %.4f%n", d);
    }

    // 13. Dígito n -> n, nn, nnn y su suma
    public static void ejercicio13() {
        int n = Entrada.enteroEnRango("Dígito (0 a 9): ", 0, 9);
        int nn = n * 11;
        int nnn = n * 111;
        System.out.println(n);
        System.out.println(nn);
        System.out.println(nnn);
        System.out.println("Suma: " + (n + nn + nnn));
    }

    // 14. Segundos -> horas:minutos:segundos
    public static void ejercicio14() {
        long total = Entrada.enteroEnRango("Cantidad de segundos: ", 0, Integer.MAX_VALUE);
        long h = total / 3600;
        long m = (total % 3600) / 60;
        long s = total % 60;
        System.out.printf("%02d:%02d:%02d%n", h, m, s);
    }
}
