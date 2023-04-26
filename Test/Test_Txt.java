package Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Test_Txt {
    public static String sHA256_cmpr_pass(String password, String algoritm, String salt) throws NoSuchAlgorithmException{


        MessageDigest md = MessageDigest.getInstance(algoritm);


        
        String concat_pass =password.concat(salt);
        byte[] bytes = concat_pass.getBytes();
        byte[] hash_b = md.digest(bytes);
        String hash_str = hash_b.toString();
        return hash_str;
    

    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        try {
            // Crear objeto File
            File archivo = new File("Test/test_cases.txt");
            
            // Crear objeto FileWriter
            FileWriter escritor = new FileWriter(archivo);

            escritor.write("hash_code,salt,algorithm,#thread,characters,realPassword\n");
            String pass= "";

            // Escribir contenido en el archivo
            for (int i = 0; i < 7; i++) {
                
                pass=pass.concat("z");
                String hash_code=sHA256_cmpr_pass(pass,"SHA-256","aa");
                escritor.write(hash_code);
                escritor.write(",");

                escritor.write("aa");
                escritor.write(",");

                escritor.write("SHA-256");
                escritor.write(",");

                escritor.write(Integer.toString(1));
                escritor.write(",");

                escritor.write(Integer.toString(1+i));
                escritor.write(",");

                escritor.write(pass);
           
                escritor.write("\n");


            }
            pass= "";
            for (int i = 0; i < 7; i++) {
                
                pass=pass.concat("z");
                String hash_code=sHA256_cmpr_pass(pass,"SHA-256","zz");
                escritor.write(hash_code);
                escritor.write(",");

                escritor.write("zz");
                escritor.write(",");

                escritor.write("SHA-256");
                escritor.write(",");

                escritor.write(Integer.toString(1));
                escritor.write(",");

                escritor.write(Integer.toString(1+i));
                escritor.write(",");

                escritor.write(pass);
           
                escritor.write("\n");


            }
            pass= "";

            for (int i = 0; i < 7; i++) {
                
                pass=pass.concat("z");
                String hash_code=sHA256_cmpr_pass(pass,"SHA-512","aa");
                escritor.write(hash_code);
                escritor.write(",");

                escritor.write("aa");
                escritor.write(",");

                escritor.write("SHA-512");
                escritor.write(",");

                escritor.write(Integer.toString(1));
                escritor.write(",");

                escritor.write(Integer.toString(1+i));
                escritor.write(",");

                escritor.write(pass);
           
                escritor.write("\n");


            }
            pass= "";

            for (int i = 0; i < 7; i++) {
                
                pass=pass.concat("z");
                String hash_code=sHA256_cmpr_pass(pass,"SHA-512","zz");
                escritor.write(hash_code);
                escritor.write(",");

                escritor.write("aa");
                escritor.write(",");

                escritor.write("SHA-512");
                escritor.write(",");

                escritor.write(Integer.toString(1));
                escritor.write(",");

                escritor.write(Integer.toString(1+i));
                escritor.write(",");

                escritor.write(pass);
           
                escritor.write("\n");


            }
            

            pass= "";

            for (int i = 0; i < 7; i++) {
                
                pass=pass.concat("z");
                String hash_code=sHA256_cmpr_pass(pass,"SHA-256","aa");
                escritor.write(hash_code);
                escritor.write(",");

                escritor.write("aa");
                escritor.write(",");

                escritor.write("SHA-256");
                escritor.write(",");

                escritor.write(Integer.toString(2));
                escritor.write(",");

                escritor.write(Integer.toString(1+i));
                escritor.write(",");

                escritor.write(pass);
           
                escritor.write("\n");


            }
            pass= "";
            for (int i = 0; i < 7; i++) {
                
                pass=pass.concat("z");
                String hash_code=sHA256_cmpr_pass(pass,"SHA-256","zz");
                escritor.write(hash_code);
                escritor.write(",");

                escritor.write("zz");
                escritor.write(",");

                escritor.write("SHA-256");
                escritor.write(",");

                escritor.write(Integer.toString(2));
                escritor.write(",");

                escritor.write(Integer.toString(1+i));
                escritor.write(",");

                escritor.write(pass);
           
                escritor.write("\n");


            }
            pass= "";

            for (int i = 0; i < 7; i++) {
                
                pass=pass.concat("z");
                String hash_code=sHA256_cmpr_pass(pass,"SHA-512","aa");
                escritor.write(hash_code);
                escritor.write(",");

                escritor.write("aa");
                escritor.write(",");

                escritor.write("SHA-512");
                escritor.write(",");

                escritor.write(Integer.toString(2));
                escritor.write(",");

                escritor.write(Integer.toString(1+i));
                escritor.write(",");

                escritor.write(pass);
           
                escritor.write("\n");


            }
            pass= "";

            for (int i = 0; i < 7; i++) {
                
                pass=pass.concat("z");
                String hash_code=sHA256_cmpr_pass(pass,"SHA-512","zz");
                escritor.write(hash_code);
                escritor.write(",");

                escritor.write("aa");
                escritor.write(",");

                escritor.write("SHA-512");
                escritor.write(",");

                escritor.write(Integer.toString(2));
                escritor.write(",");

                escritor.write(Integer.toString(1+i));
                escritor.write(",");

                escritor.write(pass);
           
                escritor.write("\n");


            }
            // Cerrar FileWriter
            escritor.close();
            
            System.out.println("Archivo de texto generado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al generar el archivo de texto: " + e.getMessage());
        }
    }
  
}
