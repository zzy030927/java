package ssm.service.impl;
import org.springframework.stereotype.Component;
import ssm.dao.BookDao;
import ssm.service.BookService;

@Component
public class BookServiceImpl implements BookService {
    private BookDao bookDao;

    public void save() {
        System.out.println("book service save ...");
        bookDao.save();
    }
}
