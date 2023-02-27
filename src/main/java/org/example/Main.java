package org.example;

import java.util.Scanner;
import java.util.logging.Logger;


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