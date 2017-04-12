package test;

import Entity.ADs;
import dao.Connection;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by dlydd on 2017/4/11.
 */
public class TestConnection {
    public static void main(String[] args){
        test();
    }

    public static boolean  test(){
        Session session= Connection.getSession();
        try {
            String hql = "from ADs as a";
            Query query = session.createQuery(hql);
            List aList = query.list();
            Connection.closeSession(session);
            System.out.println("success!");
            return true;
        }catch(Exception e){
            e.printStackTrace();
            Connection.closeSession(session);
            return  false;
        }
    }

}
