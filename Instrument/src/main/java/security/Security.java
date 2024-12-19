package security;

public class Security implements ISecurity{
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    @Override
    public String getIssuer() {
        return null;
    }
}