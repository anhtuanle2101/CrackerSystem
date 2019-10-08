import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class VerificationSystem {
    ArrayList<String> UID = new ArrayList<String>();
    ArrayList<String> HashPassword = new ArrayList<String>();

    public void SetUID(String pathname) throws IOException{
        try {
            File in = new File(pathname);
            Scanner reader = new Scanner(in);
            if (in.exists()) {
                while (reader.hasNextLine()) {
                    String dat = reader.nextLine();
                    UID.add(dat);
                    //System.out.println(dat);
                }
            } else {
                System.out.println("File does not exist");
            }
            reader.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void SetHashPassword(String pathname) throws IOException{
        try {
            File in = new File(pathname);
            Scanner reader = new Scanner(in);
            if (in.exists()) {
                while (reader.hasNextLine()) {
                    String dat = reader.nextLine();
                    HashPassword.add(dat);
                    //System.out.println(dat);
                }
            } else {
                System.out.println("File does not exist");
            }
            reader.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public String Hashfunction(String PasswordAndSalt) throws NoSuchAlgorithmException {
        String generatedHash=null;
        MessageDigest md=MessageDigest.getInstance("MD5");
        md.update(PasswordAndSalt.getBytes());
        byte[] md5Array=md.digest();
        generatedHash=bytesToHex1(md5Array);
        return generatedHash;
    }

    private String bytesToHex1(byte[] md5Array) {
        StringBuilder sb=new StringBuilder();
        for (byte b:md5Array){
            sb.append(String.format("%02x",b));
        }
        return sb.toString();
    }

    public boolean Verify(String input1, String input2){
        if (input1.equals(input2))
            return true;
        else
            return false;
    }
}
