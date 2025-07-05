package Expire;

import java.time.LocalDate;

public class Expirable implements ExpireBehaviour{
    private LocalDate expiryDate;
    public Expirable(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
    public boolean isexpired(){
        LocalDate now = LocalDate.now();
        return now.isAfter(expiryDate);
    }

}
