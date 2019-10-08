import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        VerificationSystem vs=new VerificationSystem();
        CrackerSystem cs=new CrackerSystem();
        vs.SetUID("UID.txt");
        vs.SetHashPassword("Hash.txt");
        Scanner reader=new Scanner(System.in);
        System.out.println("Enter a 3 digits UID:");
        String UIDinput=reader.nextLine();
        while (UIDinput.length()!=3 || (UIDinput.compareTo("001")<0 || UIDinput.compareTo("100")>0)){
            System.out.println("The received input was not a valid 3 digits UID, try again!");
            UIDinput=reader.nextLine();
        }
        String hashPassword=vs.HashPassword.get(vs.UID.indexOf(UIDinput));
        String[] result=new String[2];
        result=cs.BruteForce(hashPassword);
        System.out.println("result: password: "+result[0]+"; salt: "+result[1]);
    }
}
