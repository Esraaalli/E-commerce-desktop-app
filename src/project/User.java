/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abdelrahman Yasser
 */
public class User extends Account{
    private int id, ssn;
    private String address;
    private CreditCard card;
    private static User instance = null;

    private User() {
    }
    
    @Override
    public void add_product(Product product) {
        try {
            // TODO add product to cart.
            DBHelper dBHelper = DBHelper.getInstance();
            
            dBHelper.setQuery("insert into cart (product_id, product_amount, product_name, product_price, user_id)"+ " values (?, ?, ?, ?, ?)");
            PreparedStatement preparedStmt = dBHelper.getPreparedStmt();
            preparedStmt = dBHelper.getMyconnection().prepareStatement(dBHelper.getQuery());
            preparedStmt.setInt(1, product.getId());
            preparedStmt.setInt(2, product.getAmount());
            preparedStmt.setString(3, product.getName());
            if(product.getPrice() == product.getPrice_after_sale())
                preparedStmt.setFloat(4, product.getPrice());
            else
                preparedStmt.setFloat(4, product.getPrice_after_sale());
            preparedStmt.setInt(5, this.id);
            
            preparedStmt.execute();
            
//            dBHelper.closeConnection(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
    }
    
    public static User getInstance(){
        if(instance == null)
            instance = new User();
        return instance;
    }
    
    public void cancel_product(int product_id, int user_id){
    try {
            // TODO delete category.
            DBHelper dBHelper = DBHelper.getInstance();

            dBHelper.setQuery("delete from cart where product_id = '" + product_id + "' and user_id = '"+ user_id + "'");
            PreparedStatement preparedStmt = dBHelper.getPreparedStmt();
            preparedStmt = dBHelper.getMyconnection().prepareStatement(dBHelper.getQuery());
            preparedStmt.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CreditCard getCard() {
        return card;
    }

    public void setCard(CreditCard card) {
        this.card = card;
    }
    
    public void setCardType(){
        this.card.setType();
    }
  
    public void setCardNumber(int card_number){
        this.card.setCard_number(card_number);
    }
}
