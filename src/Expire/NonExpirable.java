package Expire;

public class NonExpirable implements ExpireBehaviour{
    public boolean isexpired() {
        return false;
    }
}
