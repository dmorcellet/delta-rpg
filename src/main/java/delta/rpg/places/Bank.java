package delta.rpg.places;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Bank.
 * @author DAM
 */
public class Bank extends Place
{
  private int _lastAccountID;
  private HashMap<Integer, BankAccount> _accounts;

  /**
   * Constructor.
   */
  public Bank()
  {
    _lastAccountID=0;
    _accounts=new HashMap<Integer, BankAccount>();
  }

  @Override
  public int getPlaceType()
  {
    return PlaceType.BANK;
  }

  /**
   * Create a new account.
   * @return the newly created account.
   */
  public BankAccount createNewAccount()
  {
    _lastAccountID++;
    BankAccount ret=new BankAccount(_lastAccountID);
    _accounts.put(Integer.valueOf(_lastAccountID), ret);
    return ret;
  }

  /**
   * Get an account using its identifier.
   * @param id Identifier of the account to get.
   * @return An account or <code>null</code> if not found.
   */
  public BankAccount getAccount(int id)
  {
    return _accounts.get(Integer.valueOf(id));
  }

  /**
   * Close/remove an account.
   * @param id Identifier of the account to remove.
   */
  public void closeAccount(int id)
  {
    _accounts.remove(Integer.valueOf(id));
  }

  @Override
  protected void write(DataOutputStream out)
      throws IOException
  {
    super.write(out);
    out.writeInt(_lastAccountID);
    out.writeInt(_accounts.size());
    Set<Map.Entry<Integer, BankAccount>> entrySet=_accounts.entrySet();
    Map.Entry<Integer, BankAccount> entry;
    BankAccount account;
    for(Iterator<Map.Entry<Integer, BankAccount>> it=entrySet.iterator();it.hasNext();)
    {
      entry=it.next();
      account=entry.getValue();
      account.write(out);
    }
  }

  @Override
  protected void read(DataInputStream in)
      throws IOException
  {
    super.read(in);
    _lastAccountID=in.readInt();
    _accounts.clear();
    int nb=in.readInt();
    BankAccount account=null;
    for(int i=0;i<nb;i++)
    {
      account=new BankAccount(0);
      account.read(in);
      _accounts.put(Integer.valueOf(account.getID()), account);
    }
  }

  @Override
  public String toString()
  {
    return "Bank '"+getName()+"'";
  }
}
