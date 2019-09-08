package com.tm470;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

@WebServlet(name = "MainServlet", urlPatterns = {"/processMainServlet"})


public class MainServlet extends HttpServlet {


    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();


        out.println("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
        out.println("<!DOCTYPE html>");
   out.println("<html><head>");
        out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />");
        out.println("<title>SIC Result</title>");
        out.println("<style>body { font-family: Arial, sans-serif; font-size: 14px}</style>");
        out.println("<style type=\"text/css\">");

        /// Style for Calculations table ///////////////
        out.println("<style>.cal  {border-collapse:collapse;border-spacing:0;}</style>");
        out.println("<style>.cal td{padding:6px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:black;}</style>");//font-weight:normal;
        out.println("<style>.cal th{font-weight:bold;padding:6px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:black;}</style>");
        out.println("<style>.cal .cal-xx12{text-align:left}</style>");
        out.println("<style>.cal .cal-zz12{text-align:right}</style>");
        out.println("<style>.cal .cal-yy12{text-align:right}</style>");

        /// Style for Summary table ///////////////
        out.println("<style>.sum td{font-weight:normal;padding:6px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:black;}</style>");
        out.println("<style>.sum th{font-weight:bold;padding:6px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:black;}</style>");
        out.println("<style>.sum .sum-xx12{text-align:left}</style>");
        out.println("<style>.sum .sum-zz12{text-align:right}</style>");
        out.println("<style>.sum .sum-yy12{text-align:right;vertical-align:top}</style>");

    out.println("</head>");

    out.println("<body>");

        out.println("<a href=\"help.html\" target=\"_blank\">Help</a>");
        out.println("<a href=\"documentation.html\" target=\"_blank\">Documentation</a>");
        out.println("<a href=\"about.html\" target=\"_blank\">About</a>");

        LocalDate productLaunchDate, productEndDate;//Setup dates
        double productRate= 0.0, depositValue = 0.0,  monthlyRate;//setup values
        depositValue = Double.parseDouble(req.getParameter("DepositValue"));

        LocalDate date1, date2, date3, date4;// to store Capitalisation Dates from 'Calculations' table in index.html

        long period1, period2, period3, period4;

        long periodIsLeap = 0;//to calculate if there is an additional day in a leap year

        productLaunchDate = LocalDate.parse(req.getParameter("ProductLaunchDate"));//storing the productLaunchDate from index.html
        productEndDate = LocalDate.parse(req.getParameter("ProductEndDate"));//storing the productEndDate from index.html
        productRate = Double.parseDouble(req.getParameter("ProductRate"));//parsing String to double
        date1 = LocalDate.parse(req.getParameter("date1"));//Capitalisation date1 from 'Calculations' table in index.html
        date2 = LocalDate.parse(req.getParameter("date2"));//Capitalisation date2 from 'Calculations' table in index.html
        date3 = LocalDate.parse(req.getParameter("date3"));//Capitalisation date3 from 'Calculations' table in index.html
        date4 = LocalDate.parse(req.getParameter("date4"));//Capitalisation date4 from 'Calculations' table in index.html



        //compares the days difference between the date stored in productLaunchDate
        //and the date stored in date1 +1 as required for the 1st year of savings
        period1 = (ChronoUnit.DAYS.between(productLaunchDate, date1))+1;

        //compares the days difference between the date stored in date1
        //and the date stored in date2
        period2 = ChronoUnit.DAYS.between(date1, date2);

        //compares the days difference between the date stored in date2
        //and the date stored in date3
        period3 = ChronoUnit.DAYS.between(date2, date3);

        //compares the days difference between the date stored in date3
        //and the date stored in date4
        period4 = ChronoUnit.DAYS.between(date3, date4);

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

        //Reversing date1 to display in dd/mm/yyyy format in Calculations table
        String date1a = req.getParameter("date1").substring(0,4);
        String date1b = req.getParameter("date1").substring(5,7);
        String date1c = req.getParameter("date1").substring(8);
        String date1Reversed = date1c + "/" + date1b + "/" + date1a;

        //Reversing date2 to display in dd/mm/yyyy format in Calculations table
        String date2a = req.getParameter("date2").substring(0,4);
        String date2b = req.getParameter("date2").substring(5,7);
        String date2c = req.getParameter("date2").substring(8);
        String date2Reversed = date2c + "/" + date2b + "/" + date2a;

        //Reversing date3 to display in dd/mm/yyyy format in Calculations table
        String date3a = req.getParameter("date3").substring(0,4);
        String date3b = req.getParameter("date3").substring(5,7);
        String date3c = req.getParameter("date3").substring(8);
        String date3Reversed = date3c + "/" + date3b + "/" + date3a;

        //Reversing date4 to display in dd/mm/yyyy format in Calculations table
        String date4a = req.getParameter("date4").substring(0,4);
        String date4b = req.getParameter("date4").substring(5,7);
        String date4c = req.getParameter("date4").substring(8);
        String date4Reversed = date4c + "/" + date4b + "/" + date4a;



////////////////// SETUP TABLE //////////////////////////////////////////////

        //calculate nominal value of the productRate
        monthlyRate = 1200 * (Math.pow((1+((productRate/100))),0.083333333)-1) ;
        //rounds the monthlyRate to two decimal places
        monthlyRate = Math.round(monthlyRate * 100);
        monthlyRate = monthlyRate/100;


        out.println("<h1>Savings Interest Calculator</h1>");
        out.println("<h2><b>Setup</b></h2>");
        out.println("<table class=\"cal\">");
        out.println("<tr>");
        out.println("<th class=\"cal-xx12\">Product Launch Date :</th>");
        out.println("<td class=\"cal-xx12\">" + productLaunchDateReversed + "</th> ");
        out.println("<th class=\"cal-xx12\">Product Rate :</th>");
        out.println("<td class=\"cal-xx12\">" + req.getParameter("ProductRate") + "</th>");
        out.println("<th rowspan=\"2\" class=\"cal-xx12\"> Deposit Value : " + " " + depositValue + "</th>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<th class=\"cal-xx12\">Product End Date :</td>");
        out.println("<td class=\"cal-zz12\">" + productEndDateReversed + "</td>");
        out.println("<th class=\"cal-zz12\">Monthly Rate :</td>");
        out.println("<td class=\"cal-zz12\">" + monthlyRate + "</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("<br/><br/>");

        //Daily Accrual calculation for the 1st year, where leap year is taken into account
        //..if the productLaunchDate OR date1' fall on a leap year
        if(productLaunchDate.isLeapYear() || date1.isLeapYear())  {

            if(productLaunchDate.isLeapYear()){
                //create a local variable with date 29/02/'Product Launch Year'..
                LocalDate feb29Launch = LocalDate.of(productLaunchDate.getYear(), Month.FEBRUARY, 29);

                if(((productLaunchDate.isBefore(feb29Launch)) || (productLaunchDate.isEqual(feb29Launch))) &&
                        (date1.isAfter(feb29Launch))) {

                    periodIsLeap = 366;
                } else {
                    periodIsLeap = 365;
                }

            } else if(date1.isLeapYear()) {
                //create a local variable with date 29/02/'date1'..
                LocalDate feb29Cap = LocalDate.of(date1.getYear(), Month.FEBRUARY, 29);

                if(((date1.isAfter(feb29Cap)) || (date1.isEqual(feb29Cap))) &&
                        (productLaunchDate.isBefore(feb29Cap))) {

                    periodIsLeap = 366;
                } else {
                    periodIsLeap = 365;
                }
            }

        } else {
            periodIsLeap = 365;
        }


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
        out.println("<td class=\"cal-zz12\">" + date1Reversed + "</td>");
        out.println("<td class=\"cal-zz12\">" + period1 + "</td>");
        out.println("<td class=\"cal-zz12\">Interest 1</td>");
        out.println("<td class=\"cal-zz12\">Compounded 1</td>");
        out.println("<td class=\"cal-zz12\">Accrual 1</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td class=\"cal-yy12\">" + date2Reversed + "</td>");
        out.println("<td class=\"cal-yy12\">" + period2 +"</td>");
        out.println("<td class=\"cal-yy12\">Interest 2</td>");
        out.println("<td class=\"cal-yy12\">Compounded 2</td>");
        out.println("<td class=\"cal-yy12\">Accrual 2</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td class=\"cal-yy12\">" + date3Reversed + "</td>");
        out.println("<td class=\"cal-yy12\">" + period3 + "</td>");
        out.println("<td class=\"cal-yy12\">Interest 3</td>");
        out.println("<td class=\"cal-yy12\">Compounded 3</td>");
        out.println("<td class=\"cal-yy12\">Accrual 3</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td class=\"cal-yy12\">" + date4Reversed + "</td>");
        out.println("<td class=\"cal-yy12\">"+ period4 +"</td>");
        out.println("<td class=\"cal-yy12\">Interest 4</td>");
        out.println("<td class=\"cal-yy12\">Compounded 4</td>");
        out.println("<td class=\"cal-yy12\">Accrual 4</td>");
        out.println("<tr>");
        out.println("</table>");
        out.println("<br/>");


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
        out.println("<br/>");


////////////////// Back button //////////////////////////////////////////////
        out.println("<button style=\"width: 10em; height: 3em; background-color: lightblue; font-weight: ;" +
                "font: caption; color: black;\" onclick=goBack() >Go Back</button>");
        out.println("<script>");
        out.println("function goBack() { " +
                "window.history.back() " +
                "}");
        out.println("</script>");
        out.println("<br><br>");

        out.println("</body></html>");
        out.close();
    }


}