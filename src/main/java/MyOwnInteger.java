public class MyOwnInteger {
    public static void main(String[] args) {
        System.out.println(new MyOwnInteger(3).add(new MyOwnInteger(4)));
        try {
            System.out.println(new MyOwnInteger(3).add(null));
        } catch (NullPointerException e) {
            System.out.println("Nice try, but this happened: " + e);
        }

        final Object o = new Object();
        o.toString();
    }

    private final int secretValue;
    private final int someOtherData = 23;


    public int get() {
        return secretValue;
    }

    public MyOwnInteger(int secretValue) {
        this.secretValue = secretValue;
    }

    @Override
    public String toString() {
        return "MyOwnInteger{" +
                "secretValue=" + secretValue +
                ", someOtherData=" + someOtherData +
                '}';
    }

    public MyOwnInteger add(final MyOwnInteger otherVal) {
        return new MyOwnInteger(otherVal.secretValue + this.secretValue);
    }
}

