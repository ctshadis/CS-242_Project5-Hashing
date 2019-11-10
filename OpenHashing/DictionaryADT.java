public interface DictionaryADT <E> {
    /**
     * @param item element to be inserted into the dictionary
     * @return number of collisions encountered during this insert
     */
	public int insert(E item);
    
	/**
	 * @param item element to be searched in the dictionary
	 * @param count number of element-to-element comparisons made for this search
	 * @return the object if found; null otherwise
	 */
	public E search(E item, IntObject count);
	
	/**
	 * @param item element to be deleted from the dictionary
	 * @param count number of element-to-element comparisons made for this deletion
	 * @return the object if found and deleted; null otherwise
	 */
    public E delete(E item, IntObject count);
}

