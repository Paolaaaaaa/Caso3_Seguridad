package Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Test_Txt {


    private static MessageDigest md;

    
    private static String[] letras = {"","a","b","c","d","e","f","g","h","i","j","k","l", "m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

    private static String pisca_sal_1= "aa";
    private static String pisca_sal_2 = "zz";

    public Test_Txt(String algoritm) throws NoSuchAlgorithmException{
        md= MessageDigest.getInstance(algoritm);

    }

    public String sHA256_cmpr_pass(String password, String salt) throws NoSuchAlgorithmException{

        
        String concat_pass =password.concat(salt);
      
        byte[] hash_b = md.digest(concat_pass.getBytes());
        StringBuilder sb = new StringBuilder();

        for (byte b : hash_b) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();

    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        try {
            // Crear objeto File
            File archivo = new File("Test/test_cases.txt");
            
            // Crear objeto FileWriter
            FileWriter escritor = new FileWriter(archivo);

            escritor.write("hash_code,salt,algorithm,#thread,characters,realPassword\n");
            String pass= new String();
            Test_Txt tt = new Test_Txt("SHA-256");
            Test_Txt tt_512 = new Test_Txt("SHA-512");

            // Escribir contenido en el archivo

            
            String passs= new String();
            for (int i = 0; i < 7; i++) {
                
                passs=passs.concat(letras[26]);
                String hash_code=tt.sHA256_cmpr_pass(passs,pisca_sal_1);
                escritor.write(hash_code);
                escritor.write(",");

                escritor.write(pisca_sal_1);
                escritor.write(",");

                escritor.write("SHA-256");
                escritor.write(",");

                escritor.write(Integer.toString(1));
                escritor.write(",");

                escritor.write(Integer.toString(1+i));
                escritor.write(",");

                escritor.write(passs);
           
                escritor.write("\n");


            }
            pass= "";
            for (int i = 0; i < 7; i++) {
                
                pass=pass.concat(letras[26]);
                String hash_code=tt.sHA256_cmpr_pass(pass,pisca_sal_2);
                escritor.write(hash_code);
                escritor.write(",");

                escritor.write(pisca_sal_2);
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
                
                pass=pass.concat(letras[26]);
                String hash_code=tt_512.sHA256_cmpr_pass(pass,pisca_sal_1);
                escritor.write(hash_code);
                escritor.write(",");

                escritor.write(pisca_sal_1);
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
                
                pass=pass.concat(letras[26]);
                String hash_code=tt_512.sHA256_cmpr_pass(pass,pisca_sal_2);
                escritor.write(hash_code);
                escritor.write(",");

                escritor.write(pisca_sal_2);
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
                
                pass=pass.concat(letras[26]);
                String hash_code=tt.sHA256_cmpr_pass(pass,pisca_sal_1);
                escritor.write(hash_code);
                escritor.write(",");

                escritor.write(pisca_sal_1);
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
                
                pass=pass.concat(letras[26]);
                String hash_code=tt.sHA256_cmpr_pass(pass,pisca_sal_2);
                escritor.write(hash_code);
                escritor.write(",");

                escritor.write(pisca_sal_2);
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
                
                pass=pass.concat(letras[26]);
                String hash_code=tt_512.sHA256_cmpr_pass(pass,pisca_sal_1);
                escritor.write(hash_code);
                escritor.write(",");

                escritor.write(pisca_sal_1);
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
                
                pass=pass.concat(letras[26]);
                String hash_code=tt_512.sHA256_cmpr_pass(pass,pisca_sal_2);
                escritor.write(hash_code);
                escritor.write(",");

                escritor.write(pisca_sal_2);
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
