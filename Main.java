import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.concurrent.CyclicBarrier;

public class Main{

    private static  String algoritmo_generacion;
    private static  String cod_criptografico;
    private static  String sal;
    private static  Integer num_threads;

    public Main(){

    }

    public static void main(String[] args) throws NoSuchAlgorithmException {






        menuEntradas();

        if (num_threads==2){

        }
        else if (num_threads ==1){


            CyclicBarrier barrier = new CyclicBarrier(1);
                        
            Thread_hash th = new Thread_hash(cod_criptografico,sal,algoritmo_generacion,barrier);
            System.out.println("\nSu contraseña es:.......\n");
            th.start();

        }
    
    
    
    
    
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

    public static void read_test_cases(){
        String archivo = "./Test/test_cases_512.txt";
        String linea = "";
        String separador = ",";
        int i =0;

        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            br.readLine();
            while ((linea = br.readLine()) != null) {

                System.out.println("Empieza caso "+i);

                String[] datos = linea.split(separador);
                if (datos.length >1){
                String hash_code = datos[0];
                String salt = datos[1];
                String algorithm = datos[2];
                System.out.println(algorithm);
                Integer threads_num = Integer.parseInt(datos[3]);
                if (threads_num == 1){
                    Thread_hash th;

                    try {
                        CyclicBarrier barrier = new CyclicBarrier(1);
                        
                        th = new Thread_hash(hash_code,salt,algorithm,barrier);
                        th.start();


                        System.out.println("Termina caso "+i);
                        i++;}

                    catch (NoSuchAlgorithmException e) {

                        System.out.println("no algorithm");
                    }

                } else if (threads_num == 2) {
                    Main2Threads.ejx2Threads(hash_code,salt,algorithm);



                    System.out.println("Termina caso "+i);
                    i++;
                }}

            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + archivo + ": " + e.getMessage());
        }
    }


    

    



 }
