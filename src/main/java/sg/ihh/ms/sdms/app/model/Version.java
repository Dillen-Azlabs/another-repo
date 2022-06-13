package sg.ihh.ms.sdms.app.model;

public enum Version {

    DRAFT("DRAFT"), PUBLISHED("PUBLISHED");

    private String key;

    private Version(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public static Version getVersion(String text) {
        if (text.toLowerCase().trim().equals("published")) {
            return PUBLISHED;
        } else {
            return DRAFT;
        }
    }

}
