package delta.rpg.places;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import delta.rpg.base.Amount;

public class BankAccount
{
  private int _id;
  private Amount _amount;

  public BankAccount(int id)
  {
    _id=id;
    _amount=new Amount();
  }

  public int getID()
  {
    return _id;
  }

  public Amount getAmount()
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

  public String toString()
  {
    return "Bank Account "+_id+" ("+_amount+")";
  }
}
