package com.flipkart.utils;

import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * The type Db utils.
 */
public class DBUtils {

    private static Connection connection = null;
    private final static Logger logger = Logger.getLogger(DBUtils.class);

    /**
     * Gets connection.
     *
     * @return the connection
     */
    public static Connection getConnection() {

        if (connection != null)
            return connection;
        else {
            try {
                Properties prop = new Properties();
                InputStream inputStream = DBUtils.class.getClassLoader().getResourceAsStream("config.properties");
                prop.load(inputStream);
                String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                String user = prop.getProperty("user");
                String password = prop.getProperty("password");
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return connection;
        }
    }

    /**
     * Close connection.
     */
    public static void closeConnection() {
        logger.info("Closing Connection!!");
        try {
            if(connection != null) {
                connection.close();
            }
            else {
                logger.info("Connection already closed!");
            }
        }catch (SQLException e) {
            logger.error(e.getMessage());
        }

    }

}
