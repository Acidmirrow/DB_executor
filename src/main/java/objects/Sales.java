package objects;

import java.lang.reflect.Field;

public class Sales {

    public String region;
    public String country;
    public String item_type;
    public String sales_chanel;
    public String order_priority;
    public String order_date;
    public String order_id;
    public String ship_date;
    public String units_sold;
    public String unit_price;
    public String unit_cost;
    public String total_revenue;
    public String total_cost;
    public String total_profit;


    public void printMe() {
        System.out.println(region + "," + country + "," + item_type + "," + sales_chanel + "," + order_priority + "," +
                order_date + "," + order_id + "," + ship_date + "," + units_sold + "," + unit_price + "," + unit_cost + "," +
                total_revenue + "," + total_cost + "," + total_profit);
    }

    public void fill(String... s) throws IllegalAccessException {
        region = s[0];
        country = s[1];
        item_type = s[2];
        sales_chanel = s[3];
        order_priority = s[4];
        order_date = s[5];
        order_id = s[6];
        ship_date = s[7];
        units_sold = s[8];
        unit_price = s[9];
        unit_cost = s[10];
        total_revenue = s[11];
        total_cost = s[12];
        total_profit = s[13];
    }



}

