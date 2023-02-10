package org.example;

import java.util.Scanner;
import java.util.logging.Logger;

class Tictoe
{
    private  static  final Logger logger = Logger.getLogger("Infologging");
    char[][] arr ;

    int dim;

    void create(int dim)
    {
        arr = new char[dim][dim];
        for(int i=0;i<dim;i+=1)
        {
            for(int j=0;j<dim;j+=1)
            {
                arr[i][j]=' ';
            }
        }
    }
    void assign(int user,int r,int c)
    {
        if(user==1)
        {
            arr[r-1][c-1]='O';
        }
        else if(user ==2)
        {
            arr[r-1][c-1]='X';
        }

    }
    void show()
    {
        StringBuilder st = new StringBuilder("\n");
        for(int i=0;i<=arr.length*2;i+=1) {
            st.append("-");
        }
        st.append("\n");
        for(int i=0;i<arr.length;i+=1)
        {

            for(int j=0;j<arr.length;j+=1)
            {
                st.append("|"+arr[i][j]);
            }
            st.append("|");
            st.append("\n");
        }
        for(int i=0;i<=arr.length*2;i+=1) {
            st.append("-");

        }
        st.append("\n");
        String w=""+ st;
        logger.info(w);

    }
    int diagonalcheck() {
        int count = 0;
        int count2 = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][i] == arr[i - 1][i - 1] && arr[i][i] != ' ') {
                count++;
            }
            if (arr[i][arr.length - i - 1] == arr[i - 1][arr.length - i] && arr[i][arr.length - i - 1] != ' ') {
                count2++;
            }
        }
        if (count2 == arr.length - 1 || count == arr.length - 1) {
            return 1;
        } else {
            return 0;
        }
    }

     int horizontalcheck() {
        int x = 0;
        int y = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 'X') {
                    x++;
                } else if (arr[i][j] == 'O') {
                    y++;
                }
            }
            if (x == arr.length || y == arr.length) {
                return 1;
            } else {
                return 0;
            }
        }
        return 0;
    }

     int verticalcheck() {
        int x = 0;
        int y = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j][i] == 'X') {
                    x++;
                } else if (arr[j][i] == 'O') {
                    y++;
                }
            }
            if (x == arr.length || y == arr.length) {
                return 1;
            } else {
                return 0;
            }
        }
        return 0;
    }
    int checkdraw()
    {

        for(int i=1;i<arr.length;i+=1)
        {
            for(int j=1;j<arr.length;j+=1)
            {
                if(arr[i][j]==' ')
                {

                    return 1;
                }

            }
        }
        return 0;
    }
    int win()
    {
        if((verticalcheck()==1||horizontalcheck()==1||diagonalcheck()==1))
        {
            return  7;
        }
        else if (checkdraw()==0) {
            return 2;

        }
        else
        {
            return 0;
        }
    }

}

public class Main {
    private  static  final Logger logger = Logger.getLogger("Infologging");
    public static void main(String[] args) {

        Scanner sc = new  Scanner(System.in);
        int k=1;
        int r;
        int c;
        logger.info("Enter the dimensions:");
        int dim = sc.nextInt();
        Tictoe t = new Tictoe();
        while(dim%2==0)
        {
            logger.info("Enter a odd number:");
            dim = sc.nextInt();
        }
        t.create(dim);
        t.show();
        while(k==1)
        {
            if(t.win()==0) {
                logger.info("1.Player 1");
                logger.info("Enter the row number: ");
                 r = sc.nextInt();
                logger.info("Enter the column number:");
                c = sc.nextInt();
                t.assign(1,r,c);
                t.show();
                if(t.win()==0)
                {
                   logger.info(("2.player"));
                    logger.info("Enter the row number: ");
                    r = sc.nextInt();
                    logger.info("Enter the column number:");
                    c = sc.nextInt();
                    t.assign(2,r,c);
                    t.show();
                } else if (t.win()==2) {
                    logger.info("Match drawn");
                    k=0;

                }
                else if(t.win()==7)
                {
                    logger.info("player 1 Won!!!!!!!!");
                    k=0;
                }
            }
            else if (t.win()==2) {
                logger.info("Match drawn");
                k=0;

            }
            else if(t.win()==7)
            {
                logger.info("Player 2 Won!!!!!!");
                k=0;
            }

        }

    }
}