
package useBean;

import java.util.List;
import springMVC.controller.productController;
import springMVC.model.Product;

public class productBean {
	private String pidStr;
	private String productName;
	private String ImagePath;

	public void readProductData() {
		productController pc = new productController();
		List<Product> data = pc.getAll();
		int pid = Integer.parseInt(pidStr) - 1;
		productName = data.get(pid).getProductname();
		ImagePath = data.get(pid).getImagepath();
	}

	public void setPidStr(String pidStr) {
		this.pidStr = pidStr;
	}

	public String getProductName() {
		return productName;
	}

	public String getImagePath() {
		return ImagePath;
	}
}
