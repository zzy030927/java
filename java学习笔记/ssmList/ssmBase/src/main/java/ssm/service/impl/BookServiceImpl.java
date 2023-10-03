package ssm.service.impl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ssm.dao.BookDao;
import ssm.service.BookService;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    @Qualifier("BookDao2")
    private BookDao bookDao;

    @Value("${name}")
    private String name;

    public void save() {
        System.out.println("book service save ..." + name);
        bookDao.save();
    }
}
