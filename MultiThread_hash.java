import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MultiThread_hash extends Thread {
    private String encripted_pass;
    private String salt;
    private static boolean encontrado; 
    private String[] letras = {"","a","b","c","d","e","f","g","h","i","j","k","l", "m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    private String real_password;
    private String algorithm;
    private long total_time;
    private MessageDigest md;
    private CyclicBarrier cb;  

    private static int i;
    private static int j;
    private static int j2;
    private static int k;
    private static int k2;
    private static int l;
    private  int inic_l2;
    private  int end_l2;



     



        MultiThread_hash(String pencripted_pass, String psalt, String palgorithm, CyclicBarrier cbp,int inic, int end)throws NoSuchAlgorithmException{
        this.encripted_pass = pencripted_pass;
        this.salt = psalt;
        MultiThread_hash.encontrado = false;
        this.algorithm =palgorithm;
        this.md = MessageDigest.getInstance(palgorithm);
        this.cb = cbp;

        MultiThread_hash.i=0;
        MultiThread_hash.j= 0;
        MultiThread_hash.j2=0;
        MultiThread_hash.k=0;
        MultiThread_hash.k2=0;
        MultiThread_hash.l=0;
        this.inic_l2=inic ;
        this.end_l2= end;
    }





    public void run(){
        try {
            two_threads();
            try {
                cb.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(this.real_password);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    public synchronized String hasher (String password, String salt) throws NoSuchAlgorithmException{

        
        String concat_pass =password.concat(salt);
      
        byte[] hash_b = md.digest(concat_pass.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();

        for (byte b : hash_b) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();

    }


    public static boolean write_txt(String hash_code, String salt, String algorithm, String _threads,String times,String passwordString){


            
        try {

            File archivo = new File("Test/test_result.txt");

            try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo, true))) {
                escritor.write("\n");

                escritor.write(hash_code);
                escritor.write(",");

                escritor.write(salt);
                escritor.write(",");

                escritor.write(algorithm);
                escritor.write(",");

                escritor.write(_threads);
                escritor.write(",");

                escritor.write(times);
                escritor.write(",");
                escritor.write(passwordString);

                escritor.flush();
                escritor.close();
                return true;
            }

            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;

    }




    
    public  String two_threads() throws NoSuchAlgorithmException {

        
        long startTime = System.currentTimeMillis();

        String password= "";

            for (; i < 27 && !encontrado; ) {
                for (; j < 27 && !encontrado; ) {
                    for (; j2 < 27 && !encontrado; ) {
                        for (; k < 27 && !encontrado; ) {
                            for (; k2 < 27 && !encontrado;) {
                                for (int l = 0; l < 27 && !encontrado; l++) {
                                    for (int l2 = inic_l2; l2 < end_l2 && !encontrado; l2++) {
                                        password= "";

                                        int[] nam = {l2,l,k2,k,j2,j,i};
                         
                                        for (int m = 0; m < nam.length; m++) {
                                            
                                            if (nam[m]!=0){
                                            
                                                password=password.concat(letras[nam[m]]);
                                
                                            }}
                                            
                                            String hash=hasher(password, this.salt);

                                        
                                            if (hash.equals(encripted_pass)){

                                                synchronized(this){
                                                MultiThread_hash.encontrado = true;
                                                this.real_password = password;

                                                long endTime = System.currentTimeMillis();
                                                this.total_time = endTime - startTime;}
                                                write_txt(hash, salt, this.algorithm,"2",String.valueOf(total_time),password);
                                            }
                                        
                                    }

                                    synchronized(this){
                                        MultiThread_hash.l++;
                                    }
                                }

                                synchronized(this){
                                    MultiThread_hash.k2++;
                                }
                            }

                            synchronized(this){
                                MultiThread_hash.k++;
                            }
                        }

                        synchronized(this){
                            MultiThread_hash.j2++;
                        }

                    }
                    synchronized(this){
                        MultiThread_hash.j++;
                    }
                    
                }


                synchronized(this){
                    MultiThread_hash.i++;

                }


            }return password;
            

        

    }

}
