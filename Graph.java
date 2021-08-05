/*
Description: THIS IS THE MAIN FILE. The Graph.java file contains source code for 
a digraph that takes the input from the example given in the lecture material
(e.g. Murrieta, Temecula, Canyon Lake). It does this by adding the cities by hashing the 
name of the city. It then prints everything in the graph to the console. After doing 
this, I call the Depth-First traversal algorithm that will traverse the entire graph 
and print each node without printing the node of which the vertexs have been called 
previously. 
 */


package project.pkg8;

import java.util.ArrayList;


public class Graph {
    
    /*
    An array of linked list is declared and is used as the back bone of the digraph.
    */
    
    private LinkedList[] arr;
    
    
    public Graph(){
        arr = new LinkedList[19];
    }
    
        
    
    /*
    Function: int hash(String name)
    Description: This method uses the bernstein algorithm to create a hash based 
    off of all of the characters in the string provided within the bounds of the 
    array set in the constructors. 
    Inputs: A string is required as a parameter for this method
    Outputs: An int which will indicate the index in the array.
    */
    
    public int hash(String name){
        
        //Bernstein hash function
        long hashVal = 5381;
        for(char ch : name.toCharArray()){
            if(ch != ' '){
                hashVal*=32;
                hashVal+=(int)ch;
            }
            
        }
        hashVal %= arr.length;
        
        if((int)hashVal < 0)
            return 0; //deals with out of bounds cases, just in case.
        else
            return (int)hashVal;
        
    }
    
    
    /*
    Function: addEdge(String src, String dest)
    Description: This method adds an edge if one doesn't already exist, if one does
    exists, then the method simply appends the ddestination to the end of that current
    linked list.
    Inputs: The source, or vertex and the city that is being added. 
    Outputs: None
    */
    
    public void addEdge(String src, String dest){
        
        int index = hash(src);
        
        if(arr[index] == null){
            arr[index] = new LinkedList(src);
            arr[index].append(dest);
        }else{
            arr[index].append(dest);
        }

    }
    
    /*
    Function: void printTable()
    Description: This method traverses the entire hashTable from Linked list in the arrays 
    first index, to the last and prints every nodes value. 
    Inputs: None
    Outputs: Will print to the console when called.
    */
    
    public void printTable(){
        
        for(int i = 0; i < arr.length; i++){
            if(!(arr[i] == null))
                arr[i].printList();
        }
        
    }
    
    
    /*
    Function: depthFirstTraversal(int Index)
    Description: This method traverses the entire graph and visits each node and 
    then prints each node that it visits. 
    Inputs: An int is required as input that is taken as an index into the graph
    Outputs: The depthfirsttraversal results are printed to the console
    */
    
    
    public void depthFirstTraversal(int Index){
        
        ArrayList<String> cantUse = new ArrayList<>();
        Node p = null;
        String temp;
        String vertex;
        
        for(int i = 0; i < arr.length; i++){
            if(!(arr[i] == null)){
                
                p = arr[i].getHead();
                vertex = (String)p.getData();
                cantUse.add(vertex);
                System.out.println(vertex);

                while(p.next != null){
                    temp = (String)p.getNext().getData();
                    if(!(cantUse.contains(temp))){
                        System.out.println(temp);
                    }

                p = p.getNext();
                }
            }
   
        }

    }
    
    public static void main(String[] args){
        
        /*
        19 was inputted into the constructor of the Graph instance in order to properly
        incorporate the hashing algorithm, the greater the size of the array, the lower 
        the probabilty of two cities having the same vertex. 
        */
        
        Graph adj = new Graph();
        
        adj.addEdge("Canyon Lake", "Sun City");
        adj.addEdge("Canyon Lake", "Lake Elsinore");
        adj.addEdge("Sun City", "Canyon Lake");
        adj.addEdge("Sun City", "Menifee");
        adj.addEdge("Lake Elsinore", "Canyon Lake");
        adj.addEdge("Lake Elsinore", "Murrieta");
        adj.addEdge("Murrieta", "Lake Elsinore");
        adj.addEdge("Murrieta", "Temecula");
        adj.addEdge("Murrieta", "Menifee");
        adj.addEdge("Menifee", "Sun City");
        adj.addEdge("Menifee", "Murrieta");
        adj.addEdge("Menifee", "Temecula");
        adj.addEdge("Temecula", "Murrieta");
        adj.addEdge("Temecula", "Menifee");
        
        adj.printTable();
        
        System.out.println("\nTraversal starting off at the first index: \n");
        
        adj.depthFirstTraversal(0);
       
    }
    
}
