import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ToStringTest {

    @Test
    void whenClassToStringCalled_shouldPrintBuilder() {
        Clazz clazz = Clazz.builder().build();
        assertThat(clazz.toString()).isEqualTo("\nClazz clazz = Clazz.builder().build()");
    }

    @Test
    void whenClassWithStringProp_shouldPrintBuilder() {
        Clazz clazz = Clazz.builder().build();
        clazz.stringProp = "stringPropValue";
        assertThat(clazz.toString()).isEqualTo("\nClazz clazz = Clazz.builder()" +
                "\n.stringProp(\"stringPropValue\")" +
                ".build()");
    }

    @Test
    void whenClassWithIntegerProp_shouldPrintBuilder() {
        Clazz clazz = Clazz.builder().build();
        clazz.integerProp = 123;
        assertThat(clazz.toString()).isEqualTo("\nClazz clazz = Clazz.builder()" +
                "\n.integerProp(123)" +
                ".build()");
    }

    @Test
    void whenClassWithIntProp_shouldPrintBuilder() {
        Clazz clazz = Clazz.builder().build();
        clazz.intProp = 123;
        assertThat(clazz.toString()).isEqualTo("\nClazz clazz = Clazz.builder()" +
                "\n.intProp(123)" +
                ".build()");
    }

    @Test
    void whenClassWithIntegerArr_shouldPrintBuilder() {
        Clazz clazz = Clazz.builder().build();
        clazz.integerArrProp = Arrays.array(123);
        assertThat(clazz.toString()).isEqualTo("\nClazz clazz = Clazz.builder()" +
                "\n.integerArrProp(Arrays.array(123))" +
                ".build()");
    }

    @Test
    void whenClassWithSet_shouldPrintBuilder() {
        Clazz clazz = Clazz.builder().build();
        clazz.setProp = Set.of(123);

        assertThat(clazz.toString()).isEqualTo("\nSet _set = Set.of();" +
                "\n_set.add(123);" +
                "\nClazz clazz = Clazz.builder()" +
                "\n.setProp(_set)" +
                ".build()");
    }

    @Test
    void whenClassWithMap_shouldPrintBuilder() {
        Clazz clazz = Clazz.builder().build();
        clazz.mapProp = Map.of(123, "ab");
        assertThat(clazz.toString()).isEqualTo("\nMap _map = Map.of();" +
                "\n_map.put(123,\"ab\");" +
                "\nClazz clazz = Clazz.builder()" +
                "\n.mapProp(_map)" +
                ".build()");
    }

    @Test
    void whenClassWithList_shouldPrintBuilder() {
        Clazz clazz = Clazz.builder().build();
        clazz.listProp = List.of("ab");
        assertThat(clazz.toString()).isEqualTo("\nList _list = List.of();" +
                "\n_list.add(\"ab\");" +
                "\nClazz clazz = Clazz.builder()" +
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
                "\nClazz clazz = Clazz.builder()" +
                "\n.collection(_list)" +
                ".build()");
    }

    @Test
    void whenClassWithIntArr_shouldPrintBuilder() {
        Clazz clazz = Clazz.builder().build();
        clazz.intArrProp = new int[]{123};
        assertThat(clazz.toString()).isEqualTo("\nClazz clazz = Clazz.builder()" +
                "\n.intArrProp(new int[]{123})" +
                ".build()");
    }

    @Test
    void whenClassWithAllProps_shouldPrintBuilder() {
        Clazz clazz = ClazzFactory.buildClazzWithAllProps();
        assertThat(clazz.toString()).isEqualTo("\n" +
                "List _list = List.of();\n" +
                "_list.add(\"aa\");\n" +
                "_list.add(\"bb\");\n" +
                "Map _map = Map.of();\n" +
                "_map.put(123,\"ab\");\n" +
                "Set _set = Set.of();\n" +
                "_set.add(123);\n" +
                "Clazz clazz = Clazz.builder()\n" +
                ".booleanProp(true)\n" +
                ".doubleProp(1.1)\n" +
                ".intArrProp(new int[]{123})\n" +
                ".integerArrProp(Arrays.array(111))\n" +
                ".integerProp(123)\n" +
                ".intProp(123)\n" +
                ".listProp(_list)\n" +
                ".mapProp(_map)\n" +
                ".setProp(_set)\n" +
                ".stringProp(\"aa\").build()");
    }


    @Test
    void name() {
        System.out.println("buildClazz() = " + ClazzFactory.buildClazzWithAllProps().toString());
    }
}
