package delta.rpg.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Coin type.
 * @author DAM
 */
public final class CoinType
{
  private static int _counter=0;
  /**
   * List of all known coin types.
   */
  public static final List<CoinType> ALL=new ArrayList<CoinType>();
  /**
   * Platinum coin.
   */
  public static final CoinType PLATINUM=new CoinType("pc",1000);
  /**
   * Gold coin.
   */
  public static final CoinType GOLD=new CoinType("gc",200);
  /**
   * Electrum coin.
   */
  public static final CoinType ELECTRUM=new CoinType("ec",100);
  /**
   * Silver coin.
   */
  public static final CoinType SILVER=new CoinType("sc",10);
  /**
   * Copper coin.
   */
  public static final CoinType COPPER=new CoinType("cc",1);
  /**
   * Number of coin types.
   */
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

  /**
   * Get the internal code for this coin.
   * @return An integer code.
   */
  public int getCode()
  {
    return _code;
  }

  /**
   * Get the short label for this coin type.
   * @return a short displayable label.
   */
  public String getShortLabel()
  {
    return _label;
  }

  /**
   * Get the value of this coin in 'base coin' unit.
   * @return a value.
   */
  public int getBaseCoinEquivalent()
  {
    return _baseCoinEquivalent;
  }
}
