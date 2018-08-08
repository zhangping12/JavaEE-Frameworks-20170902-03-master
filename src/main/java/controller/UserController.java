package controller;

import dao.UserDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import service.UserService;

@Controller
//@Component
@RequestMapping("user")
public class UserController extends BaseController { // Business

    @Autowired
    private UserService userService;

    @RequestMapping("signUp")
    private String signUp(User user) {
        if (!userService.signUp(user)) {
            request.setAttribute("message", "username is existed.");
            return "/signUp.jsp";
        }
        return "redirect:/index.jsp";
    }

    @RequestMapping("signIn")
    private String signIn(User user) {
        user = userService.singIn(user);
        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/book/queryAll";
        }
        request.setAttribute("message", "Invalid username or password.");
        return "/index.jsp";
    }

    @RequestMapping("signOut")
    private String signOut() {
        session.invalidate();
        return "redirect:/index.jsp";
    }
}
