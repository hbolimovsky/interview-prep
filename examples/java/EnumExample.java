package java;

public class EnumExample {
    public static void main(String[] args) {

        Coin flip = Coin.TAILS;
        switch (flip) {
            case HEADS:
                System.out.println("heads!");
                break;
            case TAILS:
                System.out.println("tails!");
                break;
            default:
                System.out.println("an error occured...");
                break;
        }

        CryptoPeople[] people = CryptoPeople.values();
        for (CryptoPeople p: people) {
            System.out.println(p + " is " + p.getDescription());
        }
        
    }

    
    enum Coin {
        HEADS, TAILS;
    }

}

enum CryptoPeople {
    ALICE("great"),
    BOB("nice"),
    EVE("evil");

    private String description;

    CryptoPeople(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}