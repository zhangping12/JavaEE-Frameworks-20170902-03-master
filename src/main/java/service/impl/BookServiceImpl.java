package service.impl;

import dao.GenericDao;
import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import service.BookService;

@Service
public class BookServiceImpl extends GenericServiceImpl<Book, Long> implements BookService {
    @Override
    @Autowired
    @Qualifier("bookDaoImpl")
    void setGenericDao(GenericDao<Book, Long> genericDao) {
        super.genericDao = genericDao;
    }
}
