
package springMVC.model;
// Generated 2021�~1��31�� �U��8:40:50 by Hibernate Tools 5.4.21.Final

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name = "product")
public class Product implements java.io.Serializable {

	private int pid;
	private String productname;
	private double price;
	private String imagepath;

	public Product() {
	}

	public Product(int pid, String productname, double price) {
		this.pid = pid;
		this.productname = productname;
		this.price = price;
	}

	public Product(int pid, String productname, double price, String imagepath) {
		this.pid = pid;
		this.productname = productname;
		this.price = price;
		this.imagepath = imagepath;
	}

	@Id
	public int getPid() {
		return this.pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getProductname() {
		return this.productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImagepath() {
		return this.imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
}
