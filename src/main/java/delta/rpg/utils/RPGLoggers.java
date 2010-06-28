package delta.rpg.utils;

import org.apache.log4j.Logger;

import delta.common.utils.traces.LoggersRegistry;

/**
 * Management class for all RPG loggers.
 * @author DAM
 */
public abstract class RPGLoggers
{
  /**
   * Name of the "RPG" logger.
   */
  public static final String RPG="RPG";

  private static final Logger _rpgLogger=LoggersRegistry.getLogger(RPG);

  /**
   * Get the logger used for RPG (RPG).
   * @return the logger used for RPG.
   */
  public static Logger getRPGLogger()
  {
    return _rpgLogger;
  }
}
