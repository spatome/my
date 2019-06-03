package com.spatome.yj.manager.entity;

import java.math.BigDecimal;
import java.util.Date;

public class AccountLog {
    private Long id;

    private String accountNo;

    private BigDecimal amount;

    private String amountType;

    private BigDecimal beforeCurrentBalance;

    private String inOut;

    private String inOutDescs;

    private String relatedAccountNo;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo == null ? null : accountNo.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getAmountType() {
        return amountType;
    }

    public void setAmountType(String amountType) {
        this.amountType = amountType == null ? null : amountType.trim();
    }

    public BigDecimal getBeforeCurrentBalance() {
        return beforeCurrentBalance;
    }

    public void setBeforeCurrentBalance(BigDecimal beforeCurrentBalance) {
        this.beforeCurrentBalance = beforeCurrentBalance;
    }

    public String getInOut() {
        return inOut;
    }

    public void setInOut(String inOut) {
        this.inOut = inOut == null ? null : inOut.trim();
    }

    public String getInOutDescs() {
        return inOutDescs;
    }

    public void setInOutDescs(String inOutDescs) {
        this.inOutDescs = inOutDescs == null ? null : inOutDescs.trim();
    }

    public String getRelatedAccountNo() {
        return relatedAccountNo;
    }

    public void setRelatedAccountNo(String relatedAccountNo) {
        this.relatedAccountNo = relatedAccountNo == null ? null : relatedAccountNo.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}