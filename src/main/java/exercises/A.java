package exercises;

import java.util.Arrays;

/*
 * Array like type that only restricts API
 * to get and set operations. User needs to
 * use sentinel value to identify end of array.
 */
public class A<T> {
    private final Object[] underlying;
    public A(int size) {
        this.underlying = new Object[size];
    }

    /*
     * Returns array element at index i.
     */
    public T get(int i) {
        return (T) underlying[i];
    }

    /*
     * Sets element at index i to value v.
     */
    public void set(int i, T v) {
        underlying[i] = v;
    }

    /*
     * Helper to create an `A` from an array.
     * Will create an `A` with a size of the
     * input array + 1, to allow the last element
     * to indicate the end of the array.
     *
     * e.g. {1,2,3} => {1,2,3,null}
     */
    public static <T> A<T> of(T...ts) {
        final A<T> a = new A<>(ts.length + 1);
        for (int i = 0; i < ts.length; i++) {
            a.set(i, ts[i]);
        }
        return a;
    }

    /*
     * Helper function to create an `A` from an
     * array of java primitive ints.
     */
    public static A<Integer> of(int[] is) {
        return A.of(Arrays.stream(is).boxed().toArray(Integer[]::new));
    }

    public static void main(String[] args) {
        //Create an `A` from int[].
        A<Integer> a = A.of(new int[]{1, 2, 3, 4, 5, 6});

        //Iterate through array, checking for null as termination condition.
        for (int i = 0; a.get(i) != null; i++) {
            System.out.println(a.get(i));
        }

        //Create an `A` via variadic arguments
        A<Integer> b = A.of(7, 8, 9, 10);

        //Iterate through array, checking for null as termination condition.
        for (int i = 0; b.get(i) != null; i++) {
            System.out.println(b.get(i));
        }
    }
}
