package Jobsheet_11_LinkedList;

public class Mahasiswa11 {
    String nim;
    String nama;
    String kelas; 
    double ipk;   

    public Mahasiswa11(String nim, String nama, String kelas, double ipk) {
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
        this.ipk = ipk;
    }
    
    public void tampilInformasi() {
       System.out.printf("%-15s %-15s %-5s %.1f%n", nama, nim, kelas, ipk);
    }
}