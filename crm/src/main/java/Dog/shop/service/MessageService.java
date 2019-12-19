package Dog.shop.service;

import java.util.List;

import Dog.shop.ben.Message;
import Utils.PageBean;

public interface MessageService {

	PageBean<Message> findAllMessageByPage(int page);

	void insertMessage(Message message);

	void deleteMessage(int messageid);

	List<Message> list();
}
