
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

    
    Thread_hash(String pencripted_pass, String psalt, String algorithm){
        this.encripted_pass = pencripted_pass;
        this.salt = psalt;
        this.encontrado = false;
        //try {
            //this.algorithm = MessageDigest.getInstance(algorithm);
        //} catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
        //}
        

    }

    @Override
    public void run() {
        one_Thread();
    }


    public synchronized Integer sec_to_try(){
        return this.num_try+=1;

    }

    public void cmpr_pass(String pass_comb){


        String concat_pass = pass_comb +salt;
        byte[] bytes = concat_pass.getBytes(StandardCharsets.UTF_8);
        byte[] hash = algorithm.digest(bytes);
        String str_hash = hash.toString();
        if (str_hash ==this.encripted_pass){
            this.response_password=pass_comb;

    }
    }
    public void one_Thread () {
      
        String password = "";
            for (int i = 97; i < 124 && !encontrado; i++) {
                for (int j = 97; j < 124 && !encontrado; j++) {
                    for (int j2 = 97; j2 < 124 && !encontrado; j2++) {
                        for (int k = 97; k < 124 && !encontrado; k++) {
                            for (int k2 = 97; k2 < 124 && !encontrado; k2++) {
                                for (int l = 97; l < 124 && !encontrado; l++) {
                                    for (int l2 = 97; l2 < 124 && !encontrado; l2++) {

                                        int[] nam = {l2,l,k2,k,j2,j,i};
                                        ArrayList<Character> validChars = new ArrayList<>();
                                        for (int n : nam) {
                                            if (n!=123){
                                                char c = (char) n;

                                                validChars.add(c);
                                            }
                                            
                                        }

                                        char[] chr_ray = new char[validChars.size()];
                                        for (int m = 0; m < chr_ray.length; m++) {
                                            chr_ray[m]=validChars.get(m);
                                        }
                                        password = new String(chr_ray);

                                       
                                        
                                    }
                                }
                            }
                        }
                    }
                    
                }



                }


                this.encontrado = true;
                   


                
            }

    }

    
    
    

