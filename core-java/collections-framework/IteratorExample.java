public class IteratorExample {
   public static void main(String[] args) {
        java.util.Set<String> tags = new java.util.LinkedHashSet<>();
        tags.add("alpha");
        tags.add("beta");
        tags.add("gamma");

        java.util.Iterator<String> it = tags.iterator();
        while (it.hasNext()) {
            String tag = it.next();
            System.out.println(tag);
        }
    }
}
/*
Expected output:
alpha
beta
gamma
*/