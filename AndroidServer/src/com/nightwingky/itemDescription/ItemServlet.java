package com.nightwingky.itemDescription;

import com.nightwingky.json.JsonConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by nightwingky on 17-1-1.
 */
@WebServlet("/ItemServlet")
public class ItemServlet extends HttpServlet {

    public ItemServlet() {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("itemTitle");

        ItemDAO itemDAO = new ItemDAO();
        try {
            ItemDescriptionVO item = itemDAO.query(title);
            String jsonString = JsonConverter.convert(item);

            response.getWriter().append(jsonString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
