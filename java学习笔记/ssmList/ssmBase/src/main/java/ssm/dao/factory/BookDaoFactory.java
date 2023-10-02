package ssm.dao.factory;

import ssm.dao.BookDao;
import ssm.dao.impl.BookDaoImpl;

public class BookDaoFactory {
    public static BookDao getBookDao() {
        System.out.println("static factory setup...");
        return new BookDaoImpl();
    }

    public BookDao getBookDaoImpl() {
        System.out.println("factory setup...");
        return new BookDaoImpl();
    }
}
