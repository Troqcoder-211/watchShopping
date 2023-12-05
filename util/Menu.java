package util;

public class Menu {
    public static void welcome() {
        String text = "\t╔══════════════════════════════════════════════════════╗\n"
                + "\t║                           _                _         ║\n"
                + "\t║      __ __ __   __ _     | |_      __     | |_       ║\n"
                + "\t║      \\ V  V /  / _` |    |  _|    / _|    | ' \\      ║\n"
                + "\t║       \\_/\\_/   \\__,_|     \\__|    \\__|    |_||_|     ║\n"
                + "\t║                 _                                    ║\n"
                + "\t║        ___     | |_      ___       _ _     ___       ║\n"
                + "\t║       (_-<     |  _|    / _ \\     | '_|   / -_)      ║\n"
                + "\t║       /__/      \\__|    \\___/     |_|     \\___|      ║\n"
                + "\t║                                                      ║\n"
                + "\t║           [1] Sign in           [2] Sign up          ║\n"
                + "\t║                                                      ║\n"
                + "\t║        Please choose 1 of the 2 options above        ║\n"
                + "\t║            or enter other content to exit            ║\n"
                + "\t║                                                      ║\n"
                + "\t╚══════════════════════════════════════════════════════╝\n";
        System.out.println(text);
    }

    public static void admin() {
        String text = "\t╔══════════════════════════════════════════════════════╗\n"
                + "\t║             ____   ____  __  __  _  __  _            ║\n"
                + "\t║            / () \\ | _) \\|  \\/  || ||  \\| |           ║\n"
                + "\t║           /__/\\__\\|____/|_|\\/|_||_||_|\\__|           ║\n"
                + "\t║                                                      ║\n"
                + "\t║           [1] Product management                     ║\n"
                + "\t║           [2] Account management                     ║\n"
                + "\t║           [0] Log out                                ║\n"
                + "\t║                                                      ║\n"
                + "\t╚══════════════════════════════════════════════════════╝\n";
        System.out.println(text);
    }

    public static void product() {
        String text = "\t╔══════════════════════════════════════════════════════╗\n"
                + "\t║                  PRODUCT MANAGEMENT                  ║\n"
                + "\t║                                                      ║\n"
                + "\t║      [1] View products                               ║\n"
                + "\t║      [2] Add product                                 ║\n"
                + "\t║      [3] Search product (edit, remove)               ║\n"
                + "\t║      [0] Home                                        ║\n"
                + "\t║                                                      ║\n"
                + "\t╚══════════════════════════════════════════════════════╝\n";
        System.out.println(text);
    }

    public static void account() {
        String text = "\t╔══════════════════════════════════════════════════════╗\n"
                + "\t║                  ACCOUNT MANAGEMENT                  ║\n"
                + "\t║                                                      ║\n"
                + "\t║      [1] Delete accounts                             ║\n"
                + "\t║      [2] Search user                                 ║\n"
                + "\t║      [0] Home                                        ║\n"
                + "\t║                                                      ║\n"
                + "\t╚══════════════════════════════════════════════════════╝\n";
        System.out.println(text);
    }

    public static void staff() {
        String text = "\t╔══════════════════════════════════════════════════════╗\n"
                + "\t║            ____  _____    ____   ____  ____          ║\n"
                + "\t║           (_ (_`|_   _|  / () \\ | ===|| ===|         ║\n"
                + "\t║          .__)__)  |_|   /__/\\__\\|__|  |__|           ║\n"
                + "\t║                                                      ║\n"
                + "\t║           [1] View products                          ║\n"
                + "\t║           [2] View bills                             ║\n"
                + "\t║           [0] Home                                   ║\n"
                + "\t║                                                      ║\n"
                + "\t╚══════════════════════════════════════════════════════╝\n";
        System.out.println(text);
    }

    public static void customer() {
        String text = "\t╔══════════════════════════════════════════════════════╗\n"
                + "\t║  ____  __ __  ____  _____  ____  __  __  ____ _____  ║\n"
                + "\t║ / (__`|  |  |(_ (_`|_   _|/ () \\|  \\/  || ===|| () ) ║\n"
                + "\t║ \\____) \\___/.__)__)  |_|  \\____/|_|\\/|_||____||_|\\_\\ ║\n"
                + "\t║                                                      ║\n"
                + "\t║                                                      ║\n"
                + "\t║                                                      ║\n"
                + "\t║                                                      ║\n"
                + "\t║                                                      ║\n";

        System.out.println(text);
    }
}