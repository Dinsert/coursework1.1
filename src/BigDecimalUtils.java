import static java.math.BigDecimal.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalUtils {

    final static BigDecimal PERCENT_VALUE = valueOf(1.0);
    final static BigDecimal ONE_HUNDRED = valueOf(100);
    final static BigDecimal PERCENT_INCREASE = ONE.add(BigDecimalUtils.divide(PERCENT_VALUE, ONE_HUNDRED));

    private BigDecimalUtils() {
    }

    public static BigDecimal divide(BigDecimal dividend, BigDecimal divisor) {
        return dividend.divide(divisor, 2, RoundingMode.HALF_UP);
    }

    public static BigDecimal divide(BigDecimal dividend, int divisor) {
        return divide(dividend, valueOf(divisor));
    }

}
