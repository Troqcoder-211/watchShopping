package util;

public class Constant {
    public static class dataPath {
        public static final String data_BaseDir = defaultDirectory() + "/WatchShopping/";
        public static final String accounts_File = data_BaseDir + "/Accounts";
        public static final String watches_File = data_BaseDir + "/Watches";
        public static final String Bills_Dir = data_BaseDir + "/Bills/";
        public static final String Carts_Dir = data_BaseDir + "/Carts/";

        private static String defaultDirectory() {
            String OS = System.getProperty("os.name").toUpperCase();
            if (OS.contains("WIN"))
                return System.getenv("APPDATA");
            else if (OS.contains("MAC"))
                return System.getProperty("user.home") + "/Library/Application " + "Support";
            else if (OS.contains("NUX"))
                return System.getProperty("user.home");
            return System.getProperty("user.dir");
        }
    }
}
