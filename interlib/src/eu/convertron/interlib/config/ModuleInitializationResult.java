package eu.convertron.interlib.config;

import eu.convertron.interlib.interfaces.View;

public class ModuleInitializationResult
{
    private final View view;
    private final String name;

    public ModuleInitializationResult(View view, String name)
    {
        this.view = view;
        this.name = name;
    }

    public View getView()
    {
        return view;
    }

    public String getName()
    {
        return name;
    }
}
