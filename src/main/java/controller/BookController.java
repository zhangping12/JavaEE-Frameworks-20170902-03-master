package controller;

import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import service.BookService;

@Controller
//@Component
@RequestMapping("book")
public class BookController extends BaseController {

    @Autowired
    private BookService bookService;

    @RequestMapping("create")
    private String create(Book book) {
        bookService.create(book);
        return queryAll();
    }

    @RequestMapping("queryAll")
    private String queryAll() {
       session.setAttribute("books", bookService.queryAll());
        return "redirect:/home.jsp";
    }

    @RequestMapping("queryById/{id}")
    private String queryById(@PathVariable Long id) {
        session.setAttribute("book", bookService.queryById(id));
        return "redirect:/edit.jsp";
    }

    @RequestMapping("update")
    private String update(Book book) {
        bookService.update(book);
        return queryAll();
    }

    @RequestMapping("remove/{id}")
    private String remove(@PathVariable Long id) {
        bookService.remove(id);
        return queryAll();
    }

    @RequestMapping("removeSelected")
    private String removeSelected(Long[] ids) {
        bookService.removeSelected(ids);
        return queryAll();
    }
}
