/**
 * 
 */
package fr.obernin.eulerproject.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:obernin@gmail.com">Olivier Bernin</a>
 *
 */
public class Tree<T> {
	
	private Node<T> root;

	/**
	 * 
	 */
	public Tree(T root) {
		this.root = new Node<T>(root);
	}
	
	public Node<T> getRoot() {
		return root;
	}
	
	public int getLeafCount() {
		return getLeafCount(root);
	}
	
	private int getLeafCount(Node<T> node) {
		
		int count = 0;
		int ccount = node.getChildrenCount();
		
		if (ccount == 0) {	// This is a leaf
			count = 1;
		} else {
			for (int i=0 ; i<node.getChildrenCount() ; i++) {
				count += getLeafCount(node.getChildren(i));
			}
		}
		
		return count;
	}
	
	
	public static class Node<T> {
		
		private T content;
		private List<Node<T>> children;
		
		
		private Node(T content) {
			this.content = content;
			this.children = new ArrayList<Node<T>>(2);
		}
		
		public T getContent() {
			return content;
		}
		
		public int getChildrenCount() {
			return children.size();
		}
		
		public Node<T> getChildren(int index) {
			return children.get(index);
		}
		
		public void link(T content) {
			children.add(new Node<T>(content));
		}
	}

}
