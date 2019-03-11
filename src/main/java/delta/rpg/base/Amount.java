package delta.rpg.base;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Amount of money.
 * Expressed as platinum, gold, electrum, silver and cupper coins.
 * 1pc=5gc;1gc=2ec;1ec=10sc;1sc=10cc;
 */
public class Amount
{
  private int[] _nbCoins;

  /**
   * Constructor.
   */
  public Amount()
  {
    _nbCoins=new int[CoinType.NB_COIN_TYPES];
  }

  /**
   * Constructor with coin counts.
   * @param coinCounts Coin counts.
   */
  public Amount(int[] coinCounts)
  {
    assert(coinCounts.length==CoinType.NB_COIN_TYPES);

    for(int i=0;i<CoinType.NB_COIN_TYPES;i++)
    {
      _nbCoins[i]=coinCounts[i];
    }
  }

  /**
   * Copy constructor.
   * @param a Source.
   */
  public Amount(Amount a)
  {
    for(int i=0;i<CoinType.NB_COIN_TYPES;i++)
    {
      _nbCoins[i]=a._nbCoins[i];
    }
  }

  /**
   * Get the 'base coin' equivalent.
   * @return A value in 'base coin'.
   */
  public int getEquivalent()
  {
    int sum=0;
    CoinType coinType;
    int factor;
    for(int i=0;i<CoinType.NB_COIN_TYPES;i++)
    {
      coinType=CoinType.ALL.get(i);
      factor=coinType.getBaseCoinEquivalent();
      sum+=_nbCoins[i]*factor;
    }
    return sum;
  }

  /**
   * Add some money to this amount.
   * @param a Amount to add.
   */
  public void addAmount(Amount a)
  {
    for(int i=0;i<CoinType.NB_COIN_TYPES;i++)
    {
      _nbCoins[i]=a._nbCoins[i];
    }
  }

  /**
   * Remove some money to this amount.
   * @param a Amount to remove.
   * @return <code>true</code> if the amount was successfully removed, <code>false</code> otherwise.
   */
  public boolean removeAmount(Amount a)
  {
    int thisAmount=getEquivalent();
    int aAmount=a.getEquivalent();
    if(thisAmount>=aAmount)
    {
      CoinType type;
      for(int i=0;i<CoinType.NB_COIN_TYPES;i++)
      {
        type=CoinType.ALL.get(i);
        remove(type,a._nbCoins[i]);
      }
      return true;
    }
    return false;
  }

  private boolean remove(CoinType type, int nb)
  {
    int index=type.getCode();
    if(_nbCoins[index]>=nb)
    {
      _nbCoins[index]-=nb;
      return true;
    }
    int nbLeft=nb-_nbCoins[index];
    if (index>0)
    {
      CoinType newType=CoinType.ALL.get(index-1);
      int factor=type.getBaseCoinEquivalent()/newType.getBaseCoinEquivalent();
      boolean ret=remove(newType,factor*nbLeft);
      if (ret)
      {
        _nbCoins[index]=0;
      }
      return ret; 
    }
    return false;
  }

  /**
   * Indicates if this amount is greater than the given amount.
   * @param a Amount to use for comparison.
   * @return <code>true</code> if it is, <code>false</code> otherwise.
   */
  public boolean isGreaterThan(Amount a)
  {
    int thisAmount=getEquivalent();
    int aAmount=a.getEquivalent();

    return(thisAmount>aAmount);
  }

  /**
   * Write the contents of this object to the given data stream.
   * @param out Output data stream.
   * @throws IOException If an I/O error occurs.
   */
  public void write(DataOutputStream out)
      throws IOException
  {
    for(int i=CoinType.NB_COIN_TYPES-1;i>=0;i--)
    {
      out.writeInt(_nbCoins[i]);
    }
  }

  /**
   * Read the contents of this object from the given data stream.
   * @param in Input data stream.
   * @throws IOException If an I/O error occurs.
   */
  public void read(DataInputStream in)
      throws IOException
  {
    for(int i=CoinType.NB_COIN_TYPES-1;i>=0;i--)
    {
      _nbCoins[i]=in.readInt();
    }
  }

  @Override
  public String toString()
  {
    boolean init=false;
    StringBuffer sb=new StringBuffer();
    for(int i=0;i<CoinType.NB_COIN_TYPES;i++)
    {
      if(_nbCoins[i]>0)
      {
        sb.append(_nbCoins[i]).append(" ").append(CoinType.ALL.get(i).getShortLabel());
        init=true;
      }
    }
    if(!init)
    {
      sb.append("-");
    }
    return sb.toString();
  }
}
