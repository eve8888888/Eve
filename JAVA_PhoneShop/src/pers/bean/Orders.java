package pers.bean;

/**
 * @Author: Eve
 * @Date: 2018/12/3 15:57
 * @Version 1.0
 */
//订单表
public class Orders {

//	oid VARCHAR(50) COMMENT'订单id',
//	ototalMoney INT COMMENT'总金额',
//	oaddress VARCHAR(50)COMMENT'订单地址',
//	oTime VARCHAR(20) COMMENT'订单时间',
//	oStatus VARCHAR(4) DEFAULT '等待处理' COMMENT'订单状态//1代表正在处理,0代表订单完成',
//	u_id VARCHAR(50) COMMENT'关联的用户id',

    String oid;
    int ototalMoney;
    String oaddress;
    String oTime;
    String oStatus;
    String u_id;
    public Orders() {
        super();
    }
    public Orders(String oid, int ototalMoney, String oaddress, String oTime, String oStatus, String u_id) {
        super();
        this.oid = oid;
        this.ototalMoney = ototalMoney;
        this.oaddress = oaddress;
        this.oTime = oTime;
        this.oStatus = oStatus;
        this.u_id = u_id;
    }
    public String getOid() {
        return oid;
    }
    public void setOid(String oid) {
        this.oid = oid;
    }
    public int getOtotalMoney() {
        return ototalMoney;
    }
    public void setOtotalMoney(int ototalMoney) {
        this.ototalMoney = ototalMoney;
    }
    public String getOaddress() {
        return oaddress;
    }
    public void setOaddress(String oaddress) {
        this.oaddress = oaddress;
    }
    public String getoTime() {
        return oTime;
    }
    public void setoTime(String oTime) {
        this.oTime = oTime;
    }
    public String getoStatus() {
        return oStatus;
    }
    public void setoStatus(String oStatus) {
        this.oStatus = oStatus;
    }
    public String getU_id() {
        return u_id;
    }
    public void setU_id(String u_id) {
        this.u_id = u_id;
    }
    @Override
    public String toString() {
        return "Orsers [oid=" + oid + ", ototalMoney=" + ototalMoney + ", oaddress=" + oaddress + ", oTime=" + oTime
                + ", oStatus=" + oStatus + ", u_id=" + u_id + "]";
    }
}
