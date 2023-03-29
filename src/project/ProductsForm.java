/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package project;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Pc
 */
public class ProductsForm extends javax.swing.JFrame {

    String selectedItem;
    public ArrayList<Product> products;
    int index;

    /**
     * Creates new form CategoryForm
     */
    public ProductsForm() throws MalformedURLException {
        initComponents();
        
        Admin admin = new Admin();
        admin.add_sale();
        
        
        String[] categoryList = getCategories();
        int selectedCategoryID = getCategoryID(selectedItem);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(categoryList));
        
        Product p = new Product();
        products = p.get_products();
        Object[][] products_array = new Object[products.size()][3];
        for (int i = 0; i < products.size(); i++) {
            products_array[i][0] = products.get(i).getName();
            products_array[i][1] = products.get(i).getPrice();
            products_array[i][2] = products.get(i).getPrice_after_sale();
        }
        ProductsTable.setModel(new javax.swing.table.DefaultTableModel(
                products_array,
                 new String[]{
                    "Name", "Price", "Price after sale"
                }
        ));
//        
//        URL url = new URL("https://ps.w.org/woo-free-product-sample/assets/icon-256x256.png?rev=2279441");
//        BufferedImage image = ImageIO.read(url);
//        jLabel1.setIcon(new ImageIcon(image));
    }

    public int getCategoryID(String name) {
        int id = 0;
        try {
            // TODO add product to cart.
            DBHelper dBHelper = DBHelper.getInstance();

            dBHelper.setQuery("select id from designpattern.category where (name)=(?)");
            PreparedStatement preparedStmt = dBHelper.getPreparedStmt();

            preparedStmt = dBHelper.getMyconnection().prepareStatement(dBHelper.getQuery());
            preparedStmt.setString(1, name);
            ResultSet rs = preparedStmt.executeQuery();
            //Category c;
            if (rs.next()) {
                //c=new Category(rs.getInt(1),rs.getString(2));
                id = rs.getInt(1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return id;
    }

    public String[] getCategories() {
        String[] list = new String[20];
        int i = 0;
        try {
            // TODO add product to cart.
            DBHelper dBHelper = DBHelper.getInstance();

            dBHelper.setQuery("select * from designpattern.category");
            PreparedStatement preparedStmt = dBHelper.getPreparedStmt();

            preparedStmt = dBHelper.getMyconnection().prepareStatement(dBHelper.getQuery());
            ResultSet rs = preparedStmt.executeQuery();
            //Category c;
            while (rs.next()) {
                //c=new Category(rs.getInt(1),rs.getString(2));
                list[i] = rs.getString(1);
                i++;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProductsTable = new javax.swing.JTable();
        image2 = new javax.swing.JLabel();
        image1 = new javax.swing.JLabel();
        product_amount = new javax.swing.JTextField();
        btn_addtocart = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        feedback_table = new javax.swing.JTable();
        feedback = new javax.swing.JTextField();
        btn_feedback = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        headerPanel.setBackground(new java.awt.Color(0, 153, 204));

        jLabel3.setFont(new java.awt.Font("Sitka Text", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/icon/icons8-shopping-cart-24.png"))); // NOI18N
        jLabel3.setText("Online Shopping System");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/icon/icons8-person-40.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Choose Category:");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/icon/icons8-shopping-cart-24.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/icon/icons8-in-transit-24.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap())
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                        .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        ProductsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Name", "Price", "Price after sale"
            }
        ));
        ProductsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ProductsTable);

        product_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                product_amountActionPerformed(evt);
            }
        });

        btn_addtocart.setText("Add to cart");
        btn_addtocart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addtocartActionPerformed(evt);
            }
        });

        feedback_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "User Id", "Feedback"
            }
        ));
        jScrollPane2.setViewportView(feedback_table);

        btn_feedback.setText("Add feedback");
        btn_feedback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_feedbackMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(image1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(image2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(product_amount)
                    .addComponent(btn_addtocart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(feedback)
                    .addComponent(btn_feedback, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(image1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(image2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(product_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_addtocart, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(feedback, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_feedback, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 34, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        selectedItem = String.valueOf(jComboBox1.getSelectedItem());
//        System.out.println("You seleted: " + selectedItem);
        Product p = new Product();
        products = p.get_products(Integer.parseInt(selectedItem));
        Object[][] products_array = new Object[products.size()][3];
        for (int i = 0; i < products.size(); i++) {
            products_array[i][0] = products.get(i).getName();
            products_array[i][1] = products.get(i).getPrice();
            products_array[i][2] = products.get(i).getPrice_after_sale();
        }
        ProductsTable.setModel(new javax.swing.table.DefaultTableModel(
                products_array,
                 new String[]{
                    "Name", "Price", "Price after sale"
                }
        ));
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        EditUserInfo UI = new EditUserInfo();
        UI.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void ProductsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductsTableMouseClicked
        // TODO add your handling code here:
        //        
//        URL url = new URL("https://ps.w.org/woo-free-product-sample/assets/icon-256x256.png?rev=2279441");
//        BufferedImage image = ImageIO.read(url);
//        jLabel1.setIcon(new ImageIcon(image));
        index = ProductsTable.getSelectedRow();
        try {
            URL url1 = new URL(products.get(index).getImage1());
            URL url2 = new URL(products.get(index).getImage2());
            BufferedImage image1 = ImageIO.read(url1);
            BufferedImage image2 = ImageIO.read(url2);
            this.image1.setIcon(new ImageIcon(image1));
            this.image2.setIcon(new ImageIcon(image2));
        } catch (MalformedURLException ex) {
            Logger.getLogger(ProductsForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProductsForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        Product p = new Product();
        ArrayList<Feedback> feedback = p.get_feedbacks(products.get(index).getId());
        Object[][] feedback_array = new Object[feedback.size()][3];
        for (int i = 0; i < feedback.size(); i++) {
            feedback_array[i][0] = feedback.get(i).getUser_id();
            feedback_array[i][1] = feedback.get(i).getText();
        }
        feedback_table.setModel(new javax.swing.table.DefaultTableModel(
                feedback_array,
                 new String[]{
                    "User Id", "Feedback"
                }
        ));
          
    }//GEN-LAST:event_ProductsTableMouseClicked

    private void btn_addtocartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addtocartActionPerformed
        // TODO add your handling code here:
        products.get(index).setAmount(Integer.parseInt(product_amount.getText().toString()));
        ProxyUser proxyUser = new ProxyUser();
        proxyUser.add_product(products.get(index));
    }//GEN-LAST:event_btn_addtocartActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        
        CartForm cartForm = new CartForm();
        cartForm.setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void product_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_product_amountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_product_amountActionPerformed

    private void btn_feedbackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_feedbackMouseClicked
        // TODO add your handling code here:
        Product product = new Product();
        User user=User.getInstance();
        Feedback feedback = new Feedback(user.getId(), products.get(index).getId(), this.feedback.getText().toString());
        product.add_feedback(feedback);
    }//GEN-LAST:event_btn_feedbackMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        ShowUserOrderForm form = new ShowUserOrderForm();
        form.setVisible(true);
    }//GEN-LAST:event_jLabel5MouseClicked

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProductsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ProductsForm().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(ProductsForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ProductsTable;
    private javax.swing.JButton btn_addtocart;
    private javax.swing.JButton btn_feedback;
    private javax.swing.JTextField feedback;
    private javax.swing.JTable feedback_table;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel image1;
    private javax.swing.JLabel image2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField product_amount;
    // End of variables declaration//GEN-END:variables

}
