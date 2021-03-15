package entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.sql.Types;
import java.util.HashSet;
import java.util.Set;

public interface DataRepository<V extends DomainObject> {
    void persist(V object);

    void delete(V object);

    Set<String> getRandomData();
}

