package No4;

public class GenericsType<T> {

    private T t;

    public T get() {
        return this.t;
    }

    public void set(T t1) {
        this.t = t1;
    }

    public static void main(String args[]) {
        GenericsType<String> type = new GenericsType<>();
        type.set("Java"); // valid
        System.out.println("Isi type: " + type.get());

        GenericsType type1 = new GenericsType(); // raw type
        type1.set("Java"); // valid
        System.out.println("Isi type1 setelah diisi tipe String: " + type1.get());

        type1.set(10); // valid and autoboxing support
        System.out.println("Isi type1 setelah diisi tipe Integer: " + type1.get());
    }
}