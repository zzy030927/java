package ssm.src;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ssm.dao.BookDao;
import ssm.service.BookService;

@SpringBootApplication
public class SsmApplication {
    public static void main(String[] args) {
        // 获取IoC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 获取bean
        BookDao bookDao = (BookDao) context.getBean("bookDao");
        bookDao.save();

        System.out.println("---------------");
        BookService bookService = (BookService) context.getBean("bookService");
        bookService.save();

        System.out.println("---------------");
        BookDao bookDao1 = (BookDao) context.getBean("bookDao");
        BookDao bookDao2 = (BookDao) context.getBean("bookDao");
        System.out.println(bookDao1 == bookDao2);       // 可以看出 bean是单例的，只能创建一个对象

    }
}
