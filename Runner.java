import java.util.*;
public class Runner
{
  public static void main(String[] Args)
  {
        Scanner console = new Scanner(System.in);
        NamePhoneEmail check = new NamePhoneEmail();
        Password enter = new Password();
        KenoGambling game = new KenoGambling();
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
        String password = enter.password();
        boolean checkPassword = enter.checkPassword(password);
        if(!checkPassword)
        {
            break;
            
            
        }
        
        else
        {
            game.kenoGambling();
        }
        System.out.println("Welcome to Keno Gambling!");
        int[] payout = new int[10];
        payout[3] = 20;
        payout[4] = 50;
        payout[5] = 100;
        payout[6] = 500;
        payout[7] = 1000;
        payout[8] = 5000;
        payout[9] = 20000;
        System.out.println("Heres a payout chart >>> ");
        for(int i = 3; i < 10; i++){
            System.out.println("If you match " + i + " numbers, then you get " + payout[i] + " dollars");
        }
        System.out.println();
        Player p1 = new Player("",50);
        p1.balance = 100;
        while(p1.balance > 50){
            System.out.print("You can enter up to 10 lucky numbers (1 - 80) as a string with one space between each number >>> ");
            String num = console.nextLine();
            System.out.print("Enter the initial amount you want to bet >>> ");
            int bet = console.nextInt();
            console.nextLine();
            System.out.println();
            p1 = new Player (num,bet); 
            if(p1.bet < 50){
                System.out.println("Get outta here!");
                break;
            }
            String[] orig = p1.luckyNum.split(" ");
            int[] numbers = new int[orig.length];
            for(int i = 0; i < orig.length; i++)
            {
                numbers[i] = Integer.parseInt(orig[i]);
            }
            Arrays.sort(numbers);
            if(numbers.length > 10){
                System.out.println("You've exceeded the max amount of numbers you can bet!");
                break;
            }
            orig = p1.rand().split(" ");
            int[] computer = new int[orig.length];
            System.out.println("Here are the actual numbers >>> ");
            for(int i = 0; i < orig.length; i++){
                computer[i] = Integer.parseInt(orig[i]);
                System.out.print(computer[i] + " ");
            }
            Arrays.sort(computer);
            System.out.println();
            System.out.println();
            
            int counter = 0;
            for(int i = 0; i < numbers.length; i++){
                if(Arrays.binarySearch(computer, numbers[i]) >= 0){
                    counter++;
                }
            }
            
            p1.balance -= p1.bet;
            p1.balance += payout[counter];
            System.out.println("Your new balance is " + p1.balance);
            if(!p1.check())
            {
                System.out.println("Oh no! Your balance is below 50! GAME OVER!");
                System.out.println();
                break;
            }
            else 
            {
                System.out.print("Do you want to play again? Y or N >>> ");
                String response = console.nextLine();
                if(response.equalsIgnoreCase("Y"))
                {
                    continue;
                }
                else
                {
                    break;
                }
            }
        }
    }
}

      
      
      
      
 
