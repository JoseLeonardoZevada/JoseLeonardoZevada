import java.util.Scanner;

public class Cist {

    static Scanner leer = new Scanner(System.in);
    static double error;
    static int totalCalculos;
    static String pregunta, concepto, unidad;

    public static void main(String[] args) {

        System.out.println("\t\t\t\t\tInstituto Tecnólogico de Culiacán");
        System.out.println("\t\t\t\t\t\tIng. En Sistemas\n");
        System.out.println("Zevada Peñuelas Jose Leonardo.");
        System.out.println("Solución de Ecuaciones.");
        System.out.println("De 1:00 a 2:00 horas\n");
        System.out.println("\t\t\t\tEste programa ejecuta la solución de problemas\r\n" +
                "\t\t\t     utilizando los procesos lógicos de cálculo de Raíces de\r\n" +
                "\t\t\t\tuna ecuación con diversos métodos numéricos.\n");

        System.out.print("Pregunta del problema: ");
        pregunta = leer.nextLine();
        System.out.print("Concepto del problema: ");
        concepto = leer.nextLine();
        System.out.print("Unidad del problema: ");
        unidad = leer.nextLine();

        int opcion;
        do {
            System.out.println("\nRaíces de una ecuación");
            System.out.println("1.-Método de la Secante");
            System.out.println("2.-Método de Newton Raphson");
            System.out.println("10.- F I N");
            System.out.print("Cuál es su opción: ");
            opcion = leer.nextInt();
            leer.nextLine();

            if (opcion == 1 || opcion == 2) {
                System.out.print("Ingrese el valor del error: ");
                error = leer.nextDouble();
                System.out.print("Ingrese el total de cálculos: ");
                totalCalculos = leer.nextInt();
                System.out.print("Ingrese el valor de x1: ");
                double x1 = leer.nextDouble();
                System.out.print("Ingrese el valor de x2: ");
                double x2 = leer.nextDouble();
                leer.nextLine();

                if (opcion == 1) {
                    metodoSecante(x1, x2);
                } else {
                    metodoNewtonRaphson(x1);
                }
            } else if (opcion != 10) {
                System.out.println("Opción no válida. Seleccione 1, 2 o 10.");
            }

        } while (opcion != 10);

        System.out.println("Fin del programa");
    }

    public static void metodoSecante(double x1, double x2) {
        double x3;
        encabezado("Método de la Secante", pregunta, concepto, unidad);
        System.out.println("===========================================================================");
        System.out.printf("%-5s %-10s %-15s %-10s %-15s %-10s %-15s\n",
                "NC", "X1", "F(X1)", "X2", "F(X2)", "X3", "F(X3)");
        System.out.println("===========================================================================");

        for (int i = 0; i <= 50; i++) {
            x3 = x1 - (((x1 - x2) * funcion(x1)) / (funcion(x1) - funcion(x2)));

            System.out.printf("%-5d %-10.6f %-15.6f %-10.6f %-15.6f %-10.6f %-15.6f\n",
                    i + 1, x1, funcion(x1), x2, funcion(x2), x3, funcion(x3));

            if (Math.abs(funcion(x3)) < error) {
                System.out.printf("La Raíz de la Ecuación = %.5f %s\n", x3, unidad);
                break;
            }

            x1 = x2;
            x2 = x3;
        }
    }

    public static void metodoNewtonRaphson(double x1) {
        double x2;
        encabezado("Método de Newton Raphson", pregunta, concepto, unidad);
        System.out.println("===========================================================================");
        System.out.printf("%-5s %-10s %-15s %-10s %-15s  %-15s\n",
                "NC", "X1", "F(X1)", "F´(X1)", "X2", "F(X2)");
        System.out.println("===========================================================================");

        for (int i = 0; i <= 50; i++) {
            x2 = x1 - (funcion(x1) / funcionDerivada(x1));

            System.out.printf("%-5d %-10.6f %-15.6f %-10.6f %-15.6f %-15.6f \n",
                    i + 1, x1, funcion(x1), funcionDerivada(x1), x2, funcion(x2));

            if (Math.abs(funcion(x2)) < error) {
                System.out.printf("La Raíz de la Ecuación = %.5f %s\n", x2, unidad);
                break;
            }

            x1 = x2;
        }
    }

    public static void encabezado(String metodo, String pregunta, String concepto, String unidad) {
        System.out.println("\n\t\t\t\tInstituto Tecnólogico de Culiacán");
        System.out.println("\t\t\t\t\tIng. En Sistemas\n");
        System.out.println("Zevada Peñuelas Jose Leonardo");
        System.out.println("Raíces de una Ecuación: " + metodo);
        System.out.println("De 1:00 a 2:00 horas\n");
        System.out.println("Pregunta del Problema: " + pregunta);
        System.out.println();
    }

    public static double funcion(double h) {
        double factor = ((10 * h) / 9) - 1;
        return Math.asin(factor) + factor * Math.sqrt(1 - Math.pow(factor, 2)) - 1.10144;
    }

    public static double funcionDerivada(double h) {
        double numerador = 400 * h * (5 * h - 9);
        double denominador = 729 * Math.sqrt(1 - Math.pow(((10 * h) / 9) - 1, 2));
        return (numerador / denominador) * -1;
    }
}

