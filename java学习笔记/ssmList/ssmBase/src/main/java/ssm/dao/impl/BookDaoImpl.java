package ssm.dao.impl;

import org.springframework.stereotype.Repository;
import ssm.dao.BookDao;

@Repository
public class BookDaoImpl implements BookDao {
    public void save() {
        System.out.println("book dao save ... ");
    }
}
