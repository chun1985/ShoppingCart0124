
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import springMVC.controller.productController;
import springMVC.model.Product;

@WebServlet("/PictureServlet")
public class PictureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	productController pc = new productController();
	List<Product>data = pc.getAll();

	public PictureServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cnt = request.getParameter("id");
		String[] images = { data.get(0).getImagepath(), data.get(1).getImagepath(), data.get(2).getImagepath(),
				data.get(3).getImagepath(), data.get(4).getImagepath() };
		int count = Integer.parseInt(cnt) % images.length;
		response.getWriter().append(images[count]);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
