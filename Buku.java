public class Buku {
    private String judul;
    private String penulis;
    private int tahunTerbit;

    // Constructor untuk menginisialisasi atribut buku
    public Buku(String judul, String penulis, int tahunTerbit) {
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
    }

    // Getter untuk mendapatkan nilai atribut judul
    public String getJudul() {
        return judul;
    }

    // Getter untuk mendapatkan nilai atribut penulis
    public String getPenulis() {
        return penulis;
    }

    // Getter untuk mendapatkan nilai atribut tahun terbit
    public int getTahunterbit() {
        return tahunTerbit;
    }
    
    // Method tampilkanInfo() tanpa parameter: hanya menampilkan judul
    public void tampilkanInfo() {
        System.out.println("Judul: " + this.judul);
    }
    
    // Overloaded method tampilkanInfo(boolean detail):
    // Jika detail true, tampilkan informasi lengkap; jika false, tampilkan hanya judul
    public void tampilkanInfo(boolean detail) {
        if (detail) {
            System.out.println("Judul: " + this.judul);
            System.out.println("Penulis: " + this.penulis);
            System.out.println("Tahun Terbit: " + this.tahunTerbit);
        } else {
            tampilkanInfo();
        }
    }
}