package Dog.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dog.shop.ben.Adminuser;
import Dog.shop.ben.AdminuserExample;
import Dog.shop.ben.AdminuserExample.Criteria;
import Dog.shop.ben.User;
import Dog.shop.ben.UserExample;
import Dog.shop.mapper.AdminuserMapper;
import Dog.shop.mapper.UserMapper;
import Dog.shop.service.UserService;
import Utils.MailUtils;
import Utils.UUIDUtiils;

@Service
public class UserServiceimpl implements UserService {
	@Autowired
	private UserMapper usermapper;
	@Autowired
	private AdminuserMapper adminuserMapper;
	@Override
	public User loginFindByUnameAndPwd(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		criteria.andUsernameEqualTo(password);
		List<User> list = usermapper.selectByExample(example);
		if(list.size()>0 && list!=null){
			return list.get(0);
		}
		return null;
	}

	@Override
	public User loginFindByid(String username) {
		// TODO Auto-generated method stub
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<User> list = usermapper.selectByExample(example);
		if(list.size()>0 && list!=null){
			return list.get(0);
		}
		return null;
	}



	@Override
	public User findByCode(String code) {
		// TODO Auto-generated method stub
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andCodeEqualTo(code);
	    List<User> list = usermapper.selectByExample(example);
	    if (list.size()>0 && list!=null) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public void activeUser(User activeUser) {
			usermapper.updateByPrimaryKeySelective(activeUser);
		
	}

	@Override
	public void saveUser(User user) {
		user.setState(0);
		user.setCode(UUIDUtiils.getUUID());
		int i = usermapper.insert(user);
		System.out.println(i);
		String emailMsg = "请激活<a href='http://localhost:8080/Dog.shop/activeUser.action?code="
				+ user.getCode() + "'>激活</a>激活码是： + user.getCode()";
		System.out.println("调用了这个方法");
		try {
			MailUtils.sendMail(user.getEmail(), emailMsg);
		} catch (Exception e) {
		} 
	}

	//后台登录
	@Override
	public Adminuser adminUser_login(String username, String password) {
		// TODO Auto-generated method stub
		AdminuserExample example = new AdminuserExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andUsernameEqualTo(username);
		createCriteria.andPasswordEqualTo(password);
		List<Adminuser> list = adminuserMapper.selectByExample(example);
		if (list.size()>0 && list!=null) {
			return list.get(0);
		}
		return null;
	}

	//查询所有的列表
	@Override
	public List<User> admin_findAll() {
		UserExample example = new UserExample();
		return usermapper.selectByExample(example);
	}

	@Override
    public boolean login(String username,String password){
        User userEntity = new User ();
        userEntity.setUsername ( username );
        userEntity.setPassword ( password );

        User user = usermapper.selectUser ( userEntity );
        if (user != null){
            return true;
        }
        return false;
    }




}
