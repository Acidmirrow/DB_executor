package db;


import objects.Sales;

import java.sql.SQLException;
import java.util.ArrayList;


public class dbManager {

    public void openDB() throws SQLException, ClassNotFoundException {

        saleDAO.OpenConnection();
    }

    public void closeDB() throws SQLException, ClassNotFoundException {

        saleDAO.CloseConnection();
    }

    public ArrayList<Sales> selectDB(String sql) throws SQLException {

        return saleDAO.selectDAO(sql);
    }


}
