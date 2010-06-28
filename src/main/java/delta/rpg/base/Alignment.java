package delta.rpg.base;

import java.util.ArrayList;
import java.util.List;

public final class Alignment
{
  private static final List<Alignment> ALL=new ArrayList<Alignment>();
  public static final Alignment GOOD=new Alignment((byte)0, "good");
  public static final Alignment NEUTRAL=new Alignment((byte)1, "neutral");
  public static final Alignment EVIL=new Alignment((byte)2, "evil");

  private byte _code;
  private String _label;

  private Alignment(byte code, String label)
  {
    _code=code;
    _label=label;
    ALL.add(this);
  }

  public byte getCode()
  {
    return _code;
  }

  public String getLabel()
  {
    return _label;
  }
}
