package db;

import objects.Sales;
import utils.PropertyReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.*;

public class db {

    public static String FileName = "data/files/500000 Sales Records.csv";
    public static Connection conn; // объявляем переменную типа Connection, для установления соединения к БД
    public static Statement statmt; // объявляем переменную типа Statement , для возможности выполнения SQL-запросов


    // --------Открытие соединения к БД--------
    public static void createConnection() throws ClassNotFoundException, SQLException {
        conn = null;
        // указываем драйвер для подключения к БД
        Class.forName("org.sqlite.JDBC");
        // строка соединения у укзанием параметров подключения
        conn = DriverManager.getConnection("jdbc:sqlite:data/db/TEST1.s3db");
        System.out.println("База Подключена!");
    }


    // --------Создание таблицы--------
    public static void CreateTable(String nameOfFileProperty) throws SQLException, IOException {
        statmt = conn.createStatement();
        String sql = "CREATE TABLE if not exists '" + new PropertyReader().getObjectFromProperty("db.tablename", nameOfFileProperty)+"' " +
                ""+new PropertyReader().getObjectFromProperty("sql.createtable", nameOfFileProperty)+"";
        System.out.println(sql);
        statmt.execute(sql);
        System.out.println("Таблица создана или уже существует.");
    }

    //---------Удаление таблицы------
    public static void DropTable () {

    }

    // --------Заполнение таблицы--------
    public static void Insert(String nameOfFileProperty) throws IOException, SQLException {
        //подготовка стринги с sql из файла property
      String sql = "INSERT INTO '" + new PropertyReader().getObjectFromProperty("db.tablename", nameOfFileProperty)+"'" +
              ""+ new PropertyReader().getObjectFromProperty("sql.insertintotable", nameOfFileProperty)+"";
        System.out.println(sql);
        PreparedStatement stmt = conn.prepareStatement(sql);
        //try-with-resources при чтении файла
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(FileName))) {

        //фиксация времени
        long t1 = System.nanoTime();

        String line;
        long l = 0;
        while ((line = br.readLine()) != null) {

            if (l++ == 0)
                continue;

            String[] parts = line.split(",");

            Sales sale = new Sales();
            sale.fill(parts);

            stmt.setString(1, sale.region);
            stmt.setString(2, sale.country);
            stmt.setString(3, sale.item_type);
            stmt.setString(4, sale.sales_chanel);
            stmt.setString(5, sale.order_priority);
            stmt.setString(6, sale.order_date);
            stmt.setString(7, sale.order_id);
            stmt.setString(8, sale.ship_date);
            stmt.setString(9, sale.units_sold);
            stmt.setString(10, sale.unit_price);
            stmt.setString(11, sale.unit_cost);
            stmt.setString(12, sale.total_revenue);
            stmt.setString(13, sale.total_cost);
            stmt.setString(14, sale.total_profit);
            // Запрос не выполняется, а укладывается в буфер,
            //  который потом выполняется сразу для всех команд
            if (l % 100_000 == 0) {

                long t2 = System.nanoTime();
                System.out.println("" + l + " time= " + (t2 - t1) / 1000_000);
            }
        }
            conn.setAutoCommit(false);
            stmt.executeBatch();
            conn.commit();

            }

        }




    // --------Закрытие соединения к БД--------
    public static void CloseDB () throws SQLException
    {
        conn.close();
        //statmt.close();

        System.out.println("Соединения закрыты");
    }
}
