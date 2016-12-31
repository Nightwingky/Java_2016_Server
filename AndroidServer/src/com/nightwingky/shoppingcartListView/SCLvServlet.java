package com.nightwingky.shoppingcartListView;

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
@WebServlet("/SCLvServlet")
public class SCLvServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SCLvDAO homeLvDAO = new SCLvDAO();

        List<SCLvVO> mList = homeLvDAO.quertAll();

        String json = JsonConverter.convert(mList);
        response.getWriter().append(json);
    }
}
