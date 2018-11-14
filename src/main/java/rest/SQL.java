package rest;

import objects.Sales;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("/SQL")
public class SQL {

    Manager manager = new Manager();

    private String form = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "<base href=\"http://127.0.0.1:8081/SQL/\" target=\"_self\" />\n" +
            "<meta http-equiv=\"Content-Type\"content=\"text/html; charset=UTF-8\">\n" +
            "</head>\n" +
            "<body>\n" +
            "<form action=\"response\" method=\"POST\">\n" +
            "<table width=\"300\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"1\">\n" +
            "   <tr>\n" +
            "      <td>\n" +
            "         <form name=\"form1\" method=\"post\" action=\"insert_ac.php\">\n" +
            "         <table width=\"100%\" border=\"0\" cellspacing=\"1\" cellpadding=\"3\">\n" +
            "            <tr>\n" +
            "               <td colspan=\"3\">Запрос в базу </td>\n" +
            "            </tr>\n" +
            "            <tr>\n" +
            "               <td width=\"71\">SQL-скрипт</td>\n" +
            "               <td width=\"6\">:</td>\n" +
            "               <td width=\"301\"><input type=\"text\" name=\"sql\" size=\"40\" autofocus>\n" +
            "            </tr>\n" +
            "            <tr>\n" +
            "               <td colspan=\"3\" align=\"center\"><input type=\"submit\" name=\"Отправить\" value=\"Отправить\"></td>\n" +
            "            </tr>\n" +
            "         </table>\n" +
            "</form>"+
            "</body>\n" +
            "</html>";

    //http://127.0.0.1:8081/SQL/request
    @GET
    @Path("request")
    @Produces(MediaType.TEXT_HTML)
    public String rqSQL() {

        return form;
    }

    //http://127.0.0.1:8081/SQL/response
    @POST
    @Path("response")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Sales> rsSQL(@FormParam("sql") String sql) throws SQLException, ClassNotFoundException {

        return manager.rqManager(sql);
    }

}

