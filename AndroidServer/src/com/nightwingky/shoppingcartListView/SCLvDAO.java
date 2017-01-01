package com.nightwingky.shoppingcartListView;

import com.nightwingky.dao.BaseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nightwingky on 16-12-31.
 */
public class SCLvDAO  extends BaseDAO{

    public List<SCLvVO> queryAll() {

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

    public SCLvVO queryByTitle(String title) {
        Connection connection = getConnection();

        try {
            String sql = "SELECT * FROM tb_shoppingcart_info WHERE commodityTitle = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, title);
            ResultSet resultSet = ps.executeQuery();

            if(resultSet.next() != false) {
                SCLvVO scLvVO = new SCLvVO(
                        resultSet.getString("commodityImageURL"),
                        resultSet.getString("commodityTitle"),
                        resultSet.getString("commodityPrice"),
                        resultSet.getString("commodityAmount")
                );

                return scLvVO;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }

        return null;
    }

    public SCLvVO queryInfo(String title) {
        Connection connection = getConnection();

        try {
            String sql = "SELECT * FROM tb_course_info WHERE contentTitle = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, title);
            ResultSet resultSet = ps.executeQuery();

            if(resultSet.next() != false) {
                SCLvVO scLvVO = new SCLvVO(
                        resultSet.getString("contentImageURL"),
                        resultSet.getString("contentTitle"),
                        resultSet.getString("contentPrice"),
                        String.valueOf(1)
                );

                return scLvVO;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }

        return null;
    }

    public boolean insert(SCLvVO scLvVO) {
        Connection connection = getConnection();

        String sql = "INSERT INTO tb_shoppingcart_info(commodityImageURL, commodityTitle, commodityPrice, commodityAmount)" +
                "VALUES (?, ?, ?, 1)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, scLvVO.getCommodityImageURL());
            ps.setString(2, scLvVO.getCommodityTitle());
            ps.setString(3, scLvVO.getCommodityPrice());

            int count = ps.executeUpdate();

            if(count > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }

        return false;
    }

    public void updateAmount(String title) {
        Connection connection = getConnection();

        String sql = "UPDATE tb_shoppingcart_info " +
                "SET commodityAmount = commodityAmount + 1 WHERE commodityTitle = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, title);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }
//    public static void main(String[] args) {
//        SCLvDAO scLvDAO = new SCLvDAO();
//        List<SCLvVO> lvVOs = scLvDAO.queryAll();
//
//        JSONArray json = JSONArray.fromObject(lvVOs);
//
//        System.out.println(json);
//    }
}
