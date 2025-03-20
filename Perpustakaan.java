import java.io.*;

public class Perpustakaan {
    private static final String FILE_NAME = "dataBuku.txt";

    public void tambahBuku(Buku buku) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(buku.formatBuku());
            writer.newLine();
            System.out.println("Buku berhasil ditambahkan!");
        } catch (IOException e) {
            System.out.println("Gagal menyimpan buku: " + e.getMessage());
        }
    }

    public void tampilkanDaftarBuku() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            boolean adaBuku = false;
            System.out.println("\nDaftar Buku:");
            
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                Buku buku = Buku.fromString(line);
                if (buku != null) {
                    System.out.println("Judul: " + buku.getJudul() +
                                       ", Penulis: " + buku.getPenulis() +
                                       ", Tahun Terbit: " + buku.getTahunTerbit());
                    adaBuku = true;
                }
            }
            
            if (!adaBuku) {
                System.out.println("Tidak ada buku yang tersimpan.");
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca buku: " + e.getMessage());
        }
    }
}
