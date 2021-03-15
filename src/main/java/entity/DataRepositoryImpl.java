package entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.sql.Types;
import java.util.HashSet;
import java.util.Set;

@org.springframework.stereotype.Repository("dataRepository")
public class DataRepositoryImpl implements DataRepository<Data> {

    @Autowired
    protected JdbcOperations jdbcOperations;

    @Override
    public void persist(Data object) {
        Object[] params = new Object[]{
                object.getId(),
                object.getDescription()
        };
        int[] types = new int[]{
                Types.VARCHAR, Types.VARCHAR
        };

        jdbcOperations.update("INSERT INTO myapp_data(\n" +
                "               data_id,data_description)\n" +
                "               VALUES (cast(? as UUID), ? );", params, types);
    }

    @Override
    public void delete(Data object) {
        jdbcOperations.update("DELETE FROM myapp_data\n" +
                "WHERE data_id = '" + object.getId().toString() + "';");
    }

    @Override
    public Set<String> getRandomData() {
        Set<String> result = new HashSet<>();
        SqlRowSet rowSet = jdbcOperations.queryForRowSet("SELECT data_description FROM myapp_data p ORDER BY RANDOM() LIMIT 50;");
        while (rowSet.next()) {
            result.add(rowSet.getNString("data_description"));
        }
        return result;
    }
}
