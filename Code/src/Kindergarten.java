import java.util.Arrays;

public class Kindergarten extends FunctionHandler{
    public static void main(String[] args){
        //checkArraySizes();
        Kindergarten kindergarten = new Kindergarten();
        kindergarten.run();
        Menu m = new Menu();
    }

    public void run() {
        checkArraySizes();

        //getPhoneList(true);
        //createChild();

        /*String test = userInput.nextLine();

        if(isInteger(test)){
            System.out.println("yes");
        }else{
            System.out.println("nope.");
        }*/

        //System.out.println(childList.size());
        //getChildInfo(20122011);
        //editChild(20122011);
        //editEmployee(1);

        for(int i = 0; i < childList.size(); i++){
            System.out.println(Arrays.toString(childList.get(i).toString("save").split(",")));
        }
    }
}
