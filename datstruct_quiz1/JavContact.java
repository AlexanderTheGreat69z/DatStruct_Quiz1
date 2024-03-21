import java.util.LinkedList;
import java.util.Scanner;

class JavContact {
    LinkedList<Contact> contactList = new LinkedList<>();
    public void run(){
        boolean willExit = false;
        while(!willExit){
            menu();
            String command = input("Enter command: ").toUpperCase();
            System.out.println("********************************");
            switch(command){
                case "A":
                addContact();
                break;

                case "D":
                deleteContact();
                break;

                case "S":
                searchContact();
                break;

                case "P":
                printList();
                break;

                case "E":
                default:
                System.out.println("Thank you for using JavContact");
                willExit = true;
                break;
            }
            System.out.println("********************************");
        }
    }
    private String input(String prompt){
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private void displayNamesList(){
        System.out.println("Contact List:");
        for(Contact c : contactList){System.out.println("- " + c.getName());}
    }

    private void addContact(){
        String name = input("Contact name\t: ");
        String num = input("Phone No.\t: ");
        String email = input("Email Account\t: ");
        contactList.add(new Contact(name, num, email));
        System.out.println("Contact added!");
    }

    private void deleteContact(){
        displayNamesList();
        String target = input("Enter contact name to delete: ");
        boolean contactDeleted = false;
        for(Contact c : contactList){
            int index = contactList.indexOf(c);
            if (c.getName().toLowerCase().equals(target.toLowerCase())){
                contactList.remove(index);
                contactDeleted = true;
                System.out.println("Contact deleted.");
            }
        }
        if (!contactDeleted){System.out.println("Contact not found.");}
    }

    private void searchContact(){
        String target = input("Enter contact name to search: ");
        boolean contactFound = false;
        for(Contact c : contactList){
            if (c.getName().toLowerCase().equals(target.toLowerCase())){
                contactFound = true;
                System.out.println("Contact Found!");
                c.display();
            }
        }
        if (!contactFound){System.out.println("Contact Not Found.");}
    }

    private void printList(){
        if (contactList.isEmpty()){System.out.println("List is empty!");}
        else{
            System.out.println("List of Contacts:");
            for(Contact c : contactList){c.display();}
        }
    }

    private void menu(){
        System.out.println("********************************");
        System.out.println("JavContact | Contact Manager");
        System.out.println("--------------------------------");
        System.out.println("Type first letter of command: ");
        System.out.println("- [A]dd");
        System.out.println("- [D]elete");
        System.out.println("- [S]earch");
        System.out.println("- [P]rint List");
        System.out.println("- [E]xit");
        System.out.println("********************************");
    }
}

class Contact{
    private String name, number, email;
    
    Contact(String name, String number, String email){
        this.name = name;
        this.number = number;
        this.email = email;
    }

    public void display(){
        System.out.println("========================");
        System.out.println(this.name);
        System.out.println("------------------------");
        System.out.println("Number\t: " + this.number);
        System.out.println("Email\t: " + this.email);
        System.out.println("========================");
    }

    public String getName(){return this.name;}
    public String getNum(){return this.number;}
    public String getEmail(){return this.email;}
}
