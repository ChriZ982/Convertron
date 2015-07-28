package convertron.tabs.modules;

import interlib.interfaces.Module;
import interlib.util.Logger;
import java.util.ArrayList;

public class ModuleManager
{
    private static ClassLocation[] importedModules;

    public static Module[] loadAllModules()
    {
        ArrayList<Module> modules = new ArrayList<>();

        for(ClassLocation loc : importedModules)
        {
            try
            {
                Object instance = ModuleLoader.loadClass(loc).newInstance();
                if(instance instanceof Module)
                    modules.add((Module)instance);
            }
            catch(InstantiationException ex)
            {
                Logger.logMessage(Logger.WARNING, "Es konnte keine Instanz der Klasse "
                                                  + loc.getJarEntryName()
                                                  + " in der Jar "
                                                  + loc.getJarFileUrl()
                                                  + "erzeugt werden");
                Logger.logError(Logger.WARNING, ex);
            }
            catch(Throwable t)
            {
                Logger.logError(Logger.WARNING, t);
            }
        }

        return modules.toArray(new Module[0]);
    }
}
