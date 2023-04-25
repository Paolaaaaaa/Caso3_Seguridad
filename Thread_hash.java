
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
    private String options = "abcdefghijklmnopqrstuvwxyz ";

    
    Thread_hash(String pencripted_pass, String psalt, MessageDigest ms){
        this.encripted_pass = pencripted_pass;
        this.salt = psalt;
        this.encontrado = false;
        this.algorithm = ms;}
        

    

    @Override
    public void run() {
        one_Thread();
    }



    public void cmpr_pass(String pass_comb){


        String concat_pass = pass_comb +salt;
        byte[] bytes = concat_pass.getBytes(Charset.forName("UTF-8"));
        byte[] hash = algorithm.digest(bytes);
        String hash_str = hash.toString();
        if (hash_str.equals(this.encripted_pass)){
            this.response_password=pass_comb;
            this.encontrado =true;

    }
    }
    public void one_Thread () {
        String[] abc_dary =options.split("");

      
            for (int i = 0; i < 26 && !encontrado; i++) {
                for (int j = 0; j < 26 && !encontrado; j++) {
                    for (int j2 = 0; j2 < 26 && !encontrado; j2++) {
                        for (int k = 0; k < 26 && !encontrado; k++) {
                            for (int k2 = 0; k2 < 26 && !encontrado; k2++) {
                                for (int l = 0; l < 26 && !encontrado; l++) {
                                    for (int l2 = 0; l2 < 26 && !encontrado; l2++) {
                                        String password = "";

                                        int[] nam = {l2,l,k2,k,j2,j,i};
                         
                                        for (int m = 0; m < nam.length; m++) {
                                            
                                            if (nam[m]!=26){
                                                String str = abc_dary[nam[m]];
                                                password+=str;
                                                
                                            }
                                            
                                        }


                                       
                                        System.out.println(password);
                                        cmpr_pass(password);

                                       
                                        
                                    }
                                }
                            }
                        }
                    }
                    
                }



                }


                   


                
            }

    }

    
    
    

