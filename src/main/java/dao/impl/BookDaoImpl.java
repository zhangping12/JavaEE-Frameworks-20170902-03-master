package dao.impl;

import dao.BookDao;
import model.Book;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl extends GenericDaoImpl<Book, Long> implements BookDao {
}