import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Calculator {


    private final String delimiter = ",|\n";

    public int calculate(String input) throws Exception {
        if (isEmpty(input)) return 0;
        verifyThereIsntNegativeNumbers(input);
        return getSum(input);
    }

    private boolean isEmpty(String input){
        return input.isEmpty();
    }

    private void verifyThereIsntNegativeNumbers(String input) throws Exception {
        for (String number : getNumbers(input)){
            if(numberIsNegative(number)) throw new Exception();
        }
    }


    public int getSum(String input) {
        return getNumbers(input).stream()
                .filter(this::numberIsSmallerThan1000)
                .map(this::stringToInt)
                .reduce(0,(sum,number)->sum + number);
    }

    private boolean numberIsNegative(String number) {
        return stringToInt(number) <0;
    }


    private List<String> getNumbers(String input) {
        return new ArrayList<>(Arrays.asList(input.split(delimiter)));
    }


    private boolean numberIsSmallerThan1000(String number) {
        return stringToInt(number)<1000;
    }

    private int stringToInt(String input){
        return parseInt(input);
    }
}
