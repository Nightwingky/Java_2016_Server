package com.nightwingky.homeListView;

import com.nightwingky.dao.BaseDAO;
import net.sf.json.JSONArray;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nightwingky on 16-12-31.
 */
public class HomeLvDAO extends BaseDAO {
    public List<HomeLvVO> quertAll() {

        Connection conn = getConnection();

        List<HomeLvVO> ls = new ArrayList<HomeLvVO>();
        HomeLvVO homeLvVO = null;

        try {
            String sql = "SELECT * FROM tb_course_info";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery(sql);
            while (resultSet.next()) {
                homeLvVO = new HomeLvVO(
                        resultSet.getString("contentImageURL"),
                        resultSet.getString("contentTitle"),
                        resultSet.getString("contentPrice"));
                ls.add(homeLvVO);
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
//        HomeLvDAO homeLvDAO = new HomeLvDAO();
//        List<HomeLvVO> lvVOs = homeLvDAO.quertAll();
//
//        JSONArray json = JSONArray.fromObject(lvVOs);
//
//        System.out.println(json);
//    }
}
