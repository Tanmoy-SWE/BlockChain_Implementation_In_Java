//ID, NAME (For example, "40404040, Janet Kim")
//Put x inside [] below:
//[] 	This assignment is entirely my own work and 
// 		I have not seen anyone else's code or design
package assignment3;

//Students must ensure they complete both the addPayment and size() method to pass the other test cases.
public class Ledger {

  public Payment head;
  public int id;
  public Ledger next;

  // add attributes as needed
  // needed to implement efficient code
  // tested for `advanced' parts
  public Payment tail;

  /**
   * Default constructor
   * 
   * You may modify this constructor if you need to (e.g.
   * if you want to initialise extra attributes in the class)
   */
  public Ledger() {
    head = null;
    id = 0;
    next = null;
    tail = null;
    //
    // add initialisation of added attributes, if needed
    
  }

  /**
   * Assign an id to the current Ledger
   * 
   * @param id
   */
  public void setId(int id) {
    //
    // Provided - not to be changed
    this.id = id;
  }

  /**
   * 
   * @return the number of payments in the Ledger
   */
  public int size() {
    Payment tnode = head;
    int cnt = 0;
    while (tnode != null) {
      cnt++;
      tnode = tnode.next;
    }
    return cnt;
    //
    // TODO - 5 marks
  }
  /* Function to reverse the linked list */
  Payment reverse(Payment node)
  {
    Payment prev = null;
    Payment current = node;
    Payment next = null;
    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    node = prev;
    return node;
  }

  /**
   * Add a payment at the end of the Ledger list
   * 
   * @param payment
   */
  void printList(Payment node)
  {
    while (node != null) {
      System.out.print(node.fromPerson + " ");
      node = node.next;
    }
    System.out.println();
  }
  public void addPayment(Payment payment) {

    Payment newNode = payment;

    //checking of the list is empty

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


  }

  /**
   * A Ledger is valid if all its payments are valid:
   * i.e. their are all done between registered persons provided in the array
   * persons
   * 
   * You may assume that the input array (String[] persons) will
   * not be null or empty.
   * 
   * @param persons - array of persons who can make and receive payment
   * 
   * @return true if the Ledger is valid based on the criteria listed above,
   *         false otherwise
   */
  public boolean isValid(String[] persons) {
    //
    // TODO - 5 marks
    if(head==null){
      return true;
    }
    int cnt = 0;
    for(int i=0; i< persons.length; i++){
      System.out.println(persons[i]);
      if(persons[i]==this.head.toPerson){
        cnt++;
      }
      if(persons[i]==this.head.fromPerson){
        cnt++;
      }
    }
    if(cnt==2){
      return true;
    }
    else{
      return false;
    }
  }

  /**
   * Check whether a payment involves a particular person
   * 
   * @param person
   * @return true if person is one of the persons involved in one of the payments
   */
  public boolean contains(String person) {

    if(head==null){
      return false;
    }

    Payment tnode = head;
    int cnt = 0;
    while (tnode != null) {
      if(person.equalsIgnoreCase(tnode.fromPerson) || person.equalsIgnoreCase(tnode.toPerson)){
        return true;
      }
      tnode = tnode.next;
    }

    return false;
    //
    // TODO - 5 marks

  }

  /**
   * Provide the net payment or profit made by the person in this ledger
   * 
   * @param person involved in payment
   * @return net balance paid or received
   * 
   *         return 0 if the ledger is empty or the person not present in this
   *         ledger
   */
  public double balance(String person) {
    //
    // TODO - 8 marks
    Payment tnode = head;
    double sum = 0;
    while (tnode != null) {
      if(person.equalsIgnoreCase(tnode.fromPerson)){
        sum = sum  - tnode.amount;
      }
      if(person.equalsIgnoreCase(tnode.toPerson)){
        sum = sum +  tnode.amount;
      }
      tnode = tnode.next;
    }

    return sum;
  }

  /**
   * Reverse a payment by creating and adding a payment that reverse the transfer
   * 
   * @param paymentToReverse is the Payment node with transfer to reverse
   *                         i.e., there is an additional payment inversing the
   *                         transfer to reverse
   */
  public void reversePayment(Payment paymentToReverse) {
    if(paymentToReverse == null){
      return;
    }
    Payment new_node = new Payment(paymentToReverse.toPerson, paymentToReverse.fromPerson,
                                  paymentToReverse.amount, paymentToReverse.next);
    if (head == null) {
      head = new Payment(paymentToReverse.toPerson, paymentToReverse.fromPerson,
              paymentToReverse.amount, paymentToReverse.next);;
      return;
    }

    new_node.next = null;

    Payment last = head;
    while (last.next != null) {
      last = last.next;
    }

    last.next = new_node;
    return;
    //
    // TODO - 5 marks
    // do nothing if paymentToReverse is null


  }

  /**
   * 5 marks - Pass level
   * 
   * Remove the first Payment from the Ledger
   * 
   * @return the removed payment if there is one, null otherwise
   */
  public Payment remove() {
    printList(head);
    if (head == null) {
      return null;
    }
    Payment temp = head;
    head = head.next;
    return temp;
    //
    // TODO - 5 marks
  }

}
