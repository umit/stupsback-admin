package org.zalando.stups.stupsback.admin.domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import javax.persistence.PersistenceException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author Christian Lohmann
 */
@Converter(autoApply = true)
public class URIConverter implements AttributeConverter<URI, String> {


    @Override
    public String convertToDatabaseColumn(final URI uri) {
        return uri.getPath();
    }

    @Override
    public URI convertToEntityAttribute(final String path) {
        try {
            return new URI(path);
        } catch (URISyntaxException e) {
            throw new PersistenceException("Cannot create an URI of given path: " + path, e);
        }
    }
}
