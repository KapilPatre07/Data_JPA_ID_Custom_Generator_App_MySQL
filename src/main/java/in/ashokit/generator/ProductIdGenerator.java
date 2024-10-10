package in.ashokit.generator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class ProductIdGenerator implements IdentifierGenerator {

    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) {
        String prefix = "PRODUCT";
        String suffix = "";

        try (Connection con = session.getJdbcConnectionAccess().obtainConnection()) 
        {
            // Create a table for maintaining the sequence
            String insertSQL = "INSERT INTO product_id_seq (PRODUCT_ID) VALUES (NULL)";
            
            try (PreparedStatement psInsert = con.prepareStatement(insertSQL)) 
            {
                psInsert.executeUpdate(); // Use executeUpdate() for INSERT statements
            }

            // Retrieve the latest sequence value
            String selectSQL = "SELECT LAST_INSERT_ID()"; // Assuming you are using MySQL
            
            try (PreparedStatement psSelect = con.prepareStatement(selectSQL);
                 ResultSet rs = psSelect.executeQuery()) 
            {
                if (rs.next()) 
                {
                    long sequenceVal = rs.getLong(1);
                    suffix = String.valueOf(sequenceVal);
                }
            }
        }
        catch (SQLException e) 
        {
            throw new HibernateException("Error generating product ID", e);
        }

        return prefix + suffix;
    }
}
