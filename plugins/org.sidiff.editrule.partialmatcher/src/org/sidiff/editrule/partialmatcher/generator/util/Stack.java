package org.sidiff.editrule.partialmatcher.generator.util;

import java.util.Arrays;
import java.util.Iterator;

public class Stack<T extends Object> {

	private T[] stack;
	
	private int pointer = 0;
	
	@SuppressWarnings("unchecked")
	public Stack(int capacity) {
		stack = (T[]) new Object[capacity];
	}
	
	public T[] getStack() {
		return stack;
	}
	
	public void push(T element) {
		stack[pointer] = element;
		++pointer;
	}
	
	public T pop() {
		--pointer;
		return stack[pointer];
	}
	
	public T peek() {
		return stack[pointer - 1];
	}
	
	public T get(int i) {
		return stack[i];
	}
	
	public boolean isEmpty() {
		return (pointer == 0);
	}
	
	public int size() {
		return pointer;
	}
	
	public void reset() {
		for (int i = 0; i < stack.length; ++i) {
			stack[i] = null;
		}
		pointer = 0;
	}
	
	public T[] toArray() {
		return Arrays.copyOf(stack, pointer);
	}
	
	public Iterator<T> iterator() {
		return Arrays.stream(stack).filter(e -> (e != null)).iterator();
	}
}
