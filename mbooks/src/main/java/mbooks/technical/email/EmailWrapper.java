package mbooks.technical.email;

import lombok.*;


@NoArgsConstructor
@RequiredArgsConstructor
public @Data  class EmailWrapper {

    @NonNull String email;
    @NonNull String title;
    @NonNull String endDate;

}
