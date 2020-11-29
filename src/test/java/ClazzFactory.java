import org.assertj.core.util.Arrays;

import java.util.Map;
import java.util.Set;

import static java.util.Arrays.asList;

public class ClazzFactory {

    public static Clazz buildClazzWithAllProps() {
        Set<Integer> source = Set.of(123);
        Map<Integer, String> sourceMap = Map.of(123, "ab");
        return Clazz.builder()
                .intProp(123)
                .listProp(asList("aa", "bb"))
                .mapProp(sourceMap)
                .setProp(source)
                .boolProp(false)
                .booleanProp(true)
                .doubleProp(1.1)
                .stringProp("aa")
                .integerProp(123)
                .integerArrProp(Arrays.array(111))
                .intArrProp(new int[]{123}).build();
    }}
