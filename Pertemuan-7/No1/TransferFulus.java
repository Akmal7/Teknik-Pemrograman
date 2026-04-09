class Account {
    int balance = 150;
}

public class TransferFulus {
    public static void main(String[] args) throws InterruptedException {
        Account acc1 = new Account();
        Account acc2 = new Account();

        // Thread 1: transfer dari acc1 ke acc2
        Thread t1 = new Thread(() -> {
            synchronized (acc1) { // Mengunci acc1 agar tidak diakses thread lain
                System.out.println("T1 mengunci acc1");
                
                try { Thread.sleep(100); } catch (Exception e) {} 
                // Memberi jeda (simulasi proses), perlu try-catch karena sleep bisa InterruptedException

                synchronized (acc2) { // Mengunci acc2 setelah acc1
                    System.out.println("T1 mengunci acc2");
                    
                    acc2.balance += acc1.balance;
                    System.out.println("T1 memindahkan saldo dari acc1 ke acc2");
                }
            }
        });

        // Thread 2: transfer dari acc2 ke acc1
        Thread t2 = new Thread(() -> {
            synchronized (acc1) { // Diubah: sekarang mengunci acc1 dulu (sama seperti t1)
                System.out.println("T2 mengunci acc1");
                
                try { Thread.sleep(100); } catch (Exception e) {}

                synchronized (acc2) { // Kemudian mengunci acc2
                    System.out.println("T2 mengunci acc2");
                    
                    acc1.balance += acc2.balance;
                    System.out.println("T2 memindahkan saldo dari acc2 ke acc1");
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("--- HASIL AKHIR ---");
        System.out.println("Saldo Akhir acc1: " + acc1.balance);
        System.out.println("Saldo Akhir acc2: " + acc2.balance);
    }
}