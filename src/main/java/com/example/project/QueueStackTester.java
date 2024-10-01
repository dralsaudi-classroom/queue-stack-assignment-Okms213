package com.example.project;
public class QueueStackTester {
    public static <T> void split(Queue<T> q, Queue<T> oq, Queue<T> eq)
    {
        
        // Write the recursive static method split that splits a queue of n elements into two
        // queues. The elements with odd orders (i.e. 1st, 3rd, 5th ...) should be put in the
        // first queue and elements with even orders (i.e. 2nd, 4th, 6th ...) should be put in
        // the second queue. The original queue should remain unchanged at the end of the
        // method.
        // Example. Given the queue (A, B, C, D, E), split results in oq (A, C, E), and eq(B, D).

        if(q.length() == 0)
            return;
        T d1 = q.serve(),d2 = null;
        if(q.length() != 0)
            d2 = q.serve();
        oq.enqueue(d1);
        if(d2 != null)
            eq.enqueue(d2);
        
        split(q,oq,eq);
        q.enqueue(d1);
        q.enqueue(d2);





    }
    public static <T> void remove(LinkedPQ<T> pq, int p)
    {
        // Write a static method remove that removes every element in the priority queue
        // having priority less than p.
        // Example. Given pq: [A, 10], [D, 8], [B, 5], [E, 3], [C, 2] remove(pq, 5) results in
        // pq: [A, 10], [D, 8], [B, 5].

        LinkedPQ<T> temp = new LinkedPQ<T>();
        while(pq.length() != 0){
            PQElement<T> e = pq.serve();
            if(e.p >= p)
                temp.enqueue(e.data,e.p);
        }

        while(temp.length() != 0){
            PQElement<T> e = temp.serve();
            pq.enqueue(e.data, e.p);
        }
    }
    public static <T> boolean search(Stack<T> st, T e)
    {
        
        // Write the recursive static method search that searches for an element e in a stack st
        // and returns true if it’s found or false otherwise. st should not change at the end of
        // the method. You are not allowed to use any auxiliary data structures.
        // Example. Given the stack st (top-to-bottom): 5, 7, 5, 3, 2. search(st, 3) returns
        // true while search(st, 1) returns false.

        if(st.empty())
            return false;
        
        T data = st.pop();
        if(data.equals(e))
            return true;

        
        boolean flag =  search(st,e);
        st.push(data);
        return flag;
        


    }
}