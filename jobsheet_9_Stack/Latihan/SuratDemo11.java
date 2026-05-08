import java.util.Scanner;

public class SuratDemo11 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StackSurat11 stackSurat = new StackSurat11(10); 
        int pilih;

        do {
            System.out.println("\n=== Manajemen Surat Izin ===");
            System.out.println("1. Terima Surat Izin"); 
            System.out.println("2. Proses Surat Izin"); 
            System.out.println("3. Lihat Surat Izin Terakhir"); 
            System.out.println("4. Cari Surat");
            System.out.print("Pilih menu: ");
            pilih = scan.nextInt();
            scan.nextLine(); 

            switch (pilih) {
                case 1:
                    System.out.print("ID Surat: ");
                    String id = scan.nextLine();
                    System.out.print("Nama Mahasiswa: ");
                    String nama = scan.nextLine();
                    System.out.print("Kelas: ");
                    String kelas = scan.nextLine();
                    System.out.print("Jenis Izin (S/I): ");
                    char jenis = scan.nextLine().charAt(0);
                    System.out.print("Durasi (hari): ");
                    int durasi = scan.nextInt();
                    scan.nextLine();

                    Surat11 srt = new Surat11(id, nama, kelas, jenis, durasi);
                    stackSurat.push(srt);
                    System.out.println("Surat berhasil diterima dan ditaruh di tumpukan.");
                    break;
                case 2:
                    Surat11 diproses = stackSurat.pop();
                    if (diproses != null) {
                        System.out.println("Surat milik " + diproses.namaMahasiswa + " telah divalidasi dan diproses.");
                    }
                    break;
                case 3:
                    Surat11 atas = stackSurat.peek();
                    if (atas != null) {
                        System.out.println("Surat teratas yang menunggu diproses adalah milik: " + atas.namaMahasiswa);
                    }
                    break;
                case 4:
                    System.out.print("Masukkan nama mahasiswa yang dicari: ");
                    String keyword = scan.nextLine();
                    stackSurat.cariSurat(keyword);
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilih >= 1 && pilih <= 4);
    }
}