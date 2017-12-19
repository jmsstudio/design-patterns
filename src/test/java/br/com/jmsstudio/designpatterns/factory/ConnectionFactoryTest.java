package br.com.jmsstudio.designpatterns.factory;

import org.junit.Test;

import java.sql.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ConnectionFactoryTest {

    @Test
    public void makeDbConnectionTest() throws SQLException {
        Connection connection = ConnectionFactory.getConnection();

        assertNotNull(connection);

        Statement statement = null;

        Integer expectedId = 1;
        String expectedValue = "test";

        Integer foundId = null;
        String foundValue = null;

        try {
            statement = connection.createStatement();
            statement.executeUpdate("create table table1 (id integer not null, VALUE VARCHAR not null)");

            PreparedStatement preparedStatement1 = connection.prepareStatement("insert into table1 values(?, ?)");
            preparedStatement1.setInt(1, expectedId);
            preparedStatement1.setString(2, expectedValue);
            preparedStatement1.executeUpdate();


            PreparedStatement preparedStatement = connection.prepareStatement("select * from table1");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                foundId = resultSet.getInt(1);
                foundValue = resultSet.getString(2);
            }
        } finally {
            connection.close();
        }

        assertNotNull(foundId);
        assertNotNull(foundValue);
        assertEquals(expectedId, foundId);
        assertEquals(expectedValue, foundValue);
    }
}
