package sg.ihh.ms.sdms.app.repository.model;

public class Sort {

    private String field;
    private String modifier;

    public Sort(String field, String modifier) {
        this.field = field;
        this.modifier = modifier;
    }

    public String getField() {
        return field;
    }

    public String getModifier() {
        return modifier;
    }

}
