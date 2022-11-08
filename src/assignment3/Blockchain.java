//ID, NAME (For example, "40404040, Janet Kim")
//Put x inside [] below:
//[] 	This assignment is entirely my own work and 
// 		I have not seen anyone else's code or design
package assignment3;

public class Blockchain {
  public Ledger head;
  public int LedgerCnt = 0;
  public int curr_id;

  // add attributes as needed
  // needed to implement efficient code
  // tested for 'advanced' parts
  public Ledger tail;
  
  /**
   * Default constructor
   * Create a new Blockchain which first ledger will start with the id = 0
   * 
   * You may modify this constructor if you need to (e.g.
   * if you want to initialise extra attributes in the class)
   */
  public Blockchain() {
    head = null;
    curr_id = 0;

    // add initialisation of added attributes, if needed
    
  }

  /**
   * Default constructor
   * 
   * @param id is an integer identity number
   *           Create a new Blockchain which first ledger will start with the
   *           given id
   * 
   *           You may modify this constructor if you need to (e.g.
   *           if you want to initialise extra attributes in the class)
   */
  public Blockchain(int id) {
    head = null;
    curr_id = id;
    // add initialisation of added attributes, if needed
    
  }

  /**
   * 
   * @return the number of Ledgers in the Blockchain
   */
  int size() {
    Ledger tnode = head;
    int cnt = 0;
    while (tnode != null) {
      cnt++;
      tnode = tnode.next;
    }
    return cnt;
    // TODO - 5 marks
  }

  /**
   * Add a Ledger at the end of the Blockchain list
   * 
   * @param ledger
   */
  public void addLedger(Ledger ledger) {
    //Creating a new node

    Ledger newNode = ledger;

    //checking of the list is empty
    LedgerCnt++;
    if(head == null)

    {

//if the given list is empty, making the two nodes head and tail to point to the newly created node newNode

      head = newNode;

      tail = newNode;

    }

    else

    {

//otherwise the newNode will be added after tail so that the next pointer of tail points to    the newNode

      tail.next = newNode;

      tail = newNode;

    }


    Ledger new_node = ledger;

    
  }


  /**
   * Provide the net payment or profit made by the person in this Blockchain
   * 
   * @param person involved in payment
   * @return net balance paid or received
   * 
   *         return 0 if the blockchain is empty or the person not present in this
   *         blockchain
   */
  public double balance(String person) {
    //
    // TODO - 8 marks
    Ledger tnode = head;
    double sum = 0;
    while (tnode != null) {
      sum += tnode.balance((person));
      tnode = tnode.next;
    }

    return sum;
    //
    // TODO - 8 marks
  }

  /**
   * Count the number of transactions(i.e., payments) in all ledgers from the
   * blockchain
   * 
   * @return an integer as the total number of transactions/payments,
   *         zero if there are none.
   */
  public int transactionCount() {

      if(head==null){
        return 0;
      }

      Ledger tnode = head;
      int sum = 0;
      while (tnode != null) {
        sum += tnode.size();
        tnode = tnode.next;
      }
      return sum;
  }

  /**
   * Constructor - creates a new Blockchain by combining two Blockchains
   * in order of their id
   * 
   * For this task, you need to write a constructor that creates a new
   * Blockchain object by combining two other Blockchain object,
   * b1 and b2. You must not make new ballots in the process
   * (i.e. you should transfer the Blockchain from both lists to the new one).
   * 
   * You can assume that b1 and list2 are valid Blockchains (that is,
   * all Blockchain objects in both lists are valid as defined in the assignment
   * specification), and that they are sorted according to the ledgers'ids in each
   * Blockchain's.
   * 
   * That is, the resulting Blockchain must be sorted according to the ledgers'
   * id.
   * 
   * 
   * If both b1 and b2 are empty, then construct an empty Blockchain.
   * Do the same if both lists are null. If only one of the lists are empty
   * or null, then you should return the other.
   * 
   * 
   * @param b1 - the first Blockchain
   * @param b2 - the second Blockchain
   */

  public Blockchain(Blockchain b1, Blockchain b2) {
    //
    // TODO - 8 marks + 5 marks for efficiency

    
  }

  /**
   * Constructor - creates a new Blockchain by combining all Blockchains in the
   * array of Blockchains in order of their id
   * 
   * That is, same as previous method for two blockchains
   * 
   * @param blocks is an array of valid blockchains.
   */
  public Blockchain(Blockchain[] blocks) {
    //
    // TODO - 8 marks + 5 marks for efficiency

    
  }

}
