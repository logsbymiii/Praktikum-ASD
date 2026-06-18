public class PustakaNusantara {

    // ═══════════════════════════════════════════════════
    //  KELAS NODE: Merepresentasikan satu buku di katalog
    // ═══════════════════════════════════════════════════
    static class NodeBuku {
        int    isbn;
        String judul, pengarang;
        int    tahun, harga;
        NodeBuku kiri, kanan;

        NodeBuku(int isbn, String judul, String pengarang, int tahun, int harga) {
            this.isbn      = isbn;
            this.judul     = judul;
            this.pengarang = pengarang;
            this.tahun     = tahun;
            this.harga     = harga;
            this.kiri = this.kanan = null;
        }
    }

    // ═══════════════════════════════════════════════════
    //  KELAS BST: Pohon Pencarian Biner untuk katalog
    // ═══════════════════════════════════════════════════
    static class PohonBuku {
        NodeBuku akar;

        PohonBuku() { this.akar = null; }

        // sisipkan buku baru ke BST
        NodeBuku sisipkan(NodeBuku simpul, int isbn, String judul,
                          String pengarang, int tahun, int harga) {
            if (simpul == null)
                return new NodeBuku(isbn, judul, pengarang, tahun, harga);
            if      (isbn < simpul.isbn)
                simpul.kiri  = sisipkan(simpul.kiri,  isbn, judul, pengarang, tahun, harga);
            else if (isbn > simpul.isbn)
                simpul.kanan = sisipkan(simpul.kanan, isbn, judul, pengarang, tahun, harga);
            return simpul;
        }

        void tambahBuku(int isbn, String judul, String pengarang, int tahun, int harga) {
            akar = sisipkan(akar, isbn, judul, pengarang, tahun, harga);
        }

        // method tampil Traversal PREORDER: Akar - Kiri - Kanan
        void tampilkanPreorder(NodeBuku simpul) {
            if (simpul != null) {
                System.out.println("ISBN: " + simpul.isbn +
                    " | " + simpul.judul +
                    " | " + simpul.pengarang +
                    " | " + simpul.tahun +
                    " | Rp " + simpul.harga);
                tampilkanPreorder(simpul.kiri);
                tampilkanPreorder(simpul.kanan);
            }
        }

        // cari buku berdasarkan ISBN menggunakan BST Search
        void cariByISBN(int isbn) {
            NodeBuku hasil = cari(akar, isbn);
            if (hasil != null) {
                System.out.println("[DITEMUKAN] Judul: " + hasil.judul + " | Pengarang: " + hasil.pengarang + " | Rp " + hasil.harga);
            } else {
                System.out.println("[TIDAK DITEMUKAN] Buku dengan ISBN " + isbn + " tidak ada dalam katalog");
            }
        }

        private NodeBuku cari(NodeBuku simpul, int isbn) {
            if (simpul == null || simpul.isbn == isbn) {
                return simpul;
            }
            if (isbn < simpul.isbn) {
                return cari(simpul.kiri, isbn);
            }
            return cari(simpul.kanan, isbn);
        }

        // tampilkanInorder: Traversal INORDER (Kiri-Akar-Kanan)
        void tampilkanInorder(NodeBuku simpul) {
            if (simpul != null) {
                tampilkanInorder(simpul.kiri);
                System.out.println("ISBN: " + simpul.isbn +
                    " | " + simpul.judul +
                    " | " + simpul.pengarang +
                    " | " + simpul.tahun +
                    " | Rp " + simpul.harga);
                tampilkanInorder(simpul.kanan);
            }
        }

        // hitungTotalNilaiInventaris: Rekursif menghitung total harga buku
        int hitungTotalNilaiInventaris(NodeBuku simpul) {
            if (simpul == null) {
                return 0;
            }
            return simpul.harga + hitungTotalNilaiInventaris(simpul.kiri) + hitungTotalNilaiInventaris(simpul.kanan);
        }
    }

    // ═══════════════════════════════════════════════════
    //  Program Utama
    // ═══════════════════════════════════════════════════
    public static void main(String[] args) {
        PohonBuku katalog = new PohonBuku();

        // -- Memuat 7 buku ke dalam BST --
        katalog.tambahBuku(1023, "Pemrograman Java Dasar",     "Budiman S.",  2020,  95000);
        katalog.tambahBuku(1156, "Algoritma & Struktur Data",  "Hartono W.", 2022, 120000);
        katalog.tambahBuku(1078, "Basis Data Modern",          "Sari M.",    2021, 108000);
        katalog.tambahBuku(1201, "Jaringan Komputer",          "Pratama D.", 2019,  85000);
        katalog.tambahBuku(1045, "Kecerdasan Buatan",          "Rahayu L.",  2023, 135000);
        katalog.tambahBuku(1189, "Sistem Operasi",             "Nugroho A.", 2021,  98000);
        katalog.tambahBuku(1067, "Rekayasa Perangkat Lunak",   "Wijaya T.",  2022, 112000);

        System.out.println("=== KATALOG PUSTAKA NUSANTARA ===");
        katalog.tampilkanPreorder(katalog.akar);
        System.out.println("=================================");

        // --- Akhir Method Main  ---
        System.out.println("\n--- Pencarian Buku ---");
        katalog.cariByISBN(1078);
        katalog.cariByISBN(1099);

        // --- TAMBAHKAN KODE BERIKUT (setelah bagian Mudah) ---
        System.out.println("\n--- Katalog Terurut (Inorder) ---");
        katalog.tampilkanInorder(katalog.akar);
        int total = katalog.hitungTotalNilaiInventaris(katalog.akar);
        System.out.println("\nTotal Nilai Inventaris: Rp " + total);
    }
}
