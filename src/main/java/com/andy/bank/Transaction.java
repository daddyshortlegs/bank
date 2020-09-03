package com.andy.bank;

public class Transaction {
    private final int amount;
    private final String date;

    public Transaction(int amount, String date) {
        this.amount = amount;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (amount != that.amount) return false;
        return date.equals(that.date);
    }

    @Override
    public int hashCode() {
        int result = amount;
        result = 31 * result + date.hashCode();
        return result;
    }
}
