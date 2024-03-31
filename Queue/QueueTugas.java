package Queue ;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner ;
        
public class QueueTugas<E>{
    private Queue<String> listTugas ;

        public QueueTugas(){
            listTugas = new LinkedList<String>();
    }

        public void tambahTugas(String tugas){
            listTugas.add(tugas);
            System.out.println(tugas + " Tambah Tugas.");
        }

            public void tampilkanTugas(){
                listTugas.peek();
            }
            
            public void hapusTugas(){
                if(!listTugas.isEmpty()){
                    listTugas.remove();
                    System.out.println("Pekerjaan sudah di selesai kan.");
                }else{
                    System.out.println("Tidak ada tugas.");
                }
            }

            public void cetakTugas() {
                Iterator<String> iterator = listTugas.iterator();
                while (iterator.hasNext()) {
                    Object value = iterator.next();
                    System.out.print(value + " ");
                }
                System.out.println();
            }

            public boolean isEmpty(){
                return listTugas.isEmpty();
            }
            
        public static void main(String[] args){

            Scanner s = new Scanner(System.in);
            QueueTugas<String> queue = new QueueTugas<String>();

            int opsi = 0 ;
            while(opsi != 5){
                
                System.out.println("1. Tambah Tugas");
                System.out.println("2. Menampilkan Tugas yang akan di kerjakan");
                System.out.println("3. Hapus Tugas");
                System.out.println("4. Menampilkan semua tugas");
                System.out.println("5. Keluar");
                System.out.print("Pilih salah satu pada menu : ");
                opsi = s.nextInt();

                switch (opsi) {
                    case 1:
                        System.out.print("Masukkan nama Tugas :");
                        s.nextLine();
                        String nama = s.nextLine();
                        queue.tambahTugas(nama);
                        break;
                    case 2:
                        queue.tampilkanTugas();
                        break;
                    case 3:
                        queue.hapusTugas();
                        break ;
                    case 4:
                        System.out.println("Cetak semua tugas :");
                        queue.cetakTugas();
                        break ;
                    case 5:
                        System.out.println("Terima kasih sudah ^_^");
                        break;
                }
            }
        }
    }

