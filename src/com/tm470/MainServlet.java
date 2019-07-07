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
      //  out.println("\t<style>body { font-family: 'Times New Roman', " +
       //         " 'Times' " +
       //         "serif ; " +
       //         "font-size: 14px; }</style>");
        out.println("<style>body { font-family: Arial, sans-serif; font-size: 14px}</style>");
        out.println(" <style type=\"text/css\">");
        out.println("<style>.table_setup  {font-weight:bold; border-collapse:collapse;border-spacing:0;}</style>");
        out.println("<style>.table_setup td{padding:6px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:black;}</style>");

        out.println("</head>");








     /*   out.println("<h1>Test header - servlet</h1>");
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
*/
        out.println("<br><br>");
        out.println("<button onclick=goBack()>Go Back</button>");
        out.println("<script>");
        out.println("function goBack() { window.history.back() }");
        out.println("</script>");

        out.println("<br><br>");
        out.println("============================================================");



      //  out.println("</body></html>");





        out.println("<h1>Savings Interest Calculator</h1>");
        out.println("<h2><b>Setup</b></h2>");
        out.println("<table class=\"table_setup\">");
        out.println("<tr>");
        out.println(" <td>Product Launch Date (format 2012-12-12):</td>");
        out.println("<td><input type=\"date\" id=\"ProductLaunchDate\" name=\"ProductLaunchDate\" required/></td>");
        out.println(" <td> Product Rate :</td>");
        out.println("<td><input type=\"number\" id=\"ProductRate\" name=\"ProductRate\" step=\".01\" required/></td>");
        out.println("<td rowspan=\"2\">Deposit Value :</td>");
        out.println("<td rowspan=\"2\"><input type=\"number\" id=\"DepositValue\" name=\"DepositValue\" step=\".01\" required/></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println(" <td>Product End Date (format 2012-12-12):</td>");
        out.println("<td><input type=\"date\" id=\"ProductEndDate\" name=\"ProductEndDate\" required/></td>");
        out.println("<td>Monthly Rate :</td>");
        out.println("<td><input type=\"number\" id=\"MonthlyRate\" name=\"MonthlyRate\" step=\".01\" required/></td>");
        out.println("</tr>");
        out.println(" </table>");
        out.println(" <br/><br/>");
      //  out.println("");
      //  out.println("");



























        out.close();
    }
}