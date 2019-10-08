import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;


public class CrackerSystem{
        /*public String StringAdd (String input, int digit){
        }*/
        public String[] BruteForce(String HashPassword) throws NoSuchAlgorithmException {
            VerificationSystem vs=new VerificationSystem();
            for (int i=0;i<=1000;i++) {
                for (int j = 0; j <= 100; j++) {
                    String password = String.format("%04d",i);
                    String salt = String.format("%03d",j);
                    System.out.println(password + " " + salt);
                    String passAndSalt = password.concat(salt);
                    String resultHashPassword = vs.Hashfunction(passAndSalt);
                    if (vs.Verify(resultHashPassword, HashPassword)) {
                        return new String[]{password, salt};
                    }
                }
            }
            return null;
        }
}