// Implementation of closing hashing with linear probing.
// The probe sequence is defined by h(k), h(k) + 1, h(k) + 2, ... all
// modulus table size.

enum Status {EMPTY, OCCUPIED, DELETED};
public class LinearProbing <E> implements DictionaryADT<E> {

	private E[] dataTable;
    private Status[] statusTable;
    final private int TABLESIZE = 300151;

    @SuppressWarnings("unchecked")
    public LinearProbing() {
          dataTable = (E[])new Object[TABLESIZE];
          statusTable = new Status[TABLESIZE];
          for (int i = 0; i < TABLESIZE; i++)
             statusTable[i] = Status.EMPTY;
    }

    /**
     * @param item element to be inserted into the dictionary
     * @return number of collisions encountered during this insert
    */
    public int insert(E item) {
        // TO BE IMPLEMENTED BY THE STUDENT
        return 0;  // TO KEEP THE COMPILER HAPPY.  DELETE IT WHEN DONE
      }  // int insert(...)

    /**
	 * @param item element to be searched in the dictionary
	 * @param count number of element-to-element comparisons made for this search
	 * @return the object if found; null otherwise
	 */
    public E search(E item, IntObject count) {
        // TO BE IMPLMENTED BY THE STUDENT
        return null;  // to keep the crazy compiler happy
    }  // search(...)

    /**
	 * @param item element to be deleted from the dictionary
	 * @param count number of element-to-element comparisons made for this deletion
	 * @return the object if found and deleted; null otherwise
	 */
    public E delete(E item, IntObject count) {
    	// TO BE IMPLEMENTED BY THE STUDENT
        return null;  // to keep the crazy compiler happy
    }  // delete(...)
}