package com.example.javaeedemo.mockito;

import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class T1 {

	@Test
	void t1() {
		List list = mock(List.class);
		list.add("one");
		list.clear();

		verify(list).add("one");
		verify(list).clear();
	}

	@Test
	void t2() {
		LinkedList list = mock(LinkedList.class);
		when(list.get(0)).thenReturn("first");
		when(list.get(1)).thenThrow(new RuntimeException());

		log.info("{}", list.get(0));
		log.info("{}", list.get(1));
		log.info("{}", list.get(999));

		verify(list).get(0);
	}

	@Test
	void t3() {
		LinkedList list = mock(LinkedList.class);
		when(list.get(anyInt())).thenReturn("element");

		log.info("{}", list.get(999));

		verify(list).get(anyInt());
	}
}
