import java.util.Scanner;
import java.text.DecimalFormat;

public class Mineria {
    static Scanner leer = new Scanner(System.in);
    static DecimalFormat formato = new DecimalFormat("0.000000");

    public static void main(String[] args) {
        
        int orden;
        String pregunta, unidad;

        System.out.print("\nPREGUNTA DEL PROBLEMA: ");
        pregunta = leer.nextLine();
        System.out.print("ORDEN: ");
        orden = leer.nextInt();
        System.out.println();

        String[] concepto = new String[orden + 1];
        for (int i = 1; i <= orden; i++) {
            leer.nextLine();
            System.out.print("CONCEPTO DEL PROBLEMA: ");
            concepto[i] = leer.nextLine();
        }
        System.out.print("UNIDAD: ");
        unidad = leer.nextLine(); 

        double[][] matrizA = new double[orden+1][orden + 2];

        System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------\n");
        menu(matrizA, concepto, orden, unidad, pregunta);
    }

    static void menu(double[][] matrizA, String[] concepto, int orden, String unidad, String pregunta) {
        int opc;
        do {
            System.out.println("\n\t\t\t\t-----------------------------------MENÚ-----------------------------------");
            System.out.println("1.MÉTODO DE GAUSS-JORDAN \n2.MÉTODO DE GAUSS-SEIDEL \n10.FIN");
            System.out.print("ESCOJA UNA OPCIÓN: ");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------\n");
                    metodoGaussJordan(matrizA, concepto, orden, unidad, pregunta);
                    break;
                case 2:
                    System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------\n");
                    metodoGaussSeidel(orden, pregunta, concepto, unidad);
                    break;
                case 10:
                    System.out.println("¡ADIÓS!");
                    break;
                default:
                    System.out.println("OPCIÓN INVÁLIDA. ESCOJA OTRA OPCIÓN.");
                break;
            }
        } while (opc != 10);
    }

    static void datos(double[][] matrizA, int orden) {
        System.out.println();
        for (int f = 1; f <= orden; f++) {
            for (int c = 1; c <= orden + 1; c++) {
                System.out.print("Ingrese el valor de x" + (f) + (c) + ": ");
                matrizA[f][c] = leer.nextDouble();
            }
        }
    }

    static void metodoGaussJordan(double[][] matrizA, String[] concepto, int orden, String unidad, String pregunta) {
        double pivote, ecero, factor;

        datos(matrizA, orden);

        System.out.println("\nMatriz de Datos:");
        imprimirMatriz(matrizA, orden);

        System.out.println("\nMatriz ceros abajo de la diagonal:");
        for (int k = 1; k <= orden-1; k++) {
            pivote = matrizA[k][k];
            for (int f = k + 1; f <= orden; f++) {
                ecero = matrizA[f][k];
                for (int c = k; c <= orden + 1; c++) {
                    pivote = matrizA[k][k];
                    matrizA[f][c] = (pivote * matrizA[f][c]) - (ecero * matrizA[k][c]);
                }
            }
        }
        imprimirMatriz(matrizA, orden);

        System.out.println("\nMatriz ceros abajo y arriba de la diagonal:");
        for (int k = orden; k >= 2; k--) {
            pivote = matrizA[k][k];
            for (int f = k - 1; f >= 1; f--) {
                factor = matrizA[f][k] / pivote;
                for (int c = k; c <= orden + 1; c++) {
                    matrizA[f][c] = matrizA[f][c] - factor * matrizA[k][c];
                }
            }
        }
        imprimirMatriz(matrizA, orden);

        System.out.println("\t\t\t\t\tINSTITUTO TECNOLÓGICO DE CULIACÁN" + 
                            "\n\t\t\t\t\tIng. En Sistemas Computacionales" +
                            "\n\nZevada Peñuelas Jose Leonardo" +
                            "\nSolución de ecuaciones." + 
                            "\nDe 13:00 a 14:00 horas." + "Método de Gauss-Jordan" +
                            "\n\n\t\t\t\t\tEste programa ejecuta la solución de problemas" +
                            "\n\t\t\t\t\tutilizando los procesos lógicos de Solución de sistemas" +
                            "\n\t\t\t\t\tde Ecuaciones utilizando diversos métodos numéricos." +
                            "\n\n");
        System.out.print("PREGUNTA: ¿" + pregunta + "?\n");

        System.out.println("\nMatriz identidad:");
        for (int f = 1; f <= orden; f++) {
            matrizA[f][orden+1] = matrizA[f][orden+1] / matrizA[f][f];
            matrizA[f][f] = 1;
        }
        imprimirMatriz(matrizA, orden);

        System.out.println("\nResultados:");
        for (int i = 1; i <= orden; i++) {
            System.out.printf("%s = %.6f %s. \n", concepto[i], matrizA[i][orden+1], unidad);
        }
    }

    static void imprimirMatriz(double[][] matrizA, int orden) {
        System.out.println("-------------------------------------------------------");
        for (int f = 1; f <= orden; f++) {
            for (int c = 1; c <= orden; c++) {
                System.out.printf("%-15.6f ", matrizA[f][c]);
            }
            System.out.print("| ");
            System.out.printf("%-20.6f\n", matrizA[f][orden + 1]);
        }
        System.out.println("-------------------------------------------------------");
    }

    static void metodoGaussSeidel(int orden, String pregunta, String[] concepto, String unidad) {
        double[] vant = new double[orden + 1];
        double[] vact = new double[orden + 1];
        double[][] matriz = new double[orden + 1][orden + 2];

        for (int f = 1; f <= orden; f++) {
            System.out.print("Ingrese el valor inicial " + f + ": ");
            vant[f] = leer.nextDouble();
            vact[f] = 0;
        }
        System.out.print("Ingrese el error: ");
        double error = leer.nextDouble();
        System.out.print("Ingrese el total de cálculos: ");
        int tc = leer.nextInt();
        System.out.println("------------------------------------------------------------------");

        datos(matriz, orden);

        for (int i = 1; i <= orden; i++) {
            int dominante = i;
            for (int j = i + 1; j <= orden; j++) {
                if (Math.abs(matriz[j][i]) > Math.abs(matriz[dominante][i])) {
                    dominante = j;
                }
            }
            if (dominante != i) {
                double[] temp = matriz[i];
                matriz[i] = matriz[dominante];
                matriz[dominante] = temp;
            }
        }

        System.out.println("\t\t\t\t\tINSTITUTO TECNOLÓGICO DE CULIACÁN" + 
                            "\n\t\t\t\t\tIng. En Sistemas Computacionales" +
                            "\n\nZevada Peñuelas Jose Leonardo" +
                            "\nSolucion de ecuaciones." + 
                            "\nDe 13:00 a 14:00 horas." + "Método de Gauss-Seidel" +
                            "\n\n\t\t\t\t\tEste programa ejecuta la solución de problemas" +
                            "\n\t\t\t\t\tutilizando los procesos lógicos de Solución de sistemas" +
                            "\n\t\t\t\t\tde Ecuaciones utilizando diversos métodos numéricos." +
                            "\n\n");
        System.out.print("PREGUNTA: " + pregunta + "\n");

        System.out.println();
        int nc = 0;
        double errorTotal = 0;

        do {
            for (int f = 1; f <= orden; f++) {
                double suma = matriz[f][orden + 1];
                for (int c = 1; c <= orden; c++) {
                    if (c != f) {
                        suma -= matriz[f][c] * ((c < f) ? vact[c] : vant[c]);
                    }
                }
                vact[f] = suma / matriz[f][f];
            }

            errorTotal = 0;
            for (int p = 1; p <= orden; p++) {
                errorTotal += Math.abs(vact[p] - vant[p]);
            }

            if (nc == 0) {
                System.out.println("\n-------------------------------------------------------------------------------------------------");
                System.out.printf("%-5s", "#");
                for (int i = 1; i <= orden; i++) {
                    System.out.printf(" | %-15s", concepto[i]);
                } 
                System.out.printf(" | %-15s |\n", "Error Total");
                System.out.println("-------------------------------------------------------------------------------------------------");
            }

            nc++;
            System.out.printf("%-5d", nc);
            for (int p = 1; p <= orden; p++) {
                System.out.printf(" | %-15.6f", vact[p]);
                vant[p] = vact[p];
            }
            System.out.printf(" | %-15.6f |\n", errorTotal);
        } while (errorTotal > error && nc <= tc);
        System.out.println("-------------------------------------------------------------------------------------------------");

        if (errorTotal <= error) {
            System.out.println("\nResultados:");
            for (int p = 1; p <= orden; p++) {
                System.out.printf("%s = %.6f %s = %.0f %s\n", concepto[p], vact[p], unidad, (double) Math.round(vact[p]), unidad);
            }
        } else {
            System.out.println("El proceso superó el número máximo de cálculos y no encontró la mejor aproximación.");
        }
        
    }
}