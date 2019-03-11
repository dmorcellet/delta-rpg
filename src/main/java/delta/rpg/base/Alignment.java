package delta.rpg.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Alignment.
 * @author DAM
 */
public final class Alignment
{
  private static final List<Alignment> ALL=new ArrayList<Alignment>();
  /**
   * Good.
   */
  public static final Alignment GOOD=new Alignment((byte)0, "good");
  /**
   * Neutral.
   */
  public static final Alignment NEUTRAL=new Alignment((byte)1, "neutral");
  /**
   * Evil.
   */
  public static final Alignment EVIL=new Alignment((byte)2, "evil");

  private byte _code;
  private String _label;

  private Alignment(byte code, String label)
  {
    _code=code;
    _label=label;
    ALL.add(this);
  }

  /**
   * Get the internal code for this alignment.
   * @return An integer code.
   */
  public byte getCode()
  {
    return _code;
  }

  /**
   * Get the label for this alignment.
   * @return a displayable label.
   */
  public String getLabel()
  {
    return _label;
  }

  @Override
  public String toString()
  {
    return _label;
  }
}
