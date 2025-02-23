import java.util.*;

public class Cisterna {
    
    static Scanner leer = new Scanner(System.in);
    static double error = 0.00001;

    public static void main(String[] args) {

        String pregunta, concepto, unidad;

        System.out.println("\t\t\t\t\tInstituto Tecnólogico de Culiacán");
        System.out.println("\t\t\t\t\t\tIng. En Sistemas\n");
        System.out.println("Zevada Peñuelas Jose Leonardo.");
        System.out.println("Solución de Ecuaciones.");
        System.out.println("De 1:00 a 2:00 horas\n");
        System.out.println("\t\t\t\tEste programa ejecuta la solución de problemas\r\n" + 
                "\t\t\t     utilizando los procesos lógicos de cálculo de Raíces de\r\n" + 
                "\t\t\t\tuna ecuación con diversos métodos numéricos.\n");
        //System.out.println(
                //"Pregunta del Problema:¿Cuál es la altura la cual debe ser llenado la cisterna para transportar el 85% de agua?");
        //System.out.println(concepto);
        //System.out.println("Unidad I");

        System.out.print("Pregunta del problema: ");
        pregunta=leer.nextLine();
        System.out.print("Concepto del problema: ");
        concepto=leer.nextLine();
        System.out.print("Unidad del problema: ");
        unidad=leer.nextLine();
        int opcion = 0;

        do {
            System.out.println("Raíces de una ecuación");
            System.out.println("1.-Método de la Secante");
            System.out.println("2.-Método de Newton Raphson");
            System.out.println("10.- F I N");
            System.out.print("Cuál es su opción:");
            opcion = leer.nextInt();
            leer.nextLine();
            switch (opcion) {
                case 1:
                    metodoSecante();
                    break;
                case 2:
                    metodoNewtonRaphson();
                    break;
                case 10:
                    System.out.println("Fin del programa");
                    break;
                default:
                    System.out.println("Opcion no valida. Elija 1, 2 o 10.");
            }
        } while (opcion != 10);
    }

    public static double funcion(double h) {
        double factor = ((10 * h) / 9) - 1;

        double resultado = Math.asin(factor) + factor * Math.sqrt((1) - (Math.pow(factor, 2))) - 1.10144;
        return resultado;
    }

    public static double funcionDerivada(double h) {
        double numerador = 400 * h * (5 * h - 9);
        double denominador = 729 * Math.sqrt(1 - Math.pow(((10 * h) / 9) - 1, 2));
        double resultadoDer = numerador / denominador * (-1);
        return resultadoDer;
    }

    public static void metodoSecante() {
        double x1 = 0.00000;  
        double x2 = 1.80000;
        double x3;
        encabezado("Metodo de la Secante");
        System.out.println("===========================================================================");
        System.out.printf("%-5s %-10s %-15s %-10s %-15s %-10s %-15s\n",
                "NC", "X1", "F(X1)", "X2", "F(X2)", "X3", "F(X3)");
        System.out.println("===========================================================================");

        for (int i = 0; i <= 50; i++) {
            x3 = x1 - (((x1 - x2) * funcion(x1)) / (funcion(x1) - funcion(x2)));

            System.out.printf("%-5d %-10.6f %-15.6f %-10.6f %-15.6f %-10.6f %-15.6f\n",
                    i + 1, x1, funcion(x1), x2, funcion(x2), x3, funcion(x3));

            if (Math.abs(funcion(x3)) < error) {
                System.out.printf("La Raíz de la Ecuación = %.5f Unidades\n", x3);

                break;
            }

            x1 = x2;
            x2 = x3;
        }

        return;
    }

    public static void metodoNewtonRaphson() {
        double x1 = 0.40000;
        double x2;
        encabezado("Metodo de Newton Raphson");
        System.out.println("===========================================================================");
        System.out.printf("%-5s %-10s %-15s %-10s %-15s  %-15s\n",
                "NC", "X1", "F(X1)", "F´(X1)", "X2", "F(X2)");
        System.out.println("===========================================================================");
        for (int i = 0; i <= 50; i++) {
            x2 = x1 - (funcion(x1) / funcionDerivada(x1));

            System.out.printf("%-5d %-10.6f %-15.6f %-10.6f %-15.6f %-15.6f \n",
                    i + 1, x1, funcion(x1), funcionDerivada(x1), x2, funcion(x2));

            if (Math.abs(funcion(x2)) < error) {
                System.out.printf("La Raíz de la Ecuación = %.5f Unidades\n", x2);
                break;
            }

            x1 = x2;

        }
    }

    public static void encabezado(String s) {
        System.out.println("\t\t\t\t\tInstituto Tecnólogico de Culiacán");
        System.out.println("\t\t\t\t\t\tIng. En Sistemas\n");
        //System.out.println();
        System.out.println("Zevada Peñuelas Jose Leonardo");
        System.out.println("Raíces de una Ecuación: " + s);
        System.out.println("De 1:00 a 2:00 horas\n");
        //System.out.println();
        //System.out.println();
        System.out.println(
                "Pregunta del Problema:¿Cuál es la altura la cual debe ser llenado la cisterna para transportar el 85% de agua?");
        //System.out.println("Método de Solución de Ecuaciones\nUnidad I");
        //System.out.println("Unidad I");
    }
}
