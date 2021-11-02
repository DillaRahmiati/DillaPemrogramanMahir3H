package PM;

public class Graph {
        //Deklarasi variable bertipe array 2 dimensi integer dengan nama dt1 yang memiliki access modifier private
        private int[][] dt1;
        //Deklarasi variable bertipe array integer dengan nama dt2 yang memiliki access modifier private
        private int[] dt2;
        //Deklarasi variable bertipe data integer dengan nama total yang diinisialisasi dengan nilai awal 0 yang memiliki access modifier private
        private int total = 0;

        //Deklarasi kelas dengan nama Node
        private class Node {
            private int data; //Deklarasi variable bertipe data integer dengan nama data yang memiliki access modifier private
            private Node next; //Deklarasi variable dengan nama next yang bertipe data Node

            //Deklarasi method constructor dengan nama Node yang memiliki parameter nilai integer dt dan Node n
            public Node(int dt, Node n) {
                data = dt; //Inisialisasi variable data yang diberi nilai dari variable dt
                next = n; //Inisialisasi variable data yang diberi nilai dari variable n
            }

            //Deklarasi method dengan nama getDt bertipe integer
            //method ini berisi perintah mengembalikan nilai pada variable data
            public int getDt() {
                return data;
            }

            //Deklarasi method dengan nama getNext yang bertipe Node
            //method tersebut berisi perintah untuk mengembalikan nilai pada variable next
            public Node getNext() {
                return next;
            }
        }
        //Deklarasi variable bernama node bertipe array Node
        private Node[] node;
        //Deklarasi variable dengan nama jNode yang bertipe data integer
        private int jNode;

        //Deklarasi kelas dengan nama Graph yang memiliki parameter data n dengan tipedata integer
        public Graph(int n) {
            jNode = n; //Pemberian nilai pada variable jNode yang di ambil dari variable n
            node = new Node[jNode]; //instansiasi objek node dari kelas Node dengan array indeks nilai dari variable jNode
            //Proses perulangan dengan for yang memiliki syarat jika integer i dimulai dari 0 dan i kurang dari variable jNode maka i++ node dari indeks I akan berisi null
            for (int i = 0; i < jNode; i++) node[i] = null;
            dt1 = new int[n][n]; //Instansiasi objek dari dt1 dengan nilai array diambil dari variable n
        }

        //Deklarasi method void dengan nama addAdj yang memiliki parameter data dengan nama head, adj yang bertipedata integer
        public void addAdj(int head, int adj) {
            //Objek baru dengan nama n yang diakses dari kelas Node dengan nilai dari variableadj dan node[head]
            Node n = new Node(adj, node[head]);
            node[head] = n; //Nilai node[head] di dapat dari variable n
            total++;
            dt1[head][adj]++; //Variable dt1 yang berisi nilai head dan adj akan bertambah 1
        }
        //Deklarasi method void dengan nama adjacency
        public void adjacency() {
            int i; //Deklarasi variable i dengan tipe data integer
            System.out.print(" ");
            //Proses perulangan dengan for yang bersyarat i dimulai dari 0, i lebih kecil dari jNode, maka i++
            for (i = 0; i < jNode; i++) {
                //Perintah mencetak sesuai format dengan nilai i yang akan ditampilkan
                System.out.printf("[%d] ", i);
            }
            System.out.println();

            //Proses perulangan dengan for yang bersyarat i dimulai dari 0, i lebih kecil dari jNode, maka i++
            for (i = 0; i < jNode; i++) {
                System.out.printf("[%d]", i);
                //Proses perulangan dengan for yang bersyarat integer j dimulai dari 0, j lebih kecildari jNode, maka j++
                for (int j = 0; j < jNode; j++) {
                    Node n = node[i]; //Objek n dari kelas Node bernilai node dengan indeks data dari i
                    boolean ketemu = false; //Cek Boolean dengan nilai awal false
                    while (n != null) { //While dengan syarat n tidak sama dengan null
                        //Pemilihan kondisi dengan if dengan syarat variable n yang memanggil method getDt sama dengan nilai variable j
                        if (n.getDt() == j) {
                            System.out.print(" 1 ");
                            ketemu = true; //Cek Boolean jika variable ketemu bernilai true
                            break;
                        }
                        //Nilai dari variable n di dapat dari nilai variable n yang memanggil method getNext
                        n = n.getNext();
                    }
                    //Pemilihan kondisi dengan if yang memiliki syarat Boolean tidak ketemu
                    if (!ketemu) {
                        System.out.print(" 0 ");
                    }
                }
                System.out.println();
            }
        }

        //Deklarasi method dengan nama getTotal bertipe integer
        public int getTotal() {
            //Perintah mencetak (“Total “ + dengan mengambil nilai variable total
            System.out.println("Total " + total);
            return total; //Mengembalikan nilai pada variable total
        }

        public void cetak() { //Deklarasi method void dengan nama cetak
            for (int i = 0; i < jNode; i++) { //proses perulangan
                //Perintah mencetak array dengan indeks mulai dari nilai i
                System.out.print("[" + i + "]");
                ////Instansiasi objek n dari kelas Node dengan nilai node yang indeksnya diambil dari variable i
                Node n = node[i];
                while (n != null) { //Perintah while dengan syarat variable n tidak sama dengan null
                    //Perintah mencetak dengan menambahkan nilai yang diambil dari variable n yang memanggil method getDt)
                    System.out.print("->" + n.getDt());
                    n = n.getNext();//Variable n bernilai n yang memanggil method getNext
                }
                System.out.println();
            }
        }

        public static void main(String s[]) {
            Graph g = new Graph(5); //Pembuatan objek dari class Graph dengan nama g, dengan argument bernilai 5
            g.addAdj(0,4); //Mengakses method addAdj dan melakukan pengisian data
            g.addAdj(0,1);
            g.addAdj(1,2);
            g.addAdj(2,4);
            g.addAdj(4,3);

            System.out.println("--------------");
            g.cetak(); //Mengakses method cetak untuk menampilkan data yang telah diisikan
            System.out.println("---------------");
            System.out.println("Graph dengan Matrik Adjacency");

            g.adjacency(); //Perintah untuk mengakses method adjacency dan menampilkannya melalui methodcetak
            g.getTotal(); //Perintah untuk mengakses method getTotal
        }
    }