 class Is
{
    public static boolean isVogal(String s)
    {
       
        for(int i = 0; i < s.length(); i = i + 1)
        {
            if(s.charAt(i) != 'a' || s.charAt(i) != 'A')
            {
                return false;
            }
            else if(s.charAt(i) != 'e' || s.charAt(i) != 'E')
            {
                return false;
            }
            else if(s.charAt(i) != 'i' || s.charAt(i) != 'I')
            {
                return false;
            }
            else if(s.charAt(i) != 'o' || s.charAt(i) != 'O')
            {
                return false;
            }
            else if(s.charAt(i) != 'u' || s.charAt(i) != 'U')
            {
                return false;
            } // end if 
            
        } // end for 
        return true;
    } // end isVogal

    public static boolean isConsonant(String s)
    {
        for(int i = 0; i < s.length(); i = i + 1)
        {
            if(s.charAt(i) == 'a' || s.charAt(i) == 'A')
            {
                return false;
            }
            else if(s.charAt(i) == 'e' || s.charAt(i) == 'E')
            {
                return false;
            }
            else if(s.charAt(i) == 'i' || s.charAt(i) == 'I')
            {
                return false;
            }
            else if(s.charAt(i) == 'o' || s.charAt(i) == 'O')
            {
                return false;
            }
            else if(s.charAt(i) == 'u' || s.charAt(i) == 'U')
            {
                return false;
            } // end if 
            
        } // end for 
        return true;
    } // end isConsonant

    public static boolean isInt(String s)
    {
        boolean result = false;
        for(int i = 0; i < s.length(); i = i + 1)
        {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9')
            {
                result = true;
            }
            else
            {
                result = false;
                i = s.length();
            } // end if 
        } // end for 
        return result;
    } // end isInt

    public static boolean isDouble(String s)
    {
        boolean decimalPoint = false;
        boolean result = false;
        for(int i = 0; i < s.length(); i = i + 1)
        {
            if(s.charAt(i) == '.' || s.charAt(i) == ','  )
            {
                if(decimalPoint)
                {
                    result = false;
                    i = s.length();
                }
                else
                {
                    decimalPoint = true;
                } // end if
            } 
            else if(s.charAt(i) < '0' || s.charAt(i) > '9')
            {
                result = false;
                i = s.length();
            } 
            else
            {
                result = true;
            } // end if
        } // end for 
        return result && decimalPoint;
    } // end isDouble


    public static void main(String[] args)
    {
        String s;
        while(true)
        {   
            s = MyIO.readLine();
            if(s.equals("FIM"))
            {
                break;
            } // end if 
            boolean r1,r2,r3,r4;
           
                r1 = isVogal(s); r2 = isConsonant(s); r3 = isInt(s); r4 = isDouble(s);
                if(r1 == true)
                {
                    MyIO.print("SIM ");
                }
                else
                {
                    MyIO.print("NAO ");
                } // end if 

                if(r2 == true)
                {
                    MyIO.print("SIM ");
                }
                else
                {
                    MyIO.print("NAO ");
                } // end if 

                if(r3 == true)
                {
                    MyIO.print("SIM ");
                }
                else
                {
                    MyIO.print("NAO ");
                } // end if 

                if(r4 == true)
                {
                    MyIO.println("SIM ");
                }
                else
                {
                    MyIO.println("NAO ");
                } // end if 
        } // end while

    } // end main
} // end Is
