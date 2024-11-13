import java.util.ArrayList;
import java.util.Scanner;




public class Main {
    public static void main(String[] args) {
        System.out.print("1.-------------\n");
        Scanner input = new Scanner(System.in);
        char[][]seats={
                {'O','O','O','O','O'},
                {'O','O','O','O','O'},
                {'O','O','O','O','O'}
        };


        displaySeating(seats);

        int row = 0;
        int col = 0;
        while(true){
            System.out.print("Enter the row number from 1 to "+(seats.length)+" :");
            row = input.nextInt()-1;
            System.out.print("Enter the col number from 1 to "+(seats[0].length)+" :");
            col = input.nextInt()-1;
            if(row>=0 && row<seats.length && col >=0 && col < seats[0].length){
                break;
            }else{
                System.out.print("Invalid input please enter numbers within range listed.");
            }
        }

        System.out.print("You have selected Row and Column: "+(row+1)+","+(col+1)+".");
        System.out.print("\nThank you for booking! Please confirm your seat booking? \n(1 = Yes/ 2 = No) : ");
        int confirm = input.nextInt();
        if(confirm == 1){
            if(bookSeat(seats, row, col)){
                System.out.println("Booking successful");
            }else{
                System.out.println("Seat occupied! Please try again! :(");
            }

        }else{
            System.out.print("Booking Canceled");
        }

        displaySeating(seats);

        System.out.print("Full rows: "+ checkFullRows(seats));
        System.out.println();

        System.out.print("\n2.--------------\n");
        ArrayList<Double> temps = new ArrayList<Double>();
        temps.add(71.2);
        temps.add(67.4);
        temps.add(83.2);
        temps.add(66.5);
        temps.add(75.3);
        temps.add(79.2);

        double thresh= 72;

        double inc= 5;
        System.out.print("The average temperature is: "+averageTemperature(temps));


        System.out.println("\nThe number of cold days is: "+(int)countColdDays(temps,thresh));

        System.out.print("\nThe increased Temperatures are as followed:\n");
       increaseTemperatures(temps, inc);

       System.out.println();
        System.out.print("3.-------------");
        int n = 5;
        double d = 7.8;
        int[]a={25,22,11,23,5};
        int[][]a2={{23,22,1,5},{6,4,5,2}};
        printData(n,d,a,a2);

    }

    public static void displaySeating(char[][] seats) {

        System.out.println();
        for(int i = 0; i<seats.length; i++){
            System.out.print((i+1)+" ");
            for(int j = 0; j<seats[i].length;j++){
                System.out.print(seats[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static boolean bookSeat(char[][]seats, int row, int col) {
        if(seats[row][col]=='V'){//If seat is vacant changes seat to Occupied and boolean becomes true
            seats[row][col]='O';
            return true;
        }
        return false;
    }


    public static ArrayList<Integer> checkFullRows(char[][]seats) {
    ArrayList<Integer> fullRows = new ArrayList<>();
    for(int i =0; i<seats.length; i++){
        boolean full = true;
        for(int j = 0 ; j<seats.length; j++){
            if(seats[i][j]=='V'){ //Checks if row is vacant and if vacant breaks loop
                full = false;
                break;
            }
        }
        if(full){
            fullRows.add(i);
        }
    }
    return fullRows;
    }
//Question 2
    public static double averageTemperature(ArrayList<Double> temps){
        double sum = 0.00;
        for(double temp: temps ){
            sum+=temp;
        }
        return sum/temps.size();
    }

    public static double countColdDays(ArrayList<Double> temps, double thresh){
        int count=0;
        for(double temp: temps){
            if(temp < thresh){
                count++;
            }
        }
        return count;
    }

    public static void increaseTemperatures(ArrayList<Double> temps, double num ){

      for(int i = 0; i<temps.size(); i++){
        temps.set(i, temps.get(i)+num);
      }
    for(int i = 0; i<temps.size(); i++){
        System.out.println(temps.get(i));
    }



    }

    //Question 3
    public static void printData(int num,double doubleNum,  int[] arr, int[][] arr2D){
        System.out.println();
        System.out.println(num);
        System.out.println();
        System.out.println(doubleNum);
        System.out.println();
        //Print 1D Array
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

//        Prints 2D array
        for(int i = 0; i<arr2D.length; i++){
            for(int j = 0; j< arr2D[i].length; j++){
                System.out.print(arr2D[i][j]+" ");
            }
        }

    }


}