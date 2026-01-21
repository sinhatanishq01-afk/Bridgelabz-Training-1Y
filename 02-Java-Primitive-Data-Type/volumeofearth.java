public class volumeofearth {
    public static void main(String[] args){
        int earthradius=6378;
        double volumeinkm=(4/3*earthradius*earthradius*earthradius*3.14);
        double voulmeinmiles=(4/3*earthradius*earthradius*earthradius*3.14)*0.621371;
        System.out.print("The volume of earth in cubic kilometers is = "+ volumeinkm + " and cubic miles is= " +voulmeinmiles);

    }
}