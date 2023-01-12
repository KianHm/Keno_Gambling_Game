import java.util.*;
public class Password
{
    public String password()
    {
        Random gen = new Random();
        Random rnd = new Random();
        String password = "";
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int x;
        char c;
        for (int i = 0; i < 6; i++)
        {
            if(i % 2 != 0)
            {
                x = gen.nextInt(10);
                password += x;
            }
            else
            {
                if(i == 2)
                {
                    x = rnd.nextInt(26);
                    c = upperAlphabet.charAt(x);
                    password += c;
                }
                else
                {
                    x = rnd.nextInt(26);
                    c = lowerAlphabet.charAt(x); 
                    password += c;
                }
            }
        }
        return password;
    }
    public boolean checkPassword(String password)
    {
        Scanner console = new Scanner(System.in);
        System.out.println("This is the password: " + password);
        System.out.print("Enter the password...");
        String response = console.nextLine();
        System.out.println("");
        return (response.equals(password));
    }
}
