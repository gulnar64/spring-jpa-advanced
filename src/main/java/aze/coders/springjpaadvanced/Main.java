package aze.coders.springjpaadvanced;

import lombok.SneakyThrows;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class Main {
    List<Object> list = new ArrayList<Object>();

    public static void main(String[] args) {
        Main main = new Main();
        for (int i = 0; i < 1000000000; i++) {
            ReferenceQueue referenceQueue =  new ReferenceQueue<>();
            PhantomReference phantomReference = new PhantomReference(new Object(), referenceQueue);
            System.out.println(phantomReference.enqueue());
            System.out.println(referenceQueue.poll());
            System.out.println(phantomReference.enqueue());
            System.out.println(referenceQueue.poll());
            main.list.add(phantomReference);
            if (i / 10000 == 0) {
                System.out.println("before: " + ((PhantomReference) main.list.get(i)).get());
                System.gc();
                System.out.println("after: " + ((PhantomReference) main.list.get(i)).get());
            }
        }
    }

    /*\

    Strong ne Object
    Soft direnende silir
    Weak
    Phantom
     */
}
