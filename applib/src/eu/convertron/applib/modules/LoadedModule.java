package eu.convertron.applib.modules;

import eu.convertron.interlib.Lesson;
import eu.convertron.interlib.config.LoadingContext;
import eu.convertron.interlib.config.ModuleConfiguration;
import eu.convertron.interlib.config.ModuleInitializationResult;
import eu.convertron.interlib.interfaces.Input;
import eu.convertron.interlib.interfaces.Module;
import eu.convertron.interlib.interfaces.Output;
import eu.convertron.interlib.interfaces.View;

public class LoadedModule
{
    private final ClassLocation classLocation;
    private final ModuleInitializationResult initializationResult;
    private final Module module;

    private final LoadingContext context;
    private final ModuleConfiguration config;

    public LoadedModule(ClassLocation classLocation, ModuleInitializationResult initializationResult, Module module, LoadingContext context, ModuleConfiguration config)
    {
        this.classLocation = classLocation;
        this.initializationResult = initializationResult;
        this.module = module;
        this.context = context;
        this.config = config;
    }

    public boolean isOutput()
    {
        return module != null && module instanceof Output;
    }

    public boolean isInput()
    {
        return module != null && module instanceof Input;
    }

    public Output asOutput()
    {
        if(!isOutput())
            throw new UnsupportedOperationException("Module is no Output");

        return (Output)module;
    }

    public Input asInput()
    {
        if(!isInput())
            throw new UnsupportedOperationException("Module is no Input");

        return (Input)module;
    }

    public void out(Lesson[] lessons)
    {
        asOutput().out(lessons);
    }

    public void motdOut(String motd)
    {
        asOutput().motdOut(motd);
    }

    public Lesson[] in()
    {
        return asInput().in();
    }

    public String getName()
    {
        return initializationResult != null ? initializationResult.getName()
               : classLocation != null ? classLocation.getClassName() : "unknown";
    }

    public String getModuleClassName()
    {
        return module != null ? module.getClass().getName() : "null";
    }

    public View getView()
    {
        return initializationResult != null ? initializationResult.getView() : null;
    }

    public ClassLocation getClassLocation()
    {
        return classLocation;
    }

    public ModuleInitializationResult getInitializationResult()
    {
        return initializationResult;
    }

    public Module getModule()
    {
        return module;
    }

    public LoadingContext getContext()
    {
        return context;
    }

    public ModuleConfiguration getConfig()
    {
        return config;
    }
}
