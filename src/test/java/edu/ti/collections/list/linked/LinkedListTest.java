package edu.ti.collections.list.linked;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {
    @Test
    public void testNewEmptyListIsEmpty() {
        LinkedList linkedList = new LinkedList();
        assertTrue(linkedList.isEmpty());
    }

    @Test
    public void testNewNotEmptyListIsNotEmpty() {
        Integer i14 = new Integer(14);
        LinkedList linkedList = new LinkedList(i14);
        assertFalse(linkedList.isEmpty());
    }

    @Test
    public void testInsertTwoObjectsGivesCorrectSize() {
        Integer i12 = new Integer(12);
        Integer j37 = new Integer(37);
        LinkedList linkedList = new LinkedList(i12);
        linkedList.insert(j37);
        assertEquals(2, linkedList.size());
    }

    @Test
    public void testAppendTwoObjectsGivesCorrectSize() {
        Integer i12 = new Integer(12);
        Integer j37 = new Integer(37);
        LinkedList linkedList = new LinkedList(i12);
        linkedList.append(j37);
        assertEquals(2, linkedList.size());
    }

    @Test
    public void testGetTooBigReturnsNull() {
        Integer i12 = new Integer(12);
        Integer j37 = new Integer(37);
        LinkedList linkedList = new LinkedList(i12);
        linkedList.append(j37);
        assertNull(linkedList.get(2));
    }

    @Test
    public void testInsertTwoObjectsCorrectOrder() {
        Integer i12 = new Integer(12);
        Integer j37 = new Integer(37);
        LinkedList linkedList = new LinkedList(i12);
        linkedList.insert(j37);
        Integer first = (Integer) linkedList.get(0);
        assertEquals(j37, first);
        Integer second = (Integer) linkedList.get(1);
        assertEquals(i12, second);
    }

    @Test
    public void testAppendTwoObjectsCorrectOrder() {
        Integer i12 = new Integer(12);
        Integer j37 = new Integer(37);
        LinkedList linkedList = new LinkedList(i12);
        linkedList.append(j37);
        Integer first =  (Integer)linkedList.get(0);
        assertEquals(i12, first);
        Integer second = (Integer) linkedList.get(1);
        assertEquals(j37, second);
    }

    @Test
    public void testDeleteCorrectElementByPosition() {
        Integer i12 = new Integer(12);
        Integer j37 = new Integer(37);
        LinkedList linkedList = new LinkedList(i12);
        linkedList.insert(j37);
        Integer actualInteger = (Integer) linkedList.remove(0);
        assertEquals(j37, actualInteger);
        assertEquals(1, linkedList.size());
        assertEquals(i12, linkedList.get(0));
    }

    @Test
    public void testDeleteCorrectElementByObject() {
        Integer i12 = new Integer(12);
        Integer j37 = new Integer(37);
        LinkedList linkedList = new LinkedList(i12);
        linkedList.insert(j37);
        Integer actualInteger = (Integer) linkedList.remove(i12);
        assertEquals(i12, actualInteger);
        assertEquals(1, linkedList.size());
        assertEquals(j37, linkedList.get(0));
    }
}