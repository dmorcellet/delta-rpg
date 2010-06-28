package delta.rpg.base;

import java.util.ArrayList;
import java.util.List;

public final class CoinType
{
  private static int _counter=0;
  public static final List<CoinType> ALL=new ArrayList<CoinType>();
  public static final CoinType PLATINUM=new CoinType("pc",1000);
  public static final CoinType GOLD=new CoinType("gc",200);
  public static final CoinType ELECTRUM=new CoinType("ec",100);
  public static final CoinType SILVER=new CoinType("sc",10);
  public static final CoinType CUPPER=new CoinType("cc",1);
  public static final int NB_COIN_TYPES=ALL.size();

  private int _code;
  private String _label;
  private int _baseCoinEquivalent;

  private CoinType(String label, int baseCoinEquivalent)
  {
    _code=_counter;
    _label=label;
    _baseCoinEquivalent=baseCoinEquivalent;
    _counter++;
    ALL.add(this);
  }

  public int getCode()
  {
    return _code;
  }

  public String getLabel()
  {
    return _label;
  }

  public int getBaseCoinEquivalent()
  {
    return _baseCoinEquivalent;
  }
}
