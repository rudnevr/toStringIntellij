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

    public String method(int i, String s, int[] arr, List<String> l, List<List<String>> ll) {

        return null;
    }




}
