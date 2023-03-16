public interface SelfBalancedBST {
    /**
     * @param key Takes a key and inserts it if it is not in the tree.
     * @return true if it is added and false if it already exists.
     */
    boolean insert(Object key);

    /**
     * @param key Takes a key and deletes it if it is in the tree.
     * @return true if it is deleted and false if it is not in the tree.
     */
    boolean delete(Object key);

    // Takes a key and searches for it returning true if it is found in the tree
    // and false otherwise.

    /**
     * @param key Takes a key and searches for it.
     * @return true if it is found in the tree and false otherwise.
     */
    boolean search(Object key);

    /**
     * @return the number of keys in the tree.
     */
    int size();

    /**
     * @return the height of the tree which is the longest path from the root to a leaf node.
     */
    int height();

}