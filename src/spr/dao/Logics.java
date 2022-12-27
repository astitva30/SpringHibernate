package spr.dao;

import java.util.List;
import java.util.Scanner;
import org.hibernate.Criteria;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import spr.beans.Sports;

public class Logics {
    
    private HibernateTemplate template;
    public HibernateTemplate getTemplate(){
        return template;
    }
    public void setTemplate(HibernateTemplate template){
        this.template=template;
    }
    
    //TO CHECK THE LOGIN INFO
    public boolean checkLogin()throws Exception
    {
    return true;
    }

    //TO INSERT THE SPORT RECORD
    public void sportEntry(Sports sports)throws Exception
    {
        //template.save(sports);
        //OR
        template.execute(new HibernateCallback<Object>()
        {
            @Override
            public Object doInHibernate(org.hibernate.Session session)throws org.hibernate.HibernateException
            {
                session.save(sports);
                return null;
            }
        });
    }
    
    //TO DELETE THE SPORT RECORD
    public void deleteSports(Sports sport)throws Exception
    {
        //template.delete(sport);
        //OR
        template.execute(new HibernateCallback<Object>(){
            @Override
            public Object doInHibernate(org.hibernate.Session session)throws org.hibernate.HibernateException
            {
                Sports ref = (Sports)session.get(Sports.class,sport.getSportId());
                if(ref==null){
                    System.out.println("No record found to Delete!!");
                    
                }else{
                    session.delete(ref);
                    System.out.println("Record Deleted!!");
                }
                return null;
            }
        });
    }
    
    //TO UPDATE THE SPORT RECORD
    public void updateSports(Sports sports)throws Exception
    {
        template.execute(new HibernateCallback<Object>(){
            @Override
            public Object doInHibernate(org.hibernate.Session session)throws org.hibernate.HibernateException
            {
                Scanner sc = new Scanner(System.in);
                Sports ref = (Sports)session.get(Sports.class,sports.getSportId());
                if(ref==null){
                    System.out.println("no record found to update");
                }else{
                    System.out.println("-------SELECT CHOICE TO UPDATE-------");
                    System.out.println("1.Sport Name\n2.About Sport\n3.Exit");
                    byte ch = sc.nextByte();
                    switch(ch)
                    {
                        case 1:
                            System.out.println("Enter updated sport name");
                            String uSportName=sc.next();
                            ref.setSportName(uSportName);
                            session.update(ref);
                            break;
                        
                        case 3:
                            System.exit(0);
                    }
                    System.out.println("Record updated!!!");
                }
                return null;
            }
        });
    }
    
    public void showAllRecords()throws Exception
    {
        template.execute(new HibernateCallback<Object>()
        {
            @Override
            public Object doInHibernate(org.hibernate.Session session)throws org.hibernate.HibernateException
                    {
                        Criteria crit = session.createCriteria(Sports.class);
                        List<Sports> data = crit.list();
                        if(data.isEmpty())
                        {
                           System.out.println("No record Found");
                        }else{
                            for(Sports records: data){
                                System.out.println(records.getSportId()+"   "+records.getSportName()+"  "+records.getAbout());
                            }
                        }
                        return null;
                    }
        });
        
    }
}
