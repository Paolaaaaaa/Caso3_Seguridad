
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Thread_hash extends Thread{

    private String encripted_pass;
    private String salt;
    private static Integer num_try;

    
    Thread_hash(String pencripted_pass, String psalt){
        this.encripted_pass = pencripted_pass;
        this.salt = psalt;

    }

    @Override
    public void run() {


        
    }


    public synchronized Integer sec_to_try(){
        return this.num_try+=1;

    }




    
}
