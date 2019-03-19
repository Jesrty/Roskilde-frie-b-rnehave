import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FunctionHandler {

	List<Employee> employeeList = new ArrayList<Employee>();
	List<Child> childList = new ArrayList<Child>();
	List<Parent> parentList = new ArrayList<Parent>();
	Scanner userInput = new Scanner(System.in);

	public void createChild() {
		// TODO - implement FunctionHandler.createChild
		int placeInInfo = 0;
		String finalString = "";

		String[] infoNeeded = {
				"Enter first name",
				"Enter last name",
				"Enter CPR number (05-10-2010)",
				"Enter waiting list (Yes or No)",
				"Enter witing list date (05-10-2010)"
		};

		do{
			System.out.println(infoNeeded[placeInInfo]);
			if(placeInInfo != 5){
				finalString += userInput.nextLine();
				if(placeInInfo != 4){
					finalString += ",";
				}
			}
			placeInInfo++;
		}while(placeInInfo != 5);

		Object[] info = finalString.split(",");
		childList.add(new Child(
				info[0].toString(),
				info[1].toString(),
				Integer.parseInt(info[2].toString()),
				Boolean.parseBoolean(info[3].toString()),
				info[4].toString()
		));

		//saving all the childs info back to file
		saveChildren();
	}

	/**
	 *
	 * @param cpr
	 */
	public void editChild(int cpr) {
		// TODO - implement FunctionHandler.editChild
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param cpr
	 */
	public void getChildInfo(int cpr) {
		// TODO - implement FunctionHandler.getChildInfo
		for(int i = 0; childList.size() > i; i++){
			int childCpr = childList.get(i).getCpr();
			if(childCpr == cpr){
				String firstName = childList.get(i).getFirstName();
				String lastName = childList.get(i).getLastName();
				System.out.println("Found the child with the corresponding CPR number.");
				System.out.println("- " + firstName + " " + lastName);
			}else if(childList.size() == i){
				System.out.println("No child with the CPR. Did you type right?");
			}
		}
		//throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param child
	 */
	public void getPhoneList(boolean child) {
		// TODO - implement FunctionHandler.getPhoneList

		if(child == true) {

		}else if(child == false){
			for(int i = 0; i < employeeList.size(); i++){
				System.out.println("- " + employeeList.get(i).getInitials() + " +45" + employeeList.get(i).getPhoneNumber());
			}
		}

		throw new UnsupportedOperationException();
	}

	public void createEmployee() {
		// TODO - implement FunctionHandler.createEmployee

		int newestId = (employeeList.get(employeeList.size()).getId() + 1);

		//saving all the employees info back to file
		saveEmployees();
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param id
	 */
	public void editEmployee(int id) {
		// TODO - implement FunctionHandler.editEmployee

		//saving all the employees info back to file
		saveEmployees();
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param id
	 */
	public String getEmployee(int id) {
		// TODO - implement FunctionHandler.getEmployee
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param week
	 */
	public void editSchedule(int week) {
		// TODO - implement FunctionHandler.editSchedule
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param week
	 */
	public void viewSchedule(int week) {
		// TODO - implement FunctionHandler.viewSchedule
		throw new UnsupportedOperationException();
	}

	public void checkArraySizes(){
		if(childList.size() == 0 || parentList.size() == 0 || employeeList.size() == 0){
			populateChilds();
			populateParents();
			populateEmployees();
		}
	}

	public void populateParents(){
		//make sure the array is empty
		parentList.clear();

		try {
			Scanner scan = new Scanner(new File("parents.txt"));
			do{
				Object[] info = scan.nextLine().split(",");
				parentList.add(new Parent(
						info[0].toString(), //first name
						info[1].toString(), //last name
						Integer.parseInt(info[2].toString()), //phone number
						info[3].toString(), //mail
						Integer.parseInt(info[4].toString()) //Child cpr
				));
			}while (scan.hasNextLine());

		}catch (FileNotFoundException e){
			System.out.println("Ingen fil fundet");
		}
	}

	public void saveParents(){
		try{
			PrintStream file = new PrintStream(new File("parents.txt"));
				for(int i = 0; i < parentList.size(); i++){
					file.println(parentList.get(i).toString("save"));
				}
		}catch (FileNotFoundException e){
			System.out.println(e);
		}
	}

	public void populateChilds(){
		//make sure the array is empty
		childList.clear();

		try {
			Scanner scan = new Scanner(new File("children.txt"));
			do{
				Object[] info = scan.nextLine().split(",");
				childList.add(new Child(
						info[0].toString(), //first name
						info[1].toString(), //last name
						Integer.parseInt(info[2].toString()), //cpr
						Boolean.parseBoolean(info[3].toString()), //on waiting list
						info[4].toString() //waiting list date
				));
			}while (scan.hasNextLine());

		}catch (FileNotFoundException e){
			System.out.println("Ingen fil fundet");
		}
	}

	public void saveChildren(){
		try{
			PrintStream fileSave = new PrintStream(new File("children.txt"));
			for(int i = 0; i < childList.size(); i++){
				System.out.println(childList.get(i).toString("save"));
				fileSave.println(childList.get(i).toString("save"));
			}
		} catch (FileNotFoundException e){
			System.out.println(e);
		}
	}

	public void populateEmployees(){
		//make sure the array is empty
		employeeList.clear();

		try {
			Scanner scan = new Scanner(new File("employees.txt"));
			do{
				Object[] info = scan.nextLine().split(",");
				employeeList.add(new Employee(
						Integer.parseInt(info[0].toString()), //id
						info[1].toString(), //first name
						info[2].toString(), //last name
						info[3].toString(), //Username
						info[4].toString(), //Password
						Integer.parseInt(info[5].toString()), //phone number
						info[6].toString(), //initials
						Boolean.parseBoolean(info[7].toString()) //is admin
				));
			}while (scan.hasNextLine());

		}catch (FileNotFoundException e){
			System.out.println("Ingen fil fundet");
		}
	}

	public void saveEmployees(){
		try{
			PrintStream file = new PrintStream(new File("employees.txt"));
			for(int i = 0; i < employeeList.size(); i++){
				file.println(employeeList.get(i).toString("save"));
			}
		}catch (FileNotFoundException e){
			System.out.println(e);
		}
	}
}