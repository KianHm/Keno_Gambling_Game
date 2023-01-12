import java.util.*;
import java.util.Random;
public class Player 
{
    public String luckyNum;
    public int bet;
    public int balance;
    public Player(String n, int m)
    {
        luckyNum = n;
        bet = m;
        balance = 0;
    }
    public boolean check ()
    {
        if(balance < 50)
        {
            return false;
        }
        return true;
    }
    public String rand ()
    {
        String ans = "";
         Random rand1 = new Random(); 
        for(int i = 0; i < 20; i++)
        {
            int temp = rand1.nextInt(80);
            temp++;
            ans = ans + temp + " ";
        }
        return ans;
    }
}
