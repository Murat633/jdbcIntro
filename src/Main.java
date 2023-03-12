import java.sql.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null;

        try {
            connection = helper.getConnection();
            String sql = "DELETE FROM name WHERE id=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,1);
            statement.execute();
            System.out.println("Kayıt Silindi");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            statement.close();
            connection.close();
        }
    }
   public static void selectData() throws SQLException {
       Connection connection = null;
       DbHelper helper = new DbHelper();
       Statement statement = null;
       ResultSet resultSet;
       try{
           connection = helper.getConnection();
           statement = connection.createStatement(); // bir sql kod satırı oluşturur
           resultSet = statement.executeQuery("select  * from city");
           ArrayList<Name> names = new ArrayList<>();
           while (resultSet.next()){
               names.add(
                       new Name(
                               resultSet.getInt("id"),
                               resultSet.getString("name"
                               ))
               );
           }
           for (Name name:names){
               System.out.println(name.getId());
           }
       }catch (Exception e){
           System.out.println(e.getMessage());
       }finally{
           connection.close();
       }
   }

   public static void updateData() throws SQLException{
       Connection connection = null;
       DbHelper helper = new DbHelper();
       PreparedStatement statement = null;
       ResultSet resultSet;
       try{
           connection = helper.getConnection();
           String sql = "UPDATE name SET name=? WHERE id=?";
           statement = connection.prepareStatement(sql);
           statement.execute();
           System.out.println("Kayıt Güncellendi");
       }catch (Exception e){
           System.out.println(e.getMessage());
       }finally{
           statement.close();
           connection.close();
       }
   }

}



