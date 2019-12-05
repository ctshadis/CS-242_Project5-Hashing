// Implementation of Open Hashing also known as
// hashing by chaining.  Each chain is implemented
// using Java's LinkedList.

import java.util.LinkedList;

public class OpenHashing <E> implements DictionaryADT <E>{

	private Object [] dataChain;
    final private int TABLESIZE = 300151;

    @SuppressWarnings("unchecked")
    public OpenHashing() {
          dataChain = new Object [TABLESIZE];
          for (int i = 0; i < TABLESIZE; i++)
             dataChain[i] = new LinkedList<E>();
    }

    /**
     * @param item to be inserted into the hash table
     * @return the number of collisions for this insert
     */
    @SuppressWarnings("unchecked")
    public int insert(E item) {
        int hashVal = item.hashCode();
        if (((LinkedList)dataChain[hashVal]).isEmpty()) {
        	((LinkedList)dataChain[hashVal]).addFirst(item);
        	return 0;
        }
        else {
        	if(((LinkedList)dataChain[hashVal]).contains(item)){
        		return 0;
        	}
        	else {
        		((LinkedList)dataChain[hashVal]).addLast(item);
        		return 1;
        	}
        }
    }  // int insert(...)

    /**
     * @param item element to be searched in the hash table
     * @param count the number of element-to-element comparisons
     * made for this search
     * @return the object if found; null if the search is unsuccessful
     */
    @SuppressWarnings("unchecked")
    public E search(E item, IntObject count) {
        int hashVal = item.hashCode();
        if(((LinkedList)dataChain[hashVal]).contains(item)) {
        	count.setData(((LinkedList)dataChain[hashVal]).indexOf(item) + 1);
        	return item;
        	
        }
        else {
        	count.setData(((LinkedList)dataChain[hashVal]).size());
        	return null;
        }
    }
      // search(...)

    /**
	 * @param item element to be deleted from the dictionary
	 * @param count number of element-to-element comparisons made for this deletion
	 * @return the object if found and deleted; null otherwise
	 */
    public E delete(E item, IntObject count) {
    	int hashVal = item.hashCode();
        if(((LinkedList)dataChain[hashVal]).contains(item)) {
        	count.setData(((LinkedList)dataChain[hashVal]).indexOf(item) + 1);
        	((LinkedList)dataChain[hashVal]).remove(item);
        	return item;
        }
        else {
        	count.setData(((LinkedList)dataChain[hashVal]).size());
        	return null;
        }
        
        }  // delete (...)
    }
