package lk.java.jta.ejb;

import java.math.BigDecimal;

public interface AccountBean {
    void creditAmount(Long accountNo, BigDecimal amount);

    void debitAmount(Long accountNo, BigDecimal amount);
}
