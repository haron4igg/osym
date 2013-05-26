package org.osym.tools;

/**
 * Created with IntelliJ IDEA.
 * User: Haron
 * Date: 26.05.13
 * Time: 23:49
 * To change this template use File | Settings | File Templates.
 */
public class OSTools {
    private static String OS = System.getProperty("os.name").toLowerCase();

        public static void main(String[] args) {

            System.out.println(OS);

            if (isWindows()) {
                System.out.println("This is Windows");
            } else if (isMac()) {
                System.out.println("This is Mac");
            } else if (isUnix()) {
                System.out.println("This is Unix or Linux");
            } else if (isSolaris()) {
                System.out.println("This is Solaris");
            } else {
                System.out.println("Your OS is not support!!");
            }
        }

        public static boolean isWindows() {
            return (OS.indexOf("win") >= 0);
        }

        public static boolean isMac() {
            return (OS.indexOf("mac") >= 0);
        }

        public static boolean isUnix() {
            return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);
        }

        public static boolean isSolaris() {
            return (OS.indexOf("sunos") >= 0);
        }

}
