import java.util.Scanner;

public class Main{

    private static  String algoritmo_generacion;
    private static  String cod_criptografico;
    private static  String sal;
    private static  Integer num_threads;

    public Main(){

    }

    public static  void menuEntradas()
    {
        Scanner input = new Scanner(System.in);


        System.out.println("//////////// CASO 3-202310 ////////////\n ");
        System.out.println("_____________Grupo 11_____________\n");

        System.out.println("Escriba el algoritmo de generación: \n");
        algoritmo_generacion = input.nextLine();
        System.out.println("Escriba el código encriptado: \n");
        cod_criptografico = input.nextLine();
        System.out.println("Escriba la SAL : \n");
        sal = input.nextLine();
        System.out.println("Escriba la numero de Threads (1,2) : \n");
        num_threads = input.nextInt();
        input.close();

    }



    public static void main(String[] args) {
        menuEntradas();
    }

 }
