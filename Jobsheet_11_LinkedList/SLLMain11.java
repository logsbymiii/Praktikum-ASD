package Jobsheet_11_LinkedList;
import java.util.Scanner;
public class SLLMain11 {
    public static void main(String[] args) {

        SingleLinkedList11 sll = new SingleLinkedList11();

        Mahasiswa11 mhs1 = new Mahasiswa11("24212200", "Alvaro", "1A", 4.0);
        Mahasiswa11 mhs2 = new Mahasiswa11("22212202", "Cintia", "3C", 3.5);
        Mahasiswa11 mhs3 = new Mahasiswa11("23212201", "Bimon", "2B", 3.8);
        Mahasiswa11 mhs4 = new Mahasiswa11("21212203", "Dirga", "4D", 3.6);

        sll.print(); 

        sll.addFirst(mhs4);
        sll.print();

        sll.addLast(mhs1);
        sll.print();

        sll.insertAt(1, mhs2);
        sll.insertAfter("Cintia", mhs3);
        sll.print();

         System.out.print("data index 1 : ");
        sll.getData(1);
        System.out.println();
        
        System.out.println("data mahasiswa an Bimon berada pada index : " + sll.indexOf("bimon"));
        System.out.println();
        
        sll.removeFirst();
        sll.removeLast();
        sll.print();
        
        sll.removeAt(0);
        sll.print();

        System.out.println("=== Input Data Mahasiswa dari Keyboard ==="); //soal nomor 3 
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan NIM   : ");
        String nim = sc.nextLine();
        System.out.print("Masukkan Nama  : ");
        String nama = sc.nextLine();
        System.out.print("Masukkan Kelas : ");
        String kelas = sc.nextLine();
        System.out.print("Masukkan IPK   : ");
        double ipk = sc.nextDouble();
        Mahasiswa11 mhsBaru = new Mahasiswa11(nim, nama, kelas, ipk);
        sll.addLast(mhsBaru);
        sll.print();
        sc.close();

    }
}