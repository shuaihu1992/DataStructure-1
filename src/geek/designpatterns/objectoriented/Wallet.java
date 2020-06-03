package geek.designpatterns.objectoriented;

import java.math.BigDecimal;

/**
 * Created by HP on 2020/6/2.
 */

public class Wallet {
    private String id;
    private long createTime;
    private BigDecimal balance;
    private long balanceLastModifiedTime;
    // ...省略其他属性...

    public Wallet() {
        this.createTime = System.currentTimeMillis();
        this.balance = BigDecimal.ZERO;
        this.balanceLastModifiedTime = System.currentTimeMillis();
    }

    // 注意：下面对get方法做了代码折叠，是为了减少代码所占文章的篇幅
    public String getId() { return this.id; }
    public long getCreateTime() { return this.createTime; }
    public BigDecimal getBalance() { return this.balance; }
    public long getBalanceLastModifiedTime() { return this.balanceLastModifiedTime;  }

    public void increaseBalance(BigDecimal increasedAmount) {
        if (increasedAmount.compareTo(BigDecimal.ZERO) < 0) {
        }
        this.balance.add(increasedAmount);
        this.balanceLastModifiedTime = System.currentTimeMillis();
    }

    public void decreaseBalance(BigDecimal decreasedAmount) {
        if (decreasedAmount.compareTo(BigDecimal.ZERO) < 0) {
        }
        if (decreasedAmount.compareTo(this.balance) > 0) {
        }
        this.balance.subtract(decreasedAmount);
        this.balanceLastModifiedTime = System.currentTimeMillis();
    }
}