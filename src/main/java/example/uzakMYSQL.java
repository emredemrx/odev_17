//https://console.aiven.io/account/a4cc43506458/project/femredemir699-c416/services/mysql-659d5db/query-statistics uzak sunucu sitesi
package example;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.statement.StatementException;

public class uzakMYSQL {
    static String url = "jdbc:mysql://mysql-659d5db-femredemir699-c416.d.aivencloud.com:19782/defaultdb";
    static String kullaniciAdi = "avnadmin";
    static String sifre = "AVNS_LuDIQhtTbr_9Juw5zh-";

    public static void main(String[] args) {
        Jdbi jdbi = Jdbi.create(url, kullaniciAdi, sifre);
        try(Handle sorgu = jdbi.open()){
            sorgu.execute("CREATE TABLE IF NOT EXISTS personel (id INT PRIMARY KEY AUTO_INCREMENT, personel_adi VARCHAR(50),personel_soyadi VARCHAR(50),department VARCHAR(50))");
            sorgu.execute("INSERT INTO personel (personel_adi, personel_soyadi, department) VALUES (?,?,?)","ahmet","demir","ik");
            sorgu.execute("DELETE FROM personel WHERE id = ?",4);
            sorgu.createQuery("SELECT * FROM personel").mapToBean(Personel.class).forEach(personel -> System.out.println(personel));
        }
        catch (StatementException e){
            e.printStackTrace();
        }
    }
}
