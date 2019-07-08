package com.tm470;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@WebServlet(name = "MainServlet", urlPatterns = {"/processMainServlet"})


public class MainServlet extends HttpServlet {


    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();


   out.println("<html><head>");
        out.println("<title>Tab title - Test tab title</title>");
        out.println("<style>body { font-family: Arial, sans-serif; font-size: 14px}</style>");
        out.println("<style type=\"text/css\">");

        //  out.println("\t<style>body { font-family: 'Times New Roman', " +
        //         " 'Times' " +
        //         "serif ; " +
        //         "font-size: 14px; }</style>");

        /// Style for Setup table ///////////////
        //out.println("<style>body { font-family: Arial, sans-serif; font-size: 14px}</style>");
        //out.println("<style type=\"text/css\">");
        out.println("<style>.table_setup  {font-weight:bold; border-collapse:collapse;border-spacing:0;}</style>");
        out.println("<style>.table_setup td{padding:6px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:black;}</style>");

        /// Style for Calculations table ///////////////

        out.println("<style>.cal  {border-collapse:collapse;border-spacing:0;}</style>");
        out.println("<style>.cal td{font-weight:normal;padding:6px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:black;}</style>");
        out.println("<style>.cal th{font-weight:bold;padding:6px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:black;}</style>");
        out.println("<style>.cal .cal-xx12{text-align:left}</style>");
        out.println("<style>.cal .cal-zz12{text-align:right}</style>");
        out.println("<style>.cal .cal-yy12{text-align:right}</style>");

        /// Style for Summary table ///////////////
        out.println("<style>.sum  {border-collapse:collapse;border-spacing:0;}</style>");
        out.println("<style>.sum td{font-weight:normal;padding:6px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:black;}</style>");
        out.println("<style>.sum th{font-weight:bold;padding:6px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:black;}</style>");
        out.println("<style>.sum .sum-xx12{text-align:left}</style>");
        out.println("<style>.sum .sum-zz12{text-align:right}</style>");
        out.println("<style>.sum .sum-yy12{text-align:right;vertical-align:top}</style>");

    out.println("</head>");



        LocalDate productLaunchDate, productEndDate;//Setup dates
        double productRateInput, depositValue = 0.0;//setup values


        productLaunchDate = LocalDate.parse(req.getParameter("ProductLaunchDate"));//storing the productLaunchDate from index.html
        productEndDate = LocalDate.parse(req.getParameter("ProductEndDate"));//storing the productEndDate from index.html

        //Reversing ProductLaunchDate to display in dd/mm/yyyy format in Setup table
        String productLaunchDate1 = req.getParameter("ProductLaunchDate").substring(0,4);
        String productLaunchDate2 = req.getParameter("ProductLaunchDate").substring(5,7);
        String productLaunchDate3 = req.getParameter("ProductLaunchDate").substring(8);
        String productLaunchDateReversed = productLaunchDate3 + "/" + productLaunchDate2 + "/" + productLaunchDate1;

        //Reversing ProductEndDate to display in dd/mm/yyyy format in Setup table
        String productEndDate1 = req.getParameter("ProductEndDate").substring(0,4);
        String productEndDate2 = req.getParameter("ProductEndDate").substring(5,7);
        String productEndDate3 = req.getParameter("ProductEndDate").substring(8);
        String productEndDateReversed = productEndDate3 + "/" + productEndDate2 + "/" + productEndDate1;


////////////////// SETUP TABLE //////////////////////////////////////////////

        out.println("<h1>Savings Interest Calculator</h1>");
        out.println("<h2><b>Setup</b></h2>");
        out.println("<table class=\"table_setup\">");
        out.println("<tr>");
        out.println("<td>Product Launch Date (format 2012-12-12):</td>");
        out.println("<td>" + productLaunchDateReversed + "</td>");
        out.println("<td> Product Rate :</td>");
        out.println("<td>" + req.getParameter("ProductRate") + "</td>");
        out.println("<td rowspan=\"2\"> Deposit Value : " + " " + req.getParameter("DepositValue") + "</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>Product End Date (format 2012-12-12):</td>");
        out.println("<td>" + productEndDateReversed + "</td>");
        out.println("<td>Monthly Rate :</td>");
        out.println("<td><input type=\"number\" id=\"MonthlyRate\" name=\"MonthlyRate\" step=\".01\" required/></td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("<br/><br/>");


////////////////// CALCULATIONS TABLE //////////////////////////////////////////////
        out.println("<h2><b>Calculations</b></h2>");
        out.println("<table class=\"cal\">");
        out.println("<tr>");
        out.println("<th class=\"cal-xx12\">Capitalisation Dates</th>");
        out.println("<th class=\"cal-xx12\">Days</th> ");
        out.println("<th class=\"cal-xx12\">Interest</th>");
        out.println("<th class=\"cal-xx12\">Compounded Value</th>");
        out.println("<th class=\"cal-xx12\">Daily Accrual</th>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td class=\"cal-zz12\">date 1</td>");
        out.println("<td class=\"cal-zz12\">number of days 1</td>");
        out.println("<td class=\"cal-zz12\">Interest 1</td>");
        out.println("<td class=\"cal-zz12\">Compounded 1</td>");
        out.println("<td class=\"cal-zz12\">Accrual 1</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td class=\"cal-yy12\">date 2</td>");
        out.println("<td class=\"cal-yy12\">number of days 2</td>");
        out.println("<td class=\"cal-yy12\">Interest 2</td>");
        out.println("<td class=\"cal-yy12\">Compounded 2</td>");
        out.println("<td class=\"cal-yy12\">Accrual 2</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td class=\"cal-yy12\">date 3</td>");
        out.println("<td class=\"cal-yy12\">number of days 3</td>");
        out.println("<td class=\"cal-yy12\">Interest 3</td>");
        out.println("<td class=\"cal-yy12\">Compounded 3</td>");
        out.println("<td class=\"cal-yy12\">Accrual 3</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td class=\"cal-yy12\">date 4</td>");
        out.println("<td class=\"cal-yy12\">number of days 4</td>");
        out.println("<td class=\"cal-yy12\">Interest 4</td>");
        out.println("<td class=\"cal-yy12\">Compounded 4</td>");
        out.println("<td class=\"cal-yy12\">Accrual 4</td>");
        out.println("<tr>");
        out.println("</table>");
        out.println(" <br/><br/>");


////////////////// SUMMARY TABLE //////////////////////////////////////////////
        out.println("<h2><b>Summary</b></h2>");
        out.println("<table class=\"sum\">");
        out.println("<tr>");
        out.println("<th class=\"sum-xx12\">Months</th>");
        out.println("<th class=\"sum-xx12\">Total Interest</th>");
        out.println("<th class=\"sum-xx12\">Balance at Maturity</th>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td class=\"sum-zz12\">ab1</td>");
        out.println("<td class=\"sum-yy12\">ab2</td>");
        out.println("<td class=\"sum-yy12\">ab3</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("<br/><br/>");


////////////////// Back button //////////////////////////////////////////////
        out.println("<br><br>");
        out.println("<button style=\"width: 10em; height: 3em; background-color: lightblue; font-weight: ;" +
                "font: caption; color: black;\" onclick=goBack() >Go Back</button>");
        out.println("<script>");
        out.println("function goBack() { window.history.back() }");
        out.println("</script>");
        out.println("<br><br>");


        out.println("</body></html>");
        out.close();
    }


}