package com.moi.controller;


import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
import com.mysql.cj.jdbc.MysqlDataSource;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.flywaydb.core.Flyway;

@WebListener
public class FlywayMigrationListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
         String JDBC_URL = System.getenv("MYSQL_JDBC_URL");
         String JDBC_USER =System.getenv("MYSQL_JDBC_USER");
         String JDBC_PASSWORD = System.getenv("MYSQL_JDBC_PASSWORD");

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(JDBC_URL);
        dataSource.setUser(JDBC_USER);
        dataSource.setPassword(JDBC_PASSWORD);

        Flyway flyway = Flyway.configure()
                .dataSource(dataSource)
                .locations("classpath:db/migration")
                .load();

        try {
            flyway.migrate();

        }catch (Exception e){
            System.err.println("Error en la migración con flyway: "+ e.getMessage());
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
      try {
          AbandonedConnectionCleanupThread.checkedShutdown();
      }catch (Exception e){
          System.err.println("Error en shutdown:  "+ e.getMessage());
      }
    }
}
