package convertron.tabs.modules;

import interlib.interfaces.Module;

public class ModuleHolder
{
    public Module module;

    public ModuleHolder(Module module)
    {
        this.module = module;
    }

    @Override
    public String toString()
    {
        if(module == null)
            return "null";

        return module.getName();
    }

    public static ModuleHolder[] toHolder(Module[] modules)
    {
        ModuleHolder[] holders = new ModuleHolder[modules.length];

        for(int i = 0; i < modules.length; i++)
        {
            holders[i] = new ModuleHolder(modules[i]);
        }

        return holders;
    }

    public static Module[] toModule(ModuleHolder[] holders)
    {
        Module[] modules = new Module[holders.length];

        for(int i = 0; i < holders.length; i++)
        {
            modules[i] = holders[i].module;
        }

        return modules;
    }
}
