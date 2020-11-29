import lombok.Builder;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ToStringTest {
    @Test
    void whenClassToStringCalled_shouldPrintBuilder() {
        Clazz clazz = Clazz.builder().build();
        assertThat(clazz.toString()).isEqualTo("\nClazz.builder().build()");
    }

    @Test
    void whenClassWithStringProp_shouldPrintBuilder() {
        Clazz clazz = Clazz.builder().build();
        clazz.stringProp = "stringPropValue";
        assertThat(clazz.toString()).isEqualTo("\nClazz.builder()" +
                "\n.stringProp(\"stringPropValue\")" +
                ".build()");
    }

    @Test
    void whenClassWithIntegerProp_shouldPrintBuilder() {
        Clazz clazz = Clazz.builder().build();
        clazz.integerProp = 123;
        assertThat(clazz.toString()).isEqualTo("\nClazz.builder()" +
                "\n.integerProp(123)" +
                ".build()");
    }

    @Test
    void whenClassWithIntProp_shouldPrintBuilder() {
        Clazz clazz = Clazz.builder().build();
        clazz.intProp = 123;
        assertThat(clazz.toString()).isEqualTo("\nClazz.builder()" +
                "\n.intProp(123)" +
                ".build()");
    }

    @Test
    void whenClassWithIntegerArr_shouldPrintBuilder() {
        Clazz clazz = Clazz.builder().build();
        clazz.integerArrProp = Arrays.array(123);
        assertThat(clazz.toString()).isEqualTo("\nClazz.builder()" +
                "\n.integerArrProp(Arrays.array(123))" +
                ".build()");
    }

    @Test
    void whenClassWithSet_shouldPrintBuilder() {
        Clazz clazz = Clazz.builder().build();
        clazz.setProp = Set.of(123);

        assertThat(clazz.toString()).isEqualTo("\nSet _set = Set.of();" +
                "\n_set.add(123);" +
                "\nClazz.builder()" +
                "\n.setProp(_set)" +
                ".build()");
    }

    @Test
    void whenClassWithMap_shouldPrintBuilder() {
        Clazz clazz = Clazz.builder().build();
        clazz.mapProp = Map.of(123, "ab");
        assertThat(clazz.toString()).isEqualTo("\nMap _map = Map.of();" +
                "\n_map.put(123,\"ab\");" +
                "\nClazz.builder()" +
                "\n.mapProp(_map)" +
                ".build()");
    }

    @Test
    void whenClassWithList_shouldPrintBuilder() {
        Clazz clazz = Clazz.builder().build();
        clazz.listProp = List.of("ab");
        assertThat(clazz.toString()).isEqualTo("\nList _list = List.of();" +
                "\n_list.add(\"ab\");" +
                "\nClazz.builder()" +
                "\n.listProp(_list)" +
                ".build()");
    }

    @Test
    void whenClassWithCustomCollection_shouldPrintBuilder() {
        Clazz clazz = Clazz.builder().build();
        clazz.collection = new CustomCollection();
        clazz.collection.add("ab");
        assertThat(clazz.toString()).isEqualTo("\nCustomCollection _list = new CustomCollection ();" +
                "\n_list.add(\"ab\");" +
                "\nClazz.builder()" +
                "\n.collection(_list)" +
                ".build()");
    }

    @Test
    void whenClassWithIntArr_shouldPrintBuilder() {
        Clazz clazz = Clazz.builder().build();
        clazz.intArrProp = new int[]{123};
        assertThat(clazz.toString()).isEqualTo("\nClazz.builder()" +
                "\n.intArrProp(new int[]{123})" +
                ".build()");
    }

    @Builder
    static class Clazz {
        public int intProp;
        public Set<Integer> setProp;
        public List<String> listProp;
        String stringProp;
        Integer integerProp;
        Double doubleProp;
        Boolean booleanProp;
        Integer[] integerArrProp;
        int[] intArrProp;
        boolean boolProp;
        Map<Integer, String> mapProp;
        CustomCollection collection;

        @Override
        public String toString() {
            String s = "";
            String p = "";
            if (intProp != 0)
                s += "\n." + "intProp" + "(" + intProp + ")";
            if (setProp != null) {
                p += "\nSet _set = Set.of();";
                for (Object o : setProp)
                    p += "\n_set.add(" + o + ");";
                s = "\n." + "setProp" + "(_set)";
            }
            if (listProp != null) {
                p += "\nList _list = List.of();";
                for (Object o : listProp)
                    p += o instanceof String ? "\n_list.add(\"" + o + "\");" : "\n_list.add(" + o + ");";
                s = "\n." + "listProp" + "(_list)";
            }
            if (stringProp != null)
                s += "\n." + "stringProp" + "(\"" + stringProp + "\")";
            if (integerProp != null)
                s += "\n." + "integerProp" + "(" + integerProp + ")";
            if (doubleProp != null)
                s += "\n." + "doubleProp" + "(" + doubleProp + ")";
            if (booleanProp != null)
                s += "\n." + "booleanProp" + "(" + booleanProp + ")";
            if (integerArrProp != null)
                if (integerArrProp != null && integerArrProp.length > 0) {
                    String s1 = "\n." + "integerArrProp" + "(Arrays.array(";
                    for (Object object : integerArrProp)
                        s1 += object.toString() + ",";
                    s += s1.substring(0, s1.length() - 1) + "))";
                }

            if (intArrProp != null && intArrProp.length > 0) {
                String s1 = "\n." + "intArrProp" + "(new " + "int" + "[]{";
                for (Object object : intArrProp)
                    s1 += object.toString() + ",";
                s += s1.substring(0, s1.length() - 1) + "})";
            }
            if (boolProp)
                s += "\n." + "boolProp" + "(" + boolProp + ")";
            if (mapProp != null) {
                p += "\nMap _map = Map.of();";
                for (Map.Entry e : mapProp.entrySet()) {
                    String key = e.getKey() instanceof String ? "\"" + e.getKey() + "\"" : e.getKey().toString();
                    String value = e.getValue() instanceof String ? "\"" + e.getValue() + "\"" : e.getValue().toString();
                    p += "\n_map.put(" + key + "," + value + ");";
                }
                s = "\n." + "mapProp" + "(_map)";
            }
            if (collection != null) {
                p += "\nCustomCollection _list = new CustomCollection ();";
                for (Object o : collection)
                    p += o instanceof String ? "\n_list.add(\"" + o + "\");" : "\n_list.add(" + o + ");";
                s = "\n." + "collection" + "(_list)";
            }
            return p + "\nClazz" + ".builder()" + s + ".build()";
        }

    }

    @Test
    void name() {
        System.out.println("buildClazz() = " + buildClazz().toString());
    }

    Clazz buildClazz() {
        Set<Integer> source = Set.of(123);
        Map<Integer, String> sourceMap = Map.of(123, "ab");
        return Clazz.builder()
                .mapProp(sourceMap)
                .setProp(source)
                .boolProp(false)
                .booleanProp(true)
                .doubleProp(1.1)
                .stringProp("aa")
                .integerProp(123)
                .integerArrProp(Arrays.array(111))
                .intArrProp(new int[]{123}).build();
    }

    public String method(int i, String s, int[] arr) {
        return null;
    }

    static class CustomCollection implements Collection {
        List list = new ArrayList();

        @Override
        public int size() {
            return list.size();
        }

        @Override
        public boolean isEmpty() {
            return list.isEmpty();
        }

        @Override
        public boolean contains(Object o) {
            return list.contains(o);
        }

        @Override
        public Iterator iterator() {
            return list.iterator();
        }

        @Override
        public Object[] toArray() {
            return list.toArray();
        }

        @Override
        public boolean add(Object o) {
            return list.add(o);
        }

        @Override
        public boolean remove(Object o) {
            return list.remove(o);
        }

        @Override
        public boolean addAll(Collection c) {
            return list.addAll(c);
        }

        @Override
        public void clear() {
            list.clear();
        }

        @Override
        public boolean retainAll(Collection c) {
            return list.retainAll(c);
        }

        @Override
        public boolean removeAll(Collection c) {
            return list.removeAll(c);
        }

        @Override
        public boolean containsAll(Collection c) {
            return list.containsAll(c);
        }

        @Override
        public Object[] toArray(Object[] a) {
            return list.toArray(a);
        }
    }


}
