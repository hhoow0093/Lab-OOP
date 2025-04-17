package Tugas;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Item>ListofItems= new ArrayList<>();
    static ArrayList<Payment> ListOfPayments = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void SeedData() {
        ListofItems.add(new Item("Kulkas", "Elektronik", 4800000));
        ListofItems.add(new Item("TV", "Elektronik", 1280000));
        ListofItems.add(new Item("Laptop", "Komputer", 6000000));
        ListofItems.add(new Item("Kulkas", "Komputer", 1200000));
    }

    public static void printItem(Item item) {
        System.out.println("Nama    :" + item.getname());
        System.out.println("Tipe    :" + item.getType());
        System.out.println("Price   :" + item.getPrice());

    }
    
    public static void viewTipeBayaran() {
        System.out.println("-----Tipe Pembayaran-----");
        System.out.println("1. Cash");
        System.out.println("2. Credit");
    }

    public static void PrintPayments(Payment pay) {
        System.out.println("Nama            :" + pay.getItemName());
        System.out.println("Tipe            :" + pay.getItem().getType());
        System.out.println("status          :" + pay.getStatus());
        System.out.println("sisa pembayaran :" + pay.getRemainingAmount());
    }
    
    public static void prosesBayarCash(Scanner scanner, Item selecteditem) {
        char Yes_or_NO;
        System.out.print("Bayar (Y/N): ");
        Yes_or_NO = scanner.nextLine().charAt(0);
        if (Yes_or_NO == 'N') {
            System.out.println("Transaksi Disimpan");
            ListOfPayments.add(new Cash(selecteditem));
            return;
        } else if (Yes_or_NO == 'Y') {
            int Bayar;
            System.out.println("Harga Pembayaran: " + selecteditem.getPrice());
            System.out.print("Bayar: ");
            Bayar = scanner.nextInt();
            if (Bayar < selecteditem.getPrice()) {
                System.out.println("uang tidak cukup");
                return;
            } else {
                Payment sudahBayar = new Cash(selecteditem);
                int kembalian = Bayar - sudahBayar.pay();
                System.out.println("Pembayaran Lunas sisa uang adalah " + kembalian);
                ListOfPayments.add(sudahBayar);
                return;
            }
        } else {
            System.out.println("masukkan input yang benar");
            return;
        }

    }
    
    public static void prosesBayarCredit(Scanner scanner, Item selecteditem) {
        char Yes_or_NO;
        System.out.print("Bayar (Y/N): ");
        Yes_or_NO = scanner.nextLine().charAt(0);
        if (Yes_or_NO == 'N') {
            System.out.println("Transaksi Disimpan");
            ListOfPayments.add(new Credit(selecteditem, 3));
            return;
        } else if (Yes_or_NO == 'Y') {
            int Bayar;
            Credit mau_bayar = new Credit(selecteditem, 3);
            System.out.println("lama cicilan sebanyak:" + mau_bayar.getMaxInstallmentAmount());
            System.out.println("Harga pembayaran : " + mau_bayar.getInstallmentAmount());
            System.out.print("Bayar: ");
            Bayar = scanner.nextInt();
            if (Bayar < mau_bayar.getInstallmentAmount()) {
                System.out.println("uang tidak cukup");
                return;
            } else {
                int kembalian;
                kembalian = Bayar - mau_bayar.pay();
                System.out.println("Transaksi selesai!, sisanya dimaukkan ke dalam keranjang listOfPayments uang kembalian : " + kembalian);
                ListOfPayments.add(mau_bayar);
                return;
            }
            
        } else {
            System.out.println("masukkan input yang benar");
            return;
        }
        
    }

    public static void main(String[] args) {
        int opt = -1;
        SeedData();
        while (opt != 0) {
            System.out.println("---Program Toko Elektronik---");
            System.out.println("1. Pesan barang");
            System.out.println("2. Lihat pesanan");
            System.out.println("0. Keluar");
            System.out.print("pilih: ");
            opt = scanner.nextInt();
            scanner.nextLine();
            
            if (opt == 1) {
                int barangTerpilih;
                for (int i = 0; i < ListofItems.size(); i++) {
                    System.out.println("No      :" + (i + 1));
                    printItem(ListofItems.get(i));
                    System.out.println("-----------------------");

                }        
                System.out.print("pilih: ");
                barangTerpilih = scanner.nextInt();
                scanner.nextLine();

                if (barangTerpilih - 1 >= ListofItems.size() || barangTerpilih - 1 < 0) {
                    System.out.println("Tidak ada dalam sistem");
                    continue;
                }

                Item barangYangmau = ListofItems.get(barangTerpilih - 1);
                viewTipeBayaran();
                int opsi_bayar;
                opsi_bayar = scanner.nextInt();
                scanner.nextLine();
                while (opsi_bayar != 1 && opsi_bayar != 2) {
                    System.out.println("masukkan pembayaran yang benar");
                    opsi_bayar = scanner.nextInt();
                    scanner.nextLine();
                }
                if (opsi_bayar == 1) {
                    prosesBayarCash(scanner, barangYangmau);
                } else {
                    prosesBayarCredit(scanner, barangYangmau);
                    
                }

            }
            
            else if (opt == 2) {
                int mau_selesaikan_transaksi_apa;
                for (int i = 0; i < ListOfPayments.size(); i++) {
                    System.out.println("No              :" + (i + 1));
                    PrintPayments(ListOfPayments.get(i));
                    System.out.println("-----------------------");
                }
                System.out.print("pilih: ");
                mau_selesaikan_transaksi_apa = scanner.nextInt();
                if (mau_selesaikan_transaksi_apa - 1 >= ListOfPayments.size() || mau_selesaikan_transaksi_apa - 1 < 0) {
                    System.out.println("masukkan nomor yang benar");
                    continue;

                }
                scanner.nextLine();
                Payment selected_Payment = ListOfPayments.get(mau_selesaikan_transaksi_apa - 1);
                if (selected_Payment instanceof Credit) {
                    Credit creditPayment = (Credit) selected_Payment;
                    if (creditPayment.isPaidOff) {
                        PrintPayments(creditPayment);
                        System.out.println("sudah lunas");

                    } else {
                        PrintPayments(creditPayment);
                        System.out.println("harga pembayaran: " + creditPayment.getInstallmentAmount());
                        int Bayar;
                        System.out.print("Bayar: ");
                        Bayar = scanner.nextInt();
                        scanner.nextLine();
                        if (Bayar < creditPayment.getInstallmentAmount()) {
                            System.out.println("uang tidak cukup");
                        } else {
                            int Sisa = Bayar - creditPayment.pay();
                            System.out.println("berhasil. kembalian : " + Sisa);
                            ListOfPayments.set(mau_selesaikan_transaksi_apa - 1, creditPayment);
                        }

                    }
                } else if (selected_Payment instanceof Cash) {
                    Cash cashPayment = (Cash) selected_Payment;
                    if (cashPayment.isPaidOff) {
                        PrintPayments(cashPayment);
                        System.out.println("sudah lunas");
                    } else {
                        PrintPayments(cashPayment);
                        System.out.println("harga pembayaran: " + cashPayment.getItem().getPrice());
                        int Bayar;
                        System.out.print("Bayar: ");
                        Bayar = scanner.nextInt();
                        scanner.nextLine();
                        if (Bayar < cashPayment.getItem().getPrice()) {
                            System.out.println("uang tidak cukup");
                        } else {
                            int Sisa = Bayar - cashPayment.pay();
                            System.out.println("berhasil. kembalian : " + Sisa);
                            ListOfPayments.set(mau_selesaikan_transaksi_apa - 1, cashPayment);
                        }
                    }
                }

            }
            
            else if (opt == 0) {
                System.out.println("Terima kasih");
            }
            
        }
        
    }

}
