
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Thread_hash extends Thread{

    private String encripted_pass;
    private String salt;
    private static Integer num_try;
    private static final Integer MAX_LENGHT =7;
    private boolean encontrado; 
    private ArrayList<String> combination= new ArrayList<String>();
    private MessageDigest algorithm; 
    private String response_password ="";
    private String[] letras = {"","a","b","c","d","e","f","g","h","i","j","k","l", "m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    
    Thread_hash(String pencripted_pass, String psalt)throws NoSuchAlgorithmException{
        this.encripted_pass = pencripted_pass;
        this.salt = psalt;
        this.encontrado = false;
        this.algorithm = MessageDigest.getInstance("SHA-256");}
        

    

    @Override
    public void run() {
        try {
            one_Thread();
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



    public void SHA256_cmpr_pass(String password) throws NoSuchAlgorithmException{


        MessageDigest md = MessageDigest.getInstance("SHA-256");


        String concat_pass =password.concat(salt);
        byte[] bytes = concat_pass.getBytes();
        byte[] hash_b = md.digest(bytes);
        String hash_str = hash_b.toString();
        if (hash_str.equals(this.encripted_pass)){
            response_password=password;
            this.encontrado =true;
            
            
        }

    }
    public void one_Thread () throws NoSuchAlgorithmException {

      
            for (int i = 0; i < 27 && !encontrado; i++) {
                for (int j = 0; j < 27 && !encontrado; j++) {
                    for (int j2 = 0; j2 < 27 && !encontrado; j2++) {
                        for (int k = 0; k < 27 && !encontrado; k++) {
                            for (int k2 = 0; k2 < 27 && !encontrado; k2++) {
                                for (int l = 0; l < 27 && !encontrado; l++) {
                                    for (int l2 = 0; l2 < 27 && !encontrado; l2++) {
                                        String password= new String();

                                        int[] nam = {l2,l,k2,k,j2,j,i};
                         
                                        for (int m = 0; m < nam.length; m++) {
                                            
                                            if (nam[m]!=0){
                                                String letra = letras[nam[m]];
                                                password=password+letra;
                                            }}

                                        SHA256_cmpr_pass(password);
                                        
                                       
                                        
                                    }
                                }
                            }
                        }
                    }
                    
                }



                }


                   


                
            }

    }

    
    
    

