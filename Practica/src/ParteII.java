public class ParteII {

    // 15. Par o impar
    public static void ejercicio15() {
        int n = Entrada.entero("Número entero: ");
        System.out.println(n % 2 == 0 ? n + " es PAR" : n + " es IMPAR");
    }

    // 16. Positivo o negativo
    public static void ejercicio16() {
        double n = Entrada.decimal("Número: ");
        if (n > 0) System.out.println("Es POSITIVO");
        else if (n < 0) System.out.println("Es NEGATIVO");
        else System.out.println("Es CERO (ni positivo ni negativo)");
    }

    // 17. IVA con descuento del 5% si la venta supera 150.000 (usa calcularIVA)
    //     Suposición: el descuento se aplica al precio bruto y luego se calcula el IVA.
    public static void ejercicio17() {
        double bruto = Entrada.decimal("Precio bruto de la venta: ");
        System.out.printf("Precio bruto: %.2f%n", bruto);
        if (bruto > 150000) {
            double descuento = bruto * 0.05;
            bruto -= descuento;
            System.out.printf("Descuento 5%%: -%.2f%n", descuento);
            System.out.printf("Precio con descuento: %.2f%n", bruto);
        }
        double conIva = ParteI.calcularIVA(bruto);
        System.out.printf("IVA (19%%): %.2f%n", conIva - bruto);
        System.out.printf("Total a pagar: %.2f%n", conIva);
    }

    // 18. Nota final con mensajes (usa calcularPromedio)
    public static void ejercicio18() {
        double[] n = ParteI.leerCincoNotas();
        double nota = ParteI.calcularPromedio(n[0], n[1], n[2], n[3], n[4]);
        System.out.printf("Nota final: %.2f%n", nota);
        if (nota < 2.0) {
            System.out.println("No puede habilitar.");
        } else if (nota < 3.0) {
            System.out.println("Reprobó.");
        } else {
            System.out.println("Aprobó.");
            if (nota > 4.5) {
                System.out.println("¡Felicitaciones por tu excelente desempeño!");
            }
        }
    }

    // 19. Ecuación cuadrática ax² + bx + c = 0
    public static void resolverCuadratica(double a, double b, double c) {
        if (a == 0) {
            if (b == 0) {
                System.out.println(c == 0 ? "Infinitas soluciones." : "No tiene solución.");
            } else {
                System.out.println("No es cuadrática, es lineal: x = " + (-c / b));
            }
            return;
        }
        double d = b * b - 4 * a * c;
        if (d > 0) {
            double x1 = (-b + Math.sqrt(d)) / (2 * a);
            double x2 = (-b - Math.sqrt(d)) / (2 * a);
            System.out.println("Dos soluciones reales: x1 = " + x1 + " , x2 = " + x2);
        } else if (d == 0) {
            System.out.println("Una solución real doble: x = " + (-b / (2 * a)));
        } else {
            double real = -b / (2 * a);
            double imag = Math.sqrt(-d) / (2 * Math.abs(a));
            System.out.println("Soluciones complejas: x1 = " + real + " + " + imag + "i , x2 = " + real + " - " + imag + "i");
        }
    }

    public static void ejercicio19() {
        System.out.println("Resolver ax² + bx + c = 0");
        double a = Entrada.decimal("a: ");
        double b = Entrada.decimal("b: ");
        double c = Entrada.decimal("c: ");
        resolverCuadratica(a, b, c);
    }

    // 20. Validar usuario y contraseña
    public static void ejercicio20() {
        final String USUARIO = "carlos";
        final String CLAVE = "1234";
        String u = Entrada.texto("Usuario: ");
        String c = Entrada.texto("Contraseña: ");
        if (u.equals(USUARIO) && c.equals(CLAVE)) {
            System.out.println("Acceso concedido. ¡Bienvenido " + u + "!");
        } else {
            System.out.println("Usuario o contraseña incorrectos.");
        }
    }

    // 21. Número (0-10) -> nombre
    public static void ejercicio21() {
        String[] nombres = {"CERO", "UNO", "DOS", "TRES", "CUATRO", "CINCO",
                "SEIS", "SIETE", "OCHO", "NUEVE", "DIEZ"};
        int n = Entrada.enteroEnRango("Número entre 0 y 10: ", 0, 10);
        System.out.println(n + " ---> " + nombres[n]);
    }

    // 22. Cantidad de dígitos de un número menor a 100.000
    public static void ejercicio22() {
        int n = Math.abs(Entrada.enteroEnRango("Número menor a 100000: ", -99999, 99999));
        int digitos;
        if (n < 10) digitos = 1;
        else if (n < 100) digitos = 2;
        else if (n < 1000) digitos = 3;
        else if (n < 10000) digitos = 4;
        else digitos = 5;
        System.out.println("Tiene " + digitos + " dígito(s).");
    }

    // 23. ¿Incrementa, disminuye o ninguno?
    public static void ejercicio23() {
        double a = Entrada.decimal("Primer número: ");
        double b = Entrada.decimal("Segundo número: ");
        double c = Entrada.decimal("Tercer número: ");
        if (a < b && b < c) System.out.println("Está incrementando");
        else if (a > b && b > c) System.out.println("Está disminuyendo");
        else System.out.println("Ni se incrementa ni se disminuye");
    }

    // 24. Número del día -> nombre del día
    public static void ejercicio24() {
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        int n = Entrada.enteroEnRango("Número del día (1 a 7): ", 1, 7);
        System.out.println(n + " ---> " + dias[n - 1]);
    }
}
