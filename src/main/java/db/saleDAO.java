package db;

import objects.Sales;

import java.sql.*;
import java.util.ArrayList;

public class saleDAO {

    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;

    // --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
    public static void OpenConnection() throws ClassNotFoundException, SQLException
    {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:DataBase/TEST1.s3db");

        System.out.println("База Подключена!");
    }

    // --------ЗАКРЫТИЕ ПОДКЛЮЧЕНИЯ К БАЗЕ ДАННЫХ--------
    public static void CloseConnection() throws ClassNotFoundException, SQLException
    {
        if(conn != null)
            conn.close();

        if(conn != null)
            statmt.close();

        if(resSet!= null)
            resSet.close();

        System.out.println("Соединения закрыты");
    }

    //-------ЗАПРОС К БАЗЕ ДАННЫЗ----------
    public static ArrayList<Sales> selectDAO(String sql) throws SQLException {

        System.err.println(sql);

        ArrayList<Sales> rs = new ArrayList<>();

        statmt = conn.createStatement();
        resSet = statmt.executeQuery(sql);

        String[] colum =  new String[resSet.getMetaData().getColumnCount()];
        for (int i = 1; i <= resSet.getMetaData().getColumnCount(); i++) {
            colum[i-1] = resSet.getMetaData().getColumnName(i);
            System.err.println(colum[i-1]);
        }

        while (resSet.next()) {

            Sales sale = new Sales();

            for (int i = 0; i < resSet.getMetaData().getColumnCount(); i++) {

                if (colum[i].equals("Region")) {
                    sale.setRegion(resSet.getString("Region"));
                    continue;
                } else {

                    if (colum[i].equals("Country")) {
                        sale.setCountry(resSet.getString("Country"));
                        continue;
                    } else {

                        if (colum[i].equals("Item_Type")) {
                            sale.setItem_type(resSet.getString("Item_Type"));
                            continue;
                        } else {

                            if (colum[i].equals("Sales_Channel")) {
                                sale.setSales_chanel(resSet.getString("Sales_Channel"));
                                continue;
                            } else {

                                if (colum[i].equals("Order_Priority")) {
                                    sale.setOrder_priority(resSet.getString("Order_Priority"));
                                    continue;
                                } else {

                                    if (colum[i].equals("Order_Date")) {
                                        sale.setOrder_date(resSet.getString("Order_Date"));
                                        continue;
                                    } else {

                                        if (colum[i].equals("Order_ID")) {
                                            sale.setOrder_id(resSet.getString("Order_ID"));
                                            continue;
                                        } else {

                                            if (colum[i].equals("Ship_Date")) {
                                                sale.setShip_date(resSet.getString("Ship_Date"));
                                                continue;
                                            } else {

                                                if (colum[i].equals("Units_Sold")) {
                                                    sale.setUnits_sold(resSet.getString("Units_Sold"));
                                                    continue;
                                                } else {

                                                    if (colum[i].equals("Unit_Price")) {
                                                        sale.setUnit_price(resSet.getString("Unit_Price"));
                                                        continue;
                                                    } else {

                                                        if (colum[i].equals("Unit_Cost")) {
                                                            sale.setUnit_cost(resSet.getString("Unit_Cost"));
                                                            continue;
                                                        } else {

                                                            if (colum[i].equals("Total_Revenue")) {
                                                                sale.setTotal_revenue(resSet.getString("Total_Revenue"));
                                                                continue;
                                                            } else {

                                                                if (colum[i].equals("Total_Cost")) {
                                                                    sale.setTotal_cost(resSet.getString("Total_Cost"));
                                                                    continue;
                                                                } else {

                                                                    if (colum[i].equals("Total_Profit")) {
                                                                        sale.setTotal_profit(resSet.getString("Total_Profit"));
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            rs.add(sale);
        }

        return rs;
    }
}
