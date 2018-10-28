import java.io.IOException;
import java.sql.SQLException;


public class Application {


    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException, IllegalAccessException {

        //Проект выложен на Github https://github.com/Acidmirrow/DB_executor
        //файл с большим количеством записей должен лежать в data/files
        //бд должна лежать в data/db
        //все настройки и sql Запросы вынесены в Property files
        db.db.createConnection();
        db.db.CreateDB(args[0]);
        db.db.Insert(args[0]);
        db.db.CloseDB();



    }
}
