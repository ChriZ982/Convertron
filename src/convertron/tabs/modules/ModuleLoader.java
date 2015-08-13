package convertron.tabs.modules;

import interlib.interfaces.Module;
import interlib.util.Logger;
import interlib.util.Settings;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import javax.swing.JOptionPane;

public class ModuleLoader
{
    private ArrayList<ClassLocation> locationOfImportedModules;

    private ModuleManageWindow moduleManageWindow;
    private ModuleManageWindowListeners listeners;

    public ModuleLoader()
    {
        loadImported();
    }

    public Module[] loadAllImportedModules()
    {
        ArrayList<Module> modules = new ArrayList<>();

        for(ClassLocation loc : locationOfImportedModules)
            try
            {
                modules.add(loadModule(loc));
            }
            catch(RuntimeException ex)
            {
                Logger.logError(Logger.INFO, "Laden des Modules" + loc.toString() + " fehlgeschlagen", ex);
            }

        return modules.toArray(new Module[modules.size()]);
    }

    public void showModuleManageWindow()
    {
        moduleManageWindow = new ModuleManageWindow(locationOfImportedModules
                .toArray(new ClassLocation[locationOfImportedModules.size()]));

        listeners = new ModuleManageWindowListeners();

        moduleManageWindow.setVisible(true);
    }

    protected ClassLocation[] getAvailableModules(File jarFile) throws IOException
    {
        ArrayList<ClassLocation> moduleClasses = new ArrayList<>();

        JarFile jar = new JarFile(jarFile);
        URL url = jarFile.toURI().toURL();
        Enumeration<JarEntry> entries = jar.entries();

        while(entries.hasMoreElements())
        {
            JarEntry e = entries.nextElement();

            if(!validateJarEntryAsClass(e))
                continue;

            try
            {
                ClassLocation location = new ClassLocation(url, parseClassName(e.getName()));

                Class cl = loadClass(location);
                if(isModule(cl))
                    moduleClasses.add(location);
            }
            catch(Exception ex)
            {
                Logger.logError(Logger.INFO, "Mirko Bitte Hinzufügen!", ex);
            }
        }

        return moduleClasses.toArray(new ClassLocation[moduleClasses.size()]);
    }

    protected Module loadModule(ClassLocation location)
    {
        try
        {
            return (Module)loadClass(location).newInstance();
        }
        catch(ClassCastException ex)
        {
            throw new RuntimeException(location.forSaving() + " isn't a Module", ex);
        }
        catch(InstantiationException ex)
        {
            throw new RuntimeException("Failed to create an Instance of " + location.forSaving(), ex);
        }
        catch(Throwable t)
        {
            throw new RuntimeException("Failed to load Module" + location.forSaving(), t);
        }
    }

    protected Class loadClass(ClassLocation location)
    {
        String logPart = location.getClassName()
                         + " from Jar " + location.getJarFileUrl();

        try
        {
            Logger.logMessage(Logger.INFO, "Try to load " + logPart);

            Class clazz = new URLClassLoader(new URL[]
            {
                location.getJarFileUrl()
            }).loadClass(location.getClassName());

            Logger.logMessage(Logger.INFO, logPart + " loaded");

            return clazz;
        }
        catch(Throwable t)
        {
            throw new RuntimeException("Failed to load " + logPart, t);
        }
    }

    protected String parseClassName(String jarEntryName)
    {
        return jarEntryName.substring(0, jarEntryName.length() - ".class".length()).replaceAll("/", ".");
    }

    protected boolean validateJarEntryAsClass(JarEntry e)
    {
        return e.getName().endsWith(".class");
    }

    protected boolean isModule(Class c)
    {
        if(c == null)
            return false;

        Class[] interfaces = c.getInterfaces();

        for(Class interf : interfaces)
        {
            if(interf.equals(interlib.interfaces.Module.class))
                return true;
        }
        return false;
    }

    protected void saveImported()
    {
        String[] arrayForSetting = new String[locationOfImportedModules.size()];
        for(int i = 0; i < arrayForSetting.length; i++)
        {
            arrayForSetting[i] = locationOfImportedModules.get(i).forSaving();
        }
        Settings.saveArray(true, "locationOfImportedModules", arrayForSetting);
    }

    protected void loadImported()
    {
        String[] fromSetting = Settings.loadArray(true, "locationOfImportedModules");
        for(String locationAsString : fromSetting)
        {
            try
            {
                locationOfImportedModules.add(new ClassLocation(locationAsString));
            }
            catch(Exception ex)
            {
                Logger.logError(Logger.INFO, "Konnte das Modul " + locationAsString + " nicht laden", ex);
            }
        }
    }

    protected void saveChangesInWindow()
    {
        Enumeration<ClassLocation> newImportedClassLocations = moduleManageWindow.getAllModulesListModel().elements();
        locationOfImportedModules.clear();

        while(newImportedClassLocations.hasMoreElements())
        {
            locationOfImportedModules.add(newImportedClassLocations.nextElement());
        }

        saveImported();

        JOptionPane.showMessageDialog(null, "Die Änderungen werden erst nach einem Neustart der Anwendung wirksam!");
    }

    protected void closeWindow()
    {
        if(moduleManageWindow != null)
            moduleManageWindow.dispose();
        moduleManageWindow = null;
        listeners = null;
    }

    @Override
    protected void finalize() throws Throwable
    {
        closeWindow();
        super.finalize();
    }

    protected class ModuleManageWindowListeners
    {
        protected ModuleManageWindowListeners()
        {
            initSaveListener();
            initOpenJarListener();
            initWindowListener();
        }

        // <editor-fold defaultstate="collapsed" desc="Listeners">
        protected void initSaveListener()
        {
            moduleManageWindow.getSaveAndCloseBtn().addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    saveChangesInWindow();
                    closeWindow();
                }
            });
        }

        protected void initOpenJarListener()
        {
            moduleManageWindow.getOpenJarBtn().addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    try
                    {
                        moduleManageWindow.setFileOpened(false);
                        moduleManageWindow.getModulesInJarListModel().removeAllElements();

                        File jarFile = new File(moduleManageWindow.getJarFileTxt().getText());
                        ClassLocation[] foundModules = getAvailableModules(jarFile);

                        for(ClassLocation foundModule : foundModules)
                        {
                            moduleManageWindow.getModulesInJarListModel().addElement(foundModule);
                        }

                        moduleManageWindow.setFileOpened(true);
                    }
                    catch(IOException ex)
                    {
                        Logger.logError(Logger.INFO, "Fehler beim öffnen oder lesen der Datei", ex);
                    }
                }
            });
        }

        protected void initWindowListener()
        {
            moduleManageWindow.addWindowListener(new WindowAdapter()
            {
                @Override
                public void windowClosing(WindowEvent e)
                {
                    switch(JOptionPane.showConfirmDialog(null,
                                                         "Wollen Sie die Änderungen speichern?",
                                                         "Änderungen speichern?",
                                                         JOptionPane.YES_NO_CANCEL_OPTION))
                    {
                        case JOptionPane.YES_OPTION:
                            saveChangesInWindow();
                            closeWindow();
                            break;
                        case JOptionPane.NO_OPTION:
                            closeWindow();
                            break;
                        default:
                            break;
                    }
                }
            });
        }
        //</editor-fold>
    }
}
