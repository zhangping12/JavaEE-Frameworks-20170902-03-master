package dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T extends Serializable, N extends Serializable> {
    void create(T t);

    void remove(N id);

    void update(T t);

    List<T> queryAll();

    List<T> queryAll(String statement, Object parameter);

    T queryById(N id);

    void removeSelected(N[] ids);

    T queryOne(String statement, Object parameter);
}
