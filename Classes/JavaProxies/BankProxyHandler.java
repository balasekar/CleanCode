import java.lang.reflect.*;

import java.util.*;

public class BankProxyHandler implements InvocationHandler
{

    private Bank bank;

    public BankHandler (Bank bank)
    {

        this.bank = bank;

    }

    // Method defined in InvocationHandler

    public Object invoke(Object proxy, Method method, Object[] args)

    throws Throwable
    {

        String methodName = method.getName();

        if (methodName.equals("getAccounts"))
        {

            bank.setAccounts(getAccountsFromDatabase());

            return bank.getAccounts();

        }
        else if (methodName.equals("setAccounts"))
        {

            bank.setAccounts((Collection<Account>) args[0]);

            setAccountsToDatabase(bank.getAccounts());

            return null;

        }
        else
        {

            ...

        }

    }

    // Lots of details here:

    protected Collection<Account> getAccountsFromDatabase()
    {
        ...
    }

    protected void setAccountsToDatabase(Collection<Account> accounts)
    {
        ...
    }

}

// Somewhere else...

Bank bank = (Bank) Proxy.newProxyInstance(

                Bank.class.getClassLoader(),

                new Class[] { Bank.class },

                new BankProxyHandler(new BankImpl()));