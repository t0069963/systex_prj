package prj_GUI;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.Chronology;
import java.time.chrono.MinguoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DecimalStyle;
import java.util.Locale;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import static prj_GUI.GUI_From.getConnection;

public class MainGET {

    public static void main(String[] args) {
        try {
           //LocalDate localDate = LocalDate.now();
           LocalDate localDate= LocalDate.of(2018, 1, 17); 
           DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
           String localDatenow = null;//比較時間 = 今天時間- 回圈圈數
           //String stopDate = "104.01.01";//農停止日期
           String stopDate = "1040601";//漁停止日期
            //轉民國Date字串轉西元
            Chronology chrono = MinguoChronology.INSTANCE;
            DateTimeFormatter df = new DateTimeFormatterBuilder().parseLenient()
            //農
            //.appendPattern("yyy.MM.dd").toFormatter().withChronology(chrono)
            //漁        
            .appendPattern("yyyMMdd").toFormatter().withChronology(chrono)
            .withDecimalStyle(DecimalStyle.of(Locale.getDefault()));
            
             
             while (!stopDate.equals(localDatenow)){
                localDate = localDate.minusDays(1);
                localDatenow =localDate.format(df);
                System.out.println("目前日期: "+localDatenow);
                //農
                //URL url = new URL("https://data.coa.gov.tw/api/v1/AgriProductsTransType/?Start_time="+localDatenow+"&End_time="+localDatenow+"");
                URL url = new URL("https://data.coa.gov.tw/api/v1/FisheryProductsTransType/?Start_time="+localDatenow+"&End_time="+localDatenow+"");
            System.out.println(url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //取得responsecode
            int responsecode = conn.getResponseCode();
            //沒有傳則報responsecode
            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {

                String inline = "";
                Scanner scanner = new Scanner(url.openStream());

                //寫成JSON
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }

             
                scanner.close();

                //使用JSON simple庫將字符串解析為 json 對象
                JSONParser parse = new JSONParser();
                JSONObject data_obj = (JSONObject) parse.parse(inline);
                
                System.out.println(data_obj.get("Data").getClass().getSimpleName());
                System.out.println(data_obj.getClass().getSimpleName());
                System.out.println(data_obj.get("Data"));
                JSONArray a = (JSONArray) data_obj.get("Data");
                //System.out.println(responsecode);
                //傳JSON行數
                System.out.println(a.size());
                if (a.size()==0){
                    continue;
                }
        
                //預設
                String TransDate = "104.01.01";
                String CropCode = "";
                String CropName = "";
                int MarketCode= 0;
                String MarketName = "";
                double Avg_Price = 0.0;
                double Trans_Quantity = 0.0;
                
                
                JSONObject c=(JSONObject) a.get(0);
               String compareDate = (String)c.get("TransDate");
                //System.out.println(a.get(0));
                
                
                for (int i = 0; i < a.size(); i++) {
              
                    System.out.println(i);
                    JSONObject b   =(JSONObject) a.get(i);
               


//                    TransDate=(String) b.get("TransDate");
//                    CropCode=(String) b.get("CropCode");
//                    CropName=(String) b.get("CropName");
//                    System.out.println(CropName);
//                    MarketCode=Integer.parseInt ((String) b.get("MarketCode"));
//                    MarketName = (String) b.get("MarketName");
//                    Avg_Price=Double.valueOf(b.get("Avg_Price").toString());
//                    Trans_Quantity=Double.parseDouble(b.get("Trans_Quantity").toString());

//漁
                    TransDate=(String) b.get("TransDate");
                    CropCode=(String) b.get("SeafoodProdCode");
                    CropName=(String) b.get("SeafoodProdName");
                    System.out.println(CropName);
                    //MarketCode=Integer.parseInt ((String) b.get("MarketCode"));
                    MarketName = (String) b.get("MarketName");
                    Avg_Price=Double.valueOf(b.get("Avg_Price").toString());
                    Trans_Quantity=Double.parseDouble(b.get("Trans_Quantity").toString());




               
                    ChronoLocalDate d1 = chrono.date(df.parse(TransDate));

                    LocalDate ld1 = LocalDate.from(d1);
                   
                    //LocalDate轉字串
                    TransDate= ld1.format(fmt);
                    System.out.println(TransDate);
                    Connection con = getConnection();
                    //PreparedStatement posted = con.prepareStatement("INSERT INTO `agriproductstranstype` (`TransDate`, `CropCode`, `CropName`, `MarketCode`, `MarketName`, `Avg_Price`, `Trans_Quantity`) VALUES ('"+TransDate+"', '"+CropCode+"', '"+CropName+"', '"+MarketCode+"', '"+MarketName+"', '"+Avg_Price+"', '"+Trans_Quantity+"')");
                    PreparedStatement posted = con.prepareStatement("INSERT INTO `fisheryproductstranstype` (`TransDate`, `CropCode`, `CropName`, `MarketName`, `Avg_Price`, `Trans_Quantity`) VALUES ('"+TransDate+"', '"+CropCode+"', '"+CropName+"', '"+MarketName+"', '"+Avg_Price+"', '"+Trans_Quantity+"')");
                    posted.executeUpdate();
                        //JSONObject jsonData = (JSONObject)data_obj.get("data").toString();
                        //System.out.println(jsonData);
                }
                
               
            }
             }
      
           
          

            
            
        } catch(Exception e){System.out.println(e);}
        finally {
            System.out.println("加入完成");
        }
    }
}