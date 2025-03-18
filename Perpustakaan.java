import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Perpustakaan {
    private List<Buku> daftarBuku = new ArrayList<>();
    private final String namaFile = "dataBuku.txt";

    // Konstruktor: saat objek Perpustakaan dibuat, data buku yang tersimpan akan langsung dimuat dari file.
    public Perpustakaan() {
        loadData();
    }

    // Menambahkan buku baru ke daftar dan menyimpannya ke file
    public void tambahBuku(Buku buku) {
        daftarBuku.add(buku);
        simpanDataBuku(buku);
    }

    // Method untuk menyimpan data buku ke file (mode append)
    public void simpanDataBuku(Buku buku) {
        try (FileWriter fw = new FileWriter(namaFile, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {

            // Format penyimpanan: judul;penulis;tahunTerbit
            out.println(buku.getJudul() + ";" + buku.getPenulis() + ";" + buku.getTahunterbit());
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan data: " + e.getMessage());
        }
    }

    // Method untuk memuat data buku yang tersimpan dari file saat program dijalankan kembali
    public void loadData() {
        File file = new File(namaFile);
        if (!file.exists()) {
            // File belum ada, sehingga tidak ada data yang perlu dimuat
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Memisahkan data buku berdasarkan delimiter ";"
                String[] data = line.split(";");
                if (data.length == 3) {
                    String judul = data[0];
                    String penulis = data[1];
                    int tahunTerbit = Integer.parseInt(data[2]);
                    Buku buku = new Buku(judul, penulis, tahunTerbit);
                    daftarBuku.add(buku);
                }
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca data: " + e.getMessage());
        }
    }

    // Method untuk menampilkan seluruh data buku yang telah tersimpan
    public void tampilkanSemuaBuku() {
        if (daftarBuku.isEmpty()) {
            System.out.println("Tidak ada data buku yang tersimpan.");
        } else {
            for (Buku buku : daftarBuku) {
                // Menampilkan data buku secara manual
                System.out.println("Judul: " + buku.getJudul() + ", Penulis: " + buku.getPenulis() + ", Tahun Terbit: " + buku.getTahunterbit());
            }
        }
    }
}