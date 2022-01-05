/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package prj_GUI;

import org.json.simple.JSONArray;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Vector;
import javax.swing.*;
import org.json.simple.JSONObject;

/**
 *
 * @author bgete
 */
public class GUI_From extends javax.swing.JFrame {
 JFrame f;
 
 
    /**
     * Creates new form GUI_From
     */
    public GUI_From() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CropNameTextField = new javax.swing.JTextField();
        CropNameLabel = new javax.swing.JLabel();
        MarketNameTextField = new javax.swing.JTextField();
        MarketNameLabel = new javax.swing.JLabel();
        CategoryLabel = new javax.swing.JLabel();
        startDateLabel = new javax.swing.JLabel();
        startDateTextField = new javax.swing.JTextField();
        endDateLabel = new javax.swing.JLabel();
        endDateTextField = new javax.swing.JTextField();
        SELECT = new javax.swing.JButton();
        CategoryComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        monthTextField = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));

        CropNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CropNameTextFieldActionPerformed(evt);
            }
        });

        CropNameLabel.setText("CropName (產品名稱) ");

        MarketNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MarketNameTextFieldActionPerformed(evt);
            }
        });

        MarketNameLabel.setText("MarketName (市場名稱)");

        CategoryLabel.setText("Category (農、漁) ");

        startDateLabel.setText("Start Date");

        startDateTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startDateTextFieldActionPerformed(evt);
            }
        });

        endDateLabel.setText("End Date");

        endDateTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endDateTextFieldActionPerformed(evt);
            }
        });

        SELECT.setText("搜尋");
        SELECT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SELECTActionPerformed(evt);
            }
        });

        CategoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "農業", "漁業"}));
        CategoryComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoryComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ex:  2022-01-04 日期輸入單一格即可查詢單日 兩個都輸入則是查詢範圍");

        monthTextField.setText("開啟月份查詢");
        monthTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CropNameLabel)
                            .addComponent(CategoryLabel)
                            .addComponent(MarketNameLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(startDateLabel)
                                .addGap(18, 18, 18)
                                .addComponent(startDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CropNameTextField)
                            .addComponent(MarketNameTextField)
                            .addComponent(CategoryComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(endDateLabel)
                                .addGap(18, 18, 18)
                                .addComponent(endDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 34, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(monthTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(SELECT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CropNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CropNameLabel))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MarketNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MarketNameLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CategoryLabel)
                    .addComponent(CategoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startDateLabel)
                    .addComponent(endDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endDateLabel)
                    .addComponent(startDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(monthTextField)
                .addGap(18, 18, 18)
                .addComponent(SELECT)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SELECTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SELECTActionPerformed

     // ;        
        try {

            // TODO add your handling code here:
            get();
        } catch (Exception ex) {
            Logger.getLogger(GUI_From.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_SELECTActionPerformed

    private void CropNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CropNameTextFieldActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_CropNameTextFieldActionPerformed

    private void MarketNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MarketNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MarketNameTextFieldActionPerformed

    private void startDateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startDateTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startDateTextFieldActionPerformed

    private void endDateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endDateTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_endDateTextFieldActionPerformed

    private void CategoryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoryComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CategoryComboBoxActionPerformed

    private void monthTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monthTextFieldActionPerformed

    
public String[] gettext(){
String[] array = new String[7];
array[0] = CropNameTextField.getText();
array[1] = MarketNameTextField.getText();
array[2] = (String)CategoryComboBox.getSelectedItem();;
array[3] = startDateTextField.getText();
array[4] = endDateTextField.getText();
array[5] = String.valueOf(monthTextField.isSelected()) ;
return array;

}
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
            java.util.logging.Logger.getLogger(GUI_From.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_From.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_From.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_From.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_From().setVisible(true);
            }
        });
    }
       public void setCropNameTextField(String name) {
         CropNameTextField.setText(name);
    }

  
    public void setMarketNameTextField(String value) { 
        MarketNameTextField.setText(value); 
    }


  
    public void setStartDateTextField(String startDate) {
        startDateTextField.setText(startDate);
    }

    public void setEndDateTextField(String endDate) {
        endDateTextField.setText(endDate);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CategoryComboBox;
    private javax.swing.JLabel CategoryLabel;
    private javax.swing.JLabel CropNameLabel;
    private javax.swing.JTextField CropNameTextField;
    private javax.swing.JLabel MarketNameLabel;
    private javax.swing.JTextField MarketNameTextField;
    private javax.swing.JButton SELECT;
    private javax.swing.JLabel endDateLabel;
    private javax.swing.JTextField endDateTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToggleButton monthTextField;
    private javax.swing.JLabel startDateLabel;
    private javax.swing.JTextField startDateTextField;
    // End of variables declaration//GEN-END:variables
public  HashSet<String> get() throws Exception{
  
        try{
            String[] text = gettext();
            //System.out.println(text[0]);//產品名稱
            //System.out.println(text[1]);//市場名稱
            //System.out.println(text[2]);//農或漁
            //System.out.println(text[3]);//開始時間
            //System.out.println(text[4]);//結束時間
            //System.out.println(text[5]);//是否按下按鈕

            PreparedStatement statement = null;
            Connection con = getConnection();
            if (text[2] == "農業"){
                System.out.println(text[2]);
                
                
                if ( text[3].length()!= 0 && text[4].length()!= 0 && text[0].length()!= 0 && text[1].length()!= 0 && text[5].equals("false") ){
                System.out.println("第一題");
                statement = con.prepareStatement("SELECT TransDate,CropName,MarketName,AVG(Trans_Quantity),max(Trans_Quantity),min(Trans_Quantity) FROM `agriproductstranstype` where MarketName = '"+text[1]+"' and CropName = '"+text[0]+"' and TransDate >='"+text[3]+"' and TransDate <='"+text[4]+"'");
                    System.out.println("ssss");
                //輸入起始時間跟結束時間，顯示這段時間農產品中的"椰子"在"台北二"這個市場中的平均交易量、最大交易量、最低交易量。
                //SELECT TransDate,CropName,MarketName,AVG(Trans_Quantity),max(Trans_Quantity),min(Trans_Quantity) FROM `agriproductstranstype2` where MarketName = "台北二" and CropName = "椰子" and TransDate >='104.01.01' and TransDate <='107.04.12' ;
                }
                ////農第二題
                
                else if( (text[3].length()!=0) ^ (text[4].length()!=0) && text[5].equals("false") ){
                    System.out.println("農第二題");
                    if ((text[3].length() - text[4].length())>0){
                        statement = con.prepareStatement("SELECT TransDate,sum(Trans_Quantity*Avg_Price) From `agriproductstranstype` where TransDate = '"+text[3]+"';");
                    }
                    else if((text[4].length() - text[3].length())>=0){
                        statement = con.prepareStatement("SELECT TransDate,sum(Trans_Quantity*Avg_Price) From `agriproductstranstype` where TransDate = '"+text[4]+"';");
                    }
                }
                ///第四題
                else if((text[3].length()!=0) ^ (text[4].length()!=0) && text[5].equals("true")){
                  String textdata;
                    if ((text[3].length() - text[4].length())>0){
                      textdata = text[3];
                  }else{
                      textdata = text[4];
                    }
                    
                Date StartDate = new SimpleDateFormat("yyyy-MM").parse(textdata);
                SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
                SimpleDateFormat getmonDateFormat = new SimpleDateFormat("MM");
                String currentYear = getYearFormat.format(StartDate);
                String currentMon = getmonDateFormat.format(StartDate);
                //Date EndDate = new SimpleDateFormat("yyyy-MM").parse(text[4]);
                 statement = con.prepareStatement("SELECT CropName, sum(Trans_Quantity) AS total_Quantity FROM  `agriproductstranstype` where month(TransDate)='"+currentMon+"'and year(TransDate)='"+currentYear+"' GROUP BY CropName ORDER BY total_Quantity DESC Limit 10;");
                
                
                }
               
   
             
             
             }
         
             if (text[2]=="漁業"){
                System.out.println(text[2]);
                //漁第二題
                if(text[3].length()!= 0 && text[4].length()!= 0 && text[0].length()!= 0 && text[1].length()!= 0 && text[5].equals("false")){
                    System.out.println("漁第二題");
                    if ((text[3].length() - text[4].length())>0){
                        statement = con.prepareStatement("SELECT TransDate,sum(Trans_Quantity*Avg_Price) From `fisheryproductstranstype` where TransDate = '"+text[3]+"';");
                    }
                    else if((text[4].length() - text[3].length())>=0){
                        statement = con.prepareStatement("SELECT TransDate,sum(Trans_Quantity*Avg_Price) From `fisheryproductstranstype` where TransDate = '"+text[4]+"';");
                    }
                }   
            }
            
             
             
             
             
             
             
             
             
     
     //以下為資料處理相關       
            ResultSet result = statement.executeQuery();
            
            HashSet<String> columns = new HashSet<String>();
            ResultSetMetaData rsmd =result.getMetaData();
            int count = rsmd.getColumnCount();
            for (int x = 1; x <= count; x++) {
	    	columns.add(rsmd.getColumnName(x));
	    }
           int arrayCount=0;
           JSONArray jsonArray = new JSONArray();
           int n= 0;
           while(result.next()){
               n=n+1;
                arrayCount  = result.getMetaData().getColumnCount();
                System.out.println(arrayCount);
                JSONObject obj = new JSONObject();
               for (int j = 0; j < arrayCount; j++) {
                    obj.put(result.getMetaData().getColumnLabel(j + 1), result.getObject(j + 1));
                    System.out.println(obj); 
               }
               jsonArray.add(obj);
              //  System.out.println(jsonArray.getClass().getSimpleName() );
               //System.out.println(jsonArray);
             
                
                //array.add(result.getString("Trans_Quantity"));
            }
            System.out.println("n"+n);
         String[] setColumns = columns.toArray(new String[0]);
            System.out.println(columns);
    // Step 1: 設定每一個資料的項目
       String [] headings= setColumns;
   // Step 2: 指定要顯示在表格中的資料
     Object[][] data = new String[n][headings.length];
    String [] totalArray= new String[headings.length];
    JSONObject arrayhigh = (JSONObject) jsonArray.get(0);
    System.out.println(arrayCount);
            
    for (int j = 0; j < n; j++) {
        JSONObject jsb   =(JSONObject)jsonArray.get(j);
            for (int k = 0; k < headings.length; k++) {
                //System.out.println(jsb.get(headings[k]));              
                data[j][k]=String.valueOf(jsb.get(headings[k]));
            }
            
        } 
     
   // Step 3: 建立 Table
       javax.swing.JTable table=new javax.swing.JTable(data,headings);
       // 建立一個 Frame 秀出表格
       javax.swing.JFrame MyFrame=new javax.swing.JFrame("農漁表格");
       MyFrame.setSize(500,200);
       MyFrame.setLocation(200,200);
       MyFrame.getContentPane().add(new javax.swing.JScrollPane(table));
       MyFrame.setVisible(true);
            //return array;
        }catch(Exception e){System.out.println(e);}
        return null;
        
        
    }
	//創表格
	public static void creatTable()throws Exception{
		try {
                       
			Connection con = getConnection();
			//如果表格不存在則創一個
			PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS agriproductstranstype(id int NOT NULL AUTO_INCREMENT, "
					+ "TransDate date,"
					+ "CropCode varchar(10),"
					+ "CropName varchar(20),"
					+ "MarketCode int(3),"
					+ "MarketName varchar(10),"
					+ "Avg_Price DOUBLE,"
					+ "Trans_Quantity DOUBLE,"
					+ "PRIMARY KEY(id));");
			create.executeUpdate();
                       PreparedStatement create2 = con.prepareStatement("CREATE TABLE IF NOT EXISTS fisheryproductstranstype(id int NOT NULL AUTO_INCREMENT, "
					+ "TransDate date,"
					+ "CropCode varchar(10),"
					+ "CropName varchar(20),"
					+ "MarketCode int(3),"
					+ "MarketName varchar(10),"
					+ "Avg_Price DOUBLE,"
					+ "Trans_Quantity DOUBLE,"
					+ "PRIMARY KEY(id));");
			create2.executeUpdate();
                        
			
			
		}catch(Exception e){
			System.out.println(e);
		}
		finally{
			System.out.println("表格已完成");
			};
	}
	
	
	
	
	public static Connection getConnection() throws Exception{
		try {
			String driver = "com.mysql.cj.jdbc.Driver";//驅動
			String url = "jdbc:mysql://localhost:3305/bgete";//路徑
			String username = "root";
			String password = "z1x2c3";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("連線成功");
			return conn;
		}catch(Exception e){
			System.out.println(e);
		}
		
		
		
		return null;
		
	}

 

   

   
        
}

