package com.nightwingky.shoppingcartListView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by nightwingky on 17-1-1.
 */
@WebServlet("/SCAddServlet")
public class SCAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("itemTitle");

        SCLvDAO scLvDAO = new SCLvDAO();

        SCLvVO scLvVO =  scLvDAO.queryByTitle(title);

        if(scLvVO == null) {
            scLvDAO.insert(scLvDAO.queryInfo(title));
        } else {
            scLvDAO.updateAmount(title);
        }
    }
}
