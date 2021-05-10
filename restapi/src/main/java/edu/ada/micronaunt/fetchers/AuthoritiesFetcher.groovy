package edu.ada.micronaunt.fetchers

interface AuthoritiesFetcher {
    List<String> findAuthoritiesByUsername(String username)
}
