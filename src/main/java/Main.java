import entity.Product;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        List<Product> products = new ArrayList<Product>();
        Product product1 = new Product("milk");
        Product product2 = new Product("water");
        products.add(product1);
        products.add(product2);
        User user = new User("userOne","mypass", products);


        Product product = new Product("moloko", new User("name", "mypass"));

        session.save(products);
        session.save(product);
        session.save(product1);
        session.save(product2);
        session.save(user);
        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}
