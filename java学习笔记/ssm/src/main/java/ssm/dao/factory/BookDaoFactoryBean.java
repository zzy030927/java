package ssm.dao.factory;

import org.springframework.beans.factory.FactoryBean;
import ssm.dao.BookDao;
import ssm.dao.impl.BookDaoImpl;

public class BookDaoFactoryBean implements FactoryBean<BookDao> {

    // 代替原始工厂中创建实例的方法
    @Override
    public BookDao getObject() throws Exception {
        return new BookDaoImpl();
    }

    // 这个bean是什么类型的
    @Override
    public Class<?> getObjectType() {
        return BookDao.class;
    }

    // 创建的对象是否为单例
    @Override
    public boolean isSingleton() {
        return true;        // true为单例，false为非单例
    }
}
