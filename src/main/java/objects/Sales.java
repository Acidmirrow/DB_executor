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


    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public String getSales_chanel() {
        return sales_chanel;
    }

    public void setSales_chanel(String sales_chanel) {
        this.sales_chanel = sales_chanel;
    }

    public String getOrder_priority() {
        return order_priority;
    }

    public void setOrder_priority(String order_priority) {
        this.order_priority = order_priority;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getShip_date() {
        return ship_date;
    }

    public void setShip_date(String ship_date) {
        this.ship_date = ship_date;
    }

    public String getUnits_sold() {
        return units_sold;
    }

    public void setUnits_sold(String units_sold) {
        this.units_sold = units_sold;
    }

    public String getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(String unit_price) {
        this.unit_price = unit_price;
    }

    public String getUnit_cost() {
        return unit_cost;
    }

    public void setUnit_cost(String unit_cost) {
        this.unit_cost = unit_cost;
    }

    public String getTotal_revenue() {
        return total_revenue;
    }

    public void setTotal_revenue(String total_revenue) {
        this.total_revenue = total_revenue;
    }

    public String getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(String total_cost) {
        this.total_cost = total_cost;
    }

    public String getTotal_profit() {
        return total_profit;
    }

    public void setTotal_profit(String total_profit) {
        this.total_profit = total_profit;
    }

    public void fill(String... s)  {
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

