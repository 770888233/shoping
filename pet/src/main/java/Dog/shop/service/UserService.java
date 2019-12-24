package Dog.shop.service;

import java.util.List;

import Dog.shop.ben.Adminuser;
import Dog.shop.ben.User;

public interface UserService {
	 User loginFindByUnameAndPwd(String username, String password)throws Exception;
	
	 User loginFindByid(String username);
	
	 User findByCode(String code);
	
	 void activeUser(User activeUser);

	void saveUser(User user);

	Adminuser adminUser_login(String username, String password);

	List<User> admin_findAll();

	boolean login(String username, String password);
    
}
