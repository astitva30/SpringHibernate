/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package springnamespace;

import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spr.beans.Sports;
import spr.dao.Logics;

/**
 *
 * @author deshp
 */
public class MainSpringClass {

    public static void main(String[] args)throws Exception {
    
        ApplicationContext context = new ClassPathXmlApplicationContext("/SpringXMLConfig.xml");
        
        Logics logicsDao = (Logics)context.getBean("technosoft");
        System.out.println("Login as:-\n1.Admin 2.Operator");
        Scanner sc = new Scanner(System.in);
        byte choice = sc.nextByte();
        byte innerChoice=0;
        switch(choice)
        {
            case 2:
                System.out.println("Enter id and password");
                String id = sc.next();
                String password = sc.next();
                //verification from database table 
                if(id.equals("abc")&& password.equals("abc"))
                {
                   do
                   {
                       System.out.println("====MENU====");
                       System.out.println("1.Sport Entry");
                       System.out.println("2.Delete Entry");
                       System.out.println("3.Update Entry");
                       System.out.println("4.Search Record");
                       System.out.println("5.Show All Records");
                       System.out.println("6.Exit");
                       int ch = sc.nextInt();
                       switch(ch){
                           case 1:
                               System.out.println("enter sport id");
                               int sportId = sc.nextInt();
                               System.out.println("enter sport name");
                               String sportName= sc.next();
                               System.out.println("enter sport about");
                               String aboutSport = sc.next();
                               Sports sport = new Sports(sportId, sportName, aboutSport);
                               logicsDao.sportEntry(sport);
                               break;
                           case 2:
                               System.out.println("Enter Sport id to delete the record");
                               int sId= sc.nextInt();
                               Sports sports = new Sports();
                               sports.setSportId(sId);
                               logicsDao.deleteSports(sports);
                               break;
                           case 3:
                               System.out.println("Enter sport id to load the record");
                               sId = sc.nextInt();
                               sports = new Sports();
                               sports.setSportId(sId);
                               logicsDao.updateSports(sports);
                               break;
                           case 5:
                               logicsDao.showAllRecords();
                               break;
                       }
                       System.out.println("PRESS 1 to cont");
                       innerChoice =sc.nextByte();
                   }while(innerChoice==1);
                }
        }
    }
    
}
