package liar.xiaoyu.www.temp.entity;


public class Order {

  private Integer id;
  private Integer ridgepole;
  private Integer dorm;
  private String info;
  private String staff;
  private String phone;
  private Integer flag;

  public Integer getFlag() {
    return flag;
  }

  public void setFlag(Integer flag) {
    this.flag = flag;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getRidgepole() {
    return ridgepole;
  }

  public void setRidgepole(Integer ridgepole) {
    this.ridgepole = ridgepole;
  }

  public Integer getDorm() {
    return dorm;
  }

  public void setDorm(Integer dorm) {
    this.dorm = dorm;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

  public String getStaff() {
    return staff;
  }

  public void setStaff(String staff) {
    this.staff = staff;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

}
