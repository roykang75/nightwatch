package xyz.oiio.nightwatch.converter;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Converter
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, String> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

    @Override
    public String convertToDatabaseColumn(LocalDateTime localDateTime) {
        log.debug("1111111111111111111111111111111111111111111111");
        log.debug("1111111111111111111111111111111111111111111111");
        log.debug("1111111111111111111111111111111111111111111111");
        if (localDateTime == null) {
            return null;
        }
        return formatter.format(localDateTime);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(String timestamp) {
        log.debug("22222222222222222222222222222222222222222222222");
        log.debug("22222222222222222222222222222222222222222222222");
        log.debug("22222222222222222222222222222222222222222222222");
        if (timestamp == null) {
            return null;
        }
        return LocalDateTime.parse(timestamp, formatter);
    }
}
