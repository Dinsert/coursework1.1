import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalUtils {

    private BigDecimalUtils() {
    }

    public static BigDecimal divide(BigDecimal dividend, BigDecimal divisor) {
        return dividend.divide(divisor, 2, RoundingMode.HALF_UP);
    }

}
