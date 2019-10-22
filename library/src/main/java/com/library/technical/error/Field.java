package com.library.technical.error;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public @Data class Field {
    @NonNull
    private String name;
}
