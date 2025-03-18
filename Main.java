import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      Perpustakaan perpustakaan = new Perpustakaan();
        Scanner input = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("=== Sistem Manajemen Perpustakaan ===");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Tampilkan Daftar Buku");
            System.out.println("3. Keluar");
            System.out.print("Masukkan pilihan: ");
            pilihan = input.nextInt();
            input.nextLine(); // Mengkonsumsi karakter newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan judul buku: ");
                    String judul = input.nextLine();
                    System.out.print("Masukkan penulis buku: ");
                    String penulis = input.nextLine();
                    System.out.print("Masukkan tahun terbit: ");
                    int tahun = input.nextInt();
                    input.nextLine(); // Mengkonsumsi newline
                    Buku bukuBaru = new Buku(judul, penulis, tahun);
                    perpustakaan.tambahBuku(bukuBaru);
                    System.out.println("Buku berhasil ditambahkan!");
                    break;
                case 2:
                    System.out.println("Daftar Buku:");
                    perpustakaan.tampilkanSemuaBuku();
                    break;
                case 3:
                    System.out.println("Keluar dari program...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, silahkan coba lagi.");
            }
            System.out.println();
        } while (pilihan != 3);

        input.close();
    }
}
