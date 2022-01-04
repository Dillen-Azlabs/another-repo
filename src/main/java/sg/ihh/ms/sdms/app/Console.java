package sg.ihh.ms.sdms.app;

import sg.ihh.ms.sdms.app.configuration.EncryptConfig;

public class Console {

    public static void main(String[] args) {
        String[] strArr = {"192.168.200.34", "3306", "sdmsDB", "sdms_user", "P@ssw0rd"};

        EncryptConfig config = new EncryptConfig();

        for (String str : strArr) {
            String encrypted = config.stringEncryptor().encrypt(str);
            System.out.println("Clear : " + str);
            System.out.println("Encrypted : ENC(" + encrypted + ")");
            System.out.println();
        }
    }
}
