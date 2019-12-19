package Dog.shop.ben;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Orders {
    private Integer oid;

    private Double money;

    private Integer state;

    private String receiveinfo;

    private String phonum;

    private Date orderTime;

    private Integer uid;

    private String accepter;
    // 关联用户
 	private User user;
 	// 关联定单选项
 	private List<Orderitem> oiList = new ArrayList<>();

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Orderitem> getOiList() {
		return oiList;
	}

	public void setOiList(List<Orderitem> oiList) {
		this.oiList = oiList;
	}
	

    public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getReceiveinfo() {
        return receiveinfo;
    }

    public void setReceiveinfo(String receiveinfo) {
        this.receiveinfo = receiveinfo == null ? null : receiveinfo.trim();
    }

    public String getPhonum() {
        return phonum;
    }

    public void setPhonum(String phonum) {
        this.phonum = phonum == null ? null : phonum.trim();
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAccepter() {
        return accepter;
    }

    public void setAccepter(String accepter) {
        this.accepter = accepter == null ? null : accepter.trim();
    }
}