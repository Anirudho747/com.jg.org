package javaP;

import java.util.Scanner;

public class Jun16<abc> {

    static String abc;
    static String bca="";
    static int[] a1 = {10,20,30,40,50};
    static String straight;

    public static void takeWordInput()
    {
        Scanner sc = new Scanner(System.in);

        abc = sc.nextLine();
    }

    public static void revWord()
    {

        for(int i=abc.length()-1;i>=0;i--)
        {
            bca = bca + abc.charAt(i);
        }
    }

    public static void printWord()
    {
        System.out.println(bca);
    }

    public static void revArray()
    {
        int k;
        for (int i = 0; i < a1.length / 2; i++) {
            k = a1[i];
            a1[i] = a1[a1.length - 1 - i];
            a1[a1.length - 1 - i] = k;
        }
    }

    public static void printArray()
    {
        for(int i=0;i<a1.length;i++)
        {
            System.out.println(a1[i]+" ");
        }
    }

    public static void enterString()
    {
        System.out.println("Enter String");
        Scanner sc = new Scanner (System.in);
        straight = sc.nextLine();
    }

    public static void revString()
    {
        String [] wordArray = straight.split(" ");

        for(int i=wordArray.length-1;i>=0;i--)
        {
            System.out.print(wordArray[i]+" ");
        }
    }

    public static void palindrome()
    {
        enterString();
        int pllndrm=1;


        for(int i=0;i<(straight.length()-1)/2;i++)
        {
            if (straight.charAt(i) != straight.charAt(straight.length() - 1 - i))
            {
                pllndrm = 0;
                break;
            }
        }


            if(pllndrm==1)
            {
                System.out.println("Its a pallindrome");
            }
            else
            {
                System.out.println("Its not a pallindrome");
            }


    }

    public static void main(String[] args)
    {
//       takeWordInput();
//       revWord();
//       printWord();

//        revArray();
//        printArray();

//        enterString();
//        revString();

        palindrome();
    }
}
