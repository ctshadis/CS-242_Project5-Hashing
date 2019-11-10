// Implementation of closing hashing with quadratic residue search.
// The probe sequence is defined by h(k), h(k) - i^2 1, h(k) + i^2, ...
// 1 <= i <= (tableSize - 1)/2 all modulus table size.

enum Status {EMPTY, OCCUPIED, DELETED};
public class QuadraticResidueSearch <E> {
    private E[] dataTable;
    private Status[] statusTable;
    final private int TABLESIZE = 300151;

    @SuppressWarnings("unchecked")
    public QuadraticResidueSearch () {
      dataTable = (E[])new Object[TABLESIZE];
      statusTable = new Status[TABLESIZE];
      for (int i = 0; i < TABLESIZE; i++)
         statusTable[i] = Status.EMPTY;
    }

    private int myMod(int index) {
		while (index < 0)
			index += TABLESIZE;
		return index % TABLESIZE;
    }

    /**
     * @param item element to be inserted into the dictionary
     * @return number of collisions encountered during this insert
    */
    public int insert(E item) {
      // TO BE IMPLEMENTED BY THE STUDENT
      return 0;  // DELETE IT WHEN DONE
    }  // int insert(...)

    /**
	 * @param item element to be searched in the dictionary
	 * @param count number of element-to-element comparisons made for this search
	 * @return the object if found; null otherwise
	 */
    public E search(E item, IntObject count) {
       // TO BE IMPLEMENTED BY THE STUDENT
       return null;
    }  // search(...)

    /**
	 * @param item element to be deleted from the dictionary
	 * @param count number of element-to-element comparisons made for this deletion
	 * @return the object if found and deleted; null otherwise
	 */
    public E delete(E item, IntObject count) {
        // TO BE IMPLEMENTED BY THE STUDENT
        return null;
     }  // delete (...)
}