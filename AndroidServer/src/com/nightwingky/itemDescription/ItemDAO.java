package com.nightwingky.itemDescription;

import com.nightwingky.dao.BaseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by nightwingky on 17-1-1.
 */
public class ItemDAO extends BaseDAO {

    public ItemDescriptionVO query(String title) throws SQLException {
        Connection connection = getConnection();

        String sql = "SELECT * FROM tb_item_info WHERE itemContentTitle = ?";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, title);

        ResultSet resultSet = ps.executeQuery();
        resultSet.next();

        ItemDescriptionVO itemDescriptionVO = new ItemDescriptionVO(
                resultSet.getString("itemContentTitle"),
                resultSet.getString("itemPicURL"),
                resultSet.getString("itemDescription"),
                resultSet.getString("itemPrice")
        );

        closeConnection(connection);

        return itemDescriptionVO;
    }
}
