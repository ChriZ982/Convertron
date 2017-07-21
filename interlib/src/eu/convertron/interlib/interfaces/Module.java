package eu.convertron.interlib.interfaces;

import eu.convertron.interlib.config.LoadingContext;
import eu.convertron.interlib.config.ModuleConfiguration;
import eu.convertron.interlib.config.ModuleInitializationResult;

public interface Module
{
    public ModuleInitializationResult init(ModuleConfiguration moduleconfig, LoadingContext context);
}
