import java.util.ArrayList;
import java.util.List;

/**
 * Problema final: control de equipaje de un BOEING 747.
 *
 * Suposiciones:
 *  - La tarifa por kilo depende del peso TOTAL del bulto:
 *      0 a 25 kg -> $0 | más de 25 hasta 300 kg -> $1.500/kg | más de 300 hasta 500 kg -> $2.500/kg
 *  - Un bulto se rechaza si pesa más de 500 kg o si, sumado a lo ya aceptado, supera 18.000 kg.
 *  - La tasa de cambio (pesos por dólar) la ingresa el usuario.
 */
public class ProblemaFinal {

    static final double CAPACIDAD_AVION = 18000;
    static final double MAX_BULTO = 500;

    public static double tarifaPorKilo(double peso) {
        if (peso <= 25) return 0;
        if (peso <= 300) return 1500;
        return 2500;
    }

    public static void ejecutar() {
        System.out.println("1. Ingresar bultos manualmente");
        System.out.println("2. Prueba automática (16 bultos, uno es rechazado por exceder 500 kg)");
        System.out.println("3. Prueba de capacidad del avión (36 bultos de 500 kg + 1 rechazado)");
        int op = Entrada.enteroEnRango("Opción: ", 1, 3);
        double trm = Entrada.decimalEnRango("Valor de 1 dólar en pesos (ej: 4000): ", 1, 1000000);

        List<Double> aceptados = new ArrayList<Double>();

        if (op == 1) {
            System.out.println("Escribe el peso de cada bulto en kg (0 para terminar).");
            while (true) {
                double peso = Entrada.decimal("Peso del bulto: ");
                if (peso == 0) break;
                if (peso < 0) {
                    System.out.println("  El peso no puede ser negativo.");
                    continue;
                }
                registrar(aceptados, peso);
            }
        } else if (op == 2) {
            double[] prueba = {12, 25, 26, 80.5, 150, 300, 301, 450, 500, 35, 220, 18, 275, 410, 60, 520};
            for (double p : prueba) registrar(aceptados, p);
        } else {
            for (int i = 0; i < 36; i++) registrar(aceptados, 500);
            registrar(aceptados, 10); // ya no cabe: 18.000 kg completos
        }

        reporte(aceptados, trm);
    }

    /** Intenta registrar un bulto; devuelve true si fue aceptado. */
    private static boolean registrar(List<Double> aceptados, double peso) {
        if (peso > MAX_BULTO) {
            System.out.printf("  RECHAZADO: %.2f kg excede el máximo por bulto (%.0f kg).%n", peso, MAX_BULTO);
            return false;
        }
        double acumulado = 0;
        for (double p : aceptados) acumulado += p;
        if (acumulado + peso > CAPACIDAD_AVION) {
            System.out.printf("  RECHAZADO: %.2f kg supera la capacidad del avión (%.0f kg). Carga actual: %.2f kg.%n",
                    peso, CAPACIDAD_AVION, acumulado);
            return false;
        }
        aceptados.add(peso);
        return true;
    }

    private static void reporte(List<Double> pesos, double trm) {
        if (pesos.isEmpty()) {
            System.out.println("\nNo se ingresó ningún bulto.");
            return;
        }

        System.out.println("\n--------------- TABLA DE SEGUIMIENTO ---------------");
        System.out.printf("%-6s %10s %12s %14s %14s%n", "Bulto", "Peso (kg)", "Tarifa/kg", "Valor ($)", "Acum. (kg)");

        double acumulado = 0, totalPesos = 0;
        double mayor = pesos.get(0), menor = pesos.get(0);
        for (int i = 0; i < pesos.size(); i++) {
            double peso = pesos.get(i);
            double tarifa = tarifaPorKilo(peso);
            double valor = peso * tarifa;
            acumulado += peso;
            totalPesos += valor;
            if (peso > mayor) mayor = peso;
            if (peso < menor) menor = peso;
            System.out.printf("%-6d %10.2f %12.0f %,14.0f %14.2f%n", (i + 1), peso, tarifa, valor, acumulado);
        }

        System.out.println("\n--------------------- RESULTADOS ---------------------");
        System.out.println("a. Total de bultos ingresados: " + pesos.size());
        System.out.printf("b. Bulto más pesado: %.2f kg | Bulto más liviano: %.2f kg%n", mayor, menor);
        System.out.printf("c. Peso promedio de los bultos: %.2f kg%n", acumulado / pesos.size());
        System.out.printf("d. Ingreso por carga: $%,.0f COP  |  US$ %,.2f (a %,.0f COP por dólar)%n",
                totalPesos, totalPesos / trm, trm);
        System.out.printf("   Carga total: %.2f kg de %.0f kg (%.1f%% de la capacidad)%n",
                acumulado, CAPACIDAD_AVION, acumulado * 100 / CAPACIDAD_AVION);
    }
}
