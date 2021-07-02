package com.personal.development.learning.zCheck;

import java.util.ArrayList;
import java.util.List;

public class ListCheck {
		
		public void leastCreate(List<Integer> list) {
			listUpdate(list, 10);
			System.out.println("Inside LeastCreate");
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i) + " ");
			}
		}
		
		public void listUpdate(List<Integer> list, int size) {
			if (size < 0) {
				return;
			}
			list.add(size);
			listUpdate(list, --size);
		}
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		ListCheck listCheck = new ListCheck();
		listCheck.leastCreate(list);
		
		System.out.println("Outside LeastCreate");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i) + " ");
		}
	}
}
