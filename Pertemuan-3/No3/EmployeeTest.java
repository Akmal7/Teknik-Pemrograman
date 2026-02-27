public class EmployeeTest {
    public static void main(String[] args) {

        // Membuat array untuk 3 objek Employee
        Employee[] staff = new Employee[3];

        // Inisialisasi data
        staff[0] = new Employee("Antonio Rossi", 2000000, 1, 10, 1989);
        staff[1] = new Employee("Maria Bianchi", 2500000, 1, 12, 1991);
        staff[2] = new Employee("Isabel Vidal", 3000000, 1, 11, 1993);

        // Menaikkan gaji 5%
        for (int i = 0; i < 3; i++) {
            staff[i].raiseSalary(5);
        }

        // Memanggil compare()
        System.out.println("Hasil compare staff[0] dan staff[1]: "
            + staff[0].compare(staff[1]));

        System.out.println("Hasil compare staff[1] dan staff[2]: "
            + staff[1].compare(staff[2]));

        System.out.println("Hasil compare staff[0] dan staff[2]: "
            + staff[0].compare(staff[2]));

        // Mencetak semua data karyawan
        for (int i = 0; i < 3; i++) {
            staff[i].print();
        }
    }
}