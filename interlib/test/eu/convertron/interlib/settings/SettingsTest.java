package eu.convertron.interlib.settings;

public class SettingsTest
{
//    private static TextFile file;
//
//    @BeforeClass
//    public static void setUpClass()
//    {
//        file = new TextFile("./testdata/local.settings");
//        file.create();
//    }
//
//    @Test
//    public void testSave()
//    {
//        Settings.save(file, "testSave_Setting", "testSave_Value");
//
//        assertTrue(file.readAllToString().contains("testSave_Setting:testSave_Value"));
//    }
//
//    @Test
//    public void testLoad()
//    {
//        Settings.save(file, "testLoad_Setting", "testLoad_Value");
//
//        assertEquals(Settings.load(file, "testLoad_Setting"), "testLoad_Value");
//    }
//
//    @Test
//    public void testSaveArray()
//    {
//        Settings.saveArray(file, "testSaveArray_Setting", "testSaveArray_Value1", "testSaveArray_Value2", "testSaveArray_Value3");
//
//        assertTrue(file.readAllToString().contains("testSaveArray_Setting:testSaveArray_Value1;testSaveArray_Value2;testSaveArray_Value3"));
//    }
//
//    @Test
//    public void testLoadArray()
//    {
//        Settings.saveArray(file, "testLoadArray_Setting", "testLoadArray_Value1", "testLoadArray_Value2", "testLoadArray_Value3");
//
//        assertArrayEquals(Settings.loadArray(file, "testLoadArray_Setting"),
//                          new String[]
//                          {
//                              "testLoadArray_Value1", "testLoadArray_Value2", "testLoadArray_Value3"
//                          });
//    }
//
//    @Test
//    public void testSettingNamesStartWith()
//    {
//        Settings.save(file, "testSettingNamesStartWith_Setting1", "testSettingNamesStartWith_Value");
//        Settings.save(file, "testSettingNamesStartWith_Setting2", "testSettingNamesStartWith_Value");
//        Settings.save(file, "testSettingNamesStartWith_Setting3", "testSettingNamesStartWith_Value");
//        String[] settingNamesStartingWith = Settings.settingNamesStartWith(file, "testSettingNamesStartWith_Setting");
//
//        assertTrue(settingNamesStartingWith.length == 3);
//        assertEquals(settingNamesStartingWith[0], "testSettingNamesStartWith_Setting1");
//        assertEquals(settingNamesStartingWith[1], "testSettingNamesStartWith_Setting2");
//        assertEquals(settingNamesStartingWith[2], "testSettingNamesStartWith_Setting3");
//    }
}
