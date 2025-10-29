package section15.design;

public class ATM {
	int denomination[] = {20,50,100,200,500};
    int notes[] = null;
    public ATM() {
        notes = new int[5];
    }
    
    public void deposit(int[] banknotesCount) {
        for(int i = 0; i < 5; i++) {
            notes[i] += banknotesCount[i];
        }
    }
    
    public int[] withdraw(int amount) {
        int deduct[] = new int[5];
        for(int i = 4; i>=0; i--) {
            if(notes[i] > 0 && amount >= denomination[i]) {
                int x = amount/denomination[i];
                if(notes[i] >= x) {
                    amount = amount - x * denomination[i];
                    deduct[i] = x;
                } else {
                    amount = amount - notes[i] * denomination[i];
                    deduct[i] = notes[i];
                } 
            }
        }
        if(amount == 0) {
            for(int i = 0; i < 5; i++) {
                notes[i] -= deduct[i];
            }            

        }
        return amount == 0 ? deduct : new int[] {-1};
    }
}
