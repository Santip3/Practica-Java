/**
 * Menú principal: elige el número del ejercicio y se ejecuta.
 */
public class Main {

    public static void main(String[] args) {
        Runnable[] ej = new Runnable[41];

        // PARTE I
        ej[1] = ParteI::ejercicio1;   ej[2] = ParteI::ejercicio2;   ej[3] = ParteI::ejercicio3;
        ej[4] = ParteI::ejercicio4;   ej[5] = ParteI::ejercicio5;   ej[6] = ParteI::ejercicio6;
        ej[7] = ParteI::ejercicio7;   ej[8] = ParteI::ejercicio8;   ej[9] = ParteI::ejercicio9;
        ej[10] = ParteI::ejercicio10; ej[11] = ParteI::ejercicio11; ej[12] = ParteI::ejercicio12;
        ej[13] = ParteI::ejercicio13; ej[14] = ParteI::ejercicio14;
        // PARTE II
        ej[15] = ParteII::ejercicio15; ej[16] = ParteII::ejercicio16; ej[17] = ParteII::ejercicio17;
        ej[18] = ParteII::ejercicio18; ej[19] = ParteII::ejercicio19; ej[20] = ParteII::ejercicio20;
        ej[21] = ParteII::ejercicio21; ej[22] = ParteII::ejercicio22; ej[23] = ParteII::ejercicio23;
        ej[24] = ParteII::ejercicio24;
        // PARTE III
        ej[25] = ParteIII::ejercicio25; ej[26] = ParteIII::ejercicio26; ej[27] = ParteIII::ejercicio27;
        ej[28] = ParteIII::ejercicio28; ej[29] = ParteIII::ejercicio29; ej[30] = ParteIII::ejercicio30;
        // PARTE IV
        ej[31] = ParteIV::ejercicio31; ej[32] = ParteIV::ejercicio32; ej[33] = ParteIV::ejercicio33;
        ej[34] = ParteIV::ejercicio34; ej[35] = ParteIV::ejercicio35; ej[36] = ParteIV::ejercicio36;
        ej[37] = ParteIV::ejercicio37; ej[38] = ParteIV::ejercicio38; ej[39] = ParteIV::ejercicio39;
        // PROBLEMA FINAL
        ej[40] = ProblemaFinal::ejecutar;

        mostrarMenu();
        try {
            while (true) {
                int op = Entrada.enteroEnRango("\nEjercicio a probar (0 = salir, -1 = ver menú): ", -1, 40);
                if (op == 0) break;
                if (op == -1) { mostrarMenu(); continue; }
                System.out.println("\n===== " + (op == 40 ? "PROBLEMA FINAL" : "EJERCICIO " + op) + " =====");
                ej[op].run();
            }
        } catch (IllegalStateException e) {
            // Se acabó la entrada de datos (Ctrl+D / Ctrl+Z): salimos sin error.
        }
        System.out.println("¡Hasta luego!");
    }

    private static void mostrarMenu() {
        System.out.println("=========== TALLER DE PRÁCTICA DE PROGRAMACIÓN ===========");
        System.out.println(" PARTE I   (1-14)  : Entrada/salida, operaciones y funciones");
        System.out.println(" PARTE II  (15-24) : Condicionales");
        System.out.println(" PARTE III (25-30) : Textos");
        System.out.println(" PARTE IV  (31-39) : Ciclos y patrones");
        System.out.println(" 40                : Problema final (equipaje BOEING 747)");
        System.out.println(" 0 = salir");
        System.out.println("==========================================================");
    }
}
