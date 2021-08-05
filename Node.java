/*
Description: This class allows for the creation of Node in which you can 
create a Node and access that Nodes next. It really is the base of LinkedList
Inputs: When creating a Node, you can pass it the data that you wish to store 
in memory.
 */


package project.pkg8;


public class Node <T>{
    
    protected Node next;
    protected T data;
        
        public Node(){ 
        }
        
        public Node(T data){
            this.data = data;
        }
        
        /*
        Function: T getValue()
        Description: This method is a getter method that allows the user to pull
        down the value of the node which can be of any type.
        Inputs: None
        Outputs: The value of the node will be returned.
        */

        public T getData() {
            return this.data;
        }     
        
        /*
        Function: T getNext()
        Description: This method is a getter method that allows the user to pull
        down the next node of the current node
        Inputs: None
        Outputs: The next node of the current node
        */
        
        public Node getNext(){
            return this.next;
        }

}
