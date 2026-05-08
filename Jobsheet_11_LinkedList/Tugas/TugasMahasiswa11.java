package Jobsheet_11_LinkedList.Tugas;

public class TugasMahasiswa11 {
    String nim;
    String nama;
    String keperluan;

    public TugasMahasiswa11() {
    }

    public TugasMahasiswa11(String nim, String nama, String keperluan) {
        this.nim = nim;
        this.nama = nama;
        this.keperluan = keperluan;
    }

    public void tampilInformasi() {
        System.out.printf("  NIM      : %s%n", nim);
        System.out.printf("  Nama     : %s%n", nama);
        System.out.printf("  Keperluan: %s%n", keperluan);
    }
}