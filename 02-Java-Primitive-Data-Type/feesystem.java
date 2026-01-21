public class feesystem {
    public static void main(String[] args){
        int discountper=10;
        double discountamount=(0.1*125000);
        int fee=125000;
        int feeaftediscount=fee-(fee*discountper/100);
        System.out.println("The discount amount is INR= "+discountamount+"and final discounted fee is INR= "+feeaftediscount);

    }
}
