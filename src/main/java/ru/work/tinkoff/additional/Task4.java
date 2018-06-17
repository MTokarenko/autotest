package ru.work.tinkoff.additional;

import java.util.*;

public class Task4 {
    public static void main(String[] args) {
        ObjectA cur = new ObjectA(1, "s", "ss");
        ObjectA cur1 = new ObjectA(1, "string", "ss");
        ObjectA cur2 = new ObjectA(1, "s", "sort");
        ObjectA ref = new ObjectA(1, "s", "ss");
        ObjectA ref2 = new ObjectA(1, "s", "ss");
        ObjectA ref3 = new ObjectA(2, "s", "ss");

        List<ObjectA> current = Arrays.asList(cur, cur1, cur2);
        List<ObjectA> reference = Arrays.asList(ref, ref2, ref3);
        compareCollections(current, reference);
    }

    public static boolean compareCollections(List<ObjectA> current, List<ObjectA> reference) {
        if (!current.equals(reference)) {
            List<T> err = new ArrayList<>();
            for(int i = 0; i < current.size(); i++){
                if(!current.get(i).equals(reference.get(i))){
                    err.add(new T(current.get(i), reference.get(i)));
                }
            }
            for (T t : err) {
                System.out.println(t);
            }
        }
        return true;
    }

    static class ObjectA {

        int id;
        String name;

        public ObjectA(int id, String name, String value) {
            this.id = id;
            this.name = name;
            this.value = value;
        }

        String value;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ObjectA)) return false;
            ObjectA objectA = (ObjectA) o;
            return id == objectA.id &&
                    Objects.equals(name, objectA.name) &&
                    Objects.equals(value, objectA.value);
        }

        @Override
        public int hashCode() {

            return Objects.hash(id, name, value);
        }

        @Override
        public String toString() {
            return "ObjectA{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    static class T {
        ObjectA o1;
        ObjectA o2;

        public T(ObjectA o1, ObjectA o2) {
            this.o1 = o1;
            this.o2 = o2;
        }

        @Override
        public String toString() {
            return o1 +", " + o2;
        }
    }
}
