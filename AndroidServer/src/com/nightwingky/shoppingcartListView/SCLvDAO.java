package com.nightwingky.shoppingcartListView;

import com.nightwingky.dao.BaseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nightwingky on 16-12-31.
 */
public class SCLvDAO  extends BaseDAO{

    public List<SCLvVO> quertAll() {

        Connection conn = getConnection();

        List<SCLvVO> ls = new ArrayList<SCLvVO>();
        SCLvVO scLvVO = null;

        try {
            String sql = "SELECT * FROM tb_shoppingcart_info";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery(sql);
            while (resultSet.next()) {
                scLvVO = new SCLvVO(
                        resultSet.getString("commodityImageURL"),
                        resultSet.getString("commodityTitle"),
                        resultSet.getString("commodityPrice"),
                        resultSet.getString("commodityAmount")
                        );
                ls.add(scLvVO);
            }

            return ls;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(conn);
        }

        return null;
    }

//    public static void main(String[] args) {
//        SCLvDAO scLvDAO = new SCLvDAO();
//        List<SCLvVO> lvVOs = scLvDAO.quertAll();
//
//        JSONArray json = JSONArray.fromObject(lvVOs);
//
//        System.out.println(json);
//    }
}
