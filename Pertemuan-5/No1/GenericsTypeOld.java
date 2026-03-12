package No1;

public class GenericsTypeOld {
    private Object t;

    public Object get() {
        return t;
    }

    public void set(Object t) {
        this.t = t;
    }
    public static void main(String args[]) {
        GenericsTypeOld type = new GenericsTypeOld();
        type.set("Java");
        //type.set(10); // terjadi error karena nilainya integer tapi tetap di casting ke string
        String str = (String) type.get(); // type casting, error prone and can cause ClassCastException
        System.out.println("Output: " + str);
    }
}