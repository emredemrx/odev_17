package example;

public class Personel {
    private int id;
    private String personelAdi;
    private String personelSoyadi;
    private String department;

    @Override
    public String toString() {
        return "Personel{" +
                "id=" + id +
                ", personelAdi='" + personelAdi + '\'' +
                ", personelSoyadi='" + personelSoyadi + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
