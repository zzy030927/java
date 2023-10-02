package ssm.dao.impl;

import org.springframework.stereotype.Repository;
import ssm.dao.BookDao;

@Repository("BookDao2")
public class BookDaoImpl2 implements BookDao {
    public void save() {
        System.out.println("book dao save ... ");
    }
}
