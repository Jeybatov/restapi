package edu.ada.micronaunt.fetchers

import edu.ada.micronaunt.dto.UserState
import edu.umd.cs.findbugs.annotations.NonNull

import javax.validation.constraints.NotBlank

interface UserFetcher {
    UserState findByUsername(@NotBlank @NonNull String username)
}