package database;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        creatTable();
        post();
        get();
        
 
    }
    public static ArrayList<String> get() throws Exception{
        try{
            Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement("SELECT * FROM agriproductstranstype ORDER BY id DESC LIMIT 10");
            
            ResultSet result = statement.executeQuery();
            
            ArrayList<String> array = new ArrayList<String>();
            while(result.next()){
                System.out.print(result.getString("CropName"));
                System.out.print(" ");
                System.out.println(result.getString("Trans_Quantity"));
                
                array.add(result.getString("Trans_Quantity"));
            }
            System.out.println("所有記錄已被選中！");
            return array;
        }catch(Exception e){System.out.println(e);}
        return null;
        
    }
    
    
    
    public static void post() throws Exception{
         var TransDate = "104.01.01";
         var CropCode = "";
         var CropName = "";
         var MarketCode= 0;
         var MarketName ="";
         var Avg_Price = 0;
         var Trans_Quantity = 0;
         
         
         
         
         
         
        try{
            Connection con = getConnection();
            PreparedStatement posted = con.prepareStatement("INSERT INTO `agriproductstranstype` (`TransDate`, `CropCode`, `CropName`, `MarketCode`, `MarketName`, `Avg_Price`, `Trans_Quantity`) VALUES ('"+TransDate+"', '"+CropCode+"', '"+CropName+"', '"+MarketCode+"', '"+MarketName+"', '"+Avg_Price+"', '"+Trans_Quantity+"')");
            
            posted.executeUpdate();
        } catch(Exception e){System.out.println(e);}
        finally {
            System.out.println("加入完成");
        }
    }
 
	//創表格
	public static void creatTable()throws Exception{
		try {
			Connection con = getConnection();
			//如果表格不存在則創一個
			PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS agriproductstranstype(id int NOT NULL AUTO_INCREMENT, "
					+ "TransDate date,"
					+ "CropCode varchar(10),"
					+ "CropName varchar(5),"
					+ "MarketCode int(3),"
					+ "MarketName varchar(10),"
					+ "Avg_Price DOUBLE,"
					+ "Trans_Quantity DOUBLE,"
					+ "PRIMARY KEY(id));");
			create.executeUpdate();
			
			
		}catch(Exception e){
			System.out.println(e);
		}
		finally{
			System.out.println("表格已完成");
			};
	}
	
	
	
	
	public static Connection getConnection() throws Exception{
		try {
			String driver = "com.mysql.jdbc.Driver";//驅動
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
