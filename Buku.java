public class Buku {
    private String judul;
    private String penulis;
    private int tahunTerbit;

    public Buku(String judul, String penulis, int tahunTerbit) {
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    // Method untuk mengonversi objek Buku ke format string yang bisa disimpan ke file
    public String formatBuku() {
        return judul + "," + penulis + "," + tahunTerbit;
    }

    public static Buku fromString(String data) {
        String[] parts = data.split(",");
        if (parts.length == 3) {  // Pastikan ada 3 elemen (judul, penulis, tahun)
            try {
                return new Buku(parts[0].trim(), parts[1].trim(), Integer.parseInt(parts[2].trim()));
            } catch (NumberFormatException e) {
                System.out.println("Gagal membaca data buku: " + data);
            }
        }
        return null; // Jika format salah, kembalikan null
    }
}
