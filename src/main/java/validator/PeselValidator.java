package validator;

public class PeselValidator {

  private int[] parameters = {9, 7, 3, 1, 9, 7, 3, 1, 9, 7};

  /**
   * Method validating PESEL number
   * @param number PESEL number
   * @return true if the character sequence represented by the argument is a real PESEL number, false otherwise
   * @throws IllegalArgumentException if the given character sequence lenght is not equal 11
   */
  public boolean validate(String number) {
    if (number.isEmpty() || number.length() != 11) {
      throw new IllegalArgumentException("Lenght error");
    }
    int result = calculateControlSumUsingParameters(number);
    return checkCotrolSum(result, convertCharToInt(number.charAt(10)));
  }

  private boolean checkCotrolSum(int sumToCheck, int validSum) {
    int modulo = sumToCheck % 10;
    return modulo == validSum;
  }

  // deprecated method, used in the first solution, refactored to a new method calculateControlSumUsingParameters
  private int calculateControlSum(String number) {
    return 9 * convertCharToInt(number.charAt(0)) +
        7 * convertCharToInt(number.charAt(1)) +
        3 * convertCharToInt(number.charAt(2)) +
        1 * convertCharToInt(number.charAt(3)) +
        9 * convertCharToInt(number.charAt(4)) +
        7 * convertCharToInt(number.charAt(5)) +
        3 * convertCharToInt(number.charAt(6)) +
        1 * convertCharToInt(number.charAt(7)) +
        9 * convertCharToInt(number.charAt(8)) +
        7 * convertCharToInt(number.charAt(9));
  }

  private int calculateControlSumUsingParameters(String number) {
    int controlSum = 0;
    for (int i = 0; i < number.length() - 1; i++) {
      controlSum += parameters[i] * convertCharToInt(number.charAt(i));
    }
    return controlSum;
  }

  private int convertCharToInt(char c) {
    return Integer.parseInt(String.valueOf(c));
  }

}
