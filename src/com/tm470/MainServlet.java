package com.tm470;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

@WebServlet(name = "MainServlet", urlPatterns = {"/processMainServlet"})


public class MainServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");

        Date ProductLaunchDate = Date.valueOf(req.getParameter("ProductLaunchDate"));
        Date ProductEndDate = Date.valueOf(req.getParameter("ProductEndDate"));
        Double ProductRate = Double.valueOf(req.getParameter("ProductRate"));

        PrintWriter out = res.getWriter();
        out.println("<html><head>");
        out.println("<title>Tab title - Test tab title</title>");
        out.println("\t<style>body { font-family: 'Times New Roman', " +
                " 'Times' " +
                "serif ; " +
                "font-size: 14px; }</style>");
        out.println("</head>");
        out.println("<h1>Test header - servlet</h1>");
        out.println("<body>");

        String doctype = "<!DOCTYPE html>\n";

        out.println("<fieldset>");
        out.println("<legend>Section header 1:</legend>");
        out.println(doctype +
                "<html>\n" +
                "<head><title></title></head>\n" +
                "<ul>\n" +
                "<li><b>ProductLaunchDate</b>: " + ProductLaunchDate + "\n" +
                "<li><b>ProductEndDate</b>: " + ProductEndDate + "\n" +
                "<li><b>ProductRate</b>: " + ProductRate + "\n" +
                "</ul>\n" +
                "</body>" +
                "</html>"
        );
        out.println("</fieldset>");


        out.println("<fieldset>");
        out.println("<legend>Section header 2:</legend>");
        Double calc = (13.00 - ProductRate)/45;
        out.println("<p>Some calculation: ProductRate + (13-ProductRate)+45 =  " + calc + "</p>");
        out.println("</fieldset>");

        out.println("<br><br>");
        out.println("<button onclick=goBack()>Go Back</button>");
        out.println("<script>");
        out.println("function goBack() { window.history.back() }");
        out.println("</script>");
        out.println("</body></html>");
        out.close();
    }
}