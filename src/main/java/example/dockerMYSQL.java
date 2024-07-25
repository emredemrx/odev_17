package example;

import java.sql.*;

public class dockerMYSQL {
    static String url = "jdbc:mysql://localhost:3306/emredb";
    static String kullaniciAdi = "root";
    static String sifre = "admin";

    static Connection connection = null;
    static PreparedStatement preparedStatement = null;
    static ResultSet resultSet = null;

    public static void main(String[] args) {
        String personel_adi = "veli";
        String personel_soyadi = "çelik";
        String personel_departman = "İT";

        int silinecekID = 6;

        tabloOlusturma();
        veriEkleme (personel_adi,personel_soyadi,personel_departman);
        tabloGetir();
        veriSil(silinecekID);

    }

    public static void tabloOlusturma() {
        try {
            connection = DriverManager.getConnection(url, kullaniciAdi, sifre);
            String sql = "CREATE TABLE IF NOT EXISTS personel (" +
                    "id INT NOT NULL AUTO_INCREMENT, " +
                    "personel_adi VARCHAR(50) NOT NULL, " +
                    "personel_soyadi VARCHAR(50) NOT NULL, " +
                    "department VARCHAR(50), " +
                    "PRIMARY KEY (id))";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        }catch (SQLException e) {

            System.out.println("Bağlantı hatası: " + e.getMessage());
        }
    }
    public static void veriEkleme (String isim, String soyisim, String departman){
        try {
            connection = DriverManager.getConnection(url, kullaniciAdi, sifre);
            String insertSQL = "INSERT INTO personel (personel_adi, personel_soyadi, department) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, isim);
            preparedStatement.setString(2, soyisim);
            preparedStatement.setString(3, departman);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            System.out.println("Bağlantı hatası: " + e.getMessage());
        }
    }
    public static void tabloGetir(){
        try {
            connection = DriverManager.getConnection(url, kullaniciAdi, sifre);
            String selectSQL = "SELECT * FROM personel";
            preparedStatement = connection.prepareStatement(selectSQL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String isim = resultSet.getString("personel_adi");
                String soyadi = resultSet.getString("personel_soyadi");
                System.out.println(id + ", " + isim + " " + soyadi);

            }
        } catch (SQLException e) {

            System.out.println("Bağlantı hatası: " + e.getMessage());
        }
    }
    public static void veriSil(int deger){
        try {
            connection = DriverManager.getConnection(url, kullaniciAdi, sifre);
            String deleteSQL = "DELETE FROM personel WHERE id = ?";
            preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1,deger);
            int basari = preparedStatement.executeUpdate();

            if (basari > 0) {
                System.out.println("Kayıt başarıyla silindi!");
            } else {
                System.out.println("Silinecek kayıt bulunamadı.");
            }
        } catch (SQLException e) {

            System.out.println("Bağlantı hatası: " + e.getMessage());
        }
    }
}