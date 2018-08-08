package dao.impl;

import dao.UserDao;
import model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by mingfei on 06/05/2018.
 */

@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements UserDao {
}
