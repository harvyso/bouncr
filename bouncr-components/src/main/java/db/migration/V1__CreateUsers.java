package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;

import java.sql.Connection;
import java.sql.Statement;

import static org.jooq.impl.DSL.*;

/**
 * @author kawasima
 */
public class V1__CreateUsers extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {
        Connection connection = context.getConnection();
        try (Statement stmt = connection.createStatement()) {
            DSLContext create = DSL.using(connection);
            String ddl = create.createTable(table("users"))
                    .column(field("user_id", SQLDataType.BIGINT.identity(true)))
                    .column(field("account", SQLDataType.VARCHAR(100).nullable(false)))
                    .column(field("write_protected", SQLDataType.BOOLEAN.nullable(false)))
                    .constraints(
                            constraint().primaryKey(field("user_id")),
                            constraint().unique(field("account"))
                    ).getSQL();
            stmt.execute(ddl);

            stmt.execute(
                    create.createIndex(name("idx_users_01"))
                            .on(table("users"), field("account"))
                            .getSQL()
            );
        }
    }
}
