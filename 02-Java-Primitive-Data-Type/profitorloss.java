public class profitorloss {
    public static void main(String[] args){
        int costprice=129;
        int sellingprice=191;
        double profit=sellingprice-costprice;
        double ProfitPercentage = (profit/costprice) * 100;
        System.out.println("The Cost Price is INR 129 and Selling Price is 191");
        System.out.println("The Profit is INR:" +profit+ "and the Profit Percentage is:"+ProfitPercentage);
    }
}
