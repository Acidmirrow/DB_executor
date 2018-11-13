package rest;

import db.dbManager;
import objects.Sales;


import java.sql.SQLException;
import java.util.ArrayList;

public class Manager {

    db.dbManager dbManager = new dbManager();

    public ArrayList<Sales> rqManager(String sql) throws SQLException, ClassNotFoundException {

        ArrayList<Sales> rs;

        try {

            dbManager.openDB();
            rs = dbManager.selectDB(sql);

        } finally {

            dbManager.closeDB();
        }

        return rs;
    }
}
