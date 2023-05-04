import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
public class Main2Threads {
private static final String ALGORITHM_SHA256 = "SHA-256";
private static final String ALGORITHM_SHA512 = "SHA-512";
private static final String CHARSET = "abcdefghijklmnopqrstuvwxyz";
private static final int MAX_PASSWORD_LENGTH = 7;
private static final int NUM_THREADS = 2;

private static byte[] hash(String algoritmo, String contrasena, String salts) throws NoSuchAlgorithmException {

    
    MessageDigest md = MessageDigest.getInstance(algoritmo);

    String concat_str = contrasena.concat(salts);
    byte[] __bconcat = concat_str.getBytes(StandardCharsets.UTF_8);
    
    return md.digest(__bconcat);
}

public static void main(String[] args) {

}
    public static void ejx2Threads(String hash_code,String salts,String algorithm) {
    
    String algoritmo = algorithm;
    String hashCode = hash_code;
    byte[] salt = salts.getBytes();

    long startTime = System.currentTimeMillis();

    Thread[] threads = new Thread[NUM_THREADS];
    int numPasswordsPerThread = (int) Math.ceil(Math.pow(CHARSET.length(), MAX_PASSWORD_LENGTH) / NUM_THREADS);
    
    for (int i = 0; i < NUM_THREADS; i++) {
        int startIndex;
        int endIndex;
        
        startIndex = i * numPasswordsPerThread;
        endIndex = Math.min(startIndex + numPasswordsPerThread, (int) Math.pow(CHARSET.length(), MAX_PASSWORD_LENGTH));

        threads[i] = new Thread(() -> {
            for (int j = startIndex; j < endIndex; j++) {
                
                String contrasena = "";
                int temp = j;
                while (temp > 0) {
                    contrasena = CHARSET.charAt(temp % CHARSET.length()) + contrasena;
                    temp /= CHARSET.length();
                }

                try {
                    String str = new String(salt, StandardCharsets.UTF_8);
                    byte[] hashedPassword = hash(algoritmo, contrasena, str);
                    String hexHashedPassword = bytesToHex(hashedPassword);
                    if (hexHashedPassword.equals(hashCode)) {
                        System.out.println("Contraseña encontrada: " + contrasena + ", salt: " + new String(salt));
                        return;
                    }
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
            }
        });
        threads[i].start();
    }

    for (Thread thread : threads) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    long endTime = System.currentTimeMillis();
    System.out.println("Tiempo de ejecución: " + (endTime - startTime) + "ms");
}

private static String bytesToHex(byte[] bytes) {
    StringBuilder sb = new StringBuilder();
    for (byte b : bytes) {
        sb.append(String.format("%02x", b));
    }
    return sb.toString();
}

}