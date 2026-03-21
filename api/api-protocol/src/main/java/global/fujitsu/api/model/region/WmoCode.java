package global.fujitsu.api.model.region;

public record WmoCode(String value) {
    public WmoCode{
        if (value == null || value.isEmpty()){
            throw new IllegalArgumentException("WMO Code value cannot be empty");
        }
    }
}
