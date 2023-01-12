import java.util.*;
public class NamePhoneEmail
{
  
    boolean isAllAlpha(String str)
    {
        boolean isLetter = true;
        for(int i = 0; i < str.length(); i++)
        {
            isLetter = Character.isLetter(str.charAt(i));
            if(isLetter == false) 
            {
                break;
            }
        }
        return isLetter;
    }
    boolean isNumeric(String str)
    {
        boolean isDigit = true;
        int period = 0;
        for(int i = 0; i < str.length(); i++) 
        {
            char charAt = str.charAt(i);
            if(charAt == '.')
            {
                period++;
            } else 
            {
                isDigit = Character.isDigit(charAt);
                if(isDigit == false || period > 1)
                {
                    isDigit = false;
                    break;
                }
            }
        }
        return isDigit;
    }
    public String checkName(String name)
    {
        if(name.length() >= 4 && isAllAlpha(name))
        {
            return "";
        }
        return "Invalid name!\n";
    }
    public String checkPhone(String phone)
    {
        String result = "";
        for (int i = 0; i < phone.length(); i++) 
        {
            if (phone.charAt(i) != '-') 
            {
                result += phone.charAt(i);
            }
        }
        int digitCount = 0;
        for (int i = 0; i < result.length(); i++) 
        {
            if (Character.isDigit(result.charAt(i))) 
            {
                digitCount++;
            }
        }
        if (digitCount == result.length() && result.length() == 10)
        {
            return "";
        }
        else
        {
          return "Invalid phone number!\n";
          
        }
    }
    public String checkEmail(String email)
    {
        String emailArr[] = email.split("@");
        if(emailArr.length != 2) 
        {
            return "Invalid email!";
        }
        if(emailArr[1].equals("gmail.com") || emailArr[1].equals("yahoo.com") || emailArr[1].equals("aol.com") || emailArr[1].equals("hotmail.com")) 
        {
            return "";
        }
        return "Invalid email!";
    }

    public static void main(String[] args) 
      
    {
        Scanner console = new Scanner(System.in);
        NamePhoneEmail check = new NamePhoneEmail();
        System.out.println("Enter your name >>> ");
        String name = console.nextLine();
        String chkName = check.checkName(name);
        System.out.println(chkName);
        System.out.println();
        System.out.println("Enter your phone number >>> ");
        String phone = console.nextLine();
        String chkPhone = check.checkPhone(phone);
        System.out.println(chkPhone);
        System.out.println();
        System.out.println("Enter your email >>> ");
        String email = console.nextLine();
        String chkEmail = check.checkEmail(email);
        System.out.println(chkEmail);
    }

    }
   



