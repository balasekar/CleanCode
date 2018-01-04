import java.utils.*;

// The “Plain Old Java Object” (POJO) implementing the abstraction.

public class BankImpl implements Bank
{

    private List<Account> accounts;

    public Collection<Account> getAccounts()
    {

        return accounts;

    }

    public void setAccounts(Collection<Account> accounts)
    {

        this.accounts = new ArrayList<Account>();

        for (Account account : accounts)
        {

            this.accounts.add(account);

        }

    }

}

