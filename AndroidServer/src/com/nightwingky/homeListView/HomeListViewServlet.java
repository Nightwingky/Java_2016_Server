package com.nightwingky.homeListView;

import com.nightwingky.json.JsonConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by nightwingky on 16-12-31.
 */
@WebServlet("/HomeListViewServlet")
public class HomeListViewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HomeLvDAO homeLvDAO = new HomeLvDAO();

        List<HomeLvVO> mList = homeLvDAO.quertAll();

        String json = JsonConverter.convert(mList);
        response.getWriter().append(json);
    }
}
