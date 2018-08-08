package dao.impl;

import dao.GenericDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class GenericDaoImpl<T extends Serializable, N extends Serializable> implements GenericDao<T, N> {

    @Autowired
    private SqlSession sqlSession;

    private String namespace;

    @SuppressWarnings("unchecked")
    GenericDaoImpl() {
        // Reflect
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        Class<T> clazz = (Class<T>) parameterizedType.getActualTypeArguments()[0];
        namespace = clazz.getSimpleName().toLowerCase();
    }

    private String getStatement(String sqlId) {
        return namespace.concat(".").concat(sqlId);
    }

    @Override
    public void create(T t) {
        sqlSession.insert(getStatement("create"), t);
    }

    @Override
    public void remove(N id) {
        sqlSession.delete(getStatement("remove"), id);
    }

    @Override
    public void update(T t) {
        sqlSession.update(getStatement("update"), t);
    }

    @Override
    public List<T> queryAll() {
        return sqlSession.selectList(getStatement("queryAll"));
    }

    @Override
    public List<T> queryAll(String statement, Object parameter) {
        return sqlSession.selectList(statement, parameter);
    }

    @Override
    public T queryById(N id) {
        return sqlSession.selectOne(getStatement("queryById"), id);
    }

    @Override
    public void removeSelected(N[] ids) {
        for (N id : ids) {
            remove(id);
        }
    }

    @Override
    public T queryOne(String statement, Object parameter) {
        return sqlSession.selectOne(statement, parameter);
    }
}
