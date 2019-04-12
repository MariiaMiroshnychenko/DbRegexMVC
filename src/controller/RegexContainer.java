package controller;

public interface RegexContainer {
    String NAME_SURNAME_REGEX = "[[А-ЯҐІЇЄ]&&[^ЁЫЭЪ]][[а-яґєії\\']&&[^ёыэъ]]{1,18}[[а-яґєії]&&[^ёыэъ]]";
    String NICKNAME_REGEX = "[A-Za-z0-9_@]{8,20}";
}
