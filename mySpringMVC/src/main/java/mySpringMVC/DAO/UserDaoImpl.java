package mySpringMVC.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.persister.entity.Queryable;

import mySpringMVC.ENTITY.User;


@Transactional(propagation=Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
@Repository
public class UserDaoImpl implements UserDao{

	
    @Autowired  
    private SessionFactory sessionFactory;  
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void addUser(User user) throws Exception {
        System.out.println("11111111111111111"+user.getName());  
        sessionFactory.getCurrentSession().save(user);          
    } 
    
    
    public void updateUser(User user) throws Exception {
        System.out.println("222222222222"+user.getName());  
        sessionFactory.getCurrentSession().update(user);          
    } 
    
    public Object[] getUsers() throws Exception {
    	String result="";
        System.out.println("3333333333");  
        Session session = sessionFactory.getCurrentSession();
        //session.beginTransaction();   因为使用servlet hibernate session来代理管理session，代理已经自动实现begin和close方法，这里就不再需要使用了。
        String sql = "select * from t_user t where t.name = ?";
        //String sql = "select * from t_user t ";
        SQLQuery sqlQuery = session.createSQLQuery(sql);
//        sqlQuery.addEntity(User.class);
//        List<User> userList = (List<User>)sqlQuery.list();
        sqlQuery.setParameter(0, "zhouyutong");
        List userList = sqlQuery.list();
        System.out.println("鏁版嵁搴撴湁" + userList.size() + "鏉¤褰�");
        for(Object obj: userList) {
        Object[] objArray = (Object[]) obj;
        result = "----id:"+ objArray[0] + "----name:" + objArray[1] 
                + "----password:" + objArray[2];
        System.out.println(result);
        }
        //session.getTransaction().commit();
        return (Object[])userList.get(0);
    } 
    
    
    public List<User> getUsersWithJsonParam(String name) throws Exception {
    	String result="";
        System.out.println("4444444444444");  
        String hql =  "from User t where 1=1";   // use HQL, User is the mapped table name in User.hbm.xml's <class name>
/*      sql中使用的是表，hql中使用映射到数据库中的对象   
        1.from后跟实体类名（注意大小写） 
        hql是写的是PO对象，不是table名，故要改为配置文件中的类名。 
        2.hbm文件是否导入 
        hibernate.cfg.xml，要放在根目录下。 
        3.把你要映射的都写上去。     <mapping resource="....包名.../Xxx.hbm.xml" /> */
        
        if(name!=null && !("").equals(name)){
            hql=hql+" and t.name='" + name + "'";
        }
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        List<User> list=query.list();
        return list;
    }
}
