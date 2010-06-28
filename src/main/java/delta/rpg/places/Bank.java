package delta.rpg.places;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Bank extends Place
{
  private int _lastAccountID;
  private HashMap<Integer, BankAccount> _accounts;

  public Bank()
  {
    _lastAccountID=0;
    _accounts=new HashMap<Integer, BankAccount>();
  }

  public int getPlaceType()
  {
    return PlaceType.BANK;
  }

  public BankAccount createNewAccount()
  {
    _lastAccountID++;
    BankAccount ret=new BankAccount(_lastAccountID);
    _accounts.put(Integer.valueOf(_lastAccountID), ret);
    return ret;
  }

  public BankAccount getAccount(int id)
  {
    return _accounts.get(Integer.valueOf(id));
  }

  public void closeAccount(int id)
  {
    _accounts.remove(Integer.valueOf(id));
  }

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

  /**
   * Read the contents of this object from the specified binary data stream.
   * @param in Input stream.
   * @throws IOException
   */
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

  public String toString()
  {
    return "Bank '"+getName()+"'";
  }
}
