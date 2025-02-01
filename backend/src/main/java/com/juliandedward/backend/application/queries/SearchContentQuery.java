package com.juliandedward.backend.application.queries;

import java.util.Collection;

public record SearchContentQuery(String title, String type, Collection<String> tags) {

}
