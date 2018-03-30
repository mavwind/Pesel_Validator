package validator;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class PeselValidatorTest {

    private String number;
    private boolean isValid;

    public PeselValidatorTest(String number, boolean isValid) {
        this.number = number;
        this.isValid = isValid;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"91091207755", true},
                {"08210408726", true},
        });
    }

    @Test
    public void should_validate_pesel() {
        // AAA
        // Arrange
        PeselValidator validator = new PeselValidator();
        // Act
        boolean validationResult = validator.validate(this.number);
        // Assert
        assertEquals(this.isValid, validationResult);
    }
}