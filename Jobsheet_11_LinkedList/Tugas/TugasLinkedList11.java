package Jobsheet_11_LinkedList.Tugas;

public class TugasLinkedList11 {

    private TugasNode11 head;
    private TugasNode11 tail; 
    private int size;
    private final int MAX_SIZE = 10; 

    public TugasLinkedList11() {
        head = null;
        tail = null;
        size = 0;
    }

   
    public boolean isEmpty() {
        return head == null;
    }

    public boolean isFull() {
        return size >= MAX_SIZE;
    }

    public void clearQueue() {
        head = null;
        tail = null;
        size = 0;
        System.out.println("Antrian berhasil dikosongkan.");
    }

    public void enqueue(TugasMahasiswa11 mhs) {
        if (isFull()) {
            System.out.println("Antrian penuh! Tidak dapat menambahkan data.");
            return;
        }
        TugasNode11 newNode = new TugasNode11(mhs, null);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        System.out.println("Mahasiswa [" + mhs.nama + "] berhasil masuk antrian. (Nomor antrian: " + size + ")");
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Antrian kosong! Tidak ada mahasiswa yang dipanggil.");
            return;
        }
        System.out.println("\n>>> Memanggil antrian terdepan:");
        head.data.tampilInformasi();
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        System.out.println("Mahasiswa telah dilayani.\n");
    }

    public void peekFront() {
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
        } else {
            System.out.println("Antrian terdepan:");
            head.data.tampilInformasi();
        }
    }

    public void peekRear() {
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
        } else {
            System.out.println("Antrian paling akhir:");
            tail.data.tampilInformasi();
        }
    }

    public void jumlahAntrian() {
        System.out.println("Jumlah mahasiswa yang masih mengantre: " + size + " orang");
    }

    public void tampilAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
        } else {
            System.out.println("===== Daftar Antrian =====");
            TugasNode11 tmp = head;
            int no = 1;
            while (tmp != null) {
                System.out.println("Antrian ke-" + no + ":");
                tmp.data.tampilInformasi();
                tmp = tmp.next;
                no++;
            }
            System.out.println("==========================");
        }
    }
}