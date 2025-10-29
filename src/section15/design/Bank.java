package section15.design;

import java.util.HashMap;
import java.util.Map;

public class Bank {
	Map<Integer, Long> bank = null;

    public Bank(long[] balance) {
        bank = new HashMap();
        for(int i = 1; i <= balance.length; i++){
            bank.put(i,balance[i-1]);
        }
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(!bank.containsKey(account1) || !bank.containsKey(account2))  return false;
        if(bank.get(account1) < money)  return false;
        bank.put(account1, bank.get(account1) - money);
        bank.put(account2, bank.get(account2) + money);
        return true;
    }
    
    public boolean deposit(int account, long money) {
        if(!bank.containsKey(account))  return false;
        bank.put(account, bank.get(account) + money);
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(!bank.containsKey(account))  return false;
        if(bank.get(account) < money)  return false;
        bank.put(account, bank.get(account) - money);
        return true;
    }
}
