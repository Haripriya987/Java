package com.example.servletconfig;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class Drives extends HttpServlet {
    Connection con = null;
    @Override
    public void init(ServletConfig sc) throws ServletException {
        try {
            String url = sc.getInitParameter("url");
            String username = sc.getInitParameter("username");
            String password = sc.getInitParameter("password");
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,username,password);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PrintWriter write = resp.getWriter();
            write.println("<h1>Welcome</h1>");
            Statement stmt = con.createStatement();
            String query  = "select * from drive";
            ResultSet res = stmt.executeQuery(query);
            write.println("<table border=\"1\">\n" +
                    "    <tr>\n" +
                    "        <th>id</th>\n" +
                    "        <th>Name</th>\n" +
                    "        <th>10th</th>\n" +
                    "        <th>12th</th>\n" +
                    "        <th>grad</th>\n" +
                    "        <th>Profile</th>\n" +
                    "        <th>package</th>\n" +
                    "        <th>Skills</th>\n" +
                    "    </tr>");

            while(res.next()) {
                write.println("    <tr>\n" +
                        "        <td>"+res.getInt(1)+"</td>\n" +
                        "        <td>"+res.getString(2)+"</td>\n" +
                        "        <td>"+res.getInt(3)+"</td>\n" +
                        "        <td>"+res.getInt(4)+"</td>\n" +
                        "        <td>"+res.getInt(5)+"</td>\n" +
                        "        <td>"+res.getString(6)+"</td>\n" +
                        "        <td>"+res.getFloat(7)+"</td>\n" +
                        "        <td>"+res.getString(8)+"</td>\n" +
                        "    </tr>");
            }

            write.println("</table>");
            req.getRequestDispatcher("/eligible").include(req,resp);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
