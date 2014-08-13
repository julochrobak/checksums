import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Checksums {
    public static void main(String[] args)
    {
        byte[] hash = new byte[0];
        FileInputStream in = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            for (String path: args) {
                in = new FileInputStream(path);
              
                byte[] buffer = new byte[8192];
                int read;
                while ((read = in.read(buffer)) > 0) {
                    md.update(buffer, 0, read);
                }

                close(in);
                in = null;
            }
            hash = md.digest();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        } finally {
            close(in);
        }
        String p = String.format("%032x",new BigInteger(1, hash));
        System.out.println(p);
    }

    private static void close(InputStream in) {
        if (in == null) {
            return;
        }
        try {
            in.close();
        } catch (IOException e) {
            // ignore
        }
    }
}
