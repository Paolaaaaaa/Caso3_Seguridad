
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;


import Test.Test_Txt;
public class Thread_hash extends Thread{

    private String encripted_pass;
    private String salt;
    private boolean encontrado; 
    private String[] letras = {"","a","b","c","d","e","f","g","h","i","j","k","l", "m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    private String real_password;
    private String algorithm;
    private long total_time;
    private MessageDigest md;
    Thread_hash(String pencripted_pass, String psalt, String palgorithm)throws NoSuchAlgorithmException{
        this.encripted_pass = pencripted_pass;
        this.salt = psalt;
        this.encontrado = false;
        this.algorithm =palgorithm;
        this.md = MessageDigest.getInstance(palgorithm);
    }
        

    

    @Override
    public void run() {
        try {
            one_Thread();
            System.out.println(this.real_password);
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public synchronized String hasher (String password, String salt) throws NoSuchAlgorithmException{

        
        String concat_pass =password.concat(salt);
      
        byte[] hash_b = md.digest(concat_pass.getBytes());
        StringBuilder sb = new StringBuilder();

        for (byte b : hash_b) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();

    }



    public String one_Thread () throws NoSuchAlgorithmException {


        long startTime = System.currentTimeMillis();

        String password= "";

            for (int i = 0; i < 27 && !encontrado; i++) {
                for (int j = 0; j < 27 && !encontrado; j++) {
                    for (int j2 = 0; j2 < 27 && !encontrado; j2++) {
                        for (int k = 0; k < 27 && !encontrado; k++) {
                            for (int k2 = 0; k2 < 27 && !encontrado; k2++) {
                                for (int l = 0; l < 27 && !encontrado; l++) {
                                    for (int l2 = 0; l2 < 27 && !encontrado; l2++) {
                                        password= "";

                                        int[] nam = {l2,l,k2,k,j2,j,i};
                         
                                        for (int m = 0; m < nam.length; m++) {
                                            
                                            if (nam[m]!=0){
                                            
                                                password=password.concat(letras[nam[m]]);
                                
                                            }}
                                            
                                            String hash=hasher(password, this.salt);

                                        
                                            if (hash.equals(encripted_pass)){
                                                this.encontrado = true;
                                                this.real_password =password;
                                            }
                                        
                                    }
                                }
                            }
                        }
                    }
                    
                }



            }
            long endTime = System.currentTimeMillis();
            this.total_time = endTime - startTime;

        return password;


                   


                
    }


    public String getTotal_time() {
        return String.valueOf(total_time);
    }
    public String getEncripted_pass() {
        return encripted_pass;
    }

    public String getSalt() {
        return salt;
    }
    public String getAlgorithm() {
        return algorithm;
    }
    

    }

    
    
    

