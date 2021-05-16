import util.Checker;
import util.UserProgram;

import java.util.regex.Pattern;

public class BuzzChecker extends Checker {
    private static final Pattern BUZZ_NUMBER = Pattern.compile(
            "is(?<buzz>n't| not)?+( a)?+ buzz", Pattern.CASE_INSENSITIVE);
    private static final Pattern EXPLANATION = Pattern.compile(
            "divisible by 7 and it ends with 7|divisible by 7|ends with 7"
                    + "|neither divisible by 7 nor it ends with 7", Pattern.CASE_INSENSITIVE);

    private final long number;

    BuzzChecker(long number) {
        this.number = number;
        this.validator = this::test;
    }

    public boolean test(UserProgram program) {
        final var matcher = BUZZ_NUMBER.matcher(program.getOutput());
        if (!matcher.find()) {
            feedback = "You should check whether is the number is a Buzz number or not.";
            return false;
        }
        final var isDivisible = number % 7 == 0;
        final var isEndsWith7 = number % 10 == 7;
        final var isBuzz = isDivisible || isEndsWith7;
        final var actual = matcher.group("buzz") == null;

        if (actual != isBuzz) {
            feedback = "For {0} expected: \"is{1} a Buzz number\". Actual output: \"is{2} a Buzz number.";
            parameters = new Object[]{number, isBuzz ? "" : " not", matcher.group("buzz")};
            return false;
        }

        final var explanation = isBuzz ? isDivisible ? isEndsWith7
                ? "divisible by 7 and it ends with 7"
                : "divisible by 7"
                : "ends with 7"
                : "neither divisible by 7 nor it ends with 7";


        if (!matcher.usePattern(EXPLANATION).find()) {
            feedback = "The program should print an explanation by which criterion this number is a buzz number";
            return false;
        }
        if (!matcher.group().equalsIgnoreCase(explanation)) {
            feedback = "Expected explanation is \"{0}\". Actual explanation is \"{1}\".";
            parameters = new Object[]{explanation, matcher.group()};
            return false;
        }
        return true;
    }
}
