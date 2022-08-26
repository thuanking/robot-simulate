import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RobotSimulator {
    public static int xR=0,yR = 0;
    public static String fR = "Unknown";
    public static int maxPos = 5;
    public static String N = "NORTH";
    public static String S = "SOUTH";
    public static String W = "WEST";
    public static String E = "EAST";
    public static List<String> listValidCmds = Arrays.asList("PLACE","MOVE","LEFT","RIGHT","REPORT");
    public static List<String> listValidFacings = Arrays.asList(N,S,W,E);
    public static boolean place(String cmdParams){
        String[] params = cmdParams.split(",");
        if(params.length == 3 ){
            int x = Integer.parseInt(params[0]);
            int y = Integer.parseInt(params[1]);
            String facing = params[2];
            if(x > 5 || x < 0 || y > 5 || y < 0){
                System.out.println("Position out of range. Must be [0,5]!");
                return false;
            }
            if (!listValidFacings.contains(facing)) {
                System.out.println("Invalid facing. Must be:" + listValidFacings);
                return false;
            }

            xR = x;
            yR = y;
            fR = facing;
            System.out.printf("Placed :%d,%d,%s \n",x,y,facing);
            return true;
        }else{
            System.out.println("Invalid params of PLACE!");
            return false;
        }
    }

    public static void move(){
        switch (fR){
            case "NORTH":
                if(yR == maxPos){
                    System.out.println("Can't move out of table. Type other command");
                    return;
                }else{
                    yR++;
                }
                break;
            case "SOUTH":
                if(yR == 0){
                    System.out.println("Can't move out of table. Type other command");
                    return;
                }else{
                    yR--;
                }
                break;
            case "WEST":
                if(xR == 0){
                    System.out.println("Can't move out of table. Type other command");
                    return;
                }else{
                    xR--;
                }
                break;
            case "EAST":
                if(xR == maxPos){
                    System.out.println("Can't move out of table. Type other command");
                    return;
                }else{
                    xR--;
                }
                break;
        }
        System.out.printf("Moved to %d,%d \n",xR,yR);
    }

    public static void left(){
        switch (fR){
            case "NORTH":
                fR = W;
                break;
            case "SOUTH":
                fR = E;
                break;
            case "WEST":
                fR = S;
                break;
            case "EAST":
                fR = N;
                break;
        }
        System.out.printf("Left to %d,%d,%s\n",xR,yR,fR);
    }

    public static void right(){
        switch (fR){
            case "NORTH":
                fR = E;
                break;
            case "SOUTH":
                fR = W;
                break;
            case "WEST":
                fR = N;
                break;
            case "EAST":
                fR = S;
                break;
        }
        System.out.printf("Right to %d,%d,%s\n",xR,yR,fR);
    }

    public static void report(){
       System.out.printf("%d,%d,%s \n",xR,yR,fR);
    }
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        boolean isPlaced = false;
        while(true){
            try {
                System.out.println("Valid commands are " + listValidCmds +
                        ". Please enter a command:");
                String inputCmd = sc.nextLine();
                String[] arr = inputCmd.split(" ");
                if (!listValidCmds.contains(arr[0])) {
                    System.out.println("Invalid command!");
                }else{
                    String cmdName = arr[0];
                    if(!isPlaced && !"PLACE".equals(cmdName)){
                        System.out.println("First command must be PLACE!");
                    }else{
                        switch (cmdName){
                            case "PLACE":
                                isPlaced = place(arr[1]);
                                break;
                            case "MOVE":
                                move();
                                break;
                            case "LEFT":
                               left();
                                break;
                            case "REPORT":
                                report();
                                break;
                            default:
                                System.out.println("Invalid command!");
                        }
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
