class PsiParameter_ {
    java.lang.String type;
    java.lang.String name;
    java.lang.Object value;

    PsiParameter_(String type, String name) {
        this.type = type;
        this.name = name;
    };

    PsiParameter_(String type, String name, Object value) {
        this.type = type;
        this.name = name;
        this.value = value;
    };

    @Override
    public String toString() {
        return type + ':' + name;
    };
}
