/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bookworm;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Jake Marson Nable
 */
public class BookWorm {
    static Scanner scan= new Scanner(System.in);
    static BookWorm author = new BookWorm();
    static BookWorm title = new BookWorm();
    static BookWorm ISBN = new BookWorm();
    
    //main operation
    public static void main(String[] args) throws InterruptedException {
        int loop = 0;
        do{
            menu();
            System.out.println("Do you want to go to the Main Menu?\n YES.\n NO.");
            String Ignored = scan.nextLine(); //Scanner bug nextLine()
            String userchoice = scan.nextLine();
            if(userchoice.equalsIgnoreCase("no")){
                //confirmation
                System.out.println("Are you sure you want to exit?\n Yes.\n No.");
                String UserChoice = scan.nextLine();
                
                if(UserChoice.equalsIgnoreCase("yes")){
                    System.out.println("EXITING\n3");
                    Thread.sleep(500);
                    System.out.println("2");
                    Thread.sleep(500);
                    System.out.println("1");
                    Thread.sleep(500);
                    System.out.println("Have a nice day!");
                    loop++;
                }else if (UserChoice.equalsIgnoreCase("no")){
                    System.out.println("Going Back to Main Menu\n3");
                    Thread.sleep(500);
                    System.out.println("2");
                    Thread.sleep(500);
                    System.out.println("1");
                    Thread.sleep(500);
                }
            }else if (userchoice.equalsIgnoreCase("yes")){
                System.out.println("Going Back to Main Menu\n3");
                Thread.sleep(500);
                System.out.println("2");
                Thread.sleep(500);
                System.out.println("1");
                Thread.sleep(500);
            }else{ //Invalid Input message
                System.out.println("Oh no! You entered an INVALID input.");
                System.out.println("Preparing to EXIT\n3");
                Thread.sleep(500);
                System.out.println("2");
                Thread.sleep(500);
                System.out.println("1");
                Thread.sleep(500);
                System.out.println("Have a nice day!!");
                loop++;
            }
        }while(loop==0);
    }
    //Main menu for BookWorm
    public static void menu(){
        System.out.println("   Welcome to BookWorm Library");
        System.out.println("===================================");
        
        System.out.println("What do you want to do?\n[1] Add Books to the Library.\n[2] Check library.");
        int input = scan.nextInt();
        
        switch(input){
            case 1:
                addBooks();
                break;
            case 2:
                library();
                break;
            default:
                System.out.println("Oh no! You entered an INVALID input.");
                break;
        }
    }
    // book Adding
    public static void addBooks(){
        System.out.println("   Welcome to BookWorm Library");
        System.out.println("===================================");
        
        System.out.println("Please Enter The Title of the book");        
        String IgnoredLine = scan.nextLine();   //Scannerbug nextline()     
        String inputTitle = scan.nextLine();
        title.insertionNodeTitle(inputTitle);
        
        System.out.println("Please Enter the Author's Name");
        String inputAuthor = scan.nextLine();
        author.insertionNodeAuthor(inputAuthor);
        
        System.out.println("Please Enter the ISBN");
        int isbn = scan.nextInt();
        ISBN.insertionNode(isbn);
    }
    //Book Searching
        public static void library(){
        System.out.println("   Welcome to BookWorm Library");
        System.out.println("===================================");
        
        System.out.println("Please Enter the ISBN");
        int target = scan.nextInt();
        
        Node resultNode = ISBN.searchNode(target);
        NodeTitle resultTitle = title.searchNodeTitle(target);
        NodeAuthor resultAuthor = author.searchNodeAuthor(target);
        
        if (resultNode != null) {
            System.out.println("The Book's title: " + resultTitle.dataTitle );
            System.out.println("The Author's Name: " + resultAuthor.dataAuthor);
            System.out.println("ISBN: " + resultNode.data );
        } else {
            System.out.println("Sorry, The ISBN you've entered is not in the library.");
        }
    }
    //Integer Insertions ISBN
    public static Node head;
    
    static class Node {
        int data;
        Node next;
        
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public void insertionNode(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }else{
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }
    
    //String Insertions Title
    public static NodeTitle headTitle;
    
    static class NodeTitle{
        String dataTitle;
        NodeTitle nextTitle;

        NodeTitle(String data){
            this.dataTitle = data;
            this.nextTitle = null;
        }
    }
    
    public void insertionNodeTitle(String data){
        NodeTitle newNodeTitle = new NodeTitle(data);
        if (headTitle == null){      
            headTitle = newNodeTitle;
        }else{
            NodeTitle currentTitle = headTitle;
            while (currentTitle.nextTitle != null){
                currentTitle = currentTitle.nextTitle;
            }
            currentTitle.nextTitle = newNodeTitle;
        }
    }    
    //String Insertion Authtor
    public static NodeAuthor headAuthor;
    
    static class NodeAuthor{
        String dataAuthor;
        NodeAuthor nextAuthor;
        
        NodeAuthor(String data){
            this.dataAuthor = data;
            this.nextAuthor = null;
        }
    }
    public void insertionNodeAuthor(String data){
        NodeAuthor newNodeAuthor = new NodeAuthor(data);
        if(headAuthor == null){
            headAuthor = newNodeAuthor;
        }else {
            NodeAuthor currentAuthor = headAuthor;
            while(currentAuthor.nextAuthor != null){
                currentAuthor = currentAuthor.nextAuthor;
            }
            currentAuthor.nextAuthor= newNodeAuthor;
        }
    } 
    //searchfor ISBN
    public Node searchNode(int target){
        Node current = head;
        while(current != null){
            if(current.data == target){
                return current;
        }
        current = current.next;
        }      
        return null;
    }
    //Target equal for title
    public NodeTitle searchNodeTitle(int target){
        Node current = head;
        NodeTitle currentTitle =headTitle;
        while(current != null){
            if(current.data == target){
                return currentTitle;
        }
        currentTitle = currentTitle.nextTitle;
        current = current.next;
        }      
        return null;
    }
    //Target equal for authors
    public NodeAuthor searchNodeAuthor(int target){
        Node current = head;
        NodeAuthor currentAuthor =headAuthor;
        while(current != null){
            if(current.data == target){
                return currentAuthor;
        }      
        currentAuthor = currentAuthor.nextAuthor;
        current = current.next;
        }      
        return null;
    }
}