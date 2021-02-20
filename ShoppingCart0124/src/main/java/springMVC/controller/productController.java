
package springMVC.controller;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.*;
import springMVC.model.Product;

@Controller
@RequestMapping("/")
public class productController {
	@RequestMapping(method = RequestMethod.GET)
	public String topPage(ModelMap model) {
		return "topPage";
	}

	@RequestMapping(value = "/productTable", method = RequestMethod.GET)
	public String listProduct(ModelMap model) {
		List<Product> data = getAll();
		model.addAttribute("message", data);
		return "productTable";
	}

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String getProductView(ModelMap modelMap) {
		return "product";
	}

	public List<Product> getAll() {
		/*
		 * Configuration configObj = new Configuration();
		 * configObj.addClass(model.Student.class);
		 * configObj.configure("hibernate.cfg.xml");
		 * 
		 * // Since Hibernate Version 4.x, ServiceRegistry Is Being Used ServiceRegistry
		 * serviceRegistryObj = new StandardServiceRegistryBuilder()
		 * .applySettings(configObj.getProperties()).build(); Session session = null;
		 */
		SessionFactory sessionFactory = null;
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure() // hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception ex) {
			StandardServiceRegistryBuilder.destroy(registry);
			System.out.println("Setup Failed:" + ex.getMessage());
		}
		// session = configObj.buildSessionFactory(serviceRegistryObj).openSession();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = "FROM Product";
			List data = session.createQuery(hql).list();
			for (Iterator iterator = data.iterator(); iterator.hasNext();) {
				Product product = (Product) iterator.next();
			}
			tx.commit();
			return data;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
}
