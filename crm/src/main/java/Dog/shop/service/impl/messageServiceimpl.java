package Dog.shop.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dog.shop.ben.Message;
import Dog.shop.ben.MessageExample;
import Dog.shop.mapper.MessageMapper;
import Dog.shop.service.MessageService;
import Utils.PageBean;
@Service
public class messageServiceimpl implements MessageService {
	@Autowired
	private MessageMapper messageMapper;

	@Override
	public PageBean<Message> findAllMessageByPage(int page) {
		PageBean<Message> pageBean = new PageBean<>();
//		设置这是第几页
		pageBean.setPage(page);
//		设置10个
		int limitPage =4;
		pageBean.setLimitPage(limitPage);
//		设置一共多少页
		int totlePage = 0;
//		查询一共有多少页
		totlePage = messageMapper.countAllMessage();
		if(Math.ceil(totlePage % limitPage)==0){
			totlePage=totlePage / limitPage;
		}else{
			totlePage=totlePage / limitPage+1;
		}
		pageBean.setTotlePage(totlePage);
		int beginPage= (page-1)*limitPage;
		//商品集合
		List<Message> list = messageMapper.findAllMessageByPage(beginPage, limitPage) ;
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public void insertMessage(Message message) {
		// TODO Auto-generated method stub
		messageMapper.insert(message);
	}

	public void deleteMessage(int messageid) {
		// TODO Auto-generated method stub
		messageMapper.deleteByPrimaryKey(messageid);
	}

	@Override
	public List<Message> list() {
		// TODO Auto-generated method stub
		MessageExample example = new MessageExample();
		return messageMapper.selectByExample(example);
	}

	

}
