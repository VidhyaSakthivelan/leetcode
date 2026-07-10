import java.util.*;
class Solution 
{
    public boolean check(char a,char b)
    {
        if((a=='['&&b==']')||(a=='{'&&b=='}')||(a=='('&&b==')'))
        {
            return true;
        }
        return false;
    }
    public boolean isValid(String s) 
    {
        int sLength =s.length(),i;
        Stack<Character>s1=new Stack<>();
        for(i=0;i<sLength;i++)
        {
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='[')
            {
                s1.push(s.charAt(i));
            }
            else
            {
                if(s1.isEmpty()==true)
                {
                    return false;
                }
                if(check(s1.peek(),s.charAt(i))==false)
                {
                    return false;
                }
                else
                {
                    s1.pop();
                }
            }
        }
        return s1.isEmpty();
    }
}