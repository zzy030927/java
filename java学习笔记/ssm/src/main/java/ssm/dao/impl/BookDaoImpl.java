package ssm.dao.impl;

import org.springframework.stereotype.Component;
import ssm.dao.BookDao;

@Component("bookDao")
public class BookDaoImpl implements BookDao {
    public void save() {
        System.out.println("book dao save ... ");
    }
}
