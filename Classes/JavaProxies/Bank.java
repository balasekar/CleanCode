import java.utils.*;

// The abstraction of a bank.

public interface Bank
{

    Collection<Account> getAccounts();

    void setAccounts(Collection<Account> accounts);

}