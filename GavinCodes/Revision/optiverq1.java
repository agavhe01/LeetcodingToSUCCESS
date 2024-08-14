import java.util.*;

public class optiverq1{

   
    public void processIntructions(String[] comms){
        for (String com : comms){
            String[] args = com.split(" ");
            String instr = args[0];

            if (instr.compareTo("CustomerEnter") == 0){
                customerEnter(Integer.valueOf(args[1]), Integer.valueOf(args[2]), Integer.valueOf(args[3]));
            }
            else if (instr.compareTo("LinesService") == 0){
                linesService();
            }
            else if (instr.compareTo("LineService") == 0){
                lineService(Integer.valueOf(args[1]),  Integer.valueOf(args[2]));
            }
            else if (instr.compareTo("BasketChange") == 0){
                basketChange(Integer.valueOf(args[1]),  Integer.valueOf(args[2]));
            }
            else System.out.println("Error Command:" + instr);
        }
    }

    Map<Integer, LinkedHashSet<Customer>> allQueues;
    Map<Integer, Customer> allCustomers;
    int numQueues;

    public optiverq1(){
        this.allQueues = new HashMap<>();
        this.allCustomers = new HashMap<>();
    }


            class Customer{

                    public int customerID;
                    public int numItems;
                    public int queueEntered;
                    public int numProcessedItems;

                    public Customer(int customerID, int queueEntered, int numItems){
                        this.customerID = customerID;
                        this.numItems = numItems;
                        this.queueEntered = queueEntered;
                        this.numProcessedItems = 0;
                    }
            }
   

    public void customerEnter(int id, int lineNumber, int numItems){
        Customer newCust = new Customer(id, lineNumber, numItems);
        allCustomers.put(id, newCust);
        LinkedHashSet<Customer> queue;

        if (! allQueues.containsKey(lineNumber) ) queue = new LinkedHashSet<Customer>();
        else queue = allQueues.get(lineNumber);
            
        queue.add(newCust);
        allQueues.put(lineNumber, queue);
    }

    public void basketChange(int customerId, int newNumItems){
        Customer theCust = allCustomers.get(customerId);
        LinkedHashSet<Customer> theQueue = allQueues.get(theCust.queueEntered);

        theCust.numItems = newNumItems;
        theQueue.remove(theCust);
        theQueue.add(theCust);

    }

     public void lineService(int lineNumber, int numProcessed){
        LinkedHashSet<Customer> theQueue = allQueues.get(lineNumber);
        ArrayList<Customer> qIterator = new ArrayList<Customer>(theQueue);

        for(Customer c : qIterator){
            c.numProcessedItems += numProcessed;
            if (c.numProcessedItems >= c.numItems) {
                customerExit(c.customerID);
                theQueue.remove(c);
                allCustomers.remove(c.customerID);
                
            }
        }
    }

    public void linesService(){
        for(int i = 0; i < this.numQueues; i++) lineService(i + 1, 1);
    }

    public void customerExit(int id){
        System.out.println("Customer ID: " + id + " has exited the store");
    }



    public static void main(String[] args){
        optiverq1 sol = new optiverq1();

        String[] commands = {"CustomerEnter 123 1 5", "CustomerEnter 2 2 3", "LinesService", "CustomerEnter 3 1 2", "LineService 1 6"};

        sol.processIntructions(commands);






    }


}