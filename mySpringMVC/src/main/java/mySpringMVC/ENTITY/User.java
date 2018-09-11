package mySpringMVC.ENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="t_user")
public class User {
	
    public User() {}      //Entity实体类需要默认构造函数，因为要使用getClass.getInstance反射来初始化对象
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Id
    @GeneratedValue(generator="id")  
    @GenericGenerator(name = "id",strategy="identity")  
	private int id;
    @Column(name="name")
	private String name;
	@Column(name="pwd")
	private String pwd;
	
	@Override
	public String toString(){
		return "name:".concat(name).concat(",").concat("pwd:").concat(pwd);		
	}
}
