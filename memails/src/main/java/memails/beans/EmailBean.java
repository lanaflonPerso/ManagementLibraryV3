package memails.beans;

import lombok.*;


@NoArgsConstructor
public @Data  class EmailBean {
    @NonNull String email;
    @NonNull String title;
    @NonNull String endDate;
}
