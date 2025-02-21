
import java.util.Scanner;

public class Pastel
{
    public static void main(String[]args){
        Scanner leer=new Scanner(System.in);

        String pregunta;
        String concepto;
        String unidad;
        int opcion=0;

        double error=0.0;
        int intentos=0;

        
        System.out.println("Instituto tecnologico de culiacan");
        System.out.println("Ing. en sistemas");
        System.out.println();
        System.out.println("Eduardo Agustin Felix Lopez");
        System.out.println("Solucion de ecuaciones");
        System.out.println("De 7:00 a 8:00 horas");

        System.out.println("Este programa ejecuta la solución de problemas");
        System.out.println("utilizando los procesos lógicos de cálculo de Raíces de");
        System.out.println("una ecuación con diversos métodos numéricos.");
        System.out.println();

        System.out.print("Pregunta del problema: ");
        pregunta=leer.nextLine();
        System.out.print("Concepto del problema: ");
        concepto=leer.nextLine();
        System.out.print("Unidad del problema: ");
        unidad=leer.nextLine();


        while(opcion!=10){
            System.out.println();
            System.out.print("Raices de una Ecuacion \n 1.Metodo de la secante \n 2.Metodo de Newton Raphson \n 10.Salir \n Cual es su opcion: ");
            while (!leer.hasNextInt()) {
                System.out.print("Entrada inválida. Ingrese una opcion: ");
                leer.next();
            }
            opcion=leer.nextInt();

            if(opcion==1){
                double x1;
                double x2;
                double fx1;
                double fx2;
                double x3;
                double fx3;

                System.out.println();
                System.out.print("Ingrese el punto x1: ");
                x1=leer.nextDouble();
                System.out.print("Ingrese el punto x2: ");
                x2=leer.nextDouble();
                System.out.print("Ingrese el error: ");
                error=leer.nextDouble();
                System.out.print("Ingrese el total de calculos: ");
                intentos=leer.nextInt();

                fx1=(Math.pow(x1,2)-36000);
                fx2=(Math.pow(x2,2)-36000);
                x3=(x1-(((x1-x2)*fx1)/(fx1-fx2)));
                fx3=(Math.pow(x3,2)-36000);

                System.out.println();
                System.out.println("Instituto tecnologico de culiacan");
                System.out.println("Ing. en sistemas");
                System.out.println();
                System.out.println("Eduardo Agustin Felix Lopez");
                System.out.println("Raices de una ecuacion: metodo de la secante");
                System.out.println("De 7:00 a 8:00 horas");
                System.out.println("Pregunta: " + pregunta);
                System.out.println();
                System.out.println("===================================================================================================");
                System.out.printf(" N%9s X1%11s x2%11s F(X1)%10s F(X2)%9s X3%10s F(X3)", " ", " ", " ", " ", " "," "," ");
                System.out.println();
                System.out.println("_________________________________");
                while(fx3>error){
                    for(int i=0; i<=intentos;i++){
                        fx1=(Math.pow(x1,2)-36000);
                        fx2=(Math.pow(x2,2)-36000);
    
                        x3=(x1-(((x1-x2)*fx1)/(fx1-fx2)));
                        fx3=(Math.pow(x3,2)-36000);
                        System.out.printf("%-7d %-12.6f %-12.6f %-15.6f %-15.6f %-15.6f %-12.10f%n", (i+1), x1, x2, fx1, fx2, x3, fx3);
                        
                        x1=x2;
                        x2=x3;
                        double fx3n = -fx3;
                        if(fx3<error && fx3n<error){
                            System.out.println("_________________________________");
                            break;
                        }
                    }
                }
                System.out.println();
                System.out.println("La raiz de la ecuacion: " + x3 + " " + unidad);
            
            }

            else if(opcion==2){
                double x1;
                double fx1;
                double fdx1;
                double x2;
                double fx2;
                int n=1;

                System.out.println();
                System.out.print("Ingrese el punto flotante x1: ");
                x1=leer.nextDouble();
                System.out.print("Ingrese el error: ");
                error=leer.nextDouble();
                System.out.print("Ingrese el total de calculos: ");
                intentos=leer.nextInt();
                
                fx1=(Math.pow(x1,2)-36000);
                fdx1=2*x1;
                x2=x1-(fx1/fdx1);
                fx2=(Math.pow(x2,2)-36000);

                System.out.println();
                System.out.println("Instituto tecnologico de culiacan");
                System.out.println("Ing. en sistemas");
                System.out.println();
                System.out.println("Eduardo Agustin Felix Lopez");
                System.out.println("Raices de una ecuacion: metodo de Newton Raphson");
                System.out.println("De 7:00 a 8:00 horas");
                System.out.println("Pregunta: " + pregunta);
                System.out.println();
                System.out.println("===========================================================================================");
                System.out.printf(" N%9s X1%9s F(X1)%9s F'(X1)%9s X2%9s F(X2)%n", " ", " ", " ", " ", " ");
                System.out.println("_______________________________");

                System.out.printf("%-7d %-12.6f %-15.6f %-13.6f %-15.6f %-15.10f%n", n,x1, fx1, fdx1, x2, fx2);


                for(int i=1; i<=intentos;i++){

                    x1=x2;
                    fx1=(Math.pow(x1,2)-36000);
                    fdx1=2*x1;
                    x2=x1-(fx1/fdx1);
                    fx2=(Math.pow(x2,2)-36000);
                    System.out.printf("%-7d %-12.6f %-15.6f %-13.6f %-15.6f %-15.10f%n", (i+1),x1, fx1, fdx1, x2, fx2);

                    double fx2n= -fx2;
                    if(fx2<error && fx2n<error){
                        System.out.println("_______________________________");
                        break;
                    }
                }
            System.out.println();
            System.out.println("La raiz de la ecuacion: " + x2 + " " + unidad);
            } else{
                System.out.println();
                System.out.print("Entrada inválida. Ingrese una opcion: ");
            }
        }
    }
}