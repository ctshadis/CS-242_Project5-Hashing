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
        int collisionCount = 0;
        int hashVal = item.hashCode();
        if(statusTable[hashVal] == Status.EMPTY) {
        	dataTable[hashVal] = item;
        	statusTable[hashVal] = Status.OCCUPIED;
        }
        else { //index is occupied - COLLISION
        	collisionCount++;
        	for(int i = 1; i <= ((TABLESIZE - 1)/2) % TABLESIZE; i++) {
        		hashVal = myMod(hashVal);
        		if (statusTable[myMod(hashVal - i*i)] == Status.EMPTY) {
        			dataTable[myMod(hashVal-i*i)] = item;
                	statusTable[myMod(hashVal-i*i)] = Status.OCCUPIED;
                	return collisionCount;
        		}
        		else { // COLLISION AT -I^2
        			collisionCount++;
        			if (statusTable[myMod(hashVal + i*i)] == Status.EMPTY) {
            			dataTable[myMod(hashVal+i*i)] = item;
                    	statusTable[myMod(hashVal+i*i)] = Status.OCCUPIED;
                    	return collisionCount;
                    	
            		}
        			else collisionCount++;
        		}
        	}
        }
        return collisionCount;
        	
     }


    /**
	 * @param item element to be searched in the dictionary
	 * @param count number of element-to-element comparisons made for this search
	 * @return the object if found; null otherwise
	 */
    public E search(E item, IntObject count) {
      int hashVal = item.hashCode();
      if (statusTable[hashVal] == Status.EMPTY) return null;
      else {//hash is either occupied or deleted.
    	  if (statusTable[hashVal] != Status.DELETED) count.setData(count.getData()+1); //DEFINITELY DOING AT LEAST ONE COMPARISON
    	  if (dataTable[hashVal].equals(item)) {//THAT ONE COMPARISON WE JUST COUNTED
    		  return item;
    	  }
    	  else {//item in hash does not match
    		  for(int i = 1; i <= ((TABLESIZE - 1)/2) % TABLESIZE; i++) { //MOVE TO THE HASH SEQUENCE
          		hashVal = myMod(hashVal);
          		if (statusTable[myMod(hashVal - i*i)] == Status.EMPTY) {
          			return null; //NO COMPARISON
          		}
          		else{ // COMPARISON AT -I^2
          			if(statusTable[myMod(hashVal - i*i)] != Status.DELETED)count.setData(count.getData() + 1); //COMPARISON AT THE OCCUPIED 
          			if (dataTable[myMod(hashVal - i*i)].equals(item)) {	//match
          				return item;          			
              		}
          			else {
          				if (statusTable[myMod(hashVal + i*i)] == Status.EMPTY) {
                  			return null;
                  		}
                  		else{ // COMPARISON AT +I^2
                  			if(statusTable[myMod(hashVal + i*i)] != Status.DELETED) count.setData(count.getData() + 1);
                  			if (dataTable[myMod(hashVal + i*i)].equals(item)) {	//match
                  				return item;          			
                      		}
                  			//else count.setData(count.getData() + 1);
                  		}
          			}	
          		}
    		  }
    	  }
    	  return null;
      }
      
    }  // search(...)

    /**
	 * @param item element to be deleted from the dictionary
	 * @param count number of element-to-element comparisons made for this deletion
	 * @return the object if found and deleted; null otherwise
	 */
	public E delete(E item, IntObject count) {
		int hashVal = item.hashCode();
		E result = null;
		if (statusTable[hashVal] == Status.EMPTY) {
			return null;
		}
		else {// hash is either occupied or deleted. DOING AT LEAST ONE COMPARISON
			if(statusTable[hashVal] != Status.DELETED) count.setData(count.getData() + 1);
			if (dataTable[hashVal] != null && dataTable[hashVal].equals(item)) {//comparison
				result = item;
				dataTable[hashVal] = null;
				statusTable[hashVal] = Status.DELETED;
				return result;
			} else {// item in hash does not match

				for (int i = 1; i <= ((TABLESIZE - 1) / 2) % TABLESIZE; i++) {
					
					hashVal = myMod(hashVal);
					if (statusTable[myMod(hashVal - i * i)] == Status.EMPTY) {
						return null;
					} else { // COMPARISON AT -I^2
						if (statusTable[myMod(hashVal - i*i)] != Status.DELETED) count.setData(count.getData()+1);
						if (dataTable[myMod(hashVal - i * i)] != null && dataTable[myMod(hashVal - i * i)].equals(item)) { // match
							result = item;
							dataTable[hashVal - i * i] = null;
							statusTable[hashVal - i * i] = Status.DELETED;
							return result;
						} else {
							if (statusTable[myMod(hashVal + i * i)] == Status.EMPTY) {
								return null;
							} else { // COMPARISON AT +I^2
								if (statusTable[myMod(hashVal + i*i)] != Status.DELETED) count.setData(count.getData()+1);
								if (dataTable[myMod(hashVal + i * i)] != null && dataTable[myMod(hashVal + i * i)].equals(item)) {
									result = item;
									dataTable[hashVal + i * i] = null;
									statusTable[hashVal + i * i] = Status.DELETED;
									return result;
								} 

							}
						}
					}
				}
			}
			return null;
		}

	}
} // delete (...)
