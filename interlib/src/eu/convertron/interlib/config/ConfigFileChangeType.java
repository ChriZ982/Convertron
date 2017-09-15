package eu.convertron.interlib.config;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum ConfigFileChangeType
{
    ADDED,
    MODIFIED,
    REMOVED
}
