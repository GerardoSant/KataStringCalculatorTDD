import static java.lang.Integer.parseInt;

public class Calculator {


    private final String delimiter = ",|\n";

    public int calculate(String input) throws Exception {
        return isEmpty(input) ? 0 : isSingleNumber(input) ? stringToInt(input) : getSum(input);
    }

    private boolean isSingleNumber(String input) {
        return input.length()==1;
    }

    private int getSum(String input) throws Exception {
        String[] numbers = input.split(delimiter);
        checkForNegativeNumbers(numbers);
        return calculateSum(numbers);
    }

    private int calculateSum(String[] numbers) {
        int sum=0;
        for (String number : numbers){
            if (!numberIsGreaterThan1000(number)){
                sum += stringToInt(number);
            }
        }
        return sum;
    }

    private void checkForNegativeNumbers(String[] numbers) throws Exception {
        for (String number : numbers){
            if (numberIsNegative(number)) throw new Exception("Negative input");
        }
    }

    private boolean numberIsGreaterThan1000(String number) {
        return (stringToInt(number)>1000);
    }

    private boolean numberIsNegative(String number) {
        return stringToInt(number)<0;
    }


    private boolean isEmpty(String input){
        return input.isEmpty();
    }

    private int stringToInt(String input){
        return parseInt(input);
    }
}
