public class StackSurat11 {
    Surat11[] stack;
    int top;
    int size;

    public StackSurat11(int size) {
        this.size = size;
        stack = new Surat11[size];
        top = -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(Surat11 srt) {
        if (!isFull()) {
            top++;
            stack[top] = srt;
        } else {
            System.out.println("Stack Penuh! Tumpukan surat sudah maksimal.");
        }
    }

    public Surat11 pop() {
        if (!isEmpty()) {
            Surat11 s = stack[top];
            top--;
            return s;
        } else {
            System.out.println("Stack Kosong! Tidak ada surat yang perlu diproses.");
            return null;
        }
    }

    public Surat11 peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            System.out.println("Stack Kosong! Tidak ada tumpukan surat.");
            return null;
        }
    }

    public void cariSurat(String nama) {
        boolean ketemu = false;
        if (!isEmpty()) {
            for (int i = top; i >= 0; i--) {
                if (stack[i].namaMahasiswa.equalsIgnoreCase(nama)) {
                    System.out.println("\nSurat ditemukan pada tumpukan ke-" + (top - i + 1) + " dari atas.");
                    System.out.println("ID Surat  : " + stack[i].idSurat);
                    System.out.println("Nama      : " + stack[i].namaMahasiswa);
                    System.out.println("Jenis Izin: " + (stack[i].jenisIzin == 'S' ? "Sakit" : "Izin Lain"));
                    System.out.println("Durasi    : " + stack[i].durasi + " hari");
                    ketemu = true;
                    break; 
                }
            }
        }
        if (!ketemu) {
            System.out.println("Surat atas nama " + nama + " tidak ditemukan di tumpukan.");
        }
    }
}