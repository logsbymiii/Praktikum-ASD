package Jobsheet_11_LinkedList.Tugas;

import java.util.Scanner;

public class TugasMain11 {

    static Scanner sc = new Scanner(System.in);
    static TugasLinkedList11 antrian = new TugasLinkedList11();

    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println("  SISTEM ANTRIAN LAYANAN UNIT KEMAHASISWAAN ");
        System.out.println("============================================");

        int pilihan;
        do {
            tampilMenu();
            System.out.print("Pilih menu : ");
            pilihan = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (pilihan) {
                case 1:
                    daftarAntrian();
                    break;
                case 2:
                    antrian.dequeue();
                    break;
                case 3:
                    antrian.tampilAntrian();
                    break;
                case 4:
                    antrian.peekFront();
                    break;
                case 5:
                    antrian.peekRear();
                    break;
                case 6:
                    antrian.jumlahAntrian();
                    break;
                case 7:
                    cekStatus();
                    break;
                case 8:
                    antrian.clearQueue();
                    break;
                case 0:
                    System.out.println("Terima kasih. Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
            System.out.println();
        } while (pilihan != 0);

        sc.close();
    }

    static void tampilMenu() {
        System.out.println("--------------------------------------------");
        System.out.println("  MENU ANTRIAN");
        System.out.println("--------------------------------------------");
        System.out.println("  1. Daftar Antrian ");
        System.out.println("  2. Panggil Antrian ");
        System.out.println("  3. Tampilkan Semua Antrian");
        System.out.println("  4. Lihat Antrian Terdepan");
        System.out.println("  5. Lihat Antrian Paling Akhir");
        System.out.println("  6. Jumlah Mahasiswa Mengantre");
        System.out.println("  7. Cek Status Antrian (Kosong/Penuh)");
        System.out.println("  8. Kosongkan Antrian");
        System.out.println("  0. Keluar");
        System.out.println("--------------------------------------------");
    }

    static void daftarAntrian() {
        if (antrian.isFull()) {
            System.out.println("Antrian penuh! Tidak dapat mendaftar saat ini.");
            return;
        }
        System.out.println("=== Pendaftaran Antrian ===");
        System.out.print("Masukkan NIM       : ");
        String nim = sc.nextLine();
        System.out.print("Masukkan Nama      : ");
        String nama = sc.nextLine();
        System.out.print("Masukkan Keperluan : ");
        String keperluan = sc.nextLine();

        TugasMahasiswa11 mhs = new TugasMahasiswa11(nim, nama, keperluan);
        antrian.enqueue(mhs);
    }

    static void cekStatus() {
        System.out.println("Status antrian:");
        if (antrian.isEmpty()) {
            System.out.println("  >> Antrian KOSONG");
        } else if (antrian.isFull()) {
            System.out.println("  >> Antrian PENUH");
        } else {
            System.out.println("  >> Antrian TERSEDIA (tidak kosong, tidak penuh)");
        }
    }
}