package example;

public class Personel {
    private int id;
    private String personelAdi;
    private String personelSoyadi;
    private String department;

    // Getter ve Setter metodları
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPersonelAdi() {
        return personelAdi;
    }

    public void setPersonelAdi(String personelAdi) {
        this.personelAdi = personelAdi;
    }

    public String getPersonelSoyadi() {
        return personelSoyadi;
    }

    public void setPersonelSoyadi(String personelSoyadi) {
        this.personelSoyadi = personelSoyadi;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

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
