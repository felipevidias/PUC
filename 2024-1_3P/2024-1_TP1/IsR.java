class IsR
{
    public static boolean isVogal(String s, int i)
    {
        if(i >= s.length())
        {
            return true;
        } // end if
        
        if(s.charAt(i) != 'a' && s.charAt(i) != 'e' && s.charAt(i) != 'i' && s.charAt(i) != 'o' && s.charAt(i) != 'u' || s.charAt(i) != 'A' && s.charAt(i) != 'E' && s.charAt(i) != 'I' && s.charAt(i) != 'O' && s.charAt(i) != 'U' ) 
        {
            return false;
        }

        return isVogal(s, i + 1);
    } //end isVogal

    public static boolean isConsonant(String s, int i)
    {
        if(i >= s.length())
        {
            return true;
        } // end if
        
        if(s.charAt(i) == 'a' && s.charAt(i) == 'e' && s.charAt(i) == 'i' && s.charAt(i) == 'o' && s.charAt(i) == 'u' || s.charAt(i) == 'A' && s.charAt(i) == 'E' && s.charAt(i) == 'I' && s.charAt(i) == 'O' && s.charAt(i) == 'U' ) 
        {
            return false;
        } // end if 
        return isVogal(s, i + 1);
    } //end isConsonant

    public static boolean isInt(String s, int index)
    {
        if (index >= s.length())
        {
            return true;
        } // end if 

        char currentChar = s.charAt(index);

        if (currentChar < '0' || currentChar > '9')
        {
            return false;
        } // end if 

        return isInt(s, index + 1);
    } // end isInt

    public static boolean isDouble(String s, int index, boolean decimalPoint)
    {
        if (index >= s.length())
        {
            return decimalPoint;
        } // end if 

        char currentChar = s.charAt(index);

        if (currentChar == '.' || currentChar == ',')
        {
            if (decimalPoint) {
                return false;
            } else {
                return isDouble(s, index + 1, true);
            }
        }
        else if (currentChar < '0' || currentChar > '9')
        {
            return false;
        } // end if 

        return isDouble(s, index + 1, decimalPoint);
    } // end isDouble

     public static void main(String[] args)
     {
        String s;
        while (true)
        {
            s = MyIO.readLine();
            if (s.equals("FIM"))
            {
                break;
            } // end if 

            boolean r1 = isVogal(s, 0);
            boolean r2 = isConsonant(s, 0);
            boolean r3 = isInt(s, 0);
            boolean r4 = isDouble(s, 0, false);

            MyIO.print(r1 ? "SIM " : "NAO ");
            MyIO.print(r2 ? "SIM " : "NAO ");
            MyIO.print(r3 ? "SIM " : "NAO ");
            MyIO.println(r4 ? "SIM" : "NAO");
        } // end while 
    } // end main
} // end IsR