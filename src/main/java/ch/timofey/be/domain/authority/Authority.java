package ch.timofey.be.domain.authority;

public enum Authority {
    USER_READ("user:read"),
    ADMIN_READ("admin:read"),
    ADMIN_CREATE("admin:create"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_DELETE("admin:delete");

    Authority(String authority) {
        this.authority = authority;
    }

    private final String authority;

    public String getAuthority() {
        return authority;
    }
}
