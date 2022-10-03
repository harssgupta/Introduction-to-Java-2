public class Main {
    //    Bank b=new Bank();
    public static void main(String[] args) {
        Bank bank = new Bank("Delhi", 1.8f);
        SBI sbiBranch = new SBI("Noida",1.3f,"1001");
        BOI boiBranch = new BOI("Lucknow",1.6f,"2001");
        ICICI iciciBranch = new ICICI("Bengaluru",2.2f,"3001");
        bank.getDetails();
        sbiBranch.getDetails();
        boiBranch.getDetails();
        iciciBranch.getDetails();
    }
}