package delta.rpg.places;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import delta.rpg.base.Amount;

/**
 * A bank account.
 * @author dm
 */
public class BankAccount
{
  private int _id;
  private Amount _amount;

  /**
   * Constructor.
   * @param id Identifier.
   */
  public BankAccount(int id)
  {
    _id=id;
    _amount=new Amount();
  }

  /**
   * Get the identifier of this account.
   * @return an identifier.
   */
  public int getID()
  {
    return _id;
  }

  /**
   * Get the balance of this account.
   * @return an amount.
   */
  public Amount getBalance()
  {
    return _amount;
  }

  public void write(DataOutputStream out)
      throws IOException
  {
    out.writeInt(_id);
    _amount.write(out);
  }

  public void read(DataInputStream in)
      throws IOException
  {
    _id=in.readInt();
    _amount.read(in);
  }

  @Override
  public String toString()
  {
    return "Bank Account "+_id+" ("+_amount+")";
  }
}
