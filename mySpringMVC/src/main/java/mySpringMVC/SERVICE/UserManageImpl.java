package mySpringMVC.SERVICE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mySpringMVC.DAO.UserDaoImpl;
import mySpringMVC.ENTITY.User;


@Service
public class UserManageImpl implements UserManage{

	@Autowired
    private UserDaoImpl userDaoImpl;  
	
    public UserDaoImpl getUserDaoImpl() {
        return userDaoImpl;
    }

    public void setUserDaoImpl(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }
	
	@Override
	public void addUser(User user) throws Exception{
		userDaoImpl.addUser(user);   
	}
	
	public Object[] getUsers() throws Exception{
		return userDaoImpl.getUsers();   
		
	}
	
	public List<User> getUsersWithJsonParam(String name) throws Exception{
		return userDaoImpl.getUsersWithJsonParam(name);
	}
}
